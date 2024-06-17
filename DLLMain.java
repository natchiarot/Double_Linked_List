package DoubleLinkedList;

public class DLLMain {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertDLL(1, 0);
        doublyLinkedList.insertDLL(2, 1);
        doublyLinkedList.insertDLL(3, 2);
        doublyLinkedList.insertDLL(4, 3);
        doublyLinkedList.insertDLL(5, 4);
        System.out.println();
        doublyLinkedList.traverseDLL();
        System.out.println();
        System.out.println("DLL Reverse Traversed:");
        doublyLinkedList.reverseTraverseDLL();
        System.out.println();
        doublyLinkedList.searchNode(3);
        doublyLinkedList.searchNode(10);
        System.out.println();
        doublyLinkedList.deleteDLL(3, 2);
        System.out.println("DLL after node deleted:");
        doublyLinkedList.traverseDLL();
        System.out.println();
        System.out.println("Deleting Entire DLL...");
        doublyLinkedList.deleteEntireDLL();
    }
}
