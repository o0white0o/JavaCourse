package com.github.o0white0o.collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class MyArrayListTest {

private List<Integer> list;

@Before
public void setUp() {
    list = new MyArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
}

@Test
public void createTest() {
    Assertions.assertFalse(list.isEmpty(), "List empty");
    Assertions.assertEquals(3, list.size(), "Invalid list size");
}

@Test
public void removeTest() {
    list.remove(1);
    Assertions.assertEquals(2, list.size(), "Element not removed");
    Assertions.assertEquals("[1, 3]", list.toString(),
                            "The element was not deleted correctly");
}

@Test
public void capacityTest() {
    int capacity = 1_000_000;
    list.clear();
    Assertions.assertTrue(list.isEmpty(), "List is not empty");
    for (int i = 0; i < capacity; i++) {
        list.add(i);
    }
    Assertions.assertEquals(capacity, list.size(), "Error size");
}

}
