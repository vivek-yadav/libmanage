package com.library.libmanage.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.libmanage.model.Book;
import com.library.libmanage.model.Borrow;
import com.library.libmanage.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class LibraryDalImpl implements LibraryDal {

    List<User> users = new ArrayList<>();
    List<Book> books = new ArrayList<>();
    Map<String, User> userNames = new HashMap<>();
    Map<String, Map<String, Book>> bookTitles = new HashMap<>(); // outerkey : Title, innerkey: Author
    Map<String, Map<String, Book>> bookAuthors = new HashMap<>(); // outerkey : Author, innerkey: Title

    public LibraryDalImpl() {
        // this.addUser(new User("vivek", 5, new HashSet<>()));
        // this.addBook(new Book("ABC", "abc", 10, new HashSet<>()));
    }

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
        boolean isAdded = false;
        if (!bookTitles.containsKey(book.getTitle())) {
            books.add(book);
            isAdded = true;
            bookTitles.put(book.getTitle(), new HashMap<>());
        }
        Map<String, Book> foundTitleBooks = bookTitles.get(book.getTitle());
        if (!foundTitleBooks.containsKey(book.getAuthor())) {
            foundTitleBooks.put(book.getAuthor(), book);
        } else {
            book = foundTitleBooks.get(book.getAuthor());
        }
        if (!bookAuthors.containsKey(book.getAuthor())) {
            if (!isAdded) {
                books.add(book);
                isAdded = true;
            }
            bookAuthors.put(book.getAuthor(), new HashMap<>());
        }
        Map<String, Book> foundAuthorBooks = bookAuthors.get(book.getAuthor());
        if (!foundAuthorBooks.containsKey(book.getTitle())) {
            foundAuthorBooks.put(book.getTitle(), book);
        }
        return isAdded;
    }

    @Override
    public Boolean addUser(User user) {
        if (!userNames.containsKey(user.getName())) {
            users.add(user);
            userNames.put(user.getName(), user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean lendBook(Borrow borrow) {
        Book book = borrow.getBook();
        User user = borrow.getUser();
        Book foundBook = null;
        if (bookTitles.containsKey(book.getTitle())) {
            if (bookTitles.get(book.getTitle()).containsKey(book.getAuthor())) {
                foundBook = bookTitles.get(book.getTitle()).get(book.getAuthor());
            }
        }
        if (foundBook == null) {
            return false;
        }
        User foundUser = null;
        foundUser = userNames.get(user.getName());
        if (foundUser == null) {
            return false;
        }

        if (foundBook.getCopies() > foundBook.getUsers().size()) {
            if (foundUser.getBorrowLimit() > foundUser.getBooks().size()) {
                foundUser.getBooks().add(foundBook);
                foundBook.getUsers().add(foundUser);
                return true;
            }
        }
        return null;
    }

    @Override
    public Boolean returnBook(Borrow borrow) {
        Book book = borrow.getBook();
        User user = borrow.getUser();
        User foundUser = userNames.get(user.getName());
        if (foundUser == null) {
            return false;
        }
        Book foundBook = null;
        if (bookTitles.containsKey(book.getTitle())) {
            if (bookTitles.get(book.getTitle()).containsKey(book.getAuthor())) {
                foundBook = bookTitles.get(book.getTitle()).get(book.getAuthor());
            }
        }
        if (foundBook == null) {
            return false;
        }
        if (foundBook.getUsers().contains(foundUser) && foundUser.getBooks().contains(foundBook)) {
            foundBook.getUsers().remove(foundUser);
            foundUser.getBooks().remove(foundBook);
            return true;
        }
        return false;
    }

    @Override
    public User findUser(String name) throws Exception {
        if (userNames.containsKey(name)) {
            return userNames.get(name);
        } else {
            throw new Exception("User Name not found");
        }
    }

    @Override
    public List<Book> findBooks(String title, String author) throws Exception {
        if (author.isEmpty() && !title.isEmpty()) {
            if (bookTitles.containsKey(title)) {
                return (List<Book>) bookTitles.get(title).values();
            }
        } else if (!author.isEmpty() && title.isEmpty()) {
            if (bookAuthors.containsKey(author)) {
                return (List<Book>) bookAuthors.get(author).values();
            }
        } else if (!author.isEmpty() && !title.isEmpty()) {
            if (bookTitles.containsKey(title)) {
                if (bookTitles.get(title).containsKey(author)) {
                    List<Book> result = new ArrayList<>();
                    result.add(bookTitles.get(title).get(author));
                    return result;
                }
            }
        }
        return new ArrayList<Book>();
    }

}