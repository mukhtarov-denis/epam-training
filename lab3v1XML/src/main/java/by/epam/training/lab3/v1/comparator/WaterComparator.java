package by.epam.training.lab3.v1.comparator;

import java.util.Comparator;

import by.epam.training.lab3.v1.entity.Plant;
import by.epam.training.lab3.v1.entity.parameter.Parameter;
import by.epam.training.lab3.v1.entity.parameter.tips.Water;

public class WaterComparator implements Comparator<Plant> {

    @Override
    public int compare(Plant plant1, Plant plant2) {
        Water water1 = null, water2 = null;
        for (Parameter parameter : plant1.getGrowingTips()) {
            if (parameter.getClass() == Water.class) {
                water1 = (Water) parameter;
            }
        }
        for (Parameter parameter : plant2.getGrowingTips()) {
            if (parameter.getClass() == Water.class) {
                water2 = (Water) parameter;
            }
        }
        if (water1 == null || water2 == null) {
            return 0;
        }
        return Integer.compare(water1.getIntValue(), water2.getIntValue());
    }
}