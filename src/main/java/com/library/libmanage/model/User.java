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
public class User {
    String name;
    Integer borrowLimit;
    @JsonIgnore
    Set<Book> books = new HashSet<>();

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            User other = (User) o;
            return this.name.equals(other.name);
        }
        return false;
    }
}