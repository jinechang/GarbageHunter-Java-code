package BusinessLayer;

import java.util.ArrayList;
import java.util.List;

import DataAccessLayer.ItemDataAccessObject;
import DataAccessLayer.ItemDataAccessObjectImpl;
import DataAccessLayer.PostItemDataAccessObject;
import DatatransferObjects.Category;
import DatatransferObjects.Item;

public class ItemBusinessLogic {
	private ItemDataAccessObject itemDataAccessObject = null; 
	
	public ItemBusinessLogic(){
		itemDataAccessObject = new ItemDataAccessObjectImpl();
	}

	public int addItem(Item item){
		return itemDataAccessObject.addItem(item);
		
	}; 
	public int deleteItem(Item item){
		return itemDataAccessObject.deleteItem(item);
		
	};
	public int updateItem(Item item){
		return itemDataAccessObject.updateItem(item);
		
	};
	public Item getItemByName(String itemName){
		return itemDataAccessObject.getItemByName(itemName);
		
	};
	public ArrayList<Item> getItemByCategory(Category category){
		return itemDataAccessObject.getItemByCategory(category);
		
	};
	public List<Item> getAllItems(){
		return itemDataAccessObject.getAllItems();
		
	};
}
