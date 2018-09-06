package com.library.libmanage.dal;

import java.util.List;

import com.library.libmanage.model.Book;
import com.library.libmanage.model.Borrow;
import com.library.libmanage.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LibraryDal {
    public List<User> getUsers();

    public List<Book> getBooks();

    public Boolean addBook(Book book);

    public Boolean addUser(User user);

    public Boolean lendBook(Borrow borrow);

    public Boolean returnBook(Borrow borrow);

    public User findUser(String name) throws Exception;

    public List<Book> findBooks(String title, String author) throws Exception ;
}
