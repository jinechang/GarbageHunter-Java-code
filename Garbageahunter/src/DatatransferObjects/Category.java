package DatatransferObjects;

import java.util.UUID;

public class Category {

	private String categoryName; 

	/**
	 * default constructor
	 */
	public Category() {
		super();
	}
	
	public Category(String cate){
		this.categoryName = cate;
	}
	
	/* ACCESSORS	-----------------------------------------------------	*/

	public String getCategoryName(){
		return this.categoryName;
	}

	/* MODIFIERS	-----------------------------------------------------	*/

	public void setCategoryName(String cate){
		this.categoryName = cate;
	}

}
