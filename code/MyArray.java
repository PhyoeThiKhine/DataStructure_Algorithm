package code;

public class MyArray extends MyArrayBasic {
    public MyArray() {
        MAX_SIZE = 100_000;
        data = new int[MAX_SIZE];
    }
    public MyArray(int max){
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
    }
    public boolean isFull() {
        return size == MAX_SIZE;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int[] expandByK(int k){
        MAX_SIZE = k*MAX_SIZE;
        int newData [] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        return data;

    }

    public int[] expand() {
        MAX_SIZE = 2*MAX_SIZE;
        int newData [] = new int[MAX_SIZE];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        return data;
    }

    public void add(int d){
        if(isFull()) 
            {
                expand();
            }
        data[size++] = d;
    }

    /*public void add(int d) throws IsFullException {
        if(isFull()) {
            expand();
        }
        data[size++] = d;
    }*/

    public void delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index is out of bounds");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }
  

    
}
