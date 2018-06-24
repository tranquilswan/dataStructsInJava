package LinkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        }
        else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }

    /*
     * Complete the function below.
     */
/*
For your reference:
LinkedListNode {
    int val;
    LinkedListNode *next;
};
*/

    static LinkedListNode removeNodes(LinkedListNode list, int x) {
        LinkedListNode current = list;
        LinkedListNode prev = null;

        //check if head > x and .next = null => return null
        if(list==null) return null;
        if(list.val>x && list.next == null){return null;}

        //find the first instance of a value that is less than x
        while(current.next != null && current.val > x){
            prev = current;
            current = current.next;
        }
        // if(prev != null){
        //     prev.next = null;
        // }
        LinkedListNode returnNode = current;

        while(current.next != null){
            if(current.next.val>x){
                current.next = current.next.next;
            }else{
                current = current.next;
                // System.out.println(current.val);
            }
        }

        return returnNode;

//         while(current !=null && current.val > 0){
//             prev = current; //take of the current
//             current = current.next;
//         }

//         LinkedListNode header = current;
//         // while (current.next!=null){
//         //     if(current.next.val > x){
//         //         current.next = current.next.next;
//         //     }else{
//         //         current = current.next;
//         //     }
//         // }
//         System.out.println(header);
//         return header;

    }



    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        LinkedListNode res;

        int _list_size = 0;
        _list_size = Integer.parseInt(in.nextLine());
        int _list_i;
        int _list_item;
        LinkedListNode _list = null;
        LinkedListNode _list_tail = null;
        for(_list_i = 0; _list_i < _list_size; _list_i++) {
            _list_item = Integer.parseInt(in.nextLine().trim());
            if(_list_i == 0) {
                _list = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
                _list_tail = _list;
            }
            else {
                _list_tail = _insert_node_into_singlylinkedlist(_list, _list_tail, _list_item);
            }
        }

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = removeNodes(_list, _x);
        while (res != null) {
            bw.write(String.valueOf(res.val));
            bw.newLine();
            res = res.next;
        }

        bw.close();
    }
}
