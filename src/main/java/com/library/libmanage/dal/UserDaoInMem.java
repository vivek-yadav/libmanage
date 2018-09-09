package com.library.libmanage.dal;

import java.util.ArrayList;

import com.library.libmanage.model.User;

import org.springframework.stereotype.Repository;

@Repository("UserDaoInMem")
public class UserDaoInMem extends GenericDaoInMem<User> implements UserDao {

    public UserDaoInMem() {
        list = new ArrayList<User>();
    }
}
