package by.epam.training.lab3.v1.entity;

import java.util.ArrayList;
import java.util.List;

import by.epam.training.lab3.v1.entity.parameter.Parameter;

public class Plant {
    private Integer id;
    private String name;
    private Soil soil;
    private String origin;
    private List<Parameter> visualParameters = new ArrayList<>();
    private List<Parameter> growingTips = new ArrayList<>();
    private Multiplying multiplying;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setSoil(Soil soil) {
        this.soil = soil;
    }
    
    public Soil getSoil() {
        return soil;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Parameter> getVisualParameters() {
        return visualParameters;
    }
    
    public void addVisualParameter(Parameter parameter) {
        visualParameters.add(parameter);
    }
    
    public List<Parameter> getGrowingTips() {
        return growingTips;
    }
    
    public void addGrowingTip(Parameter parameter) {
        growingTips.add(parameter);
    }
    
    public Multiplying getMultiplying() {
        return multiplying;
    }
    
    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }
}