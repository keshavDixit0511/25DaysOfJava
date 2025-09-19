public class Day11 {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
        public static Node head;
        public static Node tail;
        public static int size;

        public void addFirst(int data) {
            Node newNode = new Node(data);
            size++;

            if(head == null) {
                head = tail = newNode;
                return;
            }

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        public void addLast(int data) {
            Node newNode = new Node(data);
            size++;

            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        public void print() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + "<->");
                temp = temp.next;
            }
            System.out.println("null");
        }

    public static void main(String[] args) {
        Day11 dll = new Day11();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addLast(3);
        dll.print();
    }
}
