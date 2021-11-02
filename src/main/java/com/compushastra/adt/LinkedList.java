package com.compushastra.adt;

public interface LinkedList {
    boolean isEmpty();
    int length();
    void empty();
    void add(Object element);
    Object get(int index) throws IndexOutOfBoundsException;
    int remove(Object element);
    int indexOf(Object element);
    void insertAt(int index, Object element) throws IndexOutOfBoundsException;
    Object removeAt(int index) throws IndexOutOfBoundsException;
}


