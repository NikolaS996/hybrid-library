package com.hybridlibrary.services.serviceimpl;

import com.hybridlibrary.models.BookCopy;
import com.hybridlibrary.repositories.BookCopyRepository;
import com.hybridlibrary.repositories.BookRepository;
import com.hybridlibrary.services.BookCopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybridlibrary.models.Book;
import java.util.Collection;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    @Autowired
    private BookCopyRepository bookCopyRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Collection<BookCopy> findAll() {
        return bookCopyRepository.findAll();
    }

    @Override
    public BookCopy getOne(Long id) {
        return bookCopyRepository.getOne(id);
    }

    @Override
    public Collection<BookCopy> getByBook(Long id) {
        Book book = bookRepository.getOne(id);
        return bookCopyRepository.findByBook(book);
    }

    @Override
    public BookCopy update(BookCopy bookCopy) {
        bookCopyRepository.save(bookCopy);
        return bookCopy;
    }

    @Override
    public BookCopy create(BookCopy bookCopy) {
        BookCopy newBookCopy = bookCopyRepository.save(bookCopy);
        return newBookCopy;
    }

    @Override
    public void delete(Long id) {
        bookCopyRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return bookCopyRepository.existsById(id);
    }


    public Integer getCopiesCount(Long id){
        Book book = bookRepository.getOne(id);
        return bookCopyRepository.countByBook(book);
    }
}