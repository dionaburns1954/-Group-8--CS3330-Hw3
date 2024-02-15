package edu.mu.main;
import java.io.FileNotFoundException;

import edu.mu.stockManagerSingleton.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockManagerSingleton test = StockManagerSingleton.getInstance();
		try {
			test.initializeStock();
			System.out.println(test.productList.toString());
			//System.out.println(test.productList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.saveStock();
	}

}
