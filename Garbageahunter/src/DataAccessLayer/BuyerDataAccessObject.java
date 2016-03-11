package DataAccessLayer;

import java.util.Date;
import java.util.List;

import DatatransferObjects.Category;
import DatatransferObjects.Item;
import DatatransferObjects.Offer;
import DatatransferObjects.PostItem;

public interface BuyerDataAccessObject {
	public List<PostItem> searchByItem(Item item);
	public List<PostItem> searchByCategory(Category cate);
	public Offer giveOffer(PostItem item, int bid);
	public int cancelOffer(Offer offer);
	public int addInterest(Item item);
	public int deleteInterest(Item item);
	public List<Item> getAllInterest();
	
	

}