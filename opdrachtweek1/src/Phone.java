public class Phone {

    private String name;
    private String type;
    private int price;
    private String desc;



    public Phone(String name, String type, int price, String desc){

        this.name = name;
        this.type = type;
        this.price = price;
        this.desc = desc;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

}
