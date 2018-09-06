package com.library.libmanage.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.library.libmanage.model.Book;
import com.library.libmanage.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public class LibraryDalImpl implements LibraryDal {

    List<User> users = new ArrayList<>(){new User("vivek")};
    List<Book> books = new ArrayList<>(){new Book("ABC","abc")};
    Map<String, User> userNames = new HashMap<>();
    Map<String, Map<String,Book>> bookTitles = new HashMap<>(); // outerkey : Title, innerkey: Author
    Map<String, Map<String,Book>> bookAuthors = new HashMap<>(); // outerkey : Author, innerkey: Title

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Boolean addBook(Book book) {
        if (!bookTitles.containsKey(book.getTitle())){
            books.add(book);
            bookTitles.put(book.getTitle(), new HashMap<>());
        }
        Map<String,Book> foundTitleBooks = bookTitles.get(book.getTitle());
        if (!foundBooks.containsKey(book.getAuthor())){
            foundBooks.put(book.getAuthor(),book)
        }
        if (!bookAuthors.containsKey(book.getAuthor())){
            books.add(book);
            bookAuthors.put(book.getAuthor(), new HashMap<>());
        }
        Map<String, Book> foundAuthorBooks = bookAuthors.get(book.getAuthor());
        if (!foundAuthorBooks.containsKey(book.getTitle())){
            foundAuthorBooks.put(book.getTitle(),book)
        }
        return null;
    }

    @Override
    public Boolean addUser(User user) {
        return null;
    }

    @Override
    public Boolean lendBook(Book book, User user) {
        return null;
    }

    @Override
    public Boolean returnBook(Book book, User user) {
        return null;
    }

    @Override
    public List<User> findUser(String name) {
        return null;
    }

    @Override
    public List<Book> findBook(String title, String author) {
        return null;
    }


}