package model;

public class Legion {
    //Constants
    private static final String NAME = "Top maximum";

    //Attributes
    private String name;

    //Relationships
    private Archangel[] archangels;

    //Methods
    public Legion(int length) {
        name = NAME;
        archangels = new Archangel[length];
    }
    public String getName() {
        return name;
    }
    public Archangel getArchangel(int v) {
        return archangels[v];
    }
    public void createArchangel(String archangelName, String archangelPrayer, String archangelCelebrationDate, String archangelPower) {
        Archangel archangel = new Archangel(archangelName, archangelPrayer, archangelCelebrationDate, archangelPower);
        for(int i = 0; i < archangels.length; i++) {
            if(archangels[i] == null) {
                archangels[i] = archangel;
                i = archangels.length + 1;
            }
        }
    }
    public boolean endComprobation(String end) {
        boolean booleanEnd = true;
        if(!end.equals("el")) {
            booleanEnd = false;
        }
        return booleanEnd;
    }
    public boolean equalComprobation(int i, String archangelName, String archangelPower) {
        boolean booleanEqual = true;
        for(int v = 1; v < i + 1; v++) {
            if(archangelName.equals(archangels[v - 1].getName()) || archangelPower.equals(archangels[v - 1].getPower())) {
                booleanEqual = false;
                v = 1;
            }
        }
        return booleanEqual;
    }
    public int countArchangels() {
        return archangels.length;
    }
    public int searchByName(String archangelName) {
        int position = -1;
        for(int i = 0; i < archangels.length; i++) {
            if(archangels[i].getName().equals(archangelName)) {
                position = i;
                i = archangels.length + 1;
            }
        }
        return position;
    }
    public int searchByPower(String archangelPower) {
        int position = -1;
        for(int i = 0; i < archangels.length; i++) {
            if(archangels[i].getPower().equals(archangelPower)) {
                position = i;
                i = archangels.length + 1;
            }
        }
        return position;
    }
    public String[] celebrationsByMonth(String inputMonth) {
        String[] parts;
        String month = "";
        String[] outputs = new String[archangels.length];
        for(int i = 0; i < archangels.length; i++) {
            parts = archangels[i].getCelebrationDate().split("/");
            month = parts[1];
            if(inputMonth.equals(month)) {
                outputs[i] = "Name: " + archangels[i].getName() + ", celebration day: " + parts[0] + ", candle color: " + archangels[i].getCandle().getColor() + ", candle essence: " + archangels[i].getCandle().getEssence();
            }
        }
        return outputs;
    }
    public String allCelebrations() {
        String output = "";
        output += archangels[0].getName() + ": " + archangels[0].getCelebrationDate();
        for(int i = 1; i < archangels.length; i++) {
            output += ", " + archangels[i].getName() + ": " + archangels[i].getCelebrationDate();
        }
        return output;
    }
}
