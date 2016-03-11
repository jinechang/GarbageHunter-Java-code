package DatatransferObjects;

public class Offer {

	private User buyer;
	private PostItem item;
	private int bid;
	private int soldPrice;
	
	public Offer(){};
	public void setBuyer(User user){
		this.buyer = user;
	}
	public void setItem(PostItem item){
		this.item = item;
	}
	public void setBid(int bid){
		this.bid = bid;
	}
	public void setSoldPrice(int price){
		this.soldPrice = price;
	}
	public User getBuyer(){
		return this.buyer;
	}
	public PostItem getItem(){
		return this.item;
	}
	public int getBid(){
		return this.bid;
	}
	public int getSoldPrice(){
		return this.soldPrice;
	}
}
