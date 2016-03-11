package DataAccessLayer;

import java.util.Date;
import java.util.List;

import DatatransferObjects.Category;
import DatatransferObjects.Item;
import DatatransferObjects.Offer;
import DatatransferObjects.PostItem;

public class BuyerDataAccessObjectImpl implements BuyerDataAccessObject{

	PostItemDataAccessObject postitem = new PostItemDataAccessObjectImpl();
	
	public BuyerDataAccessObjectImpl(){
		super();
	}
	
	@Override
	public List<PostItem> searchByItem(Item item) {
		List<PostItem> postitems = null;
		postitems = postitem.getItemByItem(item);
		return postitems;
		
	}

	@Override
	public List<PostItem> searchByCategory(Category cate) {
		List<PostItem> postitems = null;
		postitems = postitem.getItemByCategory(cate);
		return postitems;
	}

	@Override
	public Offer giveOffer(PostItem item, int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cancelOffer(Offer offer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addInterest(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteInterest(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Item> getAllInterest() {
		// TODO Auto-generated method stub
		return null;
	}

}
