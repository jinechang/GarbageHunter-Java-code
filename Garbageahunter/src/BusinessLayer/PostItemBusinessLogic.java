package BusinessLayer;

import java.util.Date;
import java.util.List;

import DataAccessLayer.PostItemDataAccessObject;
import DataAccessLayer.PostItemDataAccessObjectImpl;
import DatatransferObjects.Category;
import DatatransferObjects.Item;
import DatatransferObjects.PostItem;

public class PostItemBusinessLogic {

	private PostItemDataAccessObject postItemDataAccessObject = null; 
	
	public PostItemBusinessLogic(){
		postItemDataAccessObject = new PostItemDataAccessObjectImpl();
	}
	
	public int addItem(PostItem item){
		return postItemDataAccessObject.addItem(item);
	};
	
	public int deleteItem(PostItem item){
		return postItemDataAccessObject.deleteItem(item);
	};
	
	public int updateItem(PostItem item){
		return postItemDataAccessObject.updateItem(item);
	};
	
	public List<PostItem> getItemByItem(Item item){
		return postItemDataAccessObject.getItemByItem(item);
	};
	
	public List<PostItem> getItemByCategory(Category cate){
		return postItemDataAccessObject.getItemByCategory(cate);
	};
	
	public List<PostItem> getItemBySeller(String user){
		return postItemDataAccessObject.getItemBySeller(user);
	}
	
}
