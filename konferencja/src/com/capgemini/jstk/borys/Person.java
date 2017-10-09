package com.capgemini.jstk.borys;

import java.awt.List;
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
import java.util.Date;
import java.util.Scanner;

public class Person 
{
	/*
	 * Pola klasy Person
	 */
	String imie ;
	String nazwisko;
	String data; // to wywalic 
	int wiek;
	Date dataUrodzenia; 
	
	
	public Person ()
	{
	
	}
	
	/*
	 * Konstruktor parametryczny tworzacy obiekt typu person  
	 */
	public Person (String imie, String nazwisko, String data,Date datka,int wiek )
	{
		this.imie= imie ;
		this.nazwisko = nazwisko;
		this.data = data;
		this.wiek = wiek; 
		this.dataUrodzenia = datka;
	}

	/* getery i setery */
	
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

	public String getData() {
		return data;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public Date getDataUrodzenia() {
		return dataUrodzenia;
	}

	public void setDataUrodzenia(Date dataUrodzenia) {
		this.dataUrodzenia = dataUrodzenia;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public int getWiek() {
		return wiek;
	}
	
	
	/*
	 * Odczytuje dane z podanego pliku "plik.csv" a nastepnie umieszcza je w liscie w identycznej kolejnosci
	 * @return zwraca liste obiektow "Person" odczytana z pliku wejsciowego 
	 */
	
	public ArrayList<Person> odczyt(){
		FileReader fr = null;
		   String linia ="";
		 
		   
		   ArrayList<Person> lista2 = new ArrayList<>();
		
		   // OTWIERANIE PLIKU:
		   try {
		     fr = new FileReader("plik.csv");
		   } catch (FileNotFoundException e1) {
		       System.out.println("blad otwarcia pliku");
		       System.exit(1);
		   }

		   BufferedReader bfr = new BufferedReader(fr);
		   // ODCZYT KOLEJNYCH LINII Z PLIKU:
		   try {
		     while((linia = bfr.readLine()) != null){
		    	 
		    	 
		    	 String[] splita = linia.split(",");
		    	 SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
		         String input =splita[2];

		        // System.out.print(input + " Parses as "); 
		         Date t;
		         Date date = new Date();
		         
		        //System.out.print( LocalDate.now().getYear());
		         try {
		            t = ft.parse(input); 
		        int wiek =   LocalDate.now().getYear() -  t.getYear() -1900; 
		            lista2.add( new Person(splita[0],splita[1],splita[2],t,wiek));
		        //    System.out.println(t); 
		         }catch (ParseException e) { 
		            System.out.println("Unparseable using " + ft); 
		         }
		    	 
		    	 
		    	//lista2.add( new Person(splita[0],splita[1],splita[2]));
		    	
		    	//najlepiej tutaj tez wiek policzyc
		    	//System.out.println(lista2);
		    	
		    	
		    //   System.out.println(linia); // wyswietla w konsoli wczytane pliki
		     }
	
		    } catch (IOException e) {
		        System.out.println("blad odczytu z pliku!");
		        System.exit(2);
		   }

		   // ZAMYKANIE PLIKU
		   try {
		     fr.close();
		    } catch (IOException e1) {
		         System.out.println("blad zamykania pliku");
		         System.exit(3);
		        }
		return lista2;

		    }
	
	/*
	 * Metoda zapisuje podana liste  do plku o nazwie "uczestnicy_litera.csv"
	 * @parm pobiera liste zawierajaca obiekty typu person
	 */


	public void zapisDoPliku(ArrayList<Person> lista)
	{
		String dane="";
		
		 FileWriter fw = null;

		    try {
		       fw = new FileWriter("uczestnicy_litera.csv");
		          } catch (IOException e) { 
		        e.printStackTrace();
		     }
		 
		   BufferedWriter bw = new BufferedWriter(fw);
		   try {
		       for (int i = 0; i < lista.size(); i++) {
		    	   dane = lista.get(i).getImie() + "," + lista.get(i).getNazwisko() + "," + lista.get(i).getWiek() + "," + lista.get(i).getDataUrodzenia()  ;
		         bw.write(dane);
		         bw.newLine();
		       //  System.out.println(dane);
		         dane = "";
		      //   System.out.println("zapisano linie");
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

	
	
	public ArrayList<Person> sortowanieNazwisk(ArrayList<Person> lista)
	{
		 for (int i = 0; i < lista.size()-2; i++){       
	           for (int j = 0; j < lista.size()-2 ; j++){
	              if( lista.get(j).getNazwisko().compareTo(lista.get(j+1).getNazwisko())>0)
	              		{
	                    Person temp = lista.get(j);
	                  //  System.out.println(lista.get(j));
	                    lista.remove(j);
	                  lista.add(j, lista.get(j+1));
	                  lista.remove(j+1);
	                 lista.add(j+1, temp) ;
	                 
	                
	                    }
	                }
	          }              
		
		//System.out.println(lista);
		return lista;
	}
	
	public ArrayList<Person> wyszukiwanieNazwisk(ArrayList<Person> lista, char N)
	{
		ArrayList<Person> nowaLista =new ArrayList<>();
		N = Character.toUpperCase(N);
		 for (int i = 0; i < lista.size(); i++)
		 {
			 if(lista.get(i).getNazwisko().charAt(0)== N ){
			 	nowaLista.add(lista.get(i)); //if true -  dodanie calego obiektu do listy 
			 //	System.out.println(lista.get(i).getNazwisko()); //Sprawdzenie poprawnosci wyszukiwania nazwiska
			 }
			 
		 }		 
		return lista;
	}
	
	
	public char wyborUzytkownika (){
		Scanner wybor = new Scanner(System.in);
		int x =0;
		char aa = 0  ;
		/*	MENU WYBORU 	*/
		
		System.out.println("Wprowadz litere lub liczbe: ");
		if(wybor.hasNextInt()){
			System.out.println("Wybrales cyfre ");
			 x = wybor.nextInt(); 
			aa= Integer.toString(x).charAt(0);
		}
		else if (wybor.hasNextLine()) {
			System.out.println("Wybrales litere ");
			aa= wybor.nextLine().charAt(0);
			//System.out.println(aa); 
		}
		return aa;
		
	}

	
		
	}
	
	
	


