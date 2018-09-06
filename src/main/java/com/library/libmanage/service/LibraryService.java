package com.library.libmanage.service;

import java.util.List;

import com.library.libmanage.model.Book;
import com.library.libmanage.model.User;

import org.springframework.stereotype.Service;

@Service
public interface LibraryService {
    public List<User> getUsers();
    public List<Book> getBooks();
    public Boolean addBook(Book book);
    public Boolean addUser(User user);
    public Boolean lendBook(Book book, User user);
    public Boolean returnBook(Book book, User user);
    public List<User> findUser(String name);
    public List<Book> findBook(String title, String author);
}