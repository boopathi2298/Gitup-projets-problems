package oops;
import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double num1,num2,result=0;
		System.out.println("Enter the first number");
		num1=sc.nextDouble();
		System.out.println("Enter the second number");
		num2=sc.nextDouble();
		System.out.println("1.Addition");
		System.out.println("2.Subtraction");
		System.out.println("3.Multiplication");
		System.out.println("4.Division");
		System.out.println("5.Modulus");
		System.out.println("Enter the operation (1-4)");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			result=num1+num2;
			System.out.println("Result od addition:"+result);
			break;
		case 2:
			result=num1-num2;
			System.out.println("Result od Subtraction:"+result);
			break;
		case 3:
			result=num1*num2;
			System.out.println("Result of Multiplication:"+result);
			break;
		case 4:
			result=num1/num2;
			System.out.println("Result of Division:"+result);
			break;
		default:
			System.out.println("invalid caption");
			
			
		}
		sc.close();
		
		
		  

	}

}
