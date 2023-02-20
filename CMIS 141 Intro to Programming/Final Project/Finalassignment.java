/* Joel Goode - CMIS141/4015 - March , 2022
 * 1. Load customers’ data - prompt user for the number of customers to be loaded and then prompts for each customer's name, customer id (5 digit number), and total sales
 * 2. Add new customer - prompts the user for customer data: customer name, customer id, and total sales
 * 3. Display all customers - displays each customer's data to the console, one customer per line
 * 4. Retrieve specific customer's data - prompts the user for the customer id and displays the corresponding customer's data: customer id, customer name, and total sales
 * 5. Retrieve customers with total sales based on the range - prompts the user for the lowest and highest total sales and displays all customers with total sales in that range.
 *    Display each customer on a separate line with all information – Customer Name, Customer ID, and Total Sales
 * 6. Exit
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Finalassignment
{
    // Initialize an array of size here to set as the max size of the array.
    public final static int MAXARRAYSIZE = 100;
    // Initialize the customer list array here to hold our customer data.
    public static List<Customer> customerList = new ArrayList<>(MAXARRAYSIZE);
    
    
    // Customer Class 
    public static class Customer 
    {

        // properties of class
        String name;
        int id;
        double totalSales;

        // Getters
        public int getId() 
        {
            return id;
        }

        // constructor
        public Customer(String name, int id, double totalSales) 
        {
            this.name = name;
            this.id = id;
            this.totalSales = totalSales;
        }

        public double getTotalSales() 
        {
            return totalSales;
        }


        // Output the information of the customer class
        @Override
        public String toString() 
        {
          String res="";
          res+="\t*Customer Name: " + name + "|Customer ID: "+ id + " |Total Sales: $"+ totalSales;
          return res;
        }

    }
	
	// Main menu Method
	public static void mainMenu()
	{
		 //Main menu
		System.out.println("\n\t*Welcome! Please Choose An Option From The Following (0-5)*");
		System.out.println("(1) Load Multiple Customers' Data. ");
		System.out.println("(2) Add New Customer.");
		System.out.println("(3) Display All Customers' Data.");
		System.out.println("(4) Retrieve A Specific Customer's Data.");
		System.out.println("(5) Retrieve Customers With Total Sales Based On Range.");
		System.out.println("(0) Exit Program.");
		System.out.print("\nEnter Choice Here: ");
	}
	
	
	// Load user defined number of customers' data method.
    public static void loadCustomersData() 
    {
        // Variables for method
    	int number, i;
        boolean continuePromptMenu = true;
        Scanner input = new Scanner(System.in);
        
        while (continuePromptMenu) 
        {
            
            try 
            {
                System.out.print("How Many Customers Do You Want To Load?: ");
                number = input.nextInt();

                if (number > 0)
                {
                    if ((MAXARRAYSIZE - customerList.size()) > number) 
                    {
                        for (i = 1; i <= number; i++) 
                        {
                            System.out.println("\nCreating Customer: " + i);
                            addNewCustomer();
                        }
                        
                        continuePromptMenu = false;
                    } 
                    
                    else 
                    {
                        System.out.println("\t**Input cannot be larger than the size of the storage(100)! Please try again!: " );
                    }
                } 
                
                else
                {
                    System.out.println("\t**Input cannot be zero Please try again!: ");
                }
                
            } catch (Exception e)
            	{
            		System.out.println("\t**Invalid input! Please try again!: ");
            		input.nextLine();
            	}
        }
    }

    
    // Adding a new customer method.
    public static void addNewCustomer() 
    {
    	//Variables for method
    	String name;
    	int idInteger;
    	double sales;
        boolean continueAddCustomer = true;
        Scanner input = new Scanner(System.in);
        
        while(continueAddCustomer)
        {
            try 
            {
                System.out.println("Enter Customer Details...");
                System.out.println("\nEnter Customer Name:");
                name = input.nextLine();

                //ID
                System.out.println("Enter Customer ID#:");
                idInteger = input.nextInt();
                if (String.valueOf(idInteger).length() != 5) 
                {
                    throw new Exception("ID# must be 5 digits in length!");
                }

                // Allow only 1 id per customer.
                for(Customer customer: customerList)
                {
                    if (customer.getId() == idInteger) 
                    {
                        throw new Exception("\t**ERORR Customer# Already Exists!**");
                    }
                }

                // Total Sales
                System.out.println("Enter Total Sales:");
                sales = input.nextDouble();
                Customer customer = new Customer(name, idInteger, sales);
                customerList.add(customer);
                System.out.println("Customer created!");
                continueAddCustomer = false;
         
            } catch (Exception e)
            {
                System.out.println("\t**Invalid input! Please try again!: ");
                input.nextLine();
            }
        }
    }

    
    // Display all customers method.
    public static void displayAllCustomers() 
    {
    	int counter = 0;
    	Scanner input = new Scanner(System.in);
        for(Customer customer : customerList) 
        {
            System.out.println(customer.toString());         
            counter += 1;
        }
        
        if(counter == 0) 
        {
            System.out.println("No Data Found...");
        }
        
        System.out.println(">> Press any key to continue!");
        input.nextLine();
    }

    
    // Retrieve specific customer method.
    public static void retrieveSpecificCustomer() 
    {
    	// Variable for method
    	int idInteger;
        boolean continueRetrieve = true;
        Scanner input = new Scanner(System.in);
        
        while (continueRetrieve)
        {
            try
            {
                System.out.println("Enter Customer ID# To search: ");
                idInteger = input.nextInt();
                boolean found = false;
                
                for(Customer customer : customerList) 
                {
                    if(customer.getId() == idInteger) 
                    {
                        System.out.println(customer.toString());
                        found = true;
                    }
                }
                
                if(!found) 
                {
                    System.out.println("No Data Found...");
                    break;
                }
                
            } catch(Exception e)
            	{
            	System.out.println("\t**Invalid input! Please try again!: ");
                	input.nextLine();
            	}
        }
    }

    
    // Retrieve customer with total sales range.
    public static void retrieveCustomerInSalesRange() 
    {
    	// Variables for Method
    	double salesLowest, salesHighest;
    	int counter = 0;
        boolean continueRetrieveSales = true;
        Scanner input = new Scanner(System.in);
        
        while(continueRetrieveSales)
        {
            try 
            {
                System.out.println("Enter (Lowest/Minumum) Total Sales Range: ");
                salesLowest = input.nextDouble();

                System.out.println("Enter (Highest/Maximum) Total Sales Range: ");
                salesHighest = input.nextDouble();

                for(Customer customer: customerList)
                { 
                    if(customer.getTotalSales() >= salesLowest && customer.getTotalSales() <= salesHighest) 
                    {
                        System.out.println(customer.toString());
                        counter += 1;
                    }
                }
                
                if(counter == 0) 
                {
                    System.out.println("No Data Found...");
                }
                
            } catch(Exception e)
            	{
            		System.out.println("\t**Invalid input! Please try again!: ");
            		input.nextLine();
            	}
        }
    }

    
    // Main method.
    public static void main(String[] args) 
    {
    	Scanner input = new Scanner(System.in);
        boolean continuePromptMenu = true;
        while(continuePromptMenu)
        {
        	mainMenu();
           
            try
            {
                int choice = input.nextInt();

                //We check the input value
                switch(choice)
                {
                    case 1:
                    	loadCustomersData();
                        break;    
                        
                    case 2:
                    	addNewCustomer();
                        break;
                        
                    case 3:
                    	displayAllCustomers();
                        break;
                        
                    case 4:
                    	retrieveSpecificCustomer();
                        break;
                        
                    case 5:
                    	retrieveCustomerInSalesRange();
                        break;
                        
                    case 0: 
                    	System.out.println("Exiting program....");
                        System.exit(0);
                        
                    default:  
                    	System.out.println("\t**Invalid Input!** Please Try Again!.\n");
                        continuePromptMenu = true;
                        break;
                }
                
            } catch(Exception e) 
            	{
            		System.out.println("\t**Invalid input! Please try again!: ");
            		input.nextLine();
            	}
        }
    }



}
