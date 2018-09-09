package com.library.libmanage.service;

import java.util.List;

import com.library.libmanage.dal.BookDao;
import com.library.libmanage.dal.UserDao;
import com.library.libmanage.model.Book;
import com.library.libmanage.model.Borrow;
import com.library.libmanage.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    @Qualifier(value = "UserDaoInMem")
    private UserDao userDao;

    @Autowired
    @Qualifier(value = "BookDaoInMem")
    private BookDao bookDao;

    public List<User> getUsers() {
        return userDao.getList();
    }

    public List<Book> getBooks() {
        return bookDao.getList();
    }

    public Boolean addBook(Book book) {
        Book result = bookDao.add(book);
        if (result != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean addUser(User user) {
        User result = userDao.add(user);
        if (result != null) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean lendBook(Borrow borrow) {
        User user = userDao.get(borrow.getUser());
        Book book = bookDao.get(borrow.getBook());
        if (user != null && book != null) {
            if (user.getBorrowLimit() > user.getBooks().size() && book.getCopies() > book.getUsers().size()) {
                user.getBooks().add(book);
                book.getUsers().add(user);
                return true;
            }
        }
        return false;
    }

    public Boolean returnBook(Borrow borrow) {
        User user = userDao.get(borrow.getUser());
        Book book = bookDao.get(borrow.getBook());
        if (user != null && book != null) {
            if (user.getBooks().contains(book) && book.getUsers().contains(user)) {
                user.getBooks().remove(book);
                book.getUsers().remove(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public User findUser(String name) throws Exception {
        User user = userDao.get(new User(name, 0, null));
        return user;
    }

    @Override
    public Book findBooks(String title, String author) throws Exception {
        Book book = bookDao.get(new Book(title, author, 0, null));
        return book;
    }

}