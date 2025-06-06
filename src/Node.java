//After modifying the program, I had to create a class for a node which we will use for the methods in our list
public class Node {
    PantryItem item;
    Node next;

    public Node(PantryItem item) {
        this.item = item;
        this.next = null;
    }
}