package edu.mu.stockManagerSingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.mediaProduct.CDRecordProduct;
import edu.mu.mediaProduct.Genre;
import edu.mu.mediaProduct.MediaProduct;
import edu.mu.mediaProduct.TapeRecordProduct;
import edu.mu.mediaProduct.VinylRecordProduct;

public class StockManagerSingleton {
	private String inventoryFilePath = "inventory.csv";
	public ArrayList<MediaProduct> productList = new ArrayList<MediaProduct>();
	
	
	
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
				Genre genre = splitProduct[4];
				
				
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
		//needs to be completed 
		return true;
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		//needs to be completed
		
		ArrayList<MediaProduct> list = new ArrayList<MediaProduct>();
		return list;
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		//needs to be completed
	}
	
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
		//needs to be completed
		
		ArrayList<VinylRecordProduct> list = new ArrayList<VinylRecordProduct>();
		return list;
	}
	
	public ArrayList<CDRecordProduct> getCDRecordList(ArrayList<MediaProduct> productList) {
		//needs to be completed
		
		ArrayList<CDRecordProduct> list = new ArrayList<CDRecordProduct>();
		return list;
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
		//needs to be completed
		
		ArrayList<TapeRecordProduct> list = new ArrayList<TapeRecordProduct>();
		return list;
	}
	
	
	
	
	
	
	
	
}
