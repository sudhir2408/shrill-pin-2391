package useCases;

import java.util.Scanner;
import dao.AdminDAO;
import dao.AdminDAOimpl;

public class AdminLogin {
	
public static boolean AdminLogin() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username");
		String username = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		AdminDAO dao = new AdminDAOimpl();
		String result =  dao.adminLogin(username, password);
		
		if (result.equals("Login Successfull")){
			System.out.println(result);
			return true;
		}
		else {
			System.out.println(result );
			return false;
		}
	}

}
