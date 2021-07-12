package app.factory;

import app.entity.flower.builder.FlowerBuilder;
import app.entity.flower.builder.impl.FlowerBuilderImpl;

public class FlowerFactory {
    private static FlowerBuilder builder;
    
    private FlowerFactory () {

    }
    
    public static FlowerBuilder getInstance() {
        if (builder == null) {
            return new FlowerBuilderImpl();
        }
        return builder;
    }
}