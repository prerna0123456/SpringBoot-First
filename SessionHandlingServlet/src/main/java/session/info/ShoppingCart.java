package session.info;

import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {

	List<String> items=new LinkedList<>();
	
	public ShoppingCart() {
		items.add("Trousers");
		items.add("Shirts");
		items.add("Groceries");
	}

	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + "]";
	}
	
	
}
