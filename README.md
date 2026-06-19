
import java.util.Scanner;

// Inhertiance(extends): Burger, Curry, Fries, and Rice classes will all 
// inherit the common fields(name, price) from a base MenuItem class.

//Polymorphism(Method Overriding): Will use a single arr
// Create parent class called MenuItem (Inheritance) and give it an 
// overridable method called calculatePrice (Polymorphism) that adapts 
// based on the item type and quantity ordered.


class MenuItem {
    protected String name;
    protected int basePrice;

    public MenuItem(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    // Polymorphism: This method will be overridden by child classes
    public int calculatePrice(int quantity) {
        return this.basePrice * quantity;
    }
}

// Inheritance: Child classes extending MenuItem
class Burger extends MenuItem {
    public Burger() {
        super("Burger and Curry House Burger", 15);
    }
}

class Curry extends MenuItem {
    public Curry() {
        super("Burger and Curry House Curry", 15);
    }
}

class Fries extends MenuItem {
    public Fries() {
        super("Burger and Curry House Fries", 8);
    }
}

// Polymorphism: Rice has a special behavior (e.g., buy 3, get $2 off)
class Rice extends MenuItem {
    public Rice() {
        super("Burger and Curry House Rice", 8);
    }

    // overriding the calculatePrice method to add a special discount for rice
    // Rules for ovverriding: Same method name(the method must have the exact same
    // name as the one in the parent class), 
    // same parameters(the parameter list must be the same as 
    // the one in the parent class), 
    // (IS-A relationship)- the child class must be a subtype of the parent class,
    
    @Override
    public int calculatePrice(int quantity) {
        int total = this.basePrice * quantity;
        if (quantity >= 3) {
            System.out.println(" $2 off your rice.");
            total -= 2;
        }
        return total;
    }
}

// MAIN APPLICATION CLASS
public class MenuOnlineFoodOrdering {
    
    // Helper method to look up items out of our polymorphic array
    // This method abstracts away the logic of creating specific
    //  MenuItem objects based on user input
    // case 1: returns a Burger object, 
    // case 2: returns a Curry object, etc.
    public static MenuItem getMenuItem(int choice) {
        switch (choice) {
            case 1: return new Burger();
            case 2: return new Curry();
            case 3: return new Fries();
            case 4: return new Rice();
            default: return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Online Food Ordering System for Burgers and Curry House!");
        System.out.println("Please select an option to get started:" );
        System.out.println("1. View Menu for Burgers and Curry House");
        System.out.println("2. Place Order");
        System.out.println("3. Exit");

        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
       
        if (userChoice == 1 || userChoice == 2) {
            System.out.println("\nMenu: ");
            System.out.println("1. Burger and Curry House Burger - $15");
            System.out.println("2. Burger and Curry House Curry - $15");
            System.out.println("3. Burger and Curry House Fries - $8");
            System.out.println("4. Burger and Curry House Rice - $8");

            int grandTotal = 0;
            
            System.out.println("\nPlease enter the item number you want to order: ");
            int itemChoice = scanner.nextInt();
            
            // Polymorphism: getMenuItem returns a MenuItem reference, 
            // but the actual object could be a Burger, Curry, Fries, 
            // or Rice depending on the user's choice. 
            // We store the specific child object inside a generic MenuItem
            //  variable reference.
            // This allows us to call calculatePrice without 
            // worrying about the specific type of item

            MenuItem selectedItem = getMenuItem(itemChoice);

            if (selectedItem != null) {
                System.out.println("Please enter the quantity: ");
                int quantity = scanner.nextInt();
                
                // Grand total starts at 0, and we add the price of each
                //  item as we go.
                // Polymorphic method call: This will call the 
                // appropriate calculatePrice
                int initialTotal = selectedItem.calculatePrice(quantity);
                grandTotal += initialTotal;
                
                System.out.println("Order Confirmed! " + quantity + " " + selectedItem.getName() + ". Total: $" + initialTotal);
                
                System.out.println("\nAny other menu items you would like to order? (yes/no)");
                String otherItems = scanner.next();
                
                // We can use a boolean variable to 
                // control the flow of the loop for additional items
                boolean wantsMoreItems = otherItems.equalsIgnoreCase("yes");
                
                if (wantsMoreItems) {
                    while (true) {
                        System.out.println("Please enter the item number you want to order: ");
                        int additionalItemNumber = scanner.nextInt();
                        
                        MenuItem additionalItem = getMenuItem(additionalItemNumber);
                        
                        if (additionalItem != null) {
                            System.out.println("Please enter the quantity: ");
                            int additionalQuantity = scanner.nextInt();
                            
                            // Grand total is updated with each additional item ordered.
                            // Polymorphism: This will call the correct calculatePrice 
                            // method based on the type of 
                            // additionalItem (Burger, Curry, Fries, or Rice).
                            //Polymorphic method call for additional items
                            int additionalTotal = additionalItem.calculatePrice(additionalQuantity);
                            grandTotal += additionalTotal;
                            
                            System.out.println("Customer added this to the order: " + additionalQuantity + " " + additionalItem.getName() + " (+$" + additionalTotal + ")");
                        } else {
                            System.out.println("Invalid selection. No item added.");
                        }
                        
                        System.out.println("\nAny other menu items you would like to order? (yes/no)");
                        String moreItems = scanner.next();
                        if (moreItems.equalsIgnoreCase("no")) {
                            break; 
                        }
                    }
                }
                System.out.println("\nYour grand total order cost is: $" + grandTotal);
            } else {
                System.out.println("Invalid menu item selection.");
            }
        } 
        else if (userChoice == 3) {
            System.out.println("Thank you for using the Online Food Ordering System for Burgers and Curry House! Goodbye!");
        }
        else { 
            System.out.println("Invalid option. Please try again.");
        }
        
        scanner.close(); 
    }
}
