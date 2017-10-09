package com.capgemini.jstk.borys;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator 
{
	/* Metoda pobiera stringa wprowadzonego przez uzytkownika w konsoli oraz sprawdza jego poprawny format.
	 * W przypadku blednego formatu, wywoluje sie ponownie
	 * @return zwraca pobranego stringa 
	 */
	public String pobieranieStringa()
	{
		System.out.println("podaj stringa o poprawnym formacie (zakres operacji ograniczony do pojemnosci INT): ");
		Scanner wejscie = new Scanner(System.in);
		String input = wejscie.nextLine();
		input = usuwanieSpacji(input);
		if(input.equals(""))
		{
			input="0";
			return input;
		}
		for (int i = 0; i < input.length(); i++) 
		{
			//System.out.println((int) input.charAt(i));
			if(  ( 57 >=(int) input.charAt(i) &&   48 <= (int) input.charAt(i) ) ||  ( (int)input.charAt(i)==43 ||  (int)input.charAt(i) ==45)  )
			{
				//System.out.println("poprawny string");
				continue;
			}
			else {
				input="";
				pobieranieStringa();
				wejscie.close();
				break;
			}
		
		}
		wejscie.close();
		return input;
	}
	
	/* Metoda usuwa spacje oraz tabulator w stringu wprowadzonym przez uzytkownika
	 * @param string z dzialaniem do wykonania
	 * @return zwraca pobranego stringa bez bialych znakow (spacja, tab)
	 */
	
	public String usuwanieSpacji(String input)
	{
		String inputN= input.replace(" ","");
		inputN=inputN.replace("	", "");
		return inputN;
	}

	/* Metoda umieszcza w nowo stworzonej liscie operacji znaki wyciagniete ze stringa w kolejnosci wystepowan tych znakow
	 * @param string wejsciowy 
	 * @return zwraca Liste zawierajaca znaki z operacjami do wykonania
	 */
	
	public ArrayList<String> wyznaczDzialania(String input)
	{
		ArrayList<String> listaOperacji = new ArrayList();
		String[] znaki = input.split("\\d+");
		
		for (int i = 0; i <  znaki.length; i++)
		{
			listaOperacji.add(znaki[i]);
		}
		
		
		return listaOperacji;
	}
	
	/* Metoda umieszcza w nowo stworzonej liscie liczb, cyfry wyciagniete ze stringa w kolejnosci ich wystapien
	 * @param string wejsciowy 
	 * @return zwraca Liste zawierajaca cyfry na ktorych wykonamy dzialania
	 */
	
	public ArrayList<Integer> wyznaczLiczby(String input)
	{
		ArrayList<Integer> listaLiczb = new ArrayList();
		String[] liczby = input.split("[-||+ ]");
		for (int i = 0; i < liczby.length; i++)
		{
			//System.out.println(liczby[i]);
			listaLiczb.add(Integer.parseInt(liczby[i]));
		}
		
		return listaLiczb ;
	}

	/* Metoda umieszcza w nowo stworzonej liscie liczb, cyfry wyciagniete ze stringa w kolejnosci ich wystapien
	 * @param lista z cyframi oraz lista z operacjami do wykonania 
	 * @return zwraca liczbe typu int zawierajaca wynik wszystkich operacji 
	 */
	
	public int wykonajOperajce(ArrayList<String> listaOperacji , ArrayList<Integer> listaLiczb){
		
		int wynik = 0; 
		if(listaLiczb.size()==0)
			wynik = 0;
		if(listaOperacji.size()==0 ){
			wynik = listaLiczb.get(0);
			}
		else {
		for (int i = 1; i < listaOperacji.size(); i++)
		{
			if (wynik == 0 && i==1 )
			{
				if(listaOperacji.get(i).equals("+")) {
					wynik = listaLiczb.get(i-1) + listaLiczb.get(i) + wynik;
					}
				else if (listaOperacji.get(i).equals("-")){
					wynik = listaLiczb.get(i-1) - listaLiczb.get(i) ;
					}
			}
			else {
			if(listaOperacji.get(i).equals("+")) {
				//aSystem.out.println(wynik);
				wynik = listaLiczb.get(i) + wynik;
			
				//System.out.println(  wynik + " dodawanie " + listaLiczb.get(i-1) + "__ " +listaLiczb.get(i));	
			}
				
			else if(listaOperacji.get(i).equals("-")){
				wynik = wynik - listaLiczb.get(i) ;
			//	System.out.println(  + wynik + " odejmowanie");	
			}
			}
		}
		}
		//System.out.println( wynik);	
		
		
		return wynik;
		
		}
	

}
