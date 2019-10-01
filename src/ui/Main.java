package ui;
import model.Legion;
import java.util.Scanner;

public class Main {
    private Scanner input1;
    private Scanner input2;
    private Legion legion;
    int length;

    public static void main(String[] args) {
        Main obj = new Main();
        boolean x = true;
        while(x) {
            System.out.println("Menu \n1. Enter the archangels \n2. Count the entered archangels \n3. Deploy the archangel information given the name \n4. Deploy the archangel information given the power");
            System.out.println("5. Display the celebrations given a month \n6. Display all the celebrations \n7. Exit");
            int menu = obj.input1.nextInt();
            switch(menu) {
                case 1:
                    System.out.println("How many archangels do you want to enter?");
                    obj.length = obj.input1.nextInt();
                    obj.legion = new Legion(obj.length);
                    obj.createArchangel();
                    break;
            }
        }
    }
    public Main() {
        input1 = new Scanner(System.in);
        input2 = new Scanner(System.in);
    }
    public void createArchangel() {
        System.out.println("Write the name");
        String archangelName = input2.nextLine().toUpperCase();
        archangelName = legion.endComprobation(archangelName);
        System.out.println("Write the prayer");
        String archangelPrayer =input2.nextLine();
        System.out.println("Write the celebration date in the format day/month. Example: 18/october");
        String archangelCelebrationDate = input2.nextLine();
        System.out.println("Write the power");
        String archangelPower = input2.nextLine().toUpperCase();
        legion.createArchangel(archangelName, archangelPrayer, archangelCelebrationDate, archangelPower);
        for(int i = 1; i < length; i++) {
            System.out.println("Write the name");
            archangelName = input2.nextLine().toUpperCase();
            archangelName = legion.endComprobation(archangelName);
            System.out.println("Write the prayer");
            archangelPrayer =input2.nextLine();
            System.out.println("Write the celebration date in the format day/month. Example: 18/october");
            archangelCelebrationDate = input2.nextLine();
            System.out.println("Write the power");
            archangelPower = input2.nextLine().toUpperCase();
            for(int v = 1; v < i + 1; v++) {
                while(archangelName.equals(legion.getArchangel(v - 1).getName()) || archangelPower.equals(legion.getArchangel(v - 1).getPower())) {
                    System.out.println("Archangels cannot have the same name or power");
                    System.out.println("Write the name");
                    archangelName = input2.nextLine().toUpperCase();
                    archangelName = legion.endComprobation(archangelName);
                    System.out.println("Write the power");
                    archangelPower = input2.nextLine().toUpperCase();
                    v = 1;
                }
            }
            legion.createArchangel(archangelName, archangelPrayer, archangelCelebrationDate, archangelPower);
        }
    }
}