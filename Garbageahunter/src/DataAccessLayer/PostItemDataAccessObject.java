package DataAccessLayer;

import java.sql.Date;
import java.util.List;

import DatatransferObjects.Category;
import DatatransferObjects.Item;
import DatatransferObjects.PostItem;
import DatatransferObjects.User;

public interface PostItemDataAccessObject {

	public int addItem(PostItem item);
	public int deleteItem(PostItem item);
	public int updateItem(PostItem item);
	public List<PostItem> getItemByDate(Date date);
	public List<PostItem> getItemBySeller(String user);
	public List<PostItem> getItemByStatus(String status);
	public List<PostItem> getItemByItem(Item item);
	public List<PostItem> getItemByCategory(Category category);
}
