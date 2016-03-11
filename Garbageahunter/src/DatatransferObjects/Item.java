package DatatransferObjects;

import java.util.UUID;

public class Item  {
	private String item; 
	private Category category; 

	/**
	 * default constructor
	 */
	public Item() {
		super();
	}
	
	public Item(String item){
		this.item = item;
	}
	
	public Item(String item, Category cate){
		this.item = item;
		this.category = cate;
	}
	
	/* ACCESSORS	-----------------------------------------------------	*/

	public String getItemName(){
		return this.item;
	}

	public Category getCategory(){
		return this.category;
	}

	/* MODIFIERS	-----------------------------------------------------	*/

	public void setItem(String item){
		this.item = item;
	}

	public void setCategory(Category cate){
		this.category = cate;
	}
	
	public String toString(){
		return this.item+":"+ this.category;
	}

}
