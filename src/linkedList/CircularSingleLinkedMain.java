package linkedList;

public class CircularSingleLinkedMain {
    public static void main(String[] args) {
        CircularSingleLinkedlist list = new CircularSingleLinkedlist();
        list.createCircularSingleLinkedList(50);
        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
      list.addAtSpecLocation(35,3);
      list.addLast(60);
        list.traverseLinkedList();
        list.search(35);
        list.deleteFirstNode();
        list.traverseLinkedList();

        list.deleteLast();
        list.traverseLinkedList();

        list.deleteAtSpecLocation(2);
        list.traverseLinkedList();
    }
}
