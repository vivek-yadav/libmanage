package com.library.libmanage.service;

import java.util.List;

import com.library.libmanage.model.Book;
import com.library.libmanage.model.Borrow;
import com.library.libmanage.model.User;

import org.springframework.stereotype.Service;

@Service
public interface LibraryService {
    public List<User> getUsers();

    public List<Book> getBooks();

    public Boolean addBook(Book book);

    public Boolean addUser(User user);

    public Boolean lendBook(Borrow borrow);

    public Boolean returnBook(Borrow borrow);

    public User findUser(String name) throws Exception;

    public Book findBooks(String title, String author) throws Exception;
}