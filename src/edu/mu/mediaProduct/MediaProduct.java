package edu.mu.mediaProduct;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;

	protected enum Genre {
		ROCK,
		POP,
		JAZZ,
		CLASSICAL,
		HIP_HOP,
		ELECTRONIC,
		CHILDREN
	}

	public MediaProduct(String title, double price, int year, Genre genre) {
		//super();
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MediaProduct [title=" + title + ", price=" + price + ", year=" + year + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
}
