package ui;
import model.Legion;
import java.util.Scanner;

public class Main {
    private Scanner input1;
    private Scanner input2;
    private Legion legion;
    
    public static void main(String[] args) {
        Main obj = new Main();
        boolean x = true;
        boolean sentinel = false;
        while(x) {
            System.out.println("Menu \n1. Enter the archangels \n2. Count the entered archangels \n3. Deploy the archangel information given the name \n4. Deploy the archangel information given the power");
            System.out.println("5. Display the celebrations given a month \n6. Display all the celebrations \n7. Exit");
            int menu = obj.input1.nextInt();
            switch(menu) {
                case 1:
                    System.out.println("How many archangels do you want to enter?");
                    int length = obj.input1.nextInt();
                    obj.legion = new Legion(length);
                    obj.createArchangel(length);
                    sentinel = true;
                    break;
                case 2:
                    if(sentinel == true) {
                        obj.countArchangelsComprobation();
                    }
                    else {
                        System.out.println("You must create the archangels first");
                    }
                    break;
                case 3:
                    if(sentinel == true) {
                        obj.mainSearchByName();
                    }
                    else {
                        System.out.println("You must create the archangels first");
                    }
                    break;
                case 4:
                    if(sentinel == true) {
                        obj.mainSearchByPower();
                    }
                    else {
                        System.out.println("You must create the archangels first");
                    }
                    break;
                case 5:
                    if(sentinel == true) {
                        obj.mainCelebrationsByMonth();
                    }
                    else {
                        System.out.println("You must create the archangels first");
                    }
                    break;
                case 6:
                    if(sentinel == true) {
                        System.out.println(obj.legion.allCelebrations());
                    }
                    else {
                        System.out.println("You must create the archangels first");
                    }
                    break;
                case 7:
                    x = false;
                    break;
                default:
                    System.out.println("Type a valid option");
                    break;
            }
        }
    }
    public Main() {
        input1 = new Scanner(System.in);
        input2 = new Scanner(System.in);
    }
    public void createArchangel(int length) {
        System.out.println("Write the name");
        String archangelName = input2.nextLine().toUpperCase();
        archangelName = mainEndComprobation(archangelName);
        System.out.println("Write the prayer");
        String archangelPrayer = input2.nextLine().toUpperCase();
        System.out.println("Write the celebration date in the format day/month. Example: 18/october");
        String archangelCelebrationDate = input2.nextLine().toUpperCase();
        System.out.println("Write the power");
        String archangelPower = input2.nextLine().toUpperCase();
        legion.createArchangel(archangelName, archangelPrayer, archangelCelebrationDate, archangelPower);
        mainCreateCandle(0);
        for(int i = 1; i < length; i++) {
            System.out.println("Write the name");
            archangelName = input2.nextLine().toUpperCase();
            archangelName = mainEndComprobation(archangelName);
            System.out.println("Write the prayer");
            archangelPrayer = input2.nextLine().toUpperCase();
            System.out.println("Write the celebration date in the format day/month. Example: 18/october");
            archangelCelebrationDate = input2.nextLine().toUpperCase();
            System.out.println("Write the power");
            archangelPower = input2.nextLine().toUpperCase();
            mainEqualComprobation(i, archangelName, archangelPrayer, archangelCelebrationDate, archangelPower);
            mainCreateCandle(i);
        }
    }
    public void mainCreateCandle(int i) {
        System.out.println("Write the color of the candle");
        String candleColor = input2.nextLine().toUpperCase();
        System.out.println("Write the size of the candle in cm");
        double candleSize = Double.parseDouble(input2.nextLine());
        System.out.println("Write the essence of the candle");
        String candleEssence = input2.nextLine().toUpperCase();
        System.out.println("Write low, medium or high for the illuminance level");
        String candleIlluminance = input2.nextLine().toUpperCase();
        legion.getArchangel(i).createCandle(candleColor, candleSize, candleEssence, candleIlluminance);
    }
    public String mainEndComprobation(String pName) {
        int nameLength = pName.length();
        String end = Character.toString(pName.charAt(nameLength - 2)) + Character.toString(pName.charAt(nameLength - 1));
        end = end.toLowerCase();
        boolean booleanEnd = legion.endComprobation(end);
        while(!booleanEnd) {
            System.out.println("The name must end with el");
            System.out.println("Write the name");
            pName = input2.nextLine().toUpperCase();
            nameLength = pName.length();
            end = Character.toString(pName.charAt(nameLength - 2)) + Character.toString(pName.charAt(nameLength - 1));
            end = end.toLowerCase();
            booleanEnd = legion.endComprobation(end);
        }
        return pName;
    }
    public void mainEqualComprobation(int i, String archangelName, String archangelPrayer, String archangelCelebrationDate, String archangelPower) {
        boolean booleanEqual = legion.equalComprobation(i, archangelName, archangelPower);
        while(!booleanEqual) {
            System.out.println("Archangels cannot have the same name or power");
            System.out.println("Write the name");
            archangelName = input2.nextLine().toUpperCase();
            archangelName = mainEndComprobation(archangelName);
            System.out.println("Write the power");
            archangelPower = input2.nextLine().toUpperCase();
            booleanEqual = legion.equalComprobation(i, archangelName, archangelPower);
        }
        legion.createArchangel(archangelName, archangelPrayer, archangelCelebrationDate, archangelPower);
    }
    public void countArchangelsComprobation() {
        if(legion.countArchangels() == 1) {
            System.out.println("There is 1 archangel created");
        }
        else {
            System.out.println("There are " + legion.countArchangels() + " archangels created");
        }
    }
    public void mainSearchByName() {
        System.out.println("Write the name of the archangel");
        String name = input2.nextLine().toUpperCase();
        int position = legion.searchByName(name);
        if(position == -1) {
            System.out.println("None of the archangels has " + name + " as a name");
        }
        else {
            giveArchangelInformation(position);
        }
    }
    public void mainSearchByPower() {
        System.out.println("Write the power of the archangel");
        String power = input2.nextLine().toUpperCase();
        int position = legion.searchByPower(power);
        if(position == -1) {
            System.out.println("None of the archangels has " + power + " as a power");
        }
        else {
            giveArchangelInformation(position);
        }
    }
    public void giveArchangelInformation(int position) {
        System.out.println("Name: " + legion.getArchangel(position).getName());
        System.out.println("Prayer: " + legion.getArchangel(position).getPrayer());
        System.out.println("Celebration date: " + legion.getArchangel(position).getCelebrationDate());
        System.out.println("Power: " + legion.getArchangel(position).getPower());
    }
    public void mainCelebrationsByMonth() {
        System.out.println("Write the month");
        String inputMonth = input2.nextLine().toUpperCase();
        String[] outputs = legion.celebrationsByMonth(inputMonth);
        for(int i = 0; i < outputs.length; i++) {
            if(outputs[i] != null) {
                System.out.println(outputs[i]);
            }
        }
    }
}