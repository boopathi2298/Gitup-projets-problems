package train_ticket_booking;
import java.util.Scanner;

public class Main {
	
	 //function for bokoing ticket
	public static void bookTicket(Passenger p) {
		// TODO Auto-generated method stub
		TicketBooker booker=new TicketBooker();
		
		  //if no WL is available , means all tickets are filled.. so no tickets available
		if(TicketBooker.availableWaitingList==0) {
			System.out.println("no ticket available");
			return;
		}
		 //check if preferred berth is available
		if((p.berthpreference.equals("L")&&TicketBooker.availableLowerBerths>0)||
		  (p.berthpreference.equals("M")&& TicketBooker.availableMiddleBerths>0)||
		  (p.berthpreference.equals("U")&& TicketBooker.availableUpperBerths>0))
		{
			System.out.println("prefered Berth Available");
			if(p.berthpreference.equals("L")) {
				
				System.out.println("lower berth given");
				booker.bookTicket(p,(TicketBooker.lowerBerthPositions.get(0)),"L");
				TicketBooker.lowerBerthPositions.remove(0);
				TicketBooker.availableLowerBerths--;
				
				}
			
			else if(p.berthpreference.equals("M")) {
				
				System.out.println("middle berth given");
				booker.bookTicket(p,(TicketBooker.middleBerthPositions.get(0)),"M");
				TicketBooker.middleBerthPositions.remove(0);
				TicketBooker.availableMiddleBerths--;
				
			}
			else if(p.berthpreference.equals("U")) {
				System.out.println("upper berth given");
				booker.bookTicket(p,TicketBooker.upperBerthPositions.get(0),"U");
				TicketBooker.upperBerthPositions.remove(0);
				TicketBooker.availableUpperBerths--;
				}
		}
			else if(TicketBooker.availableLowerBerths>0) {
				System.out.println("lower Berth given");
				booker.bookTicket(p,(TicketBooker.lowerBerthPositions.get(0)),"L");
				TicketBooker.lowerBerthPositions.remove(0);
				TicketBooker.availableLowerBerths--;
				
			}
			else if(TicketBooker.availableMiddleBerths>0) {
				System.out.println("middle berth given");
				booker.bookTicket(p,(TicketBooker.middleBerthPositions.get(0)),"M");
				TicketBooker.middleBerthPositions.remove(0);
				TicketBooker.availableMiddleBerths--;
				
			}
			else if(TicketBooker.availableUpperBerths>0) {
				System.out.println("upper berth Given");
			    booker.bookTicket(p, (TicketBooker.upperBerthPositions.get(0)),"U");
			    TicketBooker.upperBerthPositions.remove(0);
			    TicketBooker.availableUpperBerths--;
			    
				}
				
			  // if no berth available go to RAC
			else if(TicketBooker.availableRacTickets>0) {
					System.out.println("RAC available");
					booker.addRAC(p,(TicketBooker.racPositions.get(0)),"RAC");
					
				}
			     // if no RAC available go to WL
				else if(TicketBooker.availableWaitingList>0) {
				System.out.println("Added to WaitingList");
				booker.addToWaitingList(p,(TicketBooker.waitingListPositions.get(0)),"WL");
				
			}
		}
		

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner  s=new Scanner(System.in);
		boolean loop=true;
		
		 //loop to get choices from user until he stops
		
		while(loop) {
			System.out.println(" 1. Book Ticket \n 2. Cancel Ticket \n 3. Available Tickets \n 4. Booked Tickets \n 5. Exit");
			
			int choice=s.nextInt();
			
			switch(choice) {


			//book ticket
			case 1:
			{
				 //get details from Passenger
                System.out.println("Enter Passenger name,age and berth preference (L,M or U)");
                String name=s.next();
                int age=s.nextInt();
                //get berth preference (L,U,M)
                String berthPreferance=s.next();
                
                //create a passenger object
                Passenger p=new Passenger(name,age,berthPreferance);
                //booking
                bookTicket(p);
			}
			break;
          //cancel Ticket
			case 2:
			{
				
			
				System.out.println("Enter passenger id to cancel");
				int id=s.nextInt();
				cancelTicket(id);
				
                
			}
			break;
			case 3:
			{
				TicketBooker booker=new TicketBooker();
				booker.printAvailable();
				}
			break;
			
			case 4:
			{
				TicketBooker booker=new TicketBooker();
				booker.printPassengers();
			}
			break;
			case 5:
				loop=false;
				break;
				default:
					break;
				}
				}
		}
		


   //cancel Ticket function
	public static void cancelTicket(int id) {
		// TODO Auto-generated method stub
	
					TicketBooker booker=new TicketBooker();
					
					if(!booker.passengers.containsKey(id)) {
						System.out.println("passengers detail unknown");
					}
					else {
						booker.cancelTicket(id);
					}
	       }




	

}