import java.util.ArrayList;
import java.util.List;

public class Wachtkamer implements Queue{

    List<Integer> queueList = new ArrayList<>();

    public Wachtkamer(){

    }

    @Override
    public void add(int value) {
        queueList.add(value);
    }

    @Override
    public int remove() {
        queueList.remove(0);
        return 0;
    }

    @Override
    public int peek() {
        queueList.get(0);
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    @Override
    public int size() {
        return queueList.size();
    }

    @Override
    public void print() {
        System.out.print("[ ");
        queueList.forEach(i -> System.out.print(i + " "));
        System.out.print("]\n");
    }

    @Override
    public void clear() {
        this.queueList.clear();
    }

    @Override
    public void clear(int n) {
        for (int i = n-1; i > -1; i--) {
            queueList.remove(i);
        }

    }

    @Override
    public void printReverse() {
        System.out.print("[ ");
        for (int i = queueList.size() - 1; i > -1 ; i--) {
            System.out.print(queueList.get(i) + " ");
        }
        System.out.println("]");
    }

    @Override
    public void jumpTheQueue(int n, int value) {
        List<Integer> tempQueue = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < queueList.size() + 1; i++) {
            if(flag){
                tempQueue.add(queueList.get(i-1));
            }
            else{
                if(i == n){
                    tempQueue.add(value);
                    flag = true;
                }
                else{
                    tempQueue.add(queueList.get(i));
                }
            }
        }
    }

    @Override
    public boolean equals(Queue q) {
        if(q instanceof Wachtkamer){
            Wachtkamer wachtkamer = (Wachtkamer) q;
            if(wachtkamer.size() == queueList.size()){
                for (int i = 0; i < queueList.size(); i++) {
                    if(queueList.get(i) != wachtkamer.get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int value) {
        return queueList.indexOf(value);
    }

    @Override
    public int lastIndexOf(int value) {
        return queueList.lastIndexOf(value);
    }

    public int get(int index){
        return queueList.get(index);
    }
}
