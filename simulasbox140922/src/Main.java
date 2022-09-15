import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EnumChest chest = EnumChest.LOCKED;
        System.out.println("a Chest appeared in front of you!");
        String action = "";
        while (!action.equals("stop")) {
            System.out.print("The chest is " + chest.getState() + ". What do you want to do ?  ");
            action = input.nextLine();
            if (action.equals("open".toLowerCase())) {
                chest = chest.openChest();
            } else if (action.equals("close".toLowerCase())) {
                chest = chest.closeChest();
            } else if (action.equals("lock".toLowerCase())) {
                chest = chest.lockChest();
            } else if (action.equals("unlock".toLowerCase())) {
                chest = chest.unlockChest();
            } else if (action.equals("stop".toLowerCase())) {
                System.out.println("You left the chest.");
            } else {

            }
        }
    }


}

enum EnumChest {
    OPEN,
    CLOSED,
    LOCKED;


    public EnumChest openChest() {
        if (this == EnumChest.CLOSED) {

            return EnumChest.OPEN;
        } else {

            return this;
        }
    }

    public EnumChest closeChest() {
        if (this == EnumChest.OPEN) {

            return EnumChest.CLOSED;
        } else {

            return this;
        }
    }


    public EnumChest lockChest() {
        if (this == EnumChest.CLOSED) {

            return EnumChest.LOCKED;
        } else {

            return this;
        }
    }

    public EnumChest unlockChest() {
        if (this == EnumChest.LOCKED) {

            return EnumChest.CLOSED;

        } else {

            return this;
        }
    }

    public String getState() {
        if (this == EnumChest.LOCKED) {
            return "locked";
        }
        if (this == EnumChest.CLOSED) {
            return "closed";
        }
        if (this == EnumChest.OPEN) {
            return "open";
        } else return "unknown";
    }


}