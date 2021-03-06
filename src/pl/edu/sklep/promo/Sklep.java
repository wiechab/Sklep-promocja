/**
 * 
 */
package pl.edu.sklep.promo;

import java.math.BigDecimal;

/**
 * @author wieslawab
 *
 */
public class Sklep extends SklepPromo {

	public BigDecimal getProm() {
		return prom;
	}

	public void setProm(BigDecimal prom) {
		this.prom = prom;
	}

	private BigDecimal prom;
	// private BigDecimal cenaTow = BigDecimal.valueOf(0);

	// Set<Towary> towar = EnumSet.allOf(Towary.class);

	@Override
	public BigDecimal promocja(Towary towar) {
		BigDecimal cenaTow = BigDecimal.ZERO;

		switch (towar) {
		case FASOLA:
			cenaTow = Towary.FASOLA.getCena();
			break;
		case OGOREK:
			cenaTow = Towary.OGOREK.getCena();
			break;
		case MARCHEWKA:
			cenaTow = Towary.MARCHEWKA.getCena();
			break;
		default:
			break;
		}
		
		//cenaTow.multiply(BigDecimal.valueOf(0.55));
		cenaTow.multiply(this.prom);
		return cenaTow;
	}

}
