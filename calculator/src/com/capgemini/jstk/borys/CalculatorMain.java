package com.capgemini.jstk.borys;

import java.util.ArrayList;

public class CalculatorMain {

	public static void main(String[] args) 
	{
		ArrayList<Integer> listaLiczb = new ArrayList();
		ArrayList<String> listaOperacji = new ArrayList();
		
		Calculator test = new Calculator();
		String dane = test.pobieranieStringa();
		listaLiczb = test.wyznaczLiczby(dane);
		listaOperacji = test.wyznaczDzialania(dane);
		
		
		System.out.println( test.wykonajOperajce(listaOperacji, listaLiczb) );

	}

}
