package io.github.patrikalm.dao;

import io.github.patrikalm.City;

import static org.junit.jupiter.api.Assertions.*;

class CityDaoJDBCTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.Test
    void findById() {
        int id = 3;
        City testCity = new City("Herat", "AFG", "Herat", 186800);
        assertEquals(findById());
    }

    @org.junit.jupiter.api.Test
    void findByCode() {
    }

    @org.junit.jupiter.api.Test
    void findByName() {
    }

    @org.junit.jupiter.api.Test
    void findAll() {
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}