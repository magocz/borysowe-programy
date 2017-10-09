package graWzycie;

public class GameMain {

	public static void main(String[] args) 
	{
		Game test = new Game();
		test.mapaTestowa();
		//test.mapaRandomGenerator();
		test.rysujMape();
	//	System.out.println(test.sprawdzOtoczenie(1, 1));  //sprawdzenie poprawnosci wyszukiwania zywych sasiadow dla podanej komorki 
		test.nastepnaIteracja();
		test.rysujMape();
		
		
		while(test.sprawdzCzyCosZyje())
		{
			test.nastepnaIteracja();
			test.rysujMape();
			
		}
		
		
	}

}
