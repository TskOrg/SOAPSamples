package com.tsk.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.tsk.services.book.Book;

@Component
public class BookRepository {
    
    private static final List<Book> books = new ArrayList<Book>();

    @PostConstruct
    public void initData() {
        Book book1 = new Book();
        book1.setName("The Family Way");
        book1.setAuthor("Tony Parsons");
        book1.setPrice("10 $");
        
        books.add(book1);

        Book book2 = new Book();
        book2.setName("Count To Ten");
        book2.setAuthor("Karen Rose");
        book2.setPrice("12 $");
        
        books.add(book2);
    }

    public Book findBook(String name) {
        Assert.notNull(name);

        Book result = null;

        for (Book book : books) {
            if (name.equals(book.getName())) {
                result = book;
            }
        }

        return result;
    }
    
    public void addBook(Book book) {
        books.add(book);
    }
}