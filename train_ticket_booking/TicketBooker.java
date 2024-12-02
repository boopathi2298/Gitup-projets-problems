package train_ticket_booking;
import java.util.*;

public class TicketBooker {
	
	 //63 berths(upper ,lower , middle)  + ( 18 RAC passengers) 
    //10 waiting list tickets ->21 L, 21 M, 21U , 18RAC, 10WL
	static int availableLowerBerths=1;  //normally 21
	static int availableMiddleBerths=1; //normally 21
	static int availableUpperBerths=1;  //normally 21
	static int availableRacTickets=1;  //normally 18
	static int availableWaitingList=1; //normally 10
	                                                         //list in passenger id
	                                                        //order list in queue
	static Queue<Integer> waitingList= new LinkedList<>(); //queue of WL passengers
	static Queue<Integer> racList = new LinkedList<>();    //queue for RAC passenger
	static List<Integer> bookedTicketList=new ArrayList<>(); //list of booked list passengers
	
	static List<Integer> lowerBerthPositions=new ArrayList<>(Arrays.asList(1)); //normally 1,2,3,,,,21
	static List<Integer> upperBerthPositions=new ArrayList<>(Arrays.asList(1)); //normally 1,2,3,,,,21
	static List<Integer> middleBerthPositions=new ArrayList<>(Arrays.asList(1));//normally 1,2,3,,,,,21
	static List<Integer> racPositions=new ArrayList<>(Arrays.asList(1));        //normally 1,2,3,,,,18
	static List<Integer> waitingListPositions=new ArrayList<>(Arrays.asList(1));//normally 1,2,3,,,,10
	
	static Map<Integer, Passenger> passengers = new HashMap<>();//map of passenger id to passengers

	
	
	
	
	//book ticket
	public void bookTicket(Passenger p, int berthInfo , String allotedBerth) {
		// TODO Auto-generated method stub
		
		//assign the seat number and type of berth(L,U,M)
	   p.number=berthInfo;  // 1 or 2
	   p.alloted=allotedBerth;  //lower berth and higher berth 
	  
	   // add passenger to the map
	   passengers.put(p.passengerid, p);
	   
	   //add passenger id to the list of booked tickets
	   bookedTicketList.add(p.passengerid);
	   System.out.println("__________________________Booked succesfully");
	   
	}




	 //adding to RAC
	public void addRAC(Passenger p, int raceInfo , String allotedRAC) {
		// TODO Auto-generated method stub
		 //assign seat number and type(RAC)
		p.number=raceInfo;
		p.alloted=allotedRAC;
		// add passenger to the map
		passengers.put(p.passengerid, p);
		 //add passenger id to the queue of RAC tickets
		racList.add(p.passengerid);
		//decrease available RAC tickets by 1    
		availableRacTickets--;
		 //remove the position that was alloted to the passenger
		racPositions.remove(0);
		System.out.println("added___________________________RAC Successfully");
		}

public void addToWaitingList(Passenger p, int waitingListInfo  , String allotedWL) {
		// TODO Auto-generated method stub
		

        //assign seat number and type(WL)
        p.number = waitingListInfo; 
        p.alloted = allotedWL;
        // add passenger to the map
        passengers.put(p.passengerid,p);
        //add passenger id to the queue of WL tickets
        waitingList.add(p.passengerid);
        //decrease available WL tickets by 1    
        availableWaitingList--;
        //remove the position that was alloted to the passenger
        waitingListPositions.remove(0);

        System.out.println("-------------------------- added to Waiting List Successfully");
		
	}



     //cancel ticket
     public void cancelTicket(int passengerid) {
	// TODO Auto-generated method stub
    	//remove the passenger from the map
	 Passenger p=passengers.get(passengerid);
	 passengers.remove(Integer.valueOf(passengerid));
	//remove the booked ticket from the list
	 bookedTicketList.remove(Integer.valueOf(passengerid));
	   //take the booked position which is now free
	 int positionBooked=p.number;
	 System.out.println("__________cancelled successfully");
	 
	 
	//add the free position to the corresponding type of list (either L,M,U);
	 if(p.alloted.equals("L")) {  //cancelled L to increase berth always increase the lower berth
		 availableLowerBerths++;  //increase lower berth
		lowerBerthPositions.add(positionBooked); //position added
		 
	 }
	 else if(p.alloted.equals("M")) {  //cancelled M to increase berth  increase the middle berth
		 availableMiddleBerths++;
		 middleBerthPositions.add(positionBooked); //position added
		 
	 }
	 else if(p.alloted.equals("U")) {   //cancelled U to increase berth increase Upper berth
		 availableUpperBerths++;
		 upperBerthPositions.add(positionBooked); //position added
		 
	 }
	 
	 //check if any RAC is there
	 if(racList.size()>0) {
		//take passenger from RAC and increase the free space in RAC list and increase available RAC tickets
		 Passenger passengerFromRAC=passengers.get(racList.poll());
		 int positionRac=passengerFromRAC.number;
		 racPositions.add(positionRac);
		 racList.remove(Integer.valueOf(passengerFromRAC.passengerid));
		 availableRacTickets++;
		 
		//check if any WL is there
	 if(waitingList.size()>0) {
		 //take the passenger from WL and add them to RAC , increase the free space in waiting list and 
         //increase available WL and decrease available RAC by 1
		 
		 Passenger passengerFromWaitingList=passengers.get(waitingList.poll());
		 int positionWL=passengerFromWaitingList.number;
		 waitingListPositions.add(positionWL);
		 waitingList.remove(Integer.valueOf(passengerFromWaitingList.passengerid));
		 
		 
		 passengerFromWaitingList.number=racPositions.get(0);
		 passengerFromWaitingList.alloted="RAC";
		 racPositions.remove(0);
		 racList.add(passengerFromWaitingList.passengerid);
		 availableWaitingList++;
		 availableRacTickets--;
		  }
	 // now we have a passenger from RAc to whom we can book a ticket, 
     //so book the cancelled ticket to the RAC passenger
     Main.bookTicket(passengerFromRAC);
	 
	 }
	 }
   //print all available seats




	public void printAvailable() {
		// TODO Auto-generated method stub
		System.out.println("available Lower Berths"+ availableLowerBerths);
		System.out.println("available Middle Berths"+ availableMiddleBerths);
		System.out.println("available Upper Berths"+availableUpperBerths);
		System.out.println("available RAC Berths"+availableRacTickets);
		System.out.println("available waiting list"+availableWaitingList);
		System.out.println("---------------------");
	}



	//print all occupied passengers from all types including WL
	public void printPassengers() {
		// TODO Auto-generated method stub
		if(passengers.size()==0) {
			System.out.println("unknown passengers");
			return;
		}
			for(Passenger p:passengers.values()) {
				System.out.println("passengerId"+p.passengerid);
				System.out.println("age"+p.age);
				System.out.println("name"+p.name);
				System.out.println("status"+p.number+p.alloted);
				System.out.println("------------");
				
			
		}
		
	}

	  
	
	
	
	
	

}
