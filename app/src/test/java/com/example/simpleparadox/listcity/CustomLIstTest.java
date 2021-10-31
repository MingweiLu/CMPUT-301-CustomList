package com.example.simpleparadox.listcity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomLIstTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void hasCityTest() {
        City newCity = new City("Calgary", "Alberta");
        list.addCity(newCity);
        assertTrue(list.hasCity(newCity));
    }

    @Test
    public void deleteCityTest() {
        int listSize = list.getCount();
        City newCity = new City("Toronto", "Ontario");
        list.addCity(newCity);
        assertEquals(listSize + 1, list.getCount());
        list.deleteCity(newCity);
        assertFalse(list.hasCity(newCity));
    }

    @Test
    public void countCitiesTest() {
        int listSize = list.getCount();
        City mockCity = new City("Edmonton", "Alberta");
        list.addCity(mockCity);
        City newCity = new City("Vancouver", "British Columbia");
        list.addCity(newCity);
        assertEquals(listSize + 2, list.countCities());
        list.deleteCity(mockCity);
        list.deleteCity(newCity);
        assertEquals(listSize, list.countCities());
    }

}
