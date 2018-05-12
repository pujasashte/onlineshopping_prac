package speed.com.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import speed.com.shoppingbackend.dao.CategoryDAO;
import speed.com.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("speed.com.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void testAddCategory() {
		System.out.println("In Here");
		category = new Category();
		
		category.setName("Telivision");
		category.setDescription("this is description");
		category.setImageURL("CAT_1.png");

		assertEquals("Succesfully added category inside",true,categoryDAO.add(category));
	}
}
