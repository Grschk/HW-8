import java.util.*;


public class MyLinkedList<E> {

    Element<E> first;
    Element<E> last;
    int sizeList;

    class Element<E>{
        Element<E> prev;
        E value;
        Element<E> next;

        public Element(Element<E> prev, E value, Element<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public MyLinkedList() {
    }

    public void lastElement (E e){
        Element<E> l = last;
        Element<E> newElement = new Element<>(l,e,null);
        last = newElement;
        if (l == null){
            first = newElement;
        }
        else l.next = newElement;
        sizeList++;
    }

    public void add(E value){
        lastElement(value);
    }

    public void remove(int index){

        Element<E> x;
        E removeValue;
        Element<E> removeNext;
        Element<E> removePrev;

        if (index>=0 && index<=sizeList){
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            removeValue = x.value;
            removePrev = x.prev;
            removeNext = x.next;
            if (removePrev == null){
                first = removeNext;
            }
            else {
                removePrev.next = removeNext;
                x.prev = null;
            }
            if (removeNext == null) {
                last = removePrev;
            }
            else {
                removeNext.prev = removePrev;
                x.next = null;
            }
            x.value=null;
            sizeList--;
        }
        else throw new IndexOutOfBoundsException();

    }

    public void clear(){
        first = null;
        last = null;
        sizeList = 0;
    }

    public int size(){
        return sizeList;
    }

    public E get(int index){
        Element<E> x = first;
        if (index>=0 && index<=sizeList) {
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        }
        return x.value;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        List<Integer> linkedList = new LinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.remove(1);
        myLinkedList.clear();
    }
}