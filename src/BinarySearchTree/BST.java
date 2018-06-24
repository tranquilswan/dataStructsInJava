package BinarySearchTree;

public class BST<E extends Comparable<E>> extends AbstractITree<E>{

    protected TreeNode<E> root;
    protected int size = 0;

    public BST(){}

    public BST(E[] objects){
        for(int i = 0; i < objects.length;i++){
            insert(objects[i]);
        }
    }

    @Override
    public boolean insert(E e) {
       if(root==null){
           root = createNewNode(e);
       }else{
           TreeNode<E> parent = null;
           TreeNode<E> current = root;
           while (current!=null){
               if(e.compareTo(current.element)<0){      //if -1, then insert to left, because less than parent
                   parent=current;
                   current=current.left;
               }else if(e.compareTo(current.element)>0){    //if 1, then insert to right, because more than parent
                   parent = current;
                   current = current.right;
               }else{
                   return false;
               }
           }

           if(e.compareTo(parent.element)<0){
               parent.left=createNewNode(e);
           }else{
               parent.right=createNewNode(e);
           }
       }
       size++;
       return true;
    }

    private TreeNode<E> createNewNode(E e){
        return new TreeNode<E>(e);
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while(current!=null){
            if(e.compareTo(current.element)<0){
                current=current.left;
            }else if(e.compareTo(current.element)>0){
                current = current.right;
            }else{
                return true;
            }
        }
        return false;
    }



    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while(current != null){
            if(e.compareTo(current.element)<0){
                parent = current;
                current = current.left;
            }else if(e.compareTo(current.element)>0){
                parent = current;
                current = current.right;
            }else{
                break;
            }
        }
        if(current==null){
            return false;
        }
        if(current.left == null){
            if(parent ==null){
                root = current.right;
            }else{
                if(e.compareTo(parent.element)<0){
                    parent.left = current.right;
                }else{
                    parent.right = current.right;
                }
            }
        }else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if(parentOfRightMost.right == rightMost){
                parentOfRightMost.right = rightMost.left;
            }else{
                parentOfRightMost.left = rightMost.left;
            }
        }

        size--;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot(){
        return root;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    public void inOrder(){
        inOrder(root);
    }

    protected void inOrder(TreeNode<E> root){
        if(root==null)return;
        inOrder(root.left);
        System.out.print(root.element + " ");
        inOrder(root.right);
    }

}
