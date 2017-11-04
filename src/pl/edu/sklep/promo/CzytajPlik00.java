package pl.edu.sklep.promo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class CzytajPlik00 {

	/**
	 * @param args
	 */

	private static Map<String, Integer> liczniki = new HashMap<>();
	private static Set<String> wytnij = new HashSet<>();
	
	private static void listaWytnij() {
		wytnij.add(",");
		wytnij.add(".");
		wytnij.add(";");
		wytnij.add("!");
		wytnij.add("-");
		wytnij.add(" ");
		wytnij.add("  ");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String plik = "C:\\TEXT-UTF8.txt";
		listaWytnij();
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
			logger.info("Zakończono przetwarzanie: " + source + "\n");
			
			System.out.println(liczniki); //zwraca klucz, ilość wystąpień
			System.out.println(liczniki.values()); //zwraca ilość wystąpień danego klucza
			System.out.println(liczniki.keySet()); //zwraca klucze mapy
			
			String maxk = "";
			int maxv = 0;
			
			String mink = "";
			int minv = 999999;
			
			int licznikMin = 0;
			int licznikMax = 0;
			
			for (Map.Entry<String, Integer> ll : liczniki.entrySet()) {
				String k = ll.getKey();
				Integer v = ll.getValue();
				if(v >= maxv) {
				
					if(maxv == v) {
						maxk = maxk + k  + "; ";
						licznikMax ++;
					} else {
					licznikMax = 1;	
					maxk = k  + "; ";
				}	
					maxv = v;
				}
				
				if(v <= minv) {
					if(minv == v) {
						mink = mink  + k + "; ";
						licznikMin ++;
					} else {
						licznikMin = 1;
						mink = k + "; ";
					}
						
					minv = v;
				}
			}
			maxk = maxk.substring(0,  maxk.length()-2);
			mink = mink.substring(0,  mink.length()-2);
	
			System.out.println("maksymalna ilość wystąpień  " + maxv +  " licznik słów " + licznikMax + " dla słowa/słów: "+ maxk);
			System.out.println("minimalna ilość wystąpień " + minv +  " licznik słów " + licznikMin + " dla słowa/słów: " +  mink  );
			
		} catch (FileNotFoundException e) {
			logger.throwing("AWczytajPlik", "wczytajPlik", e);
		}
	}
	private static String wytnij (String s) {
		String str = s;
		for ( String w : wytnij) {
			str = str.replace(w, "");
		}
		return str;
	}
	private static void przetwarzajLinie(String wiersz) {
			wytnij.forEach(o -> wiersz.replace(o, ""));
		    
			List<String> słowa = Arrays.asList(wiersz.split(" "));
			//System.out.println(słowa);
			String[] words = new String[słowa.size()];
		
			/*
		Collection<String> listUn = Collections.unmodifiableCollection(lista);
		
		listUn.forEach(o -> System.out.println(o));
			 */

			int i = 0;
			for ( String s : słowa) {
				//System.out.println("s=");
				//words[i] = s.replace("Java", "avaJ");
				words[i] = wytnij(s);
				
				System.out.println(words[i]);
				//names[i] = s.replace(".", "");
				//names[i] = s.replace(",", "");
				//System.out.println(names[i]);
				//liczniki.merge(words[i].toUpperCase(), 1, Integer::sum);
				
				liczniki.merge(words[i].toLowerCase(), 1, Integer::sum);
			
				//liczniki.merge(s.toUpperCase(), 1, Integer::sum);
				i++;

				}

			//System.out.println(liczniki.values()); //zwraca ilość wystąpień
			//System.out.println(liczniki.get(s�owa));

			/*
			słowa.forEach(o -> o.replace(".", ""));
			słowa.forEach(o -> o.replace(",", ""));
			słowa.forEach(o -> liczniki.merge(o, 1, Integer::sum));
			
			słowa.forEach(o -> System.out.println(o));
			*/
			//System.out.println(słowa);
		};
}
