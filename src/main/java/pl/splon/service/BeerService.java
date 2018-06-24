package pl.splon.service;

import pl.splon.model.Beer;
import pl.splon.repository.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public Iterable<Beer> list() {
        return beerRepository.findAll();
    }

    public List<Beer> list2() {
        return beerRepository.findAll();
    }

    public Beer save(Beer beer) {
        return beerRepository.save(beer);
    }

    public void save(List<Beer> beers) {
        beerRepository.save(beers);
    }
}
