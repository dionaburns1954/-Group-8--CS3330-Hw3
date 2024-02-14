package edu.mu.stockManagerSingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.mu.mediaProduct.CDRecordProduct;
import edu.mu.mediaProduct.MediaProduct;
import edu.mu.mediaProduct.TapeRecordProduct;
import edu.mu.mediaProduct.VinylRecordProduct;

public class StockManagerSingleton {
	private String inventoryFilePath = "inventory.csv";
	private ArrayList<MediaProduct> productList;
	
	
	
	public boolean initializeStock() throws FileNotFoundException {
		//needs to be completed 
		
		/* Goals 
		 * Step 1: Open the file
		 * Step 2: Loop through file and add data to something?
		 */
		try {
			
			File file = new File(inventoryFilePath);
			Scanner fileScanner = new Scanner(file);
			
			fileScanner.nextLine();//skips a row
			
			while(fileScanner.hasNext()) {
				//do something
				String product = fileScanner.nextLine();
				System.out.println(product);
				String[] splitProduct = product.split(" ", 5);
				
				for(int i = 0; i < splitProduct.length; i++) {
					
					if(splitProduct[0].equals("Vinyl")) {
						
					}
					else if(splitProduct[0].equals("CD")) {
						
					}
					else { //has to equal tape
						
					}
					
				}
				
			}
			
			fileScanner.close();
			return true;
		}catch(FileNotFoundException e) {
			
		}
		return false;
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		//needs to be completed
		return true;
	}
	
	public boolean addItem(MediaProduct product) {
		//needs to be completed 
		return true;
	}
	
	public boolean removeItem(MediaProduct product ) {
		//needs to be completed 
		return true;
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
