package DoubleLinkedList;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    //Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }


    //insert into a DLL
    //0. If link list doesn't
    //1. inserting at the begining
    //2. Inserting at the ending
    //3. Insert anywhere

    public void  insertDLL (int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if(head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = tail;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    //Traverse a Linked List
    public void traverseDLL(){
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" <-> ");

                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (head == null) {
            return;
        }
        DoublyNode tempNode = head;

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        // Printing the reverse traversed DLL.
        while (tempNode != null) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.prev;
        }
        System.out.println();
    }

    // Search Node
    public void searchNode(int nodeValue) {
        if (head == null) {
            System.out.println("DLL does not exist");
            return;
        }
        DoublyNode tempNode = head;
        boolean found = false;

        while (tempNode != null) {
            if (tempNode.value == nodeValue) {
                System.out.println("Searched Node: " + nodeValue + ", successfully found in DLL.");
                found = true;
                break;
            }
            tempNode = tempNode.next;
        }

        if (!found) {
            System.out.println("Searched Node: " + nodeValue + ", could not be found in DLL.");
        }
    }

    // Deletion Method
    public void  deleteDLL (int nodeValue, int location) {
        if(head == null) {
            return;
        }
        DoublyNode tempNode = head;
        int index = 0;
        while (tempNode != null && index < location) {
            tempNode = tempNode.next;
            index++;
        }
        if (tempNode == null) {
            System.out.println("Node not found in DLL.");
            return;
        }
        if (location == 0) {
            head = tempNode.next;
            if (head != null){
                head.prev = null;
            }
        } else if (tempNode.next == null) {
            tempNode.prev.next = null;
        } else {
            tempNode.prev.next = tempNode.next;
            tempNode.next.prev = tempNode.prev;
        }
        size--;
    }

    // Delete entire DLL
    public void deleteEntireDLL() {
        DoublyNode tempNode = head;
        while (tempNode != null) {
            DoublyNode nextNode = tempNode.next;
            tempNode.prev = null;
            tempNode.next = null;
            System.out.println("Successfully deleted " + tempNode.value);
            tempNode = nextNode;
        }
        head = null;
    }
}
