public class Wachtkamer2<T, T2> implements Queue2<T, T2> {

    private T[] keyList;
    private String[] nameList;
    private T2[] valueList;

    @Override
    public void add(T key, String name, T2 value) {
        int size = keyList.length;
        T[] tkeyList = (T[]) new Object[size];
        String[] tnameList = new String[size];
        T2[] tvalueList = (T2[]) new Object[size];
        tkeyList[size-1] = key;
        tnameList[size-1] = name;
        tvalueList[size-1]= value;
        paintLists(tkeyList,tnameList,tvalueList);
    }

    @Override
    public int remove() {
        int size = keyList.length -1;
        T[] tkeyList = (T[]) new Object[size];
        String[] tnameList = new String[size];
        T2[] tvalueList = (T2[]) new Object[size];
        for (int i = 1; i < size + 1; i++) {
            tkeyList[i] = keyList[i];
            tnameList[i] = nameList[i];
            tvalueList[i] = valueList[i];
        }
        paintLists(tkeyList,tnameList,tvalueList);
        return 0;
    }

    @Override
    public T2 peek() {
        return valueList[0];
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.keyList.length;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public void clear() {
        T[] tkeyList = (T[]) new Object[0];
        String[] tnameList = new String[0];
        T2[] tvalueList = (T2[]) new Object[0];
    }

    @Override
    public void clear(int n) {
        int size = keyList.length -n;
        T[] tkeyList = (T[]) new Object[size];
        String[] tnameList = new String[size];
        T2[] tvalueList = (T2[]) new Object[size];
        for (int i = n; i < size + n; i++) {
            tkeyList[i] = keyList[i];
            tnameList[i] = nameList[i];
            tvalueList[i] = valueList[i];
        }
        paintLists(tkeyList,tnameList,tvalueList);
    }

    @Override
    public void printReverse() {

        for (int i = keyList.length-1; i > -1; i--) {
            System.out.println("[key=" + keyList[i] + ", name=" + nameList[i] + ", value=" + valueList[i] + "]");
        }
    }

    @Override
    public void jumpTheQueue(int n, T key, String name, T2 value) {
        int size = keyList.length + 1;
        T[] tkeyList = (T[]) new Object[size];
        String[] tnameList = new String[size];
        T2[] tvalueList = (T2[]) new Object[size];
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if(flag){
                tkeyList[i] = keyList[i-1];
                tnameList[i] = nameList[i-1];
                tvalueList[i]= valueList[i-1];
            }else{
                if(i == n){
                    tkeyList[i] = key;
                    tnameList[i] = name;
                    tvalueList[i]= value;
                }
                else{
                    tkeyList[i] = keyList[i];
                    tnameList[i] = nameList[i];
                    tvalueList[i]= valueList[i];
                }
            }
        }
    }

    @Override
    public boolean equals(Queue2<T,T2> q) {
        if(q instanceof Wachtkamer2<T, T2>){
            Wachtkamer2<T,T2> w2 = (Wachtkamer2<T,T2>)q;
            if(w2.size() == this.size()){
                for (int i = 0; i < this.size(); i++) {
                    if(w2.rawGet(i) != this.rawGet(i)){
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(T2 value) {

        for (int i = 0; i < this.size(); i++) {
            if(valueList[i].equals(value)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T2 value) {

        for (int i = this.size()-1; i > -1; i++) {
            if(valueList[i].equals(value)){
                return i;
            }
        }

        return -1;
    }

    private void paintLists(T[] t1, String[] s, T2[] t2){
        this.keyList = t1;
        this.nameList = s;
        this.valueList = t2;
    }

    public T2 get(T key){
        for (int i = 0; i < keyList.length; i++) {
            if(keyList[i].equals(key)){
                return valueList[i];
            }

        }
        return null;
    }
    public T2 rawGet(int index){
        return valueList[index];
    }

}
