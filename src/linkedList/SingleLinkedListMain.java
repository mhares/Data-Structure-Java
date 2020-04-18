package linkedList;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
      SingleLinkedList.SingleNode element=  list.createLinkedList(50);




        list.addFirst(40);
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);

        list.addAtSpecificLocation(35,3);
    //    list.addLast(60);

     //   list.addLast(60);


        System.out.println(list.getTail());
        System.out.println(list.getHead().getNext().getNext().getNext().getNext().getNext().getNext());
     list.traverseLinkedList();

     list.searchNode(35);

     list.deleteFirsNode();
        list.traverseLinkedList();

        list.deleteLastNode();
        list.traverseLinkedList();

        list.deleteByIndex(2);
        list.traverseLinkedList();
      int s= list.getSize();
        System.out.println(s);

        list.deleteLinkedList();

    }
}
