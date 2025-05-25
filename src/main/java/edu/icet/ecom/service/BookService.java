package edu.icet.ecom.service;

import edu.icet.ecom.model.dto.BookDTO;
import edu.icet.ecom.model.entity.BookEntity;
import edu.icet.ecom.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public List<BookDTO> getAll(){
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (BookEntity bookEntity : bookEntities){
            BookDTO bookDTO = new BookDTO();

            bookDTO.setIsbn(bookEntity.getIsbn());
            bookDTO.setTitle(bookEntity.getTitle());
            bookDTO.setAuthor(bookEntity.getAuthor());

            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }
    public  void add(BookDTO bookDTO){
        BookEntity bookEntity = new BookEntity(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor());
        bookRepository.save(bookEntity);

    }
    public void delete(Long isbn){
        bookRepository.deleteById(isbn);
    }
    public void update(BookDTO bookDTO){
        BookEntity bookEntity = new BookEntity(bookDTO.getIsbn(), bookDTO.getTitle(), bookDTO.getAuthor());
        bookRepository.save(bookEntity);
    }


    public BookDTO findByIsbn(Long isbn) {
        Optional<BookEntity> bookEntity = bookRepository.findById(isbn);
        if (bookEntity.isPresent()){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setIsbn(bookEntity.get().getIsbn());
            bookDTO.setTitle(bookEntity.get().getTitle());
            bookDTO.setAuthor(bookEntity.get().getAuthor());
            return bookDTO;
        }
        return null;

    }
}
