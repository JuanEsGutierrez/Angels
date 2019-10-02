package model;
import java.util.Scanner;
public class Legion {
    //Constants
    private static final String NAME = "Top maximum";

    //Attributes
    private String name;
    private Scanner input2;

    //Relationships
    private static Archangel[] archangels;

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
    public String endComprobation(String pName) {
        input2 = new Scanner(System.in);
        int nameLength = pName.length();
        String end = Character.toString(pName.charAt(nameLength - 2)) + Character.toString(pName.charAt(nameLength - 1));
        end = end.toLowerCase();
        while(!end.equals("el")) {
            System.out.println("The name must end with el");
            System.out.println("Write the name");
            pName = input2.nextLine().toUpperCase();
            nameLength = pName.length();
            end = Character.toString(pName.charAt(nameLength - 2)) + Character.toString(pName.charAt(nameLength - 1));
            end = end.toLowerCase();
        }
        return pName;
    }
    public void equalComprobation(int i, String archangelName, String archangelPrayer, String archangelCelebrationDate, String archangelPower) {
        for(int v = 1; v < i + 1; v++) {
            while(archangelName.equals(archangels[v - 1].getName()) || archangelPower.equals(archangels[v - 1].getPower())) {
                System.out.println("Archangels cannot have the same name or power");
                System.out.println("Write the name");
                archangelName = input2.nextLine().toUpperCase();
                archangelName = endComprobation(archangelName);
                System.out.println("Write the power");
                archangelPower = input2.nextLine().toUpperCase();
                v = 1;
            }
        }
        createArchangel(archangelName, archangelPrayer, archangelCelebrationDate, archangelPower);
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
}
