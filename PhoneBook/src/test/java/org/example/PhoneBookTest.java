package org.example;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {
    @BeforeEach
    void setUp() {
        System.out.println("Test start");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test finish");
    }

    @Test
    void add() {
        PhoneBook phoneBook = new PhoneBook();
        String actual = phoneBook.add("Владимир");
        String expected = "Владимир";
        assertEquals(expected, actual);
    }
    @Test
    void findByNumber() {

    }
    @Test
    void removeContact() {

    }
    @Test
    void printAllNames() {

    }

}