package app.filter.impl;

import app.entity.flower.Flower;
import app.filter.Filter;

public class RangeLength implements Filter {
    private int minValue;
    private int maxValue;
    
    public RangeLength(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    
    @Override
    public boolean check(Flower flower) {
        double length = flower.getLength();
        return (length * 100 >= minValue) && (length * 100 <= maxValue);
    }
}