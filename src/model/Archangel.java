package model;

public class Archangel {
    //Attributes
    private String name;
    private String prayer;
    private String celebrationDate;
    private String power;

    //Relationships
    private Candle candle;

    //Methods
    public Archangel(String name, String prayer, String celebrationDate, String power) {
        this.name = name;
        this.prayer = prayer;
        this.celebrationDate = celebrationDate;
        this.power = power;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrayer() {
        return prayer;
    }
    public void setPrayer(String prayer) {
        this.prayer = prayer;
    }
    public String getCelebrationDate() {
        return celebrationDate;
    }
    public void setCelebrationDate(String celebrationDate) {
        this.celebrationDate = celebrationDate;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public Candle getCandle() {
        return candle;
    }
    public void createCandle(String candleColor, double candleSize, String candleEssence, String candleIlluminance) {
        candle = new Candle(candleColor, candleSize, candleEssence, candleIlluminance);
    }
}