package zoho;

public class GeeksForGeeks_x_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<26;i++) {
			int n=65;
		for(int j=0;j<26;j++) {
			if(i==j) {
				System.out.print((char)(n+i));
			}
			else if(j==n-1-i) {
				System.out.print((char)(n+j));
				
			}
			else {
		System.out.print(" ");
		}
	}
		System.out.println();

	}

	}

}
