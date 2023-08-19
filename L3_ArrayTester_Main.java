import code.MyArrayBasic;
//import code.MyArray;

public class L3_ArrayTester_Main {
    public static void main(String[] args) {
        System.out.println("-demo1-------");
        arrayBasic_demo1();
        System.out.println("-demo2-------");
        arrayBasic_demo2();
        System.out.println("-demo3-------");
        arrayBasic_demo3();

    }

    static private void arrayBasic_demo1(){
        int[] inputArray = { 7,6,8,1,2,3 };
        MyArrayBasic demo = new MyArrayBasic(inputArray);
        //MyArrayBasic demo = new MyArrayBasic(7,6,8,1,2,3);
        //System.out.println(demo);
        demo.print();
    }

    static private void arrayBasic_demo2() {
        MyArrayBasic demo = new MyArrayBasic();
        demo.insert(9,0);
        demo.insert(7,0);
        demo.insert(5,0);
        demo.print();
        System.out.println("5 is at " + demo.find(5));
        System.out.println("5 is at " + demo.binarySearch(5));
        demo.delete(0);
        //System.out.println(demo);
        demo.print();
    }
    
    static private void arrayBasic_demo3(){
        //MyArrayBasic demo = new MyArrayBasic(null);
        MyArrayBasic demo = new MyArrayBasic();
        try{
            demo.add(3);
            demo.add(5);
            demo.add(6);
            demo.add(7);
            demo.add(4);

            //index out of bound due to overflow
            demo.add(1);
        } catch (MyArrayBasic.IsFullException e){
            System.out.println(e.toString());
        }
        //System.out.print(demo.toString());
        demo.print();
        
    }
    

}
