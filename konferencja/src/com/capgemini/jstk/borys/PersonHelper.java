package com.capgemini.jstk.borys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PersonHelper {
	
	/**
	 * Metoda wyznaczajaca wiek na podstawie podanego obiektu typu kalendarz (wykonuje logike biznesowa ?)
	 * @param kalendarz
	 * @return zwraca liczbe lat pojedynczej osoby typu int 
	 */
	public static int wyznaczWiek(Calendar kalendarz)
	{
		
		return  LocalDate.now().getYear() - kalendarz.get(Calendar.YEAR) ;
		
	}
	

	/**
	 * Odczytuje dane z podanego pliku "plik.csv" a nastepnie umieszcza je w
	 * liscie w identycznej kolejnosci
	 * 
	 * @return zwraca liste obiektow "Person" odczytana z pliku wejsciowego
	 */
	public static List<PersonImpl> odczyt(String nazwaPliku) {
		FileReader fr = null;
		String linia = "";

		List<PersonImpl> lista2 = new ArrayList<>();

	
		try {
			fr = new FileReader(nazwaPliku);
		} catch (FileNotFoundException e1) {
			System.out.println("blad otwarcia pliku");
			System.exit(1);
		}

		BufferedReader bfr = new BufferedReader(fr);
	
		try {
			while ((linia = bfr.readLine()) != null) {

				String[] splita = linia.split(",");
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
				String input = splita[2];
			
				Date t;
				Calendar kalendarz = Calendar.getInstance();
				try {
					
					t = ft.parse(input);// konwersja
					kalendarz.setTime(t);
					//int wiek = wyznaczWiek(kalendarz);
					int wiek  = PersonHelper.wyznaczWiek(kalendarz);
					lista2.add(new PersonImpl(splita[0], splita[1], t, wiek));
					
					// System.out.println(t);
				} catch (ParseException e) {
					System.out.println("blad z uzyciem metody parase  " + ft);
				}
			}

		} catch (IOException e) {
			System.out.println("blad odczytu z pliku!");
			System.exit(2);
		}

		
		try {
			fr.close();
		} catch (IOException e1) {
			System.out.println("blad zamykania pliku");
			System.exit(3);
		}
		return lista2;

	}
	

	/**
	 * Metoda zapisuje podana liste do plku o nazwie "nazwaPliku" w formacie csv
	 * 
	 * @parm pobiera liste zawierajaca obiekty typu person oraz string z nazwa
	 *       pliku bez jego rozszerzenia
	 */

	public static void zapisDoPliku(List<PersonImpl> lista, String nazwaPliku) {
		String dane = "";

		FileWriter fw = null;

		try {
			fw = new FileWriter(nazwaPliku + ".csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		BufferedWriter bw = new BufferedWriter(fw);
		try {
			for (int i = 0; i < lista.size(); i++) {
				dane = lista.get(i).getImie() + "," + lista.get(i).getNazwisko() + "," + lista.get(i).getWiek();
				bw.write(dane);
				bw.newLine();
				// System.out.println(dane);
				dane = "";
				// System.out.println("zapisano linie");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

}
