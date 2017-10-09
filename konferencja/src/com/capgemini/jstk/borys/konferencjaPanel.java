package com.capgemini.jstk.borys;

import java.util.ArrayList;
import java.util.Scanner;

public class konferencjaPanel {

	public static void main(String[] args) 
	{
		Person dane = new Person();
		
		ArrayList<Person> listaZdanymi = new ArrayList<>();
		listaZdanymi = dane.odczyt(); // to gowno zwraca liste
		for (int i = 0; i < dane.odczyt().size(); i++) // 
		{
			System.out.print(listaZdanymi.get(i).getImie() + " ");
			System.out.print(listaZdanymi.get(i).getNazwisko()+ " ");
			System.out.print(listaZdanymi.get(i).getData()+ " ");
			System.out.print(listaZdanymi.get(i).getDataUrodzenia()+ " ");
			System.out.print(listaZdanymi.get(i).getWiek()+ " ");
			System.out.println("");
			
		}
		dane.zapisDoPliku(listaZdanymi);
		
		
	
		
		 ArrayList<Person> test1 = new ArrayList<>();
		// test  = dane.sortowanieNazwisk(listaZdanymi );
		
		
		 
		test1= dane.wyszukiwanieNazwisk(listaZdanymi, 'c');
		 
		 /*
		 
		for (int i = 0; i <test1.size(); i++) // 
		{
			System.out.println(test1.get(i).getNazwisko()+ " ");

		}
		*/
		System.out.println(dane.wyborUzytkownika());
	}

}
