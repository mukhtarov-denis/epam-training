package app.entity.flower.builder;

import java.util.Random;

import app.entity.flower.type.CallaType;
import app.entity.flower.type.CarnationType;
import app.entity.flower.type.LilyType;
import app.entity.flower.type.RoseType;
import app.entity.freshness.Fresh;
import app.entity.freshness.Freshness;
import app.entity.freshness.MediumFresh;
import app.entity.freshness.NotFresh;

public class FlowerDirector {
    private Random random;
        
    public FlowerDirector() {
        random = new Random();
    }
    
    public void buildCalla(FlowerBuilder builder) {
        builder.setFlowerType(new CallaType());
        builder.setCost(1.10);
        builder.setLength(generateLength());
        builder.setFreshness(generateFreshness());
    }
    
    public void buildCarnation(FlowerBuilder builder) {
        builder.setFlowerType(new CarnationType());
        builder.setCost(0.95);
        builder.setLength(generateLength());
        builder.setFreshness(generateFreshness());
    }
    
    public void buildLily(FlowerBuilder builder) {
        builder.setFlowerType(new LilyType());
        builder.setCost(2.75);
        builder.setLength(generateLength());
        builder.setFreshness(generateFreshness());
    }
    
    public void buildRose(FlowerBuilder builder) {
        builder.setFlowerType(new RoseType());
        builder.setCost(1.60);
        builder.setLength(generateLength());
        builder.setFreshness(generateFreshness());
    }
    
    private double generateLength() {
        return (double) (random.nextInt(4) + 6) / 10;
    }
    
    private Freshness generateFreshness() {
        int result = random.nextInt(3) + 1;
        if (result == 1) {
            return new Fresh();
        } else if (result == 2) {
            return new MediumFresh();
        } else {
            return new NotFresh();
        }
    }
}