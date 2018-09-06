package com.library.libmanage.service;

import com.library.libmanage.dal.LibraryDal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryDal dal

    public List<User> getUsers(){
        return dal.getUsers();
    }
    public List<Book> getBooks(){
        return dal.getBooks();
    }
    public Boolean addBook(Book book){
        return dal.addBook(book)
    }
    public Boolean addUser(User user){
        return dal.addUser(user);
    }
    public Boolean lendBook(Book book, User user){
        return dal.lendBook(book, user);
    }
    public Boolean returnBook(Book book, User user){
        return returnBook(book, user);
    }
    public List<User> findUser(String name){
        return findUser(name);
    }
    public List<Book> findBook(String title, String author){
        return findBook(title, author);
    }

}