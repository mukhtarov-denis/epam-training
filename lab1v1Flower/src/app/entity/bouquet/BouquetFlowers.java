package app.entity.bouquet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import app.entity.flower.Flower;

public class BouquetFlowers implements Bouquet {
    private List<Flower> flowerList;

    public BouquetFlowers() {
        flowerList = new ArrayList<>();
    }
    
    public int getSize() {
        return flowerList.size();
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        for (Flower flower : flowerList) {
            description.append(flower.getDescription()).append(" ");
        }
        return description.toString();
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Flower flower : flowerList) {
            price = price + flower.getPrice();
        }
        return price;
    }
    
    @Override
    public void addFlower(Flower flower) {
        flowerList.add(flower);
    }
    
    @Override
    public List<Flower> getFlowers() {
        return flowerList;
    }
    
    @Override
    public void sort(Comparator<Flower> comparator) {
        Collections.sort(flowerList, comparator);   
    }
    
    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        for (Flower flower : flowerList) {
            description.append(flower.getDescription()).append("\n");
        }
        return description.toString().trim();
    }
}