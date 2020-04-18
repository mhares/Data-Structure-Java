package linkedList;
import linkedList.DoubleLinedList;

public class DoubleListMain {
    public static void main(String[] args) {
        DoubleLinedList list = new DoubleLinedList();
        list.createDoubleLinkedList(50);

        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(60);
        list.addAtSpecLocation(35,3);
        list.traverseLinkedList();
        list.searchNode(30);
    }
}
