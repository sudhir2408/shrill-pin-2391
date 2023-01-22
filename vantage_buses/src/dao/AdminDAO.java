package dao;

import bean.Bus;

public interface AdminDAO {

    public final String username = "Vantage";
	
	public final String password = "7298";

	public String adminLogin(String username, String password);
	
	public String addBus(int busNo, String busName, String route_From, String route_To, String busType, String arrival, String departure,
			int totalSeats, int availSeats, int cost);
	
	public String addBus(Bus bus);
	
	public String updateStatus(int cusId);
	
	public void viewAllTickets();

}