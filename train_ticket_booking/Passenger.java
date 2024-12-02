package train_ticket_booking;

public class Passenger {
	
	
	
	static int id=1;  //static variable to give id for every new passenger
    String name;
	int age;
	String berthpreference;   // U or L or M
	int passengerid;  // id of passenger created automatically
	String alloted;   //alloted type (L,U,M,RAC,WL)
	int number;       //seat number
	
	
	
	public Passenger(String name, int age, String berthPreferance) {
		// TODO Auto-generated constructor stub
		
		this.name=name;
		this.age=age;
		this.berthpreference=berthPreferance;
		this.passengerid=id++;
		alloted="";
		number=-1;
		
	}
	
	

}
