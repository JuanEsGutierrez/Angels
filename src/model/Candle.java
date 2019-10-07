package model;

public class Candle {
    //Attributes
    private String color;
    private double size;
    private String essence;
    private String illuminance;

    //Methods
    public Candle(String color, double size, String essence, String illuminance) {
        this.color = color;
        this.size = size;
        this.essence = essence;
        this.illuminance = illuminance;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public String getEssence() {
        return essence;
    }
    public void setEssence(String essence) {
        this.essence = essence;
    }
    public String getIlluminance() {
        return illuminance;
    }
    public void setIlluminance(String illuminance) {
        this.illuminance = illuminance;
    }
}