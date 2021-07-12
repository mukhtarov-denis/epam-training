package app.operation.impl;

import java.util.Comparator;

import app.entity.bouquet.Bouquet;
import app.entity.flower.Flower;
import app.filter.Filter;
import app.operation.Build;
import app.operation.Find;
import app.operation.Print;
import app.operation.Sort;

public class Manager implements Build, Find, Print, Sort {

    @Override
    public Bouquet buildBouquet() {
        return new BuildImpl().buildBouquet();
    }
    
    @Override
    public Bouquet buildBlankBouquet() {
        return new BuildImpl().buildBlankBouquet();
    }
    
    @Override
    public Bouquet find(Bouquet bouquet, Filter filter) {
        return new FindImpl().find(bouquet, filter);
    }
    
    @Override
    public void toConsole(Bouquet bouquet) {
        new PrintImpl().toConsole(bouquet);
    }
    
    @Override
    public void sort(Bouquet bouquet, Comparator<Flower> comparator) {
        new SortImpl().sort(bouquet, comparator);
    }
}