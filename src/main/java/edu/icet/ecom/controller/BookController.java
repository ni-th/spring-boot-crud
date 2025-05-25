package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.BookDTO;
import edu.icet.ecom.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping
    public List<BookDTO> getAll(){
        return bookService.getAll();
    }

    @PostMapping
    public void add(@RequestBody BookDTO bookDTO){
        bookService.add(bookDTO);
    }

    @DeleteMapping("/{isbn}")
    public void delete(@PathVariable Long isbn){
        bookService.delete(isbn);
    }
    @PutMapping
    public void update(@RequestBody BookDTO bookDTO){
        bookService.update(bookDTO);
    }
    @PostMapping("/{isbn}")
    public BookDTO findByIsbn(@PathVariable Long isbn){
       return bookService.findByIsbn(isbn);
    }

}
