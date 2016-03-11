import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import BusinessLayer.ItemBusinessLogic;
import BusinessLayer.PostItemBusinessLogic;
import BusinessLayer.SellerBusinessLogic;
import DataAccessLayer.PostitemStatus;
import DatatransferObjects.Category;
import DatatransferObjects.Item;
import DatatransferObjects.PostItem;
import DatatransferObjects.User;

public class Test {
	PostItemBusinessLogic postlogic = new PostItemBusinessLogic();
	ItemBusinessLogic itemlogic = new ItemBusinessLogic();
	SellerBusinessLogic sellerlogic = new SellerBusinessLogic();
	public void test() {
			//String testRecordPrimaryKey = "";
			
			//post an item
			System.out.println("\n-----Post an item-----");
			post();
			
			
			//search items posted
			System.out.println("\n-----Search-----");
			searchByItem("TV");
			searchByUser("Jine");
			searchByCategory("KITCHENWARE");
			searchByCategory("ELECTRICAL_APPLIANCE");
			searchByCategory("FURNITURE");

	}
	
	private void searchByCategory(String cate) {

		System.out.println("\nSearch All Items of "+cate+":");
		List<PostItem> list = null;
		//need modify later
		Category category = new Category(cate);
		//check
		//System.out.println(user.getUserName());
		if(category != null){
			list = postlogic.getItemByCategory(category);
			//need modify
			/*
			System.out.println("There are "+list.size()+ " items of "+cate +" are posted :");
			for(PostItem post:list){
				System.out.println(post.toString());
			}
			*/
			}
		else
			System.out.println("No any item of "+cate+" is posted.");
	}

	private void search(Item item) {
		String itemname = item.getItemName();
		System.out.println("Search All "+itemname+":");
		List<PostItem> list = null;
		if(item != null){
			list = postlogic.getItemByItem(item);
			System.out.println("There are "+list.size()+ " "+item +" are posted:");
			for(PostItem post:list){
				System.out.println(post.toString());
			}
			}
		else
			System.out.println("No any "+itemname+" is posted.");
	}
	
	private void searchByItem(String keyword_item) {
		
		System.out.println("Search All "+keyword_item+":");
		List<PostItem> list = null;
		Item item = itemlogic.getItemByName(keyword_item);
		if(item != null){
			list = postlogic.getItemByItem(item);
			System.out.println("There are "+list.size()+ " "+keyword_item +" are posted:");
			for(PostItem post:list){
				System.out.println(post.toString());
			}
			}
		else
			System.out.println("No any "+keyword_item+" is posted.");
	}
	
	private void searchByUser(String userName) {
		
		System.out.println("\nSearch All Items posted by "+userName+":");
		List<PostItem> list = null;
		//check
		//System.out.println("***");
		User user = sellerlogic.getUserByName(userName);
		//check
		//System.out.println(user.getUserName());
		if(user != null){
			list = postlogic.getItemBySeller(userName);
			System.out.println("There are "+list.size()+ " items posted by "+userName +" :");
			for(PostItem post:list){
				System.out.println(post.toString());
			}
			}
		else
			System.out.println("No any "+userName+" is posted.");
	}

	private void post() {
		//PostItem post = inputdata("Java Programming","Technical book","BOOK","Wenjun",3,100);
		//PostItem post = inputdata("Wood table","Table","FURNITURE","Jine",3,20);
		//PostItem post = inputdata("LG TV","TV","ELEVTRICAL_APPLIANCE","Jine",3,200);
		//PostItem post = inputdata("Sansung TV","TV","ELEVTRICAL_APPLIANCE","Jine",1,300);
		//PostItem post = inputdata("Good Condition sofa","Sofa","FURNITURE","Wenjun",1,80);
		//PostItem post = inputdata("Good cooker","Cooker","KITCHENWARE","Wenjun",3,200);
		PostItem post = inputdata("cooker 2","Cooker","KITCHENWARE","Jine",4,50);
		//PostItem post = inputdata("cooker 4","Cooker","KITCHENWARE","Wenjun",1,500);
		if (postlogic.addItem(post)==1){
			System.out.print("\nCongratulations! This item is posted successfully.\n");
			}
	}

	private PostItem inputdata(String postitemName,String itemName,String category,String seller,
			int yearsofuse,int postPrice) {
		
		PostItem postitem = new PostItem();

		System.out.println("Enter the data of item: ");
		System.out.println("postitemName:  "+postitemName);
		System.out.println("itemName:      "+itemName);
		System.out.println("category:      "+category);
		System.out.println("seller:        "+seller);
		System.out.println("yearsofuse:    "+yearsofuse);
		System.out.println("postPrice:     "+postPrice);
		
		Item item = checkItem(itemName,category);
		User user = checkUser(seller);
		postitem.setPostItem(postitemName);
		postitem.setItem(item);
		postitem.setCategory(postitem.getItem().getCategory());
		postitem.setPostUser(user);
		postitem.setYearsofuse(yearsofuse);
		postitem.setPostPrice(postPrice);

		java.util.Date utilDate = new java.util.Date();
		postitem.setPostDate(utilDate);
		//check
		System.out.println(postitem.getPostDate());
		postitem.setStatus(PostitemStatus.AVAILABLE);
		
		return postitem;
	}
	
	private User checkUser(String seller) {
		User user = new User(seller);
		return user;
		/*
		SellerBusinessLogic sellerlogic = new SellerBusinessLogic();
		User user = Sellerlogic.getUserByName(seller);
		if(user == null){
			System.out.println("Warning! This user does not exist.");
		}
		return user;
		*/
	}

	private Item checkItem(String itemName, String category) {

		Item item = itemlogic.getItemByName(itemName);
		if ( item == null){
			System.out.println("add new Item:"+itemName+" with Category:"+category);
			item = new Item(itemName,new Category(category));
			itemlogic.addItem(item);
		}
			return item;
	}


}
