package code;
public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    /*public void add(int d){
        data[size++] = d;
    }*/

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
    
    public void add(int d) throws IsFullException {
        if(isFull()) throw new IsFullException();
        data[size++] = d;
    }

    public class IsFullException extends Exception{
        public String toString() {
            return "Array is full.";
        }
    }

    public void insert(int d, int index) {
        for(int i=size; i>index; i--){
            data[i] = data[i-1];
        }
        data[index] = d;
        size++;
    }

    public int find(int d){
        for(int i=0; i<size; i++){
            if(data[i]==d){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int a = 0, b = size-1;
        while(a <= b){
            int m = (a+b) / 2;
            if(data[m] == d) return m;
            if(d<data[m]) b = m-1;
            else a = m+1; 
        }
        return -1;
    }

    public void delete(int index){
        for(int i=index; i<size-1; i++){
            data[i] = data[i+1];
        }
        data[size - 1] = 0; // Set the last element to 0
        size--;
    }

    public void print(){
        for(int i= 0; i<data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    

    public MyArrayBasic(int[] array){
        //max size increases to the length of the entering array.
        MAX_SIZE = array.length;
        data = new int[MAX_SIZE];
        for (int i = 0; i<array.length ; i++){
            data[i] = array[i];
        }
        size = array.length;
    }

    public MyArrayBasic(){}


}