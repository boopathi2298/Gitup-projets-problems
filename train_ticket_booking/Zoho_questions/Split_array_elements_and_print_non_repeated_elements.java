package zoho;

public class Split_array_elements_and_print_non_repeated_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {111,222,333};
		int n=a.length;
		int vi=-1;
		int temp[]=new int[100];
		int count=-1;
		
		for(int i=0;i<n;i++) {
			int numbers=a[i];
			while(numbers>0) {
				int rem=numbers%10;
				if(vi!=rem) {
				temp[++count]=rem;
				numbers=numbers/10;
				}
				}
			
		}
		for(int i=0;i<=count;i++) {
			for(int j=i+1;j<=count;j++) {
				if(temp[j]==temp[i]) {
					for(int k=j;k<count;k++){
						temp[k]=temp[k+1];
						}
					count--;
					j--;
				}
			}
		}
		for(int i=0;i<=count;i++) {
			System.out.println(temp[i]);
		}
		}
	}


