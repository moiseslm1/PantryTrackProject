
public class PantryItem {
    private String name;
    private int quantity;
    private String expiryDate;

    //Constructor
    public PantryItem(String name, int quantity, String expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    //had to add this method to help with the addItem method, this will add an amount of items to the actual quantity
    public void addQuantity(int amount)
    {
        this.quantity += amount;
    }
}



