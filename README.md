# -Group-8--CS3330-Hw3
## Description
This project is an inventory management system for a theoretical media product shop. It takes a CSV file and reads it, creating an inventory from the CSV file. The StockManagerSingleton class is used for basic CRUD operations to the inventory. After changes are finished, the StockManagerSingleton class can write the inventory back to the specified CSV file.

## How to run
To run this program please clone the repository and run the Main class which can be located as 'edu.mu.main.Main'. The Main class demonstrates the usage of the inventory management system by performing different operations such as initializing the stock, updating the price, adding and removing items, printing out a list of the media products, and much more.

For this project to work properly you need to make sure that entries in the CSV file are organized in the following format: 

`Type,Title,Price,Year,Genre`

## StockManagerSingleton Class Methods
Below is a short description of each of the methods in the StockManagerSingleton class:
- `getInstance()`
    - Gets the instance of the StockManagerSingleton
- `getInventoryFilePath()`
    - Returns the path to the CSV file
- `getProductList()`
    - Returns the entire product list in the StockManagerSingleton inventory
- `initializeStock()`
    - Loads the CSV file into the StockManagerSingleton inventory
- `updateItemPrice(MediaProduct, double)`
    - Updates a given MediaProduct's price
- `addItem(MediaProduct)`
    - Adds a MediaProduct object to the inventory
- `removeItem(MediaProduct)`
    - Removes a given MediaProduct from the inventory
- `saveStock()`
    - Saves the inventory to the CSV file specified by `inventoryFilePath`
- `getMediaProductBelowPrice(int)`
    - Gets an ArrayList of MediaProducts below the specified price
- `printListOfMediaProduct(ArrayList<MediaProduct>)`
    - Pretty prints a given ArrayList of MediaProducts
- `getVinylRecordList(ArrayList<MediaProduct>)`
    - Returns a list of all VinylRecordProducts in the inventory
- `getCDRecordList(ArrayList<MediaProduct>)`
    - Returns a list of all CDRecordProducts in the inventory
- `getTapeRecordList(ArrayList<MediaProduct>)`
    - Returns a list of all TapeRecordProducts in the inventory

## Dependencies
Java JDK 21

## Team Members
- Albert Zhou
- Dion Burns
- Logan Bird
- Ryan Esparza.
