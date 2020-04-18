package linkedList;

public class DoubleLinedList {
    private class DoubleList{
        private int value;
        private DoubleList next;
        private DoubleList prev;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public DoubleList getNext() {
            return next;
        }

        public void setNext(DoubleList next) {
            this.next = next;
        }

        public DoubleList getPrev() {
            return prev;
        }

        public void setPrev(DoubleList prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return " "+value;
        }
    }

    private DoubleList head;
    private DoubleList tail;
    private int size;

    public DoubleList getHead() {
        return head;
    }

    public void setHead(DoubleList head) {
        this.head = head;
    }

    public DoubleList getTail() {
        return tail;
    }

    public void setTail(DoubleList tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void createDoubleLinkedList(int value){
        DoubleList node = new DoubleList();
        node.setValue(value);
        node.setNext(null);
        node.setPrev(null);
        head=node;
        tail=node;
        size =1;
    }

    public void addFirst(int value){
        DoubleList node =new DoubleList();
        node.setValue(value);
        node.setNext(head);
        node.setPrev(null);
        head.setPrev(node);
        head=node;
        size++;
    }

    public void addLast(int value){
        DoubleList node =new DoubleList();
        node.setValue(value);
        node.setNext(null);
        node.setPrev(tail);
        tail.setNext(node);
        tail=node;
        size++;
    }
    public void addAtSpecLocation(int value,int location){
        DoubleList node =new DoubleList();
        node.setValue(value);
      DoubleList  tmpNode=head;
      int index=0;
        while (index<location-1){
            tmpNode=tmpNode.getNext();
            index++;
        }
        node.setPrev(tmpNode);
        node.setNext(tmpNode.getNext());
        tmpNode.setNext(node);
        node.getNext().setPrev(node);
        size++;
    }

    public void traverseLinkedList(){
        //System.out.println("Linked List now: ");
        DoubleList tempNode=head;
        for(int i =0; i<size;i++) {

            System.out.print(tempNode.getValue());
            if(i!=size-1) {
                System.out.print(" -> ");
            }
            tempNode=tempNode.getNext();
        }
        System.out.println("\n");
    }
  public   boolean searchNode(int nodeValue) {

            DoubleList tempNode=head;
            for(int i =0; i<size;i++) {
                if(tempNode.getValue()==nodeValue) {
                    System.out.print("Found the node at locaiton: " + i);
                    return true;
                }
                tempNode=tempNode.getNext();
            }

        return false;
    }
}
