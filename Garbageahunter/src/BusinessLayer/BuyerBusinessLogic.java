package BusinessLayer;

import java.util.Date;
import java.util.List;

import DataAccessLayer.BuyerDataAccessObject;
import DataAccessLayer.BuyerDataAccessObjectImpl;
import DatatransferObjects.Category;
import DatatransferObjects.Item;
import DatatransferObjects.Offer;
import DatatransferObjects.PostItem;

public class BuyerBusinessLogic {

	private BuyerDataAccessObject buyerDataAccessObject = null; 
	public BuyerBusinessLogic(){
		buyerDataAccessObject = new BuyerDataAccessObjectImpl();
	}
	
	public List<PostItem> searchByItem(Item item){
		return buyerDataAccessObject.searchByItem(item);
	};
	
	public List<PostItem> searchByCategory(Category cate){
		return buyerDataAccessObject.searchByCategory(cate);
	};
	
	public Offer giveOffer(PostItem item,int bid){
		return buyerDataAccessObject.giveOffer(item, bid);
	};
	
	public int cancelOffer(Offer offer){
		return buyerDataAccessObject.cancelOffer(offer);
	};
	
	public int addInterest(Item item){
		return buyerDataAccessObject.addInterest(item);
	};
	
	public int deleteInterest(Item item){
		return buyerDataAccessObject.deleteInterest(item);
	};
	
	public List<Item> getAllInterest(){
		return buyerDataAccessObject.getAllInterest();
	};
}
