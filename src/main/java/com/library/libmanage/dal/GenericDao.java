package com.library.libmanage.dal;

import java.util.List;

public interface GenericDao<E> {
    public List<E> getList();

    public E add(E e);

    public E update(E e);

    public E delete(E e);

    public E get(E e);
}