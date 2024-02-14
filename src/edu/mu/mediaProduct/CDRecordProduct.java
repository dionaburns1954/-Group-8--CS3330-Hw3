package edu.mu.mediaProduct;

public class CDRecordProduct extends MediaProduct{

	public CDRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Tape," + title + "," + price + "," + year + "," + genre.toString();
	}
	//copy constructor needs to be added
	
}
