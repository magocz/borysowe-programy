package com.capgemini.jstk.borys;

import java.util.List;
import java.util.Scanner;

public class Conference {

	PersonHelper helper = new PersonHelper();
	PersonImpl dane = new PersonImpl();

	/**
	 * Metoda pobiera od uzytkownika litere lub liczbe i na tej podstawie
	 * wykonywane sa dalsze dzialania programu
	 * 
	 * @parm pobiera liste ALE TU ZMIANA BEDZIE bo troche bez sensu, potrzebuje
	 *       tylko jej rozmiar
	 * @return zwracaStringa zawierajacego znak do dalszego sterowania programem
	 */
	public void wyborUzytkownika() {

		Scanner wybor = new Scanner(System.in);
		List<PersonImpl> listaZdanymiWejsciowymi = helper.odczyt("konferencja.csv");

		/* MENU WYBORU */
		String x = "";
		int n = listaZdanymiWejsciowymi.size();
		System.out.print("Wprowadz litere lub cyfre (cyfre jako dzielnik " + n + " ): ");
		if (wybor.hasNextInt()) {

			int dzielnik = wybor.nextInt();
			// System.out.println(x);
			if (dzielnik != 0 && n % dzielnik == 0 && dzielnik < n) {
				System.out.println("Utworzono  " + dzielnik + " list po " + n/dzielnik + " elementow" );
				List<PersonImpl> listaSortowanaNazwisk = dane.sortowanieNazwisk(listaZdanymiWejsciowymi);
				List<List<PersonImpl>> ListaListPosortowanych = dane.stworzsPodList(dzielnik, listaSortowanaNazwisk);
				for (int i = 0; i < ListaListPosortowanych.size(); i++) {
						helper.zapisDoPliku(ListaListPosortowanych.get(i), ("podLista "+i));
						System.out.println("------------------------------------------------------------------------------");
						dane.wyswietlListe(ListaListPosortowanych.get(i));
				}
			} else {
				System.out.println("Wprowadziles niepoprawna liczbe, wybierz ponownie co chcesz zrobic.");
				wyborUzytkownika();
			}

		} else if (wybor.hasNextLine()) {

			x = wybor.nextLine();
			char y = x.charAt(0);
			System.out.println("Sortuje po " + y);

			List<PersonImpl> listaZnazwiskami = dane.wyszukiwanieNazwisk(listaZdanymiWejsciowymi, y);
			List<PersonImpl> listaZnazwiskamiSortowana = dane.sortowanieImion(listaZnazwiskami);
			PersonHelper.zapisDoPliku(listaZnazwiskamiSortowana, "uczestnicy_litera");
			dane.wyswietlListe(listaZnazwiskami);
			if(listaZnazwiskami.size()==0)
				System.out.println("brak elementow na liscie");

		}
		wybor.close();
	}

}
