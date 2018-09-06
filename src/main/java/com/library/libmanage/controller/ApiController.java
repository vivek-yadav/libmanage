package com.library.libmanage.controller;

import org.springframework.web.bind.annotation.RestController;

import com.library.libmanage.service.LibraryService;

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

    @@RequestMapping(value="/books", method=RequestMethod.GET)
    public List<Book> getBooks(@RequestParam String param) {
        return service.getBooks();
    }
    
    
}
