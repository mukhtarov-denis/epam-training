package app.operation.impl;

import app.entity.bouquet.Bouquet;
import app.entity.flower.Flower;
import app.factory.BouquetFactory;
import app.filter.Filter;
import app.operation.Find;

public class FindImpl implements Find {

    @Override
    public Bouquet find(Bouquet bouquet, Filter filter) {
        Manager manager = BouquetFactory.getInstance();
        Bouquet result = manager.buildBlankBouquet();
        for (Flower flower : bouquet.getFlowers()) {
            if (filter.check(flower)) {
                result.addFlower(flower);
            }
        }
        return result;
    }
}