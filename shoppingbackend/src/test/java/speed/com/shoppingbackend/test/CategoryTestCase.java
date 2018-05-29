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
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() { 
	 * System.out.println("In Here");
	 *  category= new Category();
	 * 
	 * category.setName("Telivision");
	 * category.setDescription("this is description");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * assertEquals("Succesfully added category inside",true,categoryDAO.add(category)); 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() { 
	 * category = categoryDAO.get(6);
	 * assertEquals("Succesfully fetch a single category from the table","Telivision",category.getName()); 
	 * }
	 * 
	 * @Test public void testUpadateCategory() { 
	 * category = categoryDAO.get(6);
	 * category.setName("TV");
	 * assertEquals("Succesfully update a single category from the table",true,categoryDAO.update(category)); 
	 * }
	 */
	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(6);
	 * 
	 * assertEquals("Succesfully delete a single category from the table",true,
	 * categoryDAO.delete(category)); }
	 */
	/*
	 * @Test public void testListCategory() {
	 * 
	 * 
	 * assertEquals("Succesfully fetch the list of category from the table",3,categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {
		// add operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("this is description");
		category.setImageURL("CAT_1.png");

		assertEquals("Succesfully added category inside", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Telivision");
		category.setDescription("this is description");
		category.setImageURL("CAT_2.png");

		assertEquals("Succesfully added category inside", true, categoryDAO.add(category));

		// fetching and updataing the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Succesfully update a single category from the table", true, categoryDAO.update(category));

		// deleting category
		assertEquals("Succesfully delete a single category from the table",true,categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Succesfully fetch the list of category from the table",1,categoryDAO.list().size()); }
	 
	}


