package useCases;

import java.util.InputMismatchException;
import java.util.Scanner;

import bean.Customers;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import exceptions.BusException;

public class BookTicket {

public static void BookTicketbName(Customers customer) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Bus Name");
		String bName = sc.next();
		
		CustomerDAO dao = new CustomerDAOImpl();
		try {
			System.out.println("Enter no. of Tickets to Book" );
			int no = sc.nextInt();
			
			int cusId = customer.getCusId();
			String message = dao.bookTicket(bName, cusId, no);
			
			if (message.equals("Ticket Booked Successfully")) {
				System.out.println( message );
			}
			else {
				System.out.println( message );
			}
			
		} catch (BusException e) {
			System.out.println(e.getMessage() );
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input" );
		}
   }
}
