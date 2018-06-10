package Queue;

import LinkedList.LinkedIList;

public class GenericQueue<E> {

    /**
     * It must be noted that this class uses composition instead of inheritance. With composition, there is not need to
     * implement all the unnecessary methods of the parent classes.
     */
    private LinkedIList<E> list = new LinkedIList<E>();

    /**
     * Since, in a queue, you can only add element to the end, you can call the linkedList's add last to enqueue.
     */
    public void enqueue(E e){
        list.addLast(e);
    }

    /**
     * Since, in a queue, you can only remove elements from the top, you can call the linkedList's remove first to denqueue
     */
    public void dequeue(){
        list.removeFirst();
    }


    public int getSize(){
        return list.size();
    }

    @Override
    public String toString(){
        return "Queue: " + list.toString();
    }
}
