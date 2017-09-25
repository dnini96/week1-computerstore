package be.pxl.computerstore.util;

public interface Computable {
	int BTW = 21;
	
	double totalPriceExcl();
	
	default double totalPriceIncl() {
		return (totalPriceExcl() * ((100 + BTW) / 100));
	}
	
}
