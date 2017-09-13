package com.tsk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tsk.repo.BookRepository;
import com.tsk.services.book.AddBookRequest;
import com.tsk.services.book.AddBookResponse;
import com.tsk.services.book.GetBookRequest;
import com.tsk.services.book.GetBookResponse;

@Endpoint
public class BookEndPoint {
    
    private static final String NAMESPACE_URI = "http://com/tsk/services/book";

    private BookRepository bookRepository;

    @Autowired
    public BookEndPoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // To handle getBookRequest
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request) {
        GetBookResponse response = new GetBookResponse();
        response.setBook(bookRepository.findBook(request.getName()));

        return response;
    }
    
    // To handle addBookRequest
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addBook(@RequestPayload AddBookRequest request) {
        AddBookResponse response = new AddBookResponse();
        bookRepository.addBook(request.getBook());
        response.setStatus("SUCCESS");
        return response;
    }
}