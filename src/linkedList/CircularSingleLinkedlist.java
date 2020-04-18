package linkedList;

public class CircularSingleLinkedlist {
    private class SingleNode{
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
            return" "+ value;
    }
}

      private SingleNode head;
      private SingleNode tail;
      private int size;

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

    public void createCircularSingleLinkedList(int value){
        SingleNode node = new SingleNode();
        node.setValue(value);
        node.setNext(node);
        head=node;
        tail=node;
        size=1;
    }

    public void addFirst(int value){
        SingleNode node = new SingleNode();
        node.setValue(value);
        node.setNext(head);
        head=node;
        tail.setNext(head);
        size++;
    }
    public void addLast(int value){
        SingleNode node = new SingleNode();
        node.setValue(value);
        tail.setNext(node);
        tail=node;
        tail.setNext(head);
        size++;
    }
    public void addAtSpecLocation(int value,int location){
        SingleNode node= new SingleNode();
        node.setValue(value);
        SingleNode tmpNode=head;
        int index=0;
        while (index < location-1){
            tmpNode=tmpNode.getNext();
            index++;
        }
        node.setNext(tmpNode.getNext());
        tmpNode.setNext(node);
        size++;
    }

    void traverseLinkedList() {
        if (existsLinkedList()) {
            SingleNode tempNode = head;
            for (int i = 0; i < size; i++) {

                System.out.print(tempNode.getValue());
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.getNext();
            }
            System.out.println("\n");
        }else {
            System.out.println("\nLinked List does not exists !");
        }
    }

    void deleteLinkedList() {
        System.out.println("\n\nDeleting Linked List...");
        head = null;
        if(tail == null) {
            System.out.println("Linked List is already deleted, nothing to delete !");
            return;
        }else {
            tail.setNext(null);
            tail = null;
            System.out.println("Linked List deleted successfully !");
        }
    }

   public boolean search(int value){
        SingleNode tmpNode = new SingleNode();
        tmpNode=head;
        for(int i=0;i<size;i++){
            if(value==tmpNode.getValue()){
                System.out.println("Found At index "+i);
                return true;
            }
            tmpNode=tmpNode.getNext();
        }
        return false;
   }

    private boolean existsLinkedList() {
        return head != null;
    }

    public void deleteFirstNode(){
        head=head.getNext();
        tail.setNext(head);
        size--;
        if(size==0){
           tail=null;
        }
    }
    public void deleteLast(){
       SingleNode tmpNode= new SingleNode();
       tmpNode=head;
       for(int i=0;i<size-1;i++){
           tmpNode=tmpNode.getNext();
       }
       if(head==tail){
           head=tail=null;
           size--;
           return;
       }

       tmpNode.setNext(head);
       tail=tmpNode;
       size--;
    }

    public void deleteAtSpecLocation(int location){
        SingleNode tmpNode = new SingleNode();
        tmpNode=head;
        for(int i=0;i<location-1;i++){
            tmpNode=tmpNode.getNext();
        }
        tmpNode.setNext(tmpNode.getNext().getNext());
        size--;
    }
}
