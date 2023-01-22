package useCases;

import java.util.Scanner;
import dao.AdminDAO;
import dao.AdminDAOimpl;

public class UpdateStats {

public static void updateStatus() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer Id" );
		int cusId = sc.nextInt();
		
		AdminDAO dao = new AdminDAOimpl();
		
		String result = dao.updateStatus(cusId);
		boolean flag = true;
		
		for (int i = 0; i < result.length(); i++) {
			if (result.charAt(i) == 'n') flag = false;
		}
	
		if (flag) System.out.println(result );
		else System.out.println( result );
		
	}
}
