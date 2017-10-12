package com.capgemini.jstk.borys;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PersonImpl implements Person {
	/**
	 * Pola klasy Person
	 */
	String imie;
	String nazwisko;
	int wiek;
	Date dataUrodzenia;

	public PersonImpl() {

	}

	/**
	 * Konstruktor parametryczny tworzacy obiekt typu person
	 */
	public PersonImpl(String imie, String nazwisko, Date datka, int wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.wiek = wiek;
		this.dataUrodzenia = datka;
	}

	/**
	 * getery i setery
	 */

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}



	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}


	public int getWiek() {
		return wiek;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	/**
	 * Metoda implementujaca sortowanie (bubble sort) listy według alfabetycznej
	 * kolejnosci nazwisk
	 * 
	 * @parm przyjmuje liste zawierajaca obiekty typu Person
	 * 
	 * @return zwraca posortowana liste zgodnie z przyjeteym kryterium
	 */

	public List<PersonImpl> sortowanieNazwisk(List<PersonImpl> lista) {
		for (int i = (lista.size()); i > 1; i--) {
			for (int j = 0; j < i - 1; j++) {

				if (lista.get(j).getNazwisko().compareTo(lista.get(j + 1).getNazwisko()) > 0) 
			
				{
					PersonImpl temp = lista.get(j);
					lista.set(j, lista.get(j + 1)); // wczesniejsze problemy
													// tutaj polegały na
													// bezmyslnym uzywaniu
													// metody add zamiast set
					lista.set(j + 1, temp);

				}
			}
		}

		return lista;
	}
	
	
	/**
	 * Metoda wykonujaca sortowanie listy według alfabetycznej
	 * kolejnosci imion
	 * 
	 * @parm przyjmuje liste zawierajaca obiekty typu Person
	 * 
	 * @return zwraca posortowana liste zgodnie z przyjeteym kryterium
	 */

	public List<PersonImpl> sortowanieImion(List<PersonImpl> lista) {
		lista.sort(Comparator.comparing(PersonImpl::getImie));
		return lista;
	}
	

	
	/**
	 * Metoda wyszukuje osoby ktorych nazwiska zaczynaja sie na podana litere
	 * 
	 * @parm lista obiektow typu person oraz litera na podstawie ktorej
	 *       dokonujemy filtracji listy
	 * @return zwraca nowa liste zawierajaca tylko obiekty w ktorych nazwiko
	 *         spelnia warunki wyszukiwania
	 */
	public List<PersonImpl> wyszukiwanieNazwisk(List<PersonImpl> lista, char N) {
		List<PersonImpl> nowaLista = new ArrayList<>();
		N = Character.toUpperCase(N);
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNazwisko().charAt(0) == N) {
				nowaLista.add(lista.get(i));
			}

		}
		return nowaLista;
	}

	/**
	 * Metoda wyswietlajaca w konsoli liste osob wraz z ich danymi
	 * 
	 * @parm przyjmuje liste przechowujaca obiekty typu Person
	 */
	public void wyswietlListe(List<PersonImpl> lista) {
		for (int i = 0; i < lista.size(); i++) //
		{
			System.out.print(lista.get(i).getImie() + " ");
			System.out.print(lista.get(i).getNazwisko() + "		");
			//System.out.print(lista.get(i).getDataUrodzenia() + "	");
			System.out.print(lista.get(i).getWiek() + "		");
			System.out.println("");

		}
	}

	
	/**
	 * Metoda dzieli wprowadzona liste na rowne podlisty zgodnie z wprowadzonym dzielnikiem
	 * @param dzielnik oraz lista obiektow typu personimpl
	 * @return zwraca liste lis obiektow typu personimpl
	 */
	
	
	public List<List<PersonImpl>> stworzsPodList(int dzielnik, List<PersonImpl> list) {
		List<List<PersonImpl>> listaOsob = new ArrayList<>();
		if (dzielnik != 0 && list.size() % dzielnik == 0) {
			int rozmiar = list.size() / dzielnik;
			for (int i = 0; i < dzielnik; i++) {
				listaOsob.add(list.subList(i * rozmiar, (i + 1) * rozmiar));
			}
		}
		return listaOsob;
	}

	
}
