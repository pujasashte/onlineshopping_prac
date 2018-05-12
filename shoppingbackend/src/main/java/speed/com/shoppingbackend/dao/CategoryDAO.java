package speed.com.shoppingbackend.dao;

import java.util.List;

import speed.com.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	boolean add(Category category);
	
	List<Category> list();

	Category get(int id);
	

}
