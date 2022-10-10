public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}



abstract class Entity{}

class EntityLiving extends Entity implements Killable{
    double Speed;
    double HP;

    @Override
    public void Destroy() {

    }
}

class EntityStructure extends Entity{}

interface Killable{
    void Destroy();
}
interface Eatable{

}

class EntityPudding extends EntityStructure implements Killable,Eatable{

    @Override
    public void Destroy() {

    }
}

class EntityPersoon extends EntityLiving{
    @Override
    public void Destroy() {
        System.out.println("aaauuhgg");
    }
}

