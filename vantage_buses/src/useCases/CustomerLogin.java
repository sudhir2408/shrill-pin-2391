package useCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import bean.Customers;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import exceptions.CustomerException;

public class CustomerLogin {

public static Customers CusLogin() {
		
		Customers customer = null;
		
		try {
			
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Enter Username" );
			String username = sc.next();
			
			System.out.println("Enter Password");
			String password = sc.next();
			
			CustomerDAO dao = new CustomerDAOImpl();
			
			try {
				customer = dao.cusLogin(username, password);
				
				System.out.println( "Welcome " + customer.getFirstName() + " " + customer.getLastName());
			} catch (CustomerException e) {
				
				System.out.println(e.getMessage() );
			}
		}
		catch (InputMismatchException e) {
			System.out.println( e.getMessage() );
		}
		
		return customer;

	}

}
