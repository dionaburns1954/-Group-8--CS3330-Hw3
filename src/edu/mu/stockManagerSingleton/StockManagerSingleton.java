package edu.mu.stockManagerSingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.mediaProduct.CDRecordProduct;
import edu.mu.mediaProduct.Genre;
import edu.mu.mediaProduct.MediaProduct;
import edu.mu.mediaProduct.TapeRecordProduct;
import edu.mu.mediaProduct.VinylRecordProduct;

public class StockManagerSingleton {
	private String inventoryFilePath = "inventory.csv"; //needs getter
	public ArrayList<MediaProduct> productList = new ArrayList<MediaProduct>(); //needs getter
	private static StockManagerSingleton instance = null;
	
	private StockManagerSingleton() {
	}
	
	public static StockManagerSingleton getInstance() {
		if(instance == null) {
			instance = new StockManagerSingleton();
		}
		return instance;
	}
	
	public String getInventoryFilePath() {
		return inventoryFilePath;
	}

	public ArrayList<MediaProduct> getProductList() {
		return productList;
	}
	
	public boolean initializeStock() throws FileNotFoundException {
		//needs to be completed 
		
		/* Goals 
		 * Step 1: Open the file
		 * Step 2: Loop through file and add data to something?
		 */
		try {
			
			//opens new file
			File file = new File(inventoryFilePath);
			Scanner fileScanner = new Scanner(file);
			
			fileScanner.nextLine();//skips a row
			
			while(fileScanner.hasNext()) {
				//do something
				String product = fileScanner.nextLine(); //gets whole line of data
				//System.out.println(product);
				String[] splitProduct = product.split(",");
				
				//getting data from split string
				String title = splitProduct[1];
				double price = Double.parseDouble(splitProduct[2]);
				int year = Integer.parseInt(splitProduct[3]);
				Genre genre = Genre.valueOf(splitProduct[4]);
				
				
				//creating objects and adding them to ArrayList
				if(splitProduct[0].equals("Vinyl")) {
					VinylRecordProduct vinylRecord = new VinylRecordProduct(title, price, year, genre);
					productList.add(vinylRecord);
				}
				else if(splitProduct[0].equals("CD")) {
					CDRecordProduct cdRecordProduct = new CDRecordProduct(title, price, year, genre);
					productList.add(cdRecordProduct);
				}
				else { //has to equal tape
					TapeRecordProduct tapeRecordProduct = new TapeRecordProduct(title, price, year, genre);
					productList.add(tapeRecordProduct);
				}
				
			}
			
			fileScanner.close();
			return true;
		}catch(FileNotFoundException e) {
			System.out.println("ERROR! COULD NOT OPEN FILE");
		}
		return false;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		for (MediaProduct p : productList) { //Find matching product in productList
			if (p.equals(product)) { //Make sure the current product matches the one specified
				p.setPrice(newPrice); //Update the product price to newPrice
				return true; 
				
			}
		}
		return false;
	}
	
	public boolean addItem(MediaProduct product) {
		if (!productList.contains(product)) { //Check if product is not already in productList
			productList.add(product); //Add product to productList if not
			return true;
		}
		return false;
	}

	public boolean removeItem(MediaProduct product) {
		return productList.remove(product); //Remove product from productList and return true if removed
	}
	
	public boolean saveStock() {
		try {
			FileWriter writer = new FileWriter(inventoryFilePath);
			
			// Write the CSV header
			String header = "Type,Title,Price,Year,Genre\n";
			writer.write(header);
			
			// Write the details of all products in the inventory to file
			for(MediaProduct product : productList) {
				writer.write(product.toString() + "\n");
			}
			writer.close(); // Close the writer
			return true;
		} catch(FileNotFoundException e) {
			System.out.println("File \"" + inventoryFilePath + "\" could not be found");
		} catch(IOException e) {
			System.out.println("Cannot write to file!\n" + e);
		}
		return false;
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		
		ArrayList<MediaProduct> list = new ArrayList<MediaProduct>();
		
		for (MediaProduct product : productList) {// loop through media inventory 
			if (product.getPrice() < maxPrice) {// compare product price with the maxprice that is given for function 
				list.add(new MediaProduct(product));// using the copy constructor so that way we dont lose data in product constructor
			}
		}
		return list;
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		for (MediaProduct product : productList) {
			System.out.println( product.getTitle() + " - " + product.getPrice() + " - " + product.getYear()+ " - " + product.getGenre());
		}
	}
	
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
		
		ArrayList<VinylRecordProduct> list = new ArrayList<VinylRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).toString().contains("Vinyl")) {
				list.add((VinylRecordProduct) productList.get(i));
			}
		}
		//System.out.println(list.toString());
		return list;
	}
	
	public ArrayList<CDRecordProduct> getCDRecordList(ArrayList<MediaProduct> productList) {
		
		ArrayList<CDRecordProduct> list = new ArrayList<CDRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).toString().contains("CD")) {
				list.add((CDRecordProduct) productList.get(i));
			}
		}
		//System.out.println(list.toString());
		return list;
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
		
		ArrayList<TapeRecordProduct> list = new ArrayList<TapeRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).toString().contains("Tape")) {
				list.add((TapeRecordProduct) productList.get(i));
			}
		}
		//System.out.println(list.toString());
		return list;
	}
	
	
	
	
	
	
	
	
}
