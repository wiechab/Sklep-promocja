/**
 * 
 */
package pl.edu.sklep.promo;

import java.math.BigDecimal;

/**
 * @author wieslawab
 *
 */
public enum Towary {
	FASOLA(1,"fas", BigDecimal.valueOf( 5.50)){
		public void info() {
			System.out.println("Fasolka ...");
		}
		
	},
	OGOREK(2,"ogó", BigDecimal.valueOf(4.50)){
		public void info() {
			System.out.println("Ogórek ...");
		}
	},
	MARCHEWKA(3,"march", BigDecimal.valueOf(9.5)){
		public void info() {
			System.out.println("Marchewka ...");
		}
	};
	
	private int code;
	private String desc;
	private BigDecimal cena;
	
	private Towary(int code, String desc, BigDecimal cena) {
		this.code = code;
		this.desc = desc;
		this.cena = cena;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public BigDecimal getCena() {
		return cena;
	}
	public abstract void info();
}
