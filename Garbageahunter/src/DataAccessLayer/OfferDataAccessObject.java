package DataAccessLayer;

import java.util.List;

import DatatransferObjects.Offer;
import DatatransferObjects.PostItem;

public interface OfferDataAccessObject {

	public int addOffer(Offer offer);
	public int deleteOffer(Offer offer);
	public int updateOffer(Offer offer);
	public List<Offer> getOfferByItem(PostItem item);
}
