package pl.splon;


import pl.splon.model.Beer;
import pl.splon.service.BeerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@SpringBootApplication
public class PunkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PunkApiApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(BeerService beerService){
	    return args -> {
			// czytaj JSON-a i zapisz do listy
			RestTemplate restTemplate = new RestTemplate();
			try {
				//Pobieramy listę piw z punkapi i zapisujemy je jako tablicę obiektów
				Beer[] beer1 = restTemplate.getForObject("https://api.punkapi.com/v2/beers?page=1&per_page=30" , Beer[].class);
				//zapisujemy do listy
				List<Beer> list = new ArrayList<>();
				Collections.addAll(list, beer1);
 				//parsujemy tablicę Jsona
				for (int i = 0; i < 30; i++) {
					list.get(i).setFoodPairing1(list.get(i).getFood_pairing().get(0));
					list.get(i).setFoodPairing2(list.get(i).getFood_pairing().get(1));
					list.get(i).setFoodPairing3(list.get(i).getFood_pairing().get(2));
				}
				//zapis listy piw do bazy danych H2
				beerService.save(list);

				System.out.println("Zapisałem listę");
			} catch (Exception e){
				System.out.println("Błąd zapisu listy!: " + e.getMessage());
			}
	    };
	}
}
