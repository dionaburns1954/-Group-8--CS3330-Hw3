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
	
	private final String inventoryFilePath = "inventory.csv";
	private ArrayList<MediaProduct> productList = new ArrayList<MediaProduct>();
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
		return new String(inventoryFilePath);
	}

	public ArrayList<MediaProduct> getProductList() {
		return new ArrayList<MediaProduct>(productList);
	}
	
	public boolean initializeStock() {
		/* Goals 
		 * Step 1: Open the file
		 * Step 2: Loop through file and add data to inventory
		 */
		try {
			
			//opens new file
			File file = new File(inventoryFilePath);
			Scanner fileScanner = new Scanner(file);
			
			fileScanner.nextLine(); // Skip the header row
			
			while(fileScanner.hasNext()) {
				String product = fileScanner.nextLine(); // Gets a whole line of data
				String[] splitProduct = product.split(",");
				
				// Get data from split string
				String title = splitProduct[1];
				double price = Double.parseDouble(splitProduct[2]);
				int year = Integer.parseInt(splitProduct[3]);
				Genre genre = Genre.valueOf(splitProduct[4]);
				
				// Create objects and add them to ArrayList
				if(splitProduct[0].equals("Vinyl")) {
					VinylRecordProduct vinylRecord = new VinylRecordProduct(title, price, year, genre);
					productList.add(vinylRecord);
				}
				else if(splitProduct[0].equals("CD")) {
					CDRecordProduct cdRecordProduct = new CDRecordProduct(title, price, year, genre);
					productList.add(cdRecordProduct);
				}
				else if(splitProduct[0].equals("Tape")) {
					TapeRecordProduct tapeRecordProduct = new TapeRecordProduct(title, price, year, genre);
					productList.add(tapeRecordProduct);
				}
				else {
					System.out.println("Invalid product type " + splitProduct[0] + ". Skipping [" + product + "]. This item will be lost when the file is written.");
				}
			}
			
			fileScanner.close();
			return true;
		} catch(FileNotFoundException e) {
			System.out.println("ERROR! COULD NOT OPEN FILE");
		} catch(Exception e) {
			System.out.println("Cannot initialize stock. " + e);
		}
		return false;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		for (MediaProduct p : productList) { //Find matching product in productList
			if (p.equals(product)) { // Make sure the current product matches the one specified
				p.setPrice(newPrice); // Update the product price to newPrice
				return true; 
			}
		}
		return false;
	}
	
	public boolean addItem(MediaProduct product) {
		if (productList.add(product)) {
			return true;
		}
		return false;
	}

	public boolean removeItem(MediaProduct product) {
		return productList.remove(product); //Remove product from productList and return true if removed
	}
	
	public boolean saveStock() {
		// Look for the file specified and open it
		try(FileWriter writer = new FileWriter(inventoryFilePath);){

			
			// Write the CSV header
			String header = "Type,Title,Price,Year,Genre\n";
			writer.write(header);
			
			// Write the details of all products in the inventory to file
			for(MediaProduct product : productList) {
				writer.write(product.toString() + "\n");
			}
			return true; // File writer closes automatically due to try-with-resource block 
		} catch(FileNotFoundException e) {
			System.out.println("File \"" + inventoryFilePath + "\" could not be found");
		} catch(IOException e) {
			System.out.println("Cannot write to file!\n" + e);
		}
		return false;
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
		
		ArrayList<MediaProduct> list = new ArrayList<MediaProduct>();
		
		for (MediaProduct product : productList) {// Loop through media inventory 
			if (product.getPrice() < maxPrice) {// Compare product price with the maxpPrice that is given for function 
				list.add(new MediaProduct(product));// Using the copy constructor so that way we don't lose data in product constructor
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
		return list;
	}
	
	public ArrayList<CDRecordProduct> getCDRecordList(ArrayList<MediaProduct> productList) {
		
		ArrayList<CDRecordProduct> list = new ArrayList<CDRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).toString().contains("CD")) {
				list.add((CDRecordProduct) productList.get(i));
			}
		}
		return list;
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
		
		ArrayList<TapeRecordProduct> list = new ArrayList<TapeRecordProduct>();
		
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).toString().contains("Tape")) {
				list.add((TapeRecordProduct) productList.get(i));
			}
		}
		return list;
	}
	
	
	
	
	
	
	
	
}
