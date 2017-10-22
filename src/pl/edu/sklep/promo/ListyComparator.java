/**
 * 
 */
package pl.edu.sklep.promo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author wieslawab
 *
 */
public class ListyComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lista = new ArrayList<>();
	//	List<String> list;
		lista.add("Józek");
		lista.add("Wojtek");
		lista.add("Marian");		
		lista.add("Heniek");	
		lista.add("Zbychu");	
		
		lista.forEach(o -> System.out.println(o));
		
		lista.sort(new Comparator<String>()  {			
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
			}
		} );
		
		//sortowanie odwrotne
		lista.sort(new Comparator<String>()  {			
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
			}
		} );
		
		lista.forEach(o -> System.out.println(o));
		
		
		//--------------
		
		List<Integer> listaInt = new ArrayList<>();
		listaInt.add(100);
		listaInt.add(7);
		listaInt.add(25);		
		listaInt.add(101);	
		
		listaInt.forEach(o -> System.out.println(o));
		
		listaInt.sort(new Comparator<Integer>()  {
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
			}
		} );
		
		
		listaInt.forEach(o -> System.out.println(o));
		
		//filtrowanie
	//	List<String> filtr = lista.stream().filter(item -> "W".equalsIgnoreCase(anotherString)(item.substring(0, 1)).collect());
	
		//TreeSet<>
		
		TreeSet<String> countries = new TreeSet<>(); // Kraje dodawane w kolejnoœci sortowania
		countries = new TreeSet<>((u, v) ->
		u.equals(v) ? 0
		: u.equals("USA") ? -1
		: v.equals("USA") ? 1
		: u.compareTo(v));
		// USA zawsze na pocz¹tku
		
		countries.add("Hiszpania");
		countries.add("USA");
		countries.add("Polska");
		countries.add("Grecja");
		
		
		countries.forEach(o -> System.out.println(o));
		
		Map<String, Integer> liczniki = new HashMap<>();
		liczniki.put("Alicja", 1); // Dodaje parê klucz-wartoœæ do mapy
		liczniki.put("Alicja", 2); // Aktualizuje wartoœæ klucza

		//KOLEJKI + tutaj ostatni schodzi jako pierwszy LiFo
		ArrayDeque<String> stos = new ArrayDeque<>();
		stos.push("Piotr");
		stos.push("Pawe³");
		stos.push("Maria");
		while (!stos.isEmpty())
		System.out.println(stos.pop());
		
		//widok
		//Innym przyk³adem jest metoda Arrays.asList. Jeœli a jest tablic¹ typu E[], Arrays.asList(a),
		//zwraca obiekt List<T> wykorzystuj¹cy elementy tablicy.
		
		Collection<String> listUn = Collections.unmodifiableCollection(lista);
		
		listUn.forEach(o -> System.out.println(o));
	}

}
