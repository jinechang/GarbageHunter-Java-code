package BusinessLayer;

import java.util.List;
import DataAccessLayer.OfferDataAccessObject;
import DataAccessLayer.OfferDataAccessObjectImpl;
import DatatransferObjects.Offer;
import DatatransferObjects.PostItem; 

public class OfferBusinessLogic{

	private OfferDataAccessObject offerDataAccessObject = null; 

	public OfferBusinessLogic() {
		offerDataAccessObject = new OfferDataAccessObjectImpl();
	}

	public int addOffer(Offer offer) {
		offerDataAccessObject.addOffer(offer);
		return 0;
	}

	public int deleteOffer(Offer offer) {
		offerDataAccessObject.deleteOffer(offer);
		return 0;
	}

	public int updateOffer(Offer offer) {
		offerDataAccessObject.updateOffer(offer);
		return 0;
	}

	public List<Offer> getOfferByItem(PostItem item) {
		offerDataAccessObject.getOfferByItem(item);
		return null;
	}

}
