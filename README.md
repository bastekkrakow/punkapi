# PUNKAPI

## Uruchom program a następnie pod adresem www.localhost:8080/

```bash
❯ Zaloguj się:
❯ Login: user
❯ Hasło: piwo

 Pod adresem http://localhost:8080/dodaj - dodajesz nowe piwo do bazy danych
 Pod adresem http://localhost:8080/list możesz pobrać listę wszystkich piw w baze danych 
 lub pod adresem http://localhost:8080/foodpairings/search/{phrase} wyszukać piwo po food pairings
```

Zadanie:

Korzystając z https://punkapi.com/
należy zaimportować bazę piw. Baza ma być importowana przy każdym starcie aplikacji i odświeżana co godzinę.

Korzystając ze stworzonej bazy należy wystawić API. (API ma być w całości zasilane z lokalnej bazy, punk api ma służyć tylko do początkowego importu i okresowego odświeżania).

Metody:
GET /foodpairings/search/{phrase}
Wśród piw wyszukuje i zwraca te które zawierają w "food pairings" przekazaną frazę

POST /beers

Możliwość dodania piwa do bazy danych, dodane piwa nie powinny znikać z bazy podczas okresowego odświeżania. 

Endpoint ten należy zabezpieczyć Basic authentication. Username i password dowolne, należy je przekazać w pliku README w rozwiązaniu zadania.

Wymagana struktura jsona dla requestów:

{
punkapiId: number
name: string
tagline: string
firstBrewed: string
description: string
imageUrl: string
ibu: number
foodPairing: array of strings
}

Resztę propertiesów można zignorować.

Należy uzyć springa i hibernate'a oraz dowolnej bazy danych embedded. 

# TODO

- [x] Testy jednostkowe
- [x] Zamienić parsowanie Jsona do listy zamiast do tablicy
- [x] Dodać aktualizowanie co godzinę
- [x] Poprawić frontend




