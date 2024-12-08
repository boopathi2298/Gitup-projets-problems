package zoho;
import java.util.Scanner;


public class Password_creation {
	private static int countCharacter(String password) {
		// TODO Auto-generated method stub
		 int count=0;
		 int upperCase=0,lowerCase=0,digitValue=0,continuesCharacter=0;
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)>='A' && password.charAt(i)<='Z') {
				upperCase++;
	         }
			if(password.charAt(i)<='a'&& password.charAt(i)>='z') {
				lowerCase++;
			}
			if(password.charAt(i)<='0'&& password.charAt(i)>='9') {
				lowerCase++;
			}
				if (i < password.length() - 2 && password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
				    continuesCharacter++;
				}
				if(upperCase==0) {
					count++;
					}
				if(lowerCase==0) {
					count++;
					}
				if(digitValue==0) {
					count++;
				}
				if(continuesCharacter==0) {
					count++;
				}
				if(count+password.length()>6) {
					 count = count + 6 - (count + password.length());
				}
				if ((count + password.length()) > 20) {
				    count = count - 20 + (count + password.length());
				}
			}
		
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the password");
		String password=sc.nextLine();
		int count=countCharacter(password);
		System.out.println(count);
		
		

	}

	

}
