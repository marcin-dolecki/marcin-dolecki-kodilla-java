W poprzednim zadaniu związanym z algorytmami mieliśmy okazję zaimplementować pierwszy algorytm sortowania. Istnieje jednak wiele opisanych algorytmów, które ktoś już wcześniej wymyślił oraz dogłębnie zweryfikował. Przykładem takiego algorytmu może być sortowanie bąbelkowe. Podstawowa wersja sortowania bąbelkowego porównuje w ciągu kolejne cyfry po względem wielkości od lewej do prawej, umieszczając zawsze największy element bliżej końca ciągu. Przykład poniżej.

Dany jest ciąg znaków: 21854241.

Krok 1. Algorytm porównuje parę cyfr 2 i 1. Ponieważ 2 >1, elementy w parze zostają zamienione. Stan: 12854241.

Krok 2. Algorytm porównuje parę cyfr 2 i 8. 8 > 2, więc najmniejszy element to 2, para pozostaje bez zmian.

Krok 3. Algorytm porównuje parę cyfr 8 i 5. 8 > 5, więc większa cyfra zostaje przesunięta bliżej prawej strony. Stan: 12584241.

I tak dalej… na koniec całej operacji posortowany ciąg cyfr powinien wyglądać tak: 12524158.

Największa cyfra w ciągu (8) wskoczyła na ostatnie miejsce. Teraz musimy posortować pozostałe cyfry, zostaje nam zatem powtórzyć wykonane czynności dla n-1. I tak na drugim miejscu od końcu pozostanie cyfra 5.

Kroki należy powtórzyć, by posortować cały zbiór.

Spróbuj samodzielnie napisać program, w którym zaimplementujesz ten algorytm.