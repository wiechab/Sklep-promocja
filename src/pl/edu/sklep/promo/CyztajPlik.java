/**
 * 
 */
package pl.edu.sklep.promo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	private static Map<String, Integer> liczniki = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plik = "C:\\dok.txt";
		wczytajPlik(plik );
		
		//liczniki.forEach(o -> System.out.println(o));
	}
	private static Logger logger = Logger.getGlobal();
	
	private static void wczytajPlik(String source) {
		try {
			File file = new File(source);
			logger.info("Wczytano: " + source + "\n");

			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
					przetwarzajLinie(line);
			}
			sc.close();
			logger.info("Zako�czono przetwarzanie: " + source + "\n");
			
			System.out.println(liczniki); //zwraca klucz, ilo�� wyst�pie�
			System.out.println(liczniki.values()); //zwraca ilo�� wyst�pie� danego klucza
			System.out.println(liczniki.keySet()); //zwraca klucze mapy
			
			String maxk = "";
			int maxv = 0;
			
			String mink = "";
			int minv = 1;
			
			int licznikMin = 0;
			int licznikMax = 0;
			
			for (Map.Entry<String, Integer> ll : liczniki.entrySet()) {
				String k = ll.getKey();
				Integer v = ll.getValue();
				if(v >= maxv) {
				
					if(maxv == v) {
						maxk = maxk + "; " + k;
						licznikMax ++;
					} else {
					licznikMax = 1;	
					maxk = k;
				
				}	
					maxv = v;
				}
				
				if(v <= minv) {
					if(minv == v) {
						mink = mink + "; " + k;
						licznikMin ++;
					} else {
						licznikMin = 1;
						mink = k;
					
					}
						
					minv = v;
					
				}
			}
	
			System.out.println("max " + maxk + " wyst�pie� " + maxv + " licznik s��w " + licznikMax);
			System.out.println("min " + mink + " wyst�pie� " + minv + " licznik s��w " + licznikMin);
			
		} catch (FileNotFoundException e) {
			logger.throwing("AWczytajPlik", "wczytajPlik", e);
		}
	}
	private static void przetwarzajLinie(String wiersz) {
			List<String> s�owa = Arrays.asList(wiersz.split(" "));
			String[] words = new String[s�owa.size()];
			/*
		Collection<String> listUn = Collections.unmodifiableCollection(lista);
		
		listUn.forEach(o -> System.out.println(o));
			 */
			//for (int i = 0; i < s�owa.size(); i++) {

				//}
			int i = 0;
			for ( String s : s�owa) {
				//System.out.println("s=");
				words[i] = s.replace("Java", "avaJ");
				
				//names[i] = s.replace(".", "");
				//names[i] = s.replace(",", "");
				//System.out.println(names[i]);
				liczniki.merge(words[i].toUpperCase(), 1, Integer::sum);
				i++;

				}

			//System.out.println(liczniki.values()); //zwraca ilo�� wyst�pie�
			//System.out.println(liczniki.get(s�owa));

			/*
			s�owa.forEach(o -> o.replace(".", ""));
			s�owa.forEach(o -> o.replace(",", ""));
			s�owa.forEach(o -> liczniki.merge(o, 1, Integer::sum));
			
			s�owa.forEach(o -> System.out.println(o));
			*/
			//System.out.println(s�owa);
		};
}
