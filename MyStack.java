public class MyStack<E> {

    private int sizeStack;
    private E value;
    StackNode first;
    StackNode last;

    class StackNode<E>{
        StackNode<E> prev;
        E value;
        StackNode<E> next;

        public StackNode(StackNode<E> prev, E value, StackNode<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    public void push(E value){
        StackNode lastNode = last;
        StackNode newStackNode = new StackNode(lastNode,value,null);
        last = newStackNode;
        if (lastNode == null){
            first = newStackNode;
        }
        else{
            lastNode.next=newStackNode;
        }
        sizeStack++;
    }

    public void remove(int index) {
        StackNode<E> x;
        StackNode<E> removeNext;
        StackNode<E> removePrev;
        E removeValue;

        if (index>=0 && index<=sizeStack){
            x = first;
            for (int i = 0; i < index; i++) {
                x=x.next;
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
            sizeStack--;
        }
        else throw new IndexOutOfBoundsException();
    }

    public void clear() {
        for (StackNode<E> x = first; x != null;) {
            StackNode<E> tempNext = x.next;
            x.next=null;
            x.prev=null;
            x.value=null;
            x = tempNext;
            sizeStack--;
        }
    }

    public int size() {
        return sizeStack;
    }

    public E peek() {
        return (E) last.value;
    }

    public E pop() {
        E returnPop = peek();
        remove(sizeStack-1);
        return returnPop;
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(4);
        myStack.push(3);
        myStack.push(2);
        myStack.push(1);
        myStack.size();
        System.out.println(myStack.peek());
        myStack.remove(0);
        System.out.println(myStack.size());
        myStack.pop();
        System.out.println(myStack.size());
    }
}