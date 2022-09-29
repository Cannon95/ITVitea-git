public interface Queue2<T, T2> {


        // voeg een item toe aan de FIFO queue
        public void add(T key, String name, T2 value);
        // verwijder een item uit de FIFO queue
        public int remove();
        // geef het eerste item in de FIFO queue terug, maar haal het er niet uit
        public T2 peek();
        // geef aan of de FIFO queue leeg is
        public boolean isEmpty();
        // geef de lengte van de FIFO queue terug
        public int size();
        // Print de inhoud van de FIFO queue
        public void print();
        // verwijder alle items uit de FIFO queue
        public void clear();
        // verwijder de eerste n items uit de FIFO queue
        public void clear(int n);
        // print de inhoud van de FIFO queue in omgekeerde volgorde
        public void printReverse();
        // plaats een element op een bepaalde positie in de FIFO queue
        public void jumpTheQueue(int n,T key, String name, T2 value);
        // Zet de FIFO queue om naar een String
        public String toString();
        // Kijk of de FIFO queue gelijk is aan een andere FIFO queue
        public boolean equals(Queue2<T,T2> q);
        // Bepaal de index van een bepaalde waarde in de FIFO queue
        public int indexOf(T2 value);
        // bepaal de laatste index van een bepaalde waarde in de FIFO queue
        public int lastIndexOf(T2 value);
    }



