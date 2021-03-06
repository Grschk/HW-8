import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList <E>{
    private E [] array;
    private int sizeArr;

    public MyArrayList(E[] array) {
        this.array = array;
        sizeArr = 0;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        this.array = (E[]) new Object [capacity];
        sizeArr = 0;
    }

    public void add(E a){
        if (sizeArr == array.length){
            Object [] newArray = new Object[array.length + 10];
            System.arraycopy(array,0,newArray,0,array.length);
            array = (E[]) newArray;
        }
        array[sizeArr++] = a;
    }


    public void remove(int index) {
        Object[] newArray = new Object[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        array = (E[]) newArray;
        sizeArr--;
    }

    public void clear (){
        sizeArr = 0;
        array = (E[]) new Object [10];
    }

    public int size(){
        return sizeArr;
    }

    public E get(int index) {
        if(index > array.length) throw new IndexOutOfBoundsException("Out of bounds");
        return (E) (array[index]);
    }
    public static void main(String[] args) {
        MyArrayList<Integer> myArrList = new MyArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        myArrList.add(1);
        myArrList.add(3);
        System.out.println(myArrList.size());
        myArrList.remove(0);
        System.out.println(myArrList.size());
        myArrList.clear();
        myArrList.get(0);
        System.out.println(myArrList.size());
    }

}