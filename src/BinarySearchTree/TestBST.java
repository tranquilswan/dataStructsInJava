package BinarySearchTree;

public class TestBST {
    public static void main(String[] args){
        BST<Integer> tree = new BST<Integer>();

        tree.insert(125);
        tree.insert(100);
        tree.insert(150);

        System.out.println("Root: " + tree.getRoot().element);

        System.out.println("Size: " + tree.getSize());

        tree.insert(200);
        tree.insert(50);
        tree.delete(100);
        tree.search(100);
        tree.search(125);

        System.out.println("Root: " + tree.getRoot().element);

        System.out.println("Size: " + tree.getSize());

    }
}
