package pl.edu.sklep.promo;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plik = "C:\\TEXT-UTF8.txt";
		CzytajPlik wczytaj = new CzytajPlik(plik);
		wczytaj.podajStatystyki(5);
	}

}
