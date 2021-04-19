public class MyQueue<E> {
    private int sizeQueue;
    private E value;
    MyNode first;
    MyNode last;

    class MyNode<E>{
        MyNode<E> prev;
        E value;
        MyNode<E> next;

        public MyNode(MyNode<E> prev, E value, MyNode<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public void add(E value) {
        MyNode lastNode = last;
        MyNode newNode = new MyNode(lastNode, value, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        }
        else {
            lastNode.next = newNode;
        }
        sizeQueue++;
    }
    public void remove(int index) {
        MyNode<E> x;
        MyNode<E> removeNext;
        MyNode<E> removePrev;
        E removeValue;

        if (index>=0 && index<=sizeQueue){
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
            else{
                removePrev.next = removeNext;
                x.prev = null;
            }
            if (removeNext == null){
                last = removePrev;
            }
            else {
                removeNext.prev = removePrev;
                x.next = null;
            }
            x.value=null;
            sizeQueue--;
        }
        else throw new IndexOutOfBoundsException();
    }
    public void clear() {
        for (MyNode<E> x = first; x != null;) {
            MyNode<E> tmpNext = x.next;
            x.next=null;
            x.prev=null;
            x.value=null;
            x = tmpNext;
            sizeQueue--;
        }

    }
    public int size() {
        return sizeQueue;
    }
    public E peek() {
        return (E) first.value;
    }
    public E poll(){
        E result = peek();
        remove(0);
        return result;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(3);
        myQueue.add(2);
        myQueue.add(4);
        myQueue.remove(0);
        myQueue.peek();
        myQueue.clear();
    }
}