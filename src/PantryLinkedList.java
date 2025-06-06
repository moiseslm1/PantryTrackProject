//Made the mistake of not reading full instructions about not using a structure from java collections
//Tweaked the code very little and ended up putting it as a separate class
public class PantryLinkedList
{
    private Node head;

    //The add method
    public void addItem(String name, int quantity, String expiryDate) {
        Node currentNode = head; //Using the node class to create a node on my list which points to the head.
        while (currentNode != null)
        {
            if (currentNode.item.getName().equalsIgnoreCase(name)) {
                currentNode.item.addQuantity(quantity); //this was a small modification made after creating my own list, using the addQuantity method.
                System.out.println("More added to this item!\n"); //shows message if you add more to the same item
                return;
            }
            currentNode = currentNode.next;
        }
        System.out.println("Item added successfully!\n");
        Node newNode = new Node(new PantryItem(name, quantity, expiryDate)); //updates list with the items
        newNode.next = head;
        head = newNode;


    }
    //The distributing method
    //Note for self: there was an issue with skipping a line, may need a \n at the end of sentence
    public void distributeItem(String name, int quantityAsked)
    {
        Node currentNode = head; //Creating a node that points to the head to find the item to distribute on the list

        while(currentNode != null)
        {
            if (currentNode.item.getName().equalsIgnoreCase(name))
            {
                int currentQuantity = currentNode.item.getQuantity();
                if (currentQuantity >= quantityAsked) //Checking if quantity in stock is bigger than the requested
                {
                    currentNode.item.setQuantity(currentQuantity - quantityAsked); //subtracting from inventory
                    System.out.printf("%d %s distributed successfully!\n\n", quantityAsked, name.toLowerCase()); //used google to remember how to use printf formatting
                    //Using toLowerCase() in case someone inputs something like Apples or aPPles, it will print out in all lower case and it will make it look cleaner
                } else if (currentQuantity > 0) {
                    System.out.printf("There are only %d of %s to distribute.\n\n", currentQuantity, name.toLowerCase());
                    currentNode.item.setQuantity(0);
                } else {
                    System.out.printf("The item %s is out of stock.\n\n", name.toLowerCase());
                }
                return;
            }
            currentNode = currentNode.next;
        }
        System.out.printf("Item '%s' not found on the list.\n\n", name.toLowerCase()); //If item inputted isn't there then it'll give this message,
        // and that is if it has never been added before, otherwise it's just out of stock
    }
    //Searching method
    //Note for self: there was an issue with skipping a line, revise
    //Other error was, goodbye message printing right after
    public void searchItem(String name)
    {
        Node currentNode = head; //Creating a node that points to the head to find the item being looked for
        while (currentNode != null)
        {
            if (currentNode.item.getName().equalsIgnoreCase(name)) //Comparing name inputting to names in the list
            {
                System.out.printf("Item: %s, Quantity: %d, Expiry Date: %s\n\n", currentNode.item.getName(), currentNode.item.getQuantity(),
                        currentNode.item.getExpiryDate()); //Once item is found, it will display the item's data
                return;
            }
            currentNode = currentNode.next;
        }
        System.out.println("Item is not available\n"); //Message will pop up if the item is not on the list
    }
}