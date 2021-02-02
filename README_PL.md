# Warsztaty 1 - Java

##Main1 - Gra w zgadywanie liczb

Po uruchomieniu programu komputer losuje liczbę od 1 do 100, celem użytkownika jest zgadnąć wylosowaną liczbę. 

Gdy liczba podana przez użytkownika jest równa wylosowanej, wyświetli się komunikat: "Zgadłeś!", a następnie działanie programu zakończy się.

##Main2 - Symulator LOTTO

LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu od 1 do 49. Zadaniem gracza jest poprawne wytypowanie losowanych liczb. Nagradzane jest trafienie 3, 4, 5 lub 6 poprawnych liczb.
Program zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
* czy wprowadzony ciąg znaków jest poprawną liczbą,
* czy użytkownik nie wpisał tej liczby już poprzednio,
* czy liczba należy do zakresu 1-49.

Po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie, wylosuje 6 liczb z zakresu i wyświetli je na ekranie, a na koniec poinformuje gracza, czy trafił przynajmniej "trójkę".

##Main3 - Gra w zgadywanie liczb - odwrócona

Sytuacja z "Gra w zgadywanie liczb" zostaje odwrócona. Użytkownik ma za zadanie pomyśleć sobie liczbę z zakresu 1-1000 a komputer będzie ją zgadywał i zrobi to w maksymalnie 10 ruchach.

Zadaniem gracza jest udzielanie odpowiedzi "za dużo", "za mało" i "trafiłeś". Inne odpowiedzi zostaną zignorowane. 

##Main4 - Symulator rzutu kostką RPG

W grach planszowych i papierowych RPG używa się wielu rodzajów kostek do gry, nie tylko standardowej kostki sześciennej. Często rzutu kostką należy dokonać wiele razy a na ostateczny wynik wpływają modyfikatory, które mogą dodać lub odjąć ustaloną wartość od ostatecznego wyniku.

Aby ułatwić zapis używa się kodu skracającego polecenie, np "2D12+10" oznacza "rzuć dwa razy kostką dwunastościenną a do wyniku dodaj 10".

Zadaniem użytkownika jest wpisanie komendy w powyższym formacie. Ilość rzutów kostką i modyfikatory można pominąć jeśli nie są potrzebne.

Program sprawdzi, czy użytkownik wpisał poprawną komendę i czy wybrana kostka istnieje oraz wyliczy ostateczny, losowy wynik rzutu kostką oraz wyświetli go na ekranie.

##Main5 - Wyszukiwarka najpopularniejszych słów

**Aby program działał poprawnie, należy zaimportować do projektu bibliotekę jsoup.** Można ją pobrać pod adresem https://jsoup.org/download

Program wyszuka w podanym serwisie internetowym nagłówki artykułów, a następnie zapisze pojedyncze słowa w nich występujące do pliku o nazwie *popular_words.txt*. 

Następnie utworzy plik *filtered_popular_words.txt*, który będzie zawierał wszystkie znalezione słowa pomijając słowa krotsze niż 3-literowe oraz wykluczone (np. oraz, ponieważ).
