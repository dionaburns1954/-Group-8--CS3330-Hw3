package edu.mu.mediaProduct;

public class VinylRecordProduct extends MediaProduct{

	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		// TODO Auto-generated constructor stub
	}
	public VinylRecordProduct(VinylRecordProduct copy) {
		super(copy);
	}// copy constructor
	@Override
	public String toString() {
		return "Vinyl," + title + "," + price + "," + year + "," + genre.toString();
	}
	

}
