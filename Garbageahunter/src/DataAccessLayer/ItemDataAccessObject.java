package DataAccessLayer;

import java.util.ArrayList;
import java.util.List;

import DatatransferObjects.Category;
import DatatransferObjects.Item;

public interface ItemDataAccessObject {
	public int addItem(Item item); 
	public int deleteItem(Item item);
	public int updateItem(Item item);
	public Item getItemByName(String itemName);
	public Item getItemByItem(Item item);
	public ArrayList<Item> getItemByCategory(Category category);
	public List<Item> getAllItems();
}
