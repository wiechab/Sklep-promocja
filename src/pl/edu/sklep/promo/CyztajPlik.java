/**
 * 
 */
package pl.edu.sklep.promo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


/**
 * @author wieslawab
 *
 */
public class CyztajPlik {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plik = "C:\\dok.txt";
	//	wczytajPlik(plik );
	}
	protected Logger logger = Logger.getGlobal();
	
	public void wczytajPlik(String source) {
		try {
			File file = new File(source);
			logger.info("Wczytano: " + source + "\n");

			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
					przetwarzajLinie(line);
			}
			sc.close();
			logger.info("Zakoñczono przetwarzanie: " + source + "\n");
		} catch (FileNotFoundException e) {
			logger.throwing("AWczytajPlik", "wczytajPlik", e);
		}
	}
		public void przetwarzajLinie(String wiersz) {
			List<String> s³owa = Arrays.asList(wiersz.split(" "));
			
			
		};
}
