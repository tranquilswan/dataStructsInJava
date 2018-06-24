package BinarySearchTree;

import java.util.Iterator;

public interface ITree<E> extends Iterable<E>{

    public boolean search(E e);

    public boolean insert(E e);

    public boolean delete(E e);

    public void inOrder();

    //post Order

    //pre order

    public int getSize();

    public boolean isEmpty();

    public void clear();

    public Iterator<E> iterator();

}