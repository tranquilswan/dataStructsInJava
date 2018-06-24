package BinarySearchTree;

public abstract class AbstractITree<E extends Comparable<E>> implements ITree<E> {
    //what does it mean to extend comparable?

    @Override
    public void inOrder(){}

    @Override
    public boolean isEmpty() {
        return getSize()==0;
    }

    @Override
    public java.util.Iterator<E> iterator(){
        return null;
    }
}