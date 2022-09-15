import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chest {

    private EnumChestState state;
    private String contains;

    public Chest(EnumChestState state, String contains){

        this.state = state;
        this.contains = contains;
    }
    public void Interact() {
        Scanner sc = new Scanner(System.in);
        String s = "a";


        while(!s.toLowerCase().equals("leave")) {
            System.out.println("you came across a chest, what would you do? [lock,unlock,open,close,leave] ");
            s = sc.nextLine();
            if(s.equals("lock")) {
                this.lockChest();
            }else if(s.equals("unlock")){
                this.unlockChest();
            }else if(s.equals("open")){
                this.openChest();
            }else if(s.equals("close")){
                this.closeChest();
            }else if(s.equals("leave")) {
                System.out.println("you left the Chest");
            }
        }
    }

    public void unlockChest(){

        switch(this.state){
            case LOCKED:
                this.state = EnumChestState.CLOSED;
                System.out.println("You unlocked the chest");
                break;
            case OPEN:
                System.out.println("the Chest is already open!");
                System.out.println("Trying to unlock an open Chest makes you look silly");
                break;
            case CLOSED:
                Scanner sc = new Scanner(System.in);
                String s = "a";
                while(!s.toLowerCase().equals("y") && !s.toLowerCase().equals("n")){
                    System.out.println("The chest is already unlocked, would you like to lock it? [Y/N]");
                    s = sc.nextLine();
                    if (s.toLowerCase().equals("y")) {
                        this.state = EnumChestState.LOCKED;
                        System.out.println("You've locked the chest.");
                    }else if(s.toLowerCase().equals("n")){
                        System.out.println("You left the chest unlocked.");
                    }
                }
        }
}

    public void lockChest(){
        switch(this.state){
            case CLOSED:
                this.state = EnumChestState.LOCKED;
                System.out.println("You've locked the chest");
                break;
            case OPEN:
                System.out.println("the Chest is open!");
                System.out.println("Trying to lock an open Chest makes you look silly");
                break;
            case LOCKED:
                Scanner sc = new Scanner(System.in);
                String s = "a";
                while(!s.toLowerCase().equals("y") && !s.toLowerCase().equals("n")){
                    System.out.println("The chest is already locked, would you like to unlock it? [Y/N]");
                    s = sc.nextLine();
                    if (s.toLowerCase().equals("y")) {
                        this.state = EnumChestState.CLOSED;
                        System.out.println("You've unlocked the chest.");
                    }else if(s.toLowerCase().equals("n")){
                        System.out.println("You left the chest unlocked.");

                    }
                }


        }
    }
    public void openChest(){
        switch(this.state){
            case CLOSED:
                this.state = EnumChestState.OPEN;
                System.out.println("You've opened the chest");
                break;
            case OPEN:
                System.out.println("the Chest is already open!");
                System.out.println("you cannot open an open chest");
                break;
            case LOCKED:
                System.out.println("the Chest is shut, you need to unlock it before you can open it!");
        }

    }
    public void closeChest(){
        switch(this.state){
            case OPEN:
                this.state = EnumChestState.CLOSED;
                System.out.println("You've closed the chest");
                break;
            case CLOSED:
                System.out.println("The chest is already closed!");
                break;
            case LOCKED:
                System.out.println("The Chest is already closed, and it's locked too!");
        }
    }
}