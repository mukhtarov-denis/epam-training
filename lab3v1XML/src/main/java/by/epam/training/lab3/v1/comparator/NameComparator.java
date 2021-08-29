package by.epam.training.lab3.v1.comparator;

import java.util.Comparator;

import by.epam.training.lab3.v1.entity.Plant;

public class NameComparator implements Comparator<Plant> {

    @Override
    public int compare(Plant plant1, Plant plant2) {
        return plant1.getName().compareTo(plant2.getName());
    }
}