package pl.spring.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Controller
@ResponseBody
public class BookRestService {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books-by-title", method = RequestMethod.GET)
    public List<BookTo> findBooksByTitle(@RequestParam("titlePrefix") String titlePrefix) {
        return bookService.findBooksByTitle(titlePrefix);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public BookTo saveBook(@RequestBody BookTo book) {
        return bookService.saveBook(book);
    }
    
	@RequestMapping(value = "/booksCriteria", method = RequestMethod.POST)
	public List<BookTo> getProductsByFilter(@RequestBody BookSearchCriteria bookSearchCriteria) {
		return bookService.findBookByCriteria(bookSearchCriteria);
	}
}
