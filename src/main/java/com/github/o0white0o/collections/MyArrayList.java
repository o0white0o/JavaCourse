package com.github.o0white0o.collections;

import java.util.*;

public class MyArrayList<T> implements List<T> {

private T[] array;
private int size = 0;
private int capacity = 10;

MyArrayList() {
    array = (T[]) new Object[capacity];
}


public int size() {
    return size;
}

@Override
public boolean isEmpty() {
    return size == 0;
}

@Override
public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
        if (array[i].equals(o)) {
            return true;
        }
    }
    return false;
}

@Override
public Iterator<T> iterator() {
    return null;
}

@Override
public Object[] toArray() {
    return Arrays.copyOf(array, size);
}

@Override
public <T> T[] toArray(T[] a) {
    if (a.length < size)
        // Make a new array of a's runtime type, but my contents:
        return (T[]) Arrays.copyOf(array, size, a.getClass());
    System.arraycopy(array, 0, a, 0, size);
    if (a.length > size)
        a[size] = null;
    return a;
}

@Override
public boolean add(T t) {
    if (size >= capacity) {
        capacity = capacity * 2;
        T[] newArray = (T[]) new Object[capacity];
        if (size >= 0) System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    array[size] = t;
    size++;
    return true;
}

@Override
public boolean remove(Object o) {

    return false;
}

@Override
public boolean containsAll(Collection<?> c) {
    return false;
}

@Override
public boolean addAll(Collection<? extends T> c) {
    return false;
}

@Override
public boolean addAll(int index, Collection<? extends T> c) {
    return false;
}

@Override
public boolean removeAll(Collection<?> c) {
    return false;
}

@Override
public boolean retainAll(Collection<?> c) {
    return false;
}

@Override
public void clear() {
    size = 0;
    array = (T[]) new Object[capacity];
}

@Override
public T get(int index) {
    if (index < 0 || index > size) {
        return null;
    }
    return array[index];
}

@Override
public T set(int index, T element) {
    if (index < 0 || index > size) {
        return null;
    }
    array[index] = element;
    return array[index];
}

@Override
public void add(int index, T element) {

}

@Override
public T remove(int index) {
    if (index < 0 || index > size) {
        return null;
    }
    int sizeSubArray = size - index;
    T[] subArray = (T[]) new Object[sizeSubArray];
    int j = 0;
    for(int i = index + 1; i < size; i++) {
        subArray[j++] = array[i];
    }
    size--;
    j = 0;
    for(int i = index; i < size; i++) {
        array[i] = subArray[j++];
    }
    if (index == 0) {
        return null;
    }
    return array[index - 1];
}


@Override
public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
        if (o.equals(array[i])) {
            return i;
        }
    }
    return -1;
}

@Override
public int lastIndexOf(Object o) {
    return 0;
}

@Override
public ListIterator<T> listIterator() {
    return null;
}

@Override
public ListIterator<T> listIterator(int index) {
    return null;
}

@Override
public List<T> subList(int fromIndex, int toIndex) {
    return null;
}

@Override
public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("[");
    for (int i = 0; i < size; i++) {
        str.append(array[i]);
        if (i != size - 1) {
            str.append(", ");
        }
    }
    str.append("]");

    return str.toString();
}
}
