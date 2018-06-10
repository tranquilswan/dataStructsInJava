package Queue;

public class TestQueue {
    public static void main(String[] args){
        GenericQueue<String> queue = new GenericQueue<String>();

        queue.enqueue("Canada");
        queue.enqueue("Israel");
        queue.enqueue("Germany");
        queue.enqueue("Omicron Persie 8");
        System.out.println(queue.toString());
        System.out.println("size of queue: " + queue.getSize());
        queue.dequeue();
        System.out.println(queue.toString());
        System.out.println("size of queue: " + queue.getSize());

    }
}
