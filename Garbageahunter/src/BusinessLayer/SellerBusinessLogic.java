package BusinessLayer;

import DataAccessLayer.ItemDataAccessObject;
import DataAccessLayer.ItemDataAccessObjectImpl;
import DataAccessLayer.SellDataAccessObjectImpl;
import DataAccessLayer.SellerDataAccessObject;
import DataAccessLayer.SellerDataAccessObjectImpl;
import DatatransferObjects.Offer;
import DatatransferObjects.PostItem;
import DatatransferObjects.User;

public class SellerBusinessLogic {

	private SellerDataAccessObjectImpl sellerDataAccessObject = null; 
	
	public SellerBusinessLogic(){
		sellerDataAccessObject = new SellerDataAccessObjectImpl();
	}
	
	public PostItem Post(PostItem item){
		return sellerDataAccessObject.Post(item);
	};
	public int cancelPost(PostItem item){
		return sellerDataAccessObject.cancelPost(item);
	};
	
	public PostItem editPost(PostItem item){
		return sellerDataAccessObject.editPost(item);
	};
	
	public Offer Auction(PostItem item){
		return sellerDataAccessObject.Auction(item);
	};
	
	public User getUserByName(String username){
		//check
		//System.out.println("----");
		return sellerDataAccessObject.getUserByName(username);
	}
	
}
