package com.library.libmanage.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    String title;
    String author;
    Integer copies;
    @JsonIgnore
    Set<User> users = new HashSet<>();

    @Override
    public int hashCode() {
        return (this.title + "-" + this.author).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book other = (Book) o;
            return this.title.equals(other.title) && this.author.equals(other.author);
        }
        return false;
    }
}