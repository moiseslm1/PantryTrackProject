import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//These three import statements will help with date formatting, chatgpt assisted and I also used https://www.w3schools.com/java/java_date.asp
public class PantryDisplay
{ //Had to modify main method to meet the <30 line requirement, created methods that can be accessed by main method, code is still the same just shortened on main method, used a little help from an example chatgpt provided
    public static void main(String[] args) //main method line 1
    { //Line 2
            Scanner input = new Scanner(System.in); //to receive user's input    //Line 3
            PantryLinkedList pantry = new PantryLinkedList();        //Line 4
        /*Header*/System.out.println("Welcome to the University Food Pantry Management System\n-------------------------------------------------------");//Line 5
            int choice; //Line 6
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //formats the data as yyyy-dd-mm chatgpt provided an example of how this formatting works //Line 7
            do { //Line 8
                System.out.print("1.Add Item\n2.Distribute Item\n3.Search item\n4.Exit\nEnter your choice: ");//Prints out the options //Line 9
                choice = input.hasNextInt() ? input.nextInt() : -1; input.nextLine(); //Line 10, had to modify so that it also throws error message when
                // a letter is inputted, chatgpt helped with this idea, basically if the input isn't in between 1-4, the choice becomes -1 and this will bring out the default message we created for invalid input.
                switch (choice) { //Line 11
                    case 1: //Line 12
                        addItemMenu(input, pantry, formatter); //Line 13 adds item to list, so the user's input,
                        break; //Line 14
                    case 2: //Line 15
                        distributeItemMenu(input, pantry); //Line 16
                        break; //Line 17
                    case 3: //Line 18
                        searchItemMenu(input, pantry); //Line 19
                        break; //Line 20
                    case 4: //Line 21
                        System.out.println("Goodbye!"); //Line 22
                        break; //Line 23
                    default: //Line 24
                        System.out.println("Invalid, please enter a valid option."); //Line 25
                } //Line 26
            } while (choice != 4); //Line 27
            input.close(); //Line 28
        } //main method ends at 29 lines
    private static void addItemMenu(Scanner input, PantryLinkedList pantry, DateTimeFormatter formatter)
    {   //Menu for adding an item
        String name;
        while (true) //I used https://stackoverflow.com/questions/69267154/java-how-to-write-an-exception-if-the-user-entered-a-number-instead-of-a-string
        //the website helped me find a way to create an exception for integers when name was inputted
        //this is similar to the exception for the quantity except it uses Integer.parseInt(name) to check if the name is a number
        {
            System.out.print("Enter item name: ");
            name = input.next(); //Forgot to add this, was creating an error and skipping a line
            try
            {
                Integer.parseInt(name); //this will check that the name is a number, and if so it'll throw error
                System.out.println("Invalid input. Enter only characters");
            } catch(NumberFormatException e)
            {
                break; //will stop if the name is not a number
            }
        }
        int quantity;
        while(true)
        {
            System.out.print("Enter quantity: ");
            try
            {
                quantity = input.nextInt();
                input.nextLine();
                if(quantity <= 0 )
                {
                    System.out.println("Please enter a positive number"); //Things to consider, input must be positive
                }else
                {
                    break;
                }
            }catch(InputMismatchException e)
            {
                System.out.println("Invalid input. Enter a number"); //input needs to be a number not a character
                input.nextLine();
            }
        }
        String expiry;
        while (true)
        { //Will ask for the expiration date in the specific format
            System.out.print("Enter expiry date (YYYY-MM-DD): ");
            expiry = input.nextLine(); //We will use a try catch to throw a message error when date is inputted in wrong format
            //for reference I used https://www.w3schools.com/java/java_try_catch.asp to help me remember the catch try method
                       try
                       {
                           LocalDate.parse(expiry, formatter);
                           break;
                       }
                       catch (DateTimeParseException e)
                       {
                                 System.out.println("Invalid format. Enter date as (YYYY-MM-DD)");
                       }
        }
        pantry.addItem(name, quantity, expiry); //adding to the pantry the item
    }
    private static void distributeItemMenu(Scanner input, PantryLinkedList pantry)
    {
        //Distribution menu with prompts
        //Search menu with prompts
        String name;
        while (true) //Using this same method for all name inputs, copy and paste
        {
            System.out.print("Enter item name: ");
            name = input.next(); //Forgot to add this, was creating an error and skipping a line
            try
            {
                Integer.parseInt(name); //this will check that the name is a number, and if so it'll throw error
                System.out.println("Invalid input. Enter only characters");
            } catch(NumberFormatException e)
            {
                break; //will stop if the name is not a number
            }
        }
        //Will use a try catch here to only accept numbers as input, no letters or anything else
        int quantity;
        while(true)
        {
        System.out.print("Enter quantity: ");
        try
        {
            quantity = input.nextInt();
            if(quantity <= 0 )
            {
             System.out.println("Please enter a positive number"); //Things to consider, input must be positive
            }else
            {
                break;
            }
        }catch(InputMismatchException e)
        {
            System.out.println("Invalid input. Enter a number"); //input needs to be a number not a character
            input.nextLine();
        }
        }
        pantry.distributeItem(name, quantity);
    }
    private static void searchItemMenu(Scanner input, PantryLinkedList pantry)
    {
        //Search menu with prompts
        String name;
        while (true) //Using this same method for all name inputs, copy and paste
        {
            System.out.print("Enter item name: ");
            name = input.next(); //Forgot to add this, was creating an error and skipping a line
            try
            {
               Integer.parseInt(name); //this will check that the name is a number, and if so it'll throw error
               System.out.println("Invalid input. Enter only characters");
            } catch(NumberFormatException e)
            {
                break; //will stop if the name is not a number
            }
        }
        pantry.searchItem(name); //searching the name of the item on the list.
    }
}

