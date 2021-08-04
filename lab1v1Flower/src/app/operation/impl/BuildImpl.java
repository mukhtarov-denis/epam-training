package app.operation.impl;

import java.util.Random;

import app.entity.bouquet.Bouquet;
import app.entity.bouquet.BouquetFlowers;
import app.entity.flower.builder.FlowerBuilder;
import app.entity.flower.builder.FlowerDirector;
import app.factory.FlowerFactory;
import app.operation.Build;

public class BuildImpl implements Build {
    private Random random = new Random();
    
    @Override
    public Bouquet buildBouquet() {
        FlowerBuilder flowerBuilder = FlowerFactory.getInstance();
        FlowerDirector flowerDirector = new FlowerDirector();
        Bouquet bouquet = new BouquetFlowers();
        for (int i = 1; i <= random.nextInt(3) + 1; i++) {
            flowerDirector.buildRose(flowerBuilder);
            bouquet.addFlower(flowerBuilder.getResult());
        }
        for (int i = 1; i <= random.nextInt(3) + 1; i++) {
            flowerDirector.buildLily(flowerBuilder);
            bouquet.addFlower(flowerBuilder.getResult());
        }
        for (int i = 1; i <= random.nextInt(3) + 1; i++) {
            flowerDirector.buildCalla(flowerBuilder);
            bouquet.addFlower(flowerBuilder.getResult());
        }
        for (int i = 1; i <= random.nextInt(3) + 1; i++) {
            flowerDirector.buildCarnation(flowerBuilder);
            bouquet.addFlower(flowerBuilder.getResult());
        }
        return bouquet;
    }

    @Override
    public Bouquet buildBlankBouquet() {
        Bouquet bouquet = new BouquetFlowers();
        return bouquet;
    }
}