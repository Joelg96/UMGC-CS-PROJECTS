/* Joel Goode - CMIS141/4015 - January 17th, 2022 - Assignment 1
 * 
 * This program is designed to prompt a user to enter:
 * Customer ID
 * Unit price (format x.xx)
 * Quantity (whole number)
 * Product Description 
 * With a discount (format .xx)
 * Then calculate the customer's total before and after discount
 * Display/Output - inputed data with order total before and after discount
 * 
 */

import java.util.Scanner; //Import Scanner Class


public class Assign1 {

		
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Create Scanner object. 
	
// Variables for program:
		int custID; // Customer ID
		float unitPrice; // Unit Price
		int quantity; // Quantity 
		float discount; // Discount 
		String proDescrip; // Product Description
		float totalBefore; // Order total before discount
		float totalAfter; // Order total after discount

		
		
// Prompt User to enter order data
		System.out.print("Please Enter Customer ID #: "); 
		custID = input.nextInt();
		
		
		System.out.print("\nEnter Unit Price(x.xx): $"); 
		unitPrice = input.nextFloat();
		
		
		System.out.print("Enter Unit Quantity: ");
		quantity = input.nextInt();
		input.nextLine();
		
		
		System.out.print("Enter Product Description: "); 
		proDescrip = input.nextLine();
		
		
		System.out.print("Enter Discount(.xx): "); 
		discount = input.nextFloat();
		
	
		
	
		
		
		
// Calculate total before discount.
		
		totalBefore = unitPrice * quantity;	

// Calculate total after discount. 
		
		totalAfter = totalBefore * 1 - totalBefore * discount;
			

		
// Output order data and display Order total before and after discount.
		
		System.out.println("\nFINAL ORDER:");
		
		System.out.println("Customer ID #: "+ custID);		
		System.out.print("Product Description: " + proDescrip);	
		System.out.println();
		System.out.printf("Unit Price: $%.2f", unitPrice);
		System.out.println();
		System.out.println("Quantity: " + quantity);
		System.out.printf("Discount: %.2f", discount);
		System.out.println();
		System.out.printf("\nOrder Total Before Discount: $%,.2f", totalBefore); // Before Discount
		System.out.println();
		System.out.printf("Order Total After Discount: $%,.2f",  totalAfter); // After Discount
		

		input.close();
	}

}
