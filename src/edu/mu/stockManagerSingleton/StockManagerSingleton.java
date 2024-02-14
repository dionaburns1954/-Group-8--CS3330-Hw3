package edu.mu.stockManagerSingleton;

import java.util.ArrayList;

import edu.mu.cdRecordProduct.CDRecordProduct;
import edu.mu.mediaProduct.MediaProduct;
import edu.mu.tapeRecordProduct.TapeRecordProduct;
import edu.mu.vinylRecordProduct.VinylRecordProduct;

public class StockManagerSingleton {
	private String inventoryFilePath = "inventory.csv";
	
	
	public boolean initializeStock() {
		//needs to be completed 
		return true;
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
