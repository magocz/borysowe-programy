package com.capgemini.jstk.borys;


import java.util.ArrayList;
import java.util.Scanner;

public class DodawanieStringa {

	

		public static void main(String[] args)
		{
			
		
			Calculator test = new Calculator();
			test.pobieranieStringa();
			ArrayList<Integer> listaLiczb = new ArrayList();
			ArrayList<String> listaOperacji = new ArrayList();
			String input1 = "2-2 - 1";
			String input= input1.replace(" ","");
			String[] liczby = input.split("[-||+ ]+");
			String[] znaki = input.split("\\d+");
			
			
			for (int i = 0; i < liczby.length; i++)
			{
				//System.out.println(liczby[i]);
				listaLiczb.add(Integer.parseInt(liczby[i]));
			}
			
			for (int i = 0; i <  znaki.length; i++)
			{
				//System.out.println( "| " + znaki[i] + " |");
				listaOperacji.add(znaki[i]);
			}
			
			//System.out.println( znaki.length);
			System.out.println(listaOperacji);
			System.out.println(listaLiczb);
			
			//if(znaki[1].equals("+"))
				//System.out.println( "rowne");	
			
			
			int wynik = 0; 
			
			if(znaki.length==0){
				wynik = listaLiczb.get(0);
				System.out.println(4);}
			else {
			for (int i = 1; i < znaki.length; i++)
			{
				if (wynik == 0 && i ==1)
				{
					if(znaki[i].equals("+")) {
						wynik = listaLiczb.get(i-1) + listaLiczb.get(i) + wynik;
						System.out.println("tu1");}
					else if (znaki[i].equals("-")){
						wynik = listaLiczb.get(i-1) - listaLiczb.get(i)  ;
						System.out.println(wynik);}
				}
				else {
				if(znaki[i].equals("+")) {
					System.out.println(wynik);
					wynik = listaLiczb.get(i) + wynik;
				
					System.out.println(  wynik + " dodawanie " + listaLiczb.get(i-1) + "__ " +listaLiczb.get(i));	
				}
					
				else if(znaki[i].equals("-")){
					wynik = wynik - listaLiczb.get(i) ;
					System.out.println(  + wynik + " odejmowanie");	
				}
				}
			}
			}
			System.out.println( wynik);	
		}

	}
