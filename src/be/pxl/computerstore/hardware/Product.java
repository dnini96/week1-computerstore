package be.pxl.computerstore.hardware;

import java.util.Random;

public class Product {

	private String vendor;
	private String name;
	private double price;
	private String articleNumber;
	private static int uniqueNumber = 0;
	private Random rand = new Random();
	
	{
		uniqueNumber++;
	}

	public Product(String vendor, String name, double price) {
		setVendor(vendor);
		setName(name);
		setPrice(price);
		articleNumber = generateArtNumber();
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getArticleNumber() {
		return articleNumber;
	}

	private String generateArtNumber() {
		StringBuilder artNumber;
		int numberOfLetters = getVendor().length();
		if (numberOfLetters < 3) {
			artNumber = new StringBuilder(getVendor().toUpperCase());
			for (int i = numberOfLetters; i < 3 ; i++) {
				artNumber.append("X");
			}
		} else {
			artNumber = new StringBuilder(getVendor().substring(0, 2).toUpperCase());
		}
		artNumber.append("-");
		artNumber.append(String.format("%05d", Product.uniqueNumber));
		artNumber.append("-");
		for(int i = 0; i < 3; i++) {
			int j = (rand.nextInt(9) + 1);
			artNumber.append(j);
		}
		return artNumber.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder product = new StringBuilder("ArticleNumber = " + articleNumber + "vendor = " + vendor + "\nName = " + name + "\nPrice = " + price);
		return product.toString();
	}
	
	public String getShortDescription() {
		return getArticleNumber() + " * " + name +  " * " + price + "€";
	}
	
}
