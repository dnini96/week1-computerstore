package be.pxl.computerstore.hardware;

public abstract class Peripheral extends Product {
	
	public Peripheral(String vendor, String name, double price) {
		super(vendor, name, price);
	}
	
	@Override
	public String getShortDescription() {
		return getArticleNumber() + " * " +  this.getClass().getSimpleName() +  " * "  + getName() + " * " + getPrice() + "€";
	}

}
