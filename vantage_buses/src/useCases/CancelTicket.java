package useCases;

import java.util.Scanner;

import bean.Customers;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import exceptions.BusException;

public class CancelTicket {

	public  static void cancelTicket(Customers customer) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println( "Enter Bus Name" );
		String busName = sc.nextLine();
		
		CustomerDAO dao = new CustomerDAOImpl();
		try {
			
			int cusId = customer.getCusId();
			String message = dao.cancelTicket(busName, cusId);
			
			if (message.equals("Ticket cancelled Successfully")) {
				System.out.println( message );
			}
			else {
				System.out.println( message );
			}
			
		} catch (BusException e) {
			System.out.println( e.getMessage());
		}
	}
}
