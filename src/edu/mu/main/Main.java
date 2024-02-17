package edu.mu.main;

import java.util.ArrayList;

import edu.mu.mediaProduct.*;
import edu.mu.stockManagerSingleton.*;


public class Main {

	public static void main(String[] args) {
		
		StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
		if (!stockManager.initializeStock()) { // Guard statement
			System.out.println("Cannot initialize stock. Exiting program. See error above.");
			return;
		}
		
		// Update the price 
		MediaProduct productToUpdate = stockManager.getProductList().getFirst();
		System.out.println(productToUpdate.toString());
		if (stockManager.updateItemPrice(productToUpdate, 9999.1))
			System.out.println("Success! product price updated to $" + productToUpdate.getPrice() + ".");
		else
			System.out.println("Failed to update product");
		
		// Add an item
		CDRecordProduct newProduct = new CDRecordProduct("Toxic", 512355.32, 2003, Genre.POP);
		if (stockManager.addItem(newProduct))
			System.out.println(stockManager.getProductList().getLast());
		else
			System.out.println("Failed to add product. Product already exists");
		
		// Remove an item
		MediaProduct itemToRemove = stockManager.getProductList().get(1);
		//MediaProduct itemToRemove = new CDRecordProduct("does not exist", 0, 2142, Genre.CHILDREN); // Test item that should fail
		
		System.out.println("Removing " + itemToRemove);
		if (stockManager.removeItem(itemToRemove))
			System.out.println("Item successfully removed");
		else
			System.out.println("Item could not be removed");
		
		// Find MediaProduct below $10
		ArrayList<MediaProduct> itemsBelow10 = stockManager.getMediaProductBelowPrice(10);
		System.out.println(itemsBelow10);
		
		// Print the inventory
		stockManager.printListOfMediaProduct(stockManager.getProductList());
		
		// Get all of the Vinyl records
		ArrayList<VinylRecordProduct> vinylList = stockManager.getVinylRecordList(stockManager.getProductList());
		System.out.println(vinylList);
		
		// Get all of the CD records
		ArrayList<CDRecordProduct> cdList = stockManager.getCDRecordList(stockManager.getProductList());
		System.out.println(cdList);
		
		// Get all of the Tape records
		ArrayList<TapeRecordProduct> tapeList = stockManager.getTapeRecordList(stockManager.getProductList());
		System.out.println(tapeList);
		
		System.out.println(stockManager.getProductList().toString());
		stockManager.saveStock();
	}
	
}
