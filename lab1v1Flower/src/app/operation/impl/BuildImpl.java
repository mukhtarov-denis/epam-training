package app.operation.impl;

import app.entity.bouquet.Bouquet;
import app.entity.bouquet.BouquetFlowers;
import app.entity.flower.builder.FlowerBuilder;
import app.entity.flower.builder.FlowerDirector;
import app.factory.FlowerFactory;
import app.operation.Build;

public class BuildImpl implements Build {

    @Override
    public Bouquet buildBouquet() {
        FlowerBuilder flowerBuilder = FlowerFactory.getInstance();
        FlowerDirector flowerDirector = new FlowerDirector();
        Bouquet bouquet = new BouquetFlowers();
        flowerDirector.buildRose(flowerBuilder);
        bouquet.addFlower(flowerBuilder.getResult());
        flowerDirector.buildLily(flowerBuilder);
        bouquet.addFlower(flowerBuilder.getResult());
        flowerDirector.buildCalla(flowerBuilder);
        bouquet.addFlower(flowerBuilder.getResult());
        flowerDirector.buildCarnation(flowerBuilder);
        bouquet.addFlower(flowerBuilder.getResult());
        flowerDirector.buildRose(flowerBuilder);
        bouquet.addFlower(flowerBuilder.getResult());
        return bouquet;
    }

    @Override
    public Bouquet buildBlankBouquet() {
        Bouquet bouquet = new BouquetFlowers();
        return bouquet;
    }
}