package hh.swd20.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Bookstore.domain.Book;

@Controller
@ResponseBody

public class BookController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";

	}

}
