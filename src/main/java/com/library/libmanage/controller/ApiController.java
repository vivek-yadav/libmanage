package com.library.libmanage.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.library.libmanage.model.Book;
import com.library.libmanage.model.User;
import com.library.libmanage.model.Borrow;
import com.library.libmanage.service.LibraryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ApiController {

    @Autowired
    private LibraryService service;

    @RequestMapping("/")
    public String index() {
        return "Welcome to Library Managment System";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @RequestMapping(value = "/books/find", method = RequestMethod.GET)
    public Book findBooks(@RequestParam("title") String title, @RequestParam("author") String author) throws Exception {
        return service.findBooks(title, author);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return service.getUsers();
    }

    @RequestMapping(value = "/users/find", method = RequestMethod.GET)
    public User findUser(@RequestParam("name") String name) throws Exception {
        return service.findUser(name);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public Boolean addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Boolean addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @RequestMapping(value = "/lend", method = RequestMethod.POST)
    public Boolean lendBook(@RequestBody Borrow borrow) {
        return service.lendBook(borrow);
    }

    @RequestMapping(value = "/return", method = RequestMethod.POST)
    public Boolean returnBook(@RequestBody Borrow borrow) {
        return service.returnBook(borrow);
    }

}
