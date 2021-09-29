package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private BookRepository books;
	@Autowired
	private CategoryRepository catrep;

	@RequestMapping("/categorylist")
	public String getCategories(Model model) {
		model.addAttribute("categories", catrep.findAll());

		return "categorylist";

	}
	

	@RequestMapping(value = "/addcategory")
	public String addBook(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	@RequestMapping(value = "/savecat", method = RequestMethod.POST)
	public String save(Category category) {
		catrep.save(category);
		return "redirect:categorylist";
	}
	

}
