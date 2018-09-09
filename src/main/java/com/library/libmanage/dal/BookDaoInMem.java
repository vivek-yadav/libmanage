package com.library.libmanage.dal;

import java.util.ArrayList;

import com.library.libmanage.model.Book;

import org.springframework.stereotype.Repository;

@Repository("BookDaoInMem")
public class BookDaoInMem extends GenericDaoInMem<Book> implements BookDao {
    public BookDaoInMem() {
        list = new ArrayList<Book>();
    }
}
