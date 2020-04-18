package linkedList;

public class SingleLinkedList {
    public class SingleNode {
        private int value;
        private SingleNode next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public SingleNode getNext() {
            return next;
        }

        public void setNext(SingleNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }


    private SingleNode head; // First element of LinkedList
    private SingleNode tail; // Last Element in LinkedList
    private int size;  // size of LinkedList

    public SingleNode getHead() {
        return head;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SingleNode createLinkedList(int value) {
        SingleNode node = new SingleNode();
        node.setValue(value);
        node.setNext(null);
        head = node;
        tail = node;
        size++;

        return head;

    }

    public SingleNode addFirst(int value) {
        SingleNode node = new SingleNode();
        node.value = value;
        node.setNext(head);
        head = node;
        size++;
        return node;
    }
public SingleNode addLast(int value){
        SingleNode node = new SingleNode();
        node.setValue(value);
        node.setNext(null);
        tail.setNext(node);
        tail=node;
        size++;
       return node;
    }

    public void addAtSpecificLocation(int value, int location) {
        SingleNode node = new SingleNode();
        node.setValue(value);
        SingleNode tmp = head;
        int index = 0;
        while (index < location - 1) {
            tmp = tmp.getNext();
            index++;
        }
        SingleNode nextNode = tmp.getNext();
        tmp.setNext(node);
        node.setNext(nextNode);
        size++;
    }

    public void traverseLinkedList() {
        if (existsLinkedList()) {
            SingleNode tempNode = head;
            for (int i = 0; i < getSize(); i++) {
                System.out.print(tempNode.getValue());
                if (i != getSize() - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNext();
            }
        }else {
            System.out.println("Linked List does not exists !");
        }
        System.out.println("\n");
    }

    public void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        head = null;
        tail = null;
        System.out.println("Linked List deleted successfully !");
    }

    public boolean searchNode(int value) {
        SingleNode tmpNode = head;
        for (int i = 0; i < size; i++) {
            if (value == tmpNode.value) {
                System.out.println("Found at Index " + i);
                return true;
            }
            tmpNode = tmpNode.getNext();
        }
        System.out.println("Node Not Found");
        return false;
    }

    public void deleteFirsNode() {
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }

    }

    public void deleteLastNode() {
        SingleNode tmpNode = head;
        for (int i = 0; i < size - 1; i++) {  // 2nd last node
            tmpNode = tmpNode.getNext();
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }
        tmpNode.setNext(null);
        tail = tmpNode;
        size--;

    }

    public void deleteByIndex(int locattion) {
        SingleNode tmpNode = head;
        for (int i = 0; i < locattion - 1; i++) {
            tmpNode = tmpNode.getNext();
        }

        tmpNode.setNext(tmpNode.getNext().getNext());
        size--;
    }


    public boolean existsLinkedList() {
        // if head is not null retrun true otherwise return false
        if (head != null) return true;
        else
            return false;
    }
}