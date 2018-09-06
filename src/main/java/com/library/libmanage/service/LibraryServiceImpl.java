package com.library.libmanage.service;

import java.util.List;

import com.library.libmanage.dal.LibraryDal;
import com.library.libmanage.model.Book;
import com.library.libmanage.model.Borrow;
import com.library.libmanage.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDal dal;

    public List<User> getUsers() {
        return dal.getUsers();
    }

    public List<Book> getBooks() {
        return dal.getBooks();
    }

    public Boolean addBook(Book book) {
        return dal.addBook(book);
    }

    public Boolean addUser(User user) {
        return dal.addUser(user);
    }

    public Boolean lendBook(Borrow borrow) {
        return dal.lendBook(borrow);
    }

    public Boolean returnBook(Borrow borrow) {
        return dal.returnBook(borrow);
    }

    public User findUser(String name) throws Exception {
        return dal.findUser(name);
    }

    public List<Book> findBooks(String title, String author) throws Exception {
        return dal.findBooks(title, author);
    }

}