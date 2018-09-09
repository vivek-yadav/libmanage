package com.library.libmanage.dal;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericDaoInMem<E> implements GenericDao<E> {

    List<E> list;

    @Override
    public List<E> getList() {
        return list;
    }

    @Override
    public E add(E e) {
        if (list.add(e)) {
            return e;
        } else {
            return null;
        }
    }

    @Override
    public E update(E e) {
        if (list.indexOf(e) != -1) {
            int pos = list.indexOf(e);
            list.set(pos, e);
            return e;
        } else {
            return null;
        }
    }

    @Override
    public E delete(E e) {
        if (list.indexOf(e) != -1) {
            int pos = list.indexOf(e);
            list.remove(pos);
            return e;
        } else {
            return null;
        }
    }

    @Override
    public E get(E e) {
        if (list.indexOf(e) != -1) {
            int pos = list.indexOf(e);
            return list.get(pos);
        } else {
            return null;
        }
    }

}