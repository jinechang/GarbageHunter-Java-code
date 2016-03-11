package DataAccessLayer;

import DatatransferObjects.User;
import DatatransferObjects.Offer;
import DatatransferObjects.PostItem;

public interface SellerDataAccessObject {

	public PostItem Post(PostItem item);
	public int cancelPost(PostItem item);
	public PostItem editPost(PostItem item);
	public Offer Auction(PostItem item);
	public User getUserByName(String username);
}
