package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import bean.Customers;
import useCases.AddNewBus;
import useCases.BookTicket;
import useCases.CancelTicket;
import useCases.CustomerLogin;
import useCases.CustomerNewSignup;
import useCases.SeeAllTickets;
import useCases.SeeTickets;
import useCases.UpdateStats;

public class Main {
	
	static void AdminOrCustomer() {
		System.out.println("                   ");
		System.out.println(" Welcome to the Vantage Bus Service (live with Us)" );
		System.out.println("                   ");
		System.out.println(  " 1. Login As Administrator " + "\n"
						  + " 2. Login As Customer      " + "\n"
						  + " 3. Exit  " );
		choice();
	}
	
	static void choice() {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println( "Input type should be number");
			AdminOrCustomer();
		}
		
		if (choice == 1) {
			System.out.println("Welcome Admin ! Please Login to your account");
			AdminLogin();
		}
		else if (choice == 2) {
			System.out.println("Welcome Customer !");
			customerLoginOrSignup();
		}
		else if (choice == 3) {
			System.out.println( "Thank you ! Visit again" );
			System.exit(0);
		}
		else {
			System.out.println("Please choose a number from below options");
			AdminOrCustomer();
		}
	}
	
	static void AdminLogin() {
		
		Boolean result = useCases.AdminLogin.AdminLogin();

		if (result) adminMethods();
		else {
			AdminLogin();
		}
	}
	
	static void adminMethods() {
		System.out.println(  
		                   " Welcome Admin                  " + "\n"
						 + " 1. Add Bus                     " + "\n"
						 + " 2. Confirm Tickets of Customer " + "\n"
						 + " 3. View All Bookings           " + "\n"
						 + " 4. Back                        " + "\n"
						 + " 5. Exit                        " );
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println("Please choose a number from below options");
				adminMethods();
			}
			else adminChoice(choice);
		}
		catch (InputMismatchException e) {
			
			System.out.println("Input type should be number");
			adminMethods();
		}
	}
	
	static void adminChoice(int choice) {
		
			switch(choice) {
				case 1 : {
					AddNewBus.AddBus();
					adminMethods();
				}
				break;
				case 2 : {
					UpdateStats.updateStatus();
					adminMethods();
				}
				break;
				case 3 : {
					SeeAllTickets.viewAllTicket();
					adminMethods();
				}
				break;
				case 4 : AdminOrCustomer();
				break;	
				case 5 : {
					System.out.println("Thank you ! Visit again");
					System.exit(0);
				}
			}
	}
	
	static void customerLoginOrSignup() {
		System.out.println(    " 1. Login to your Account       " + "\n"
				             + " 2. Don't have Account? Sign Up " + "\n"
				             + " 3. Back                        " + "\n"
				             + " 4. Exit                        " );
		try {
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			if (choice == 1) {
				customerLogin();
			}
			else if (choice == 2) {
				customerSignup();
			}
			else if (choice == 3) {
				AdminOrCustomer();
			}
			else if (choice == 4) {
				System.out.println("Thank you for coming ! Hope to see you again" );
				System.exit(0);
			}
			else {
				System.out.println( "Please choose a number from below options");
				customerLoginOrSignup();
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Input type should be number" );
			customerLoginOrSignup();
		}
		
	}
	
	static void customerLogin() {
		Customers customer = CustomerLogin.CusLogin();
		
		if (customer == null) {
			customerLogin();
		}
		else {
			System.out.println("Login Successfull" );
			customerMethods(customer);
		}
		
	}
	
	static void customerSignup() {
		boolean flag = CustomerNewSignup.cusSignUp();
		
		if (flag) {
			System.out.println("Login to your Account" );
			customerLogin();
		}
		else {
			customerSignup();
		}
	}
	
	static void customerMethods(Customers customer) {
		System.out.println(
				 		 "  1. Book Bus Ticket             " + "\n"
				         +  "2. Cancel Bus Ticket           " + "\n"
				         +  " 3. View Status of your Tickets " + "\n"
				         +  " 4. Back                        " + "\n"
				         +  "5. Exit                       " );
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		try {
			choice = sc.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println("Please choose a number from below options");
				customerMethods(customer);
			}
			else customerChoice(choice, customer);
		}
		catch (InputMismatchException e) {
			
			System.out.println("Input type should be number");
			customerMethods(customer);
		}
	}
	
	static void customerChoice(int choice, Customers customer) {
		switch(choice) {
		case 1 : {
			BookTicket.BookTicketbName(customer);
			customerMethods(customer);
		}
		break;
		case 2 : {
			CancelTicket.cancelTicket(customer);
			customerMethods(customer);
		}
		break;
		case 3 : {
			SeeTickets.viewTicket(customer);
			customerMethods(customer);
		}
		break;
		case 4 : {
			customerLoginOrSignup();
		}
		case 5 : {
			System.out.println(" Thank you for coming ! come again and enjoye your journey with us");
			System.exit(0);
		}
	}
	}

	public static void main(String[] args) {
		
		AdminOrCustomer();
	}

}
