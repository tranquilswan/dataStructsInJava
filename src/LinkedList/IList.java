package LinkedList;


public interface IList<E> extends java.lang.Iterable<E> {

    /*
     * public interface IList<E> extends java.lang.Iterable<E>
     * Breakdown of the above:
     * -The interface IList<of Generic type, denoted by E> extends Iterable<of generic type E>
     *      -all children of IList (and their children) can be of any type, but must be iterable.
     */

    //add new element to list
    public void add(E e);

    //add new element at specified index
    public void add(int index, E e);

    //clear the list
    public void clear();

    //see if list contains value
    public boolean contains(E e);

    //get the value to give index
    public E get(int index);

    //return the index of a given value
    public int indexOf(E e);

    //see if the list is empty
    public boolean isEmpty();

    //return the last index of the given element
    public int lastIndexOf(E e);

    /**
     remove the first occurrence of given element and return true if removed
     */
    public boolean remove(E e);

    /**
     * remove the element at index and return remove element
     */
    public E remove(int index);

    //replace the element at given index, and return the replaced item
    public Object set(int index, E e);

    /**
     return the size of the list
     */
    public int size();

}

