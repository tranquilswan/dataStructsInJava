package LinkedList;

import LinkedList.AbstractIList;
import LinkedList.Node;

import java.util.Iterator;

public class LinkedIList<E> extends AbstractIList<E> {

    private Node<E> head, tail;

    public LinkedIList(){}
    public LinkedIList(E[] objects){
        super(objects);
    }

    public E getFirst(){
        if(size==0){
            return null;
        }else{
            return head.element;
        }
    }

    public E getLast(){
        if(size ==0){
            return null;
        }else{
            return tail.element;
        }
    }


    public void addFirst(E e){
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if(tail == null){
            tail = head;
        }
    }

    public void addLast(E e){
        Node<E> newNode = new Node<E>(e);

        if(tail == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, E e) {
        if(index==0) addFirst(e);
        else if(index >= size) addLast(e);
        else{
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size++;
        }
    }


    public E removeFirst(){
        if(size ==0) return null;
        else{
            Node<E> temp = head;
            head = head.next;
            size--;
            if(head == null)tail=null;
            return temp.element;
        }
    }

    public E removeLast(){
        if(size==0)return null;
        if(size==1){
            Node<E> temp = head;
            head=tail=null;
            size=0;
            return temp.element;
        }
        else{
            Node<E> current = head;
            for(int i = 0; i<size-2;i++)
                current = current.next;
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index){
        if(index<0||index >= size)return null;
        else if(index==0)return removeFirst();
        else if(index==size-1)return removeLast();
        else{
            Node<E> previous = head;
            for(int i = 1;i<index;i++){
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public void clear(){
        size = 0;
        head = tail = null;
    }


    public String toString(){
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for(int i = 0;i<size;i++){
            result.append(current.element);
            current=current.next;
            if(current!=null){
                result.append(", ");
            }else{
                result.append("]");
            }
        }
        return result.toString();
    }

    //trust but verify
    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        for(int i = 0; i < size; i++){
            if(current.element == e){
                return true;
            }else{
                current = current.next;
            }
        }
        return false;
    }


    @Override
    public E get(int index) {
        if(index < 0 || index >= size)return null;
        else {
            Node<E> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            return current.element;
        }
    }

    @Override
    public int indexOf(E e) {
        if(head==null){
            return 0;
        }else{
            Node<E> current = head;
            for(int i = 0; i < size; i++){
                current = current.next;
                if(current.element.equals(e)){
                    return i;
                }
            }
            return 0;
        }
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public E set(int index, E e) {
        if(index < 0 || index >= size)return null;
        else {
            Node<E> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            current.element = e;
            return current.element;
        }
    }

    @Override
    public Iterator iterator() {
        return new LinedListIterator();
    }

    private class LinedListIterator implements Iterator<E>{
        private Node<E> current = head;

        public boolean hasNext(){
            return (current !=null);
        }

        public E next(){
            E e = current.element;
            current = current.next;
            return e;
        }

        public void remove(){
            //implement this
        }
    }

}
