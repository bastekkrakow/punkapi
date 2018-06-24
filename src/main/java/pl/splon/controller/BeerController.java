package pl.splon.controller;

import pl.splon.model.Beer;
import pl.splon.service.BeerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class BeerController {

    private long id = 31L;

    private BeerService beerService;


    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/list")
    @ResponseBody
    public Iterable<Beer> list() {
        return beerService.list();
    }

    @GetMapping("/dodaj")
    public String dodaj() {
        return "dodaj";
    }

    @PostMapping("/dodaj")
    @ResponseBody
    public String add(@RequestParam("name") String name,
                      @RequestParam("desc") String desc,
                      @RequestParam("ibu") long ibu,
                      @RequestParam("firstBrewed") String firstBrewed,
                      @RequestParam("tagline") String tagline,
                      @RequestParam("imageUrl") String imageUrl,
                      @RequestParam("foodPairing1") String foodPairing1,
                      @RequestParam("foodPairing2") String foodPairing2,
                      @RequestParam("foodPairing2") String foodPairing3) {

        Beer beer1 = new Beer();
        beer1.setId(id);
        beer1.setName(name);
        beer1.setDescription(desc);
        beer1.setIbu(ibu);
        beer1.setFirst_brewed(firstBrewed);
        beer1.setTagline(tagline);
        beer1.setFoodPairing1(foodPairing1);
        beer1.setFoodPairing2(foodPairing2);
        beer1.setFoodPairing3(foodPairing3);
        beer1.setImage_url(imageUrl);
        beerService.save(beer1);
        id++;
        return "Ok";
    }

    @RequestMapping(value = "/foodpairings/search/{pharse}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String search(@PathVariable("pharse") String pharse) {
        String result = null;
        for (Beer beer : beerService.list2()) {
            if (beer.getFoodPairing1().equals(pharse) || beer.getFoodPairing2().equals(pharse)
                    || beer.getFoodPairing3().equals(pharse)) {
                result = "{ \"PunkapiId\":" + beer.getId() + ", \"name\": \"" + beer.getName() + " \" "
                        + ", \"tagline\": \"" + beer.getTagline() + " \" "
                        + ", \"firstBrewed\": \"" + beer.getFirst_brewed() + " \" "
                        + ", \"description\": \"" + beer.getDescription() + " \" "
                        + ", \"imageUrl\": \"" + beer.getImage_url() + " \" "
                        + ", \"ibu\": \"" + beer.getIbu() + " \" "
                        + ", \"foodPairing1\": \"" + beer.getFoodPairing1() + " \" "
                        + ", \"foodPairing2\": \"" + beer.getFoodPairing2() + " \" "
                        + ", \"foodPairing3\": \"" + beer.getFoodPairing3() + " \" }";
            }
        }
        return result;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

