package zoho;
import java.util.*;


public class Maximum_subSet_of_sum {
	private static int maxsum(int[] a, int k, int n) {
	// TODO Auto-generated method stub
		if(k>n) {
			System.out.println("invalid");
			return -1;
		}
		int res=0;
		for(int i=0;i<k;i++) 
			res+=a[i];
			
			int curr_sum = res;
	           for (int i=k; i<n; i++){
	               curr_sum += a[i] - a[i-k];
	               res = Math.max(res, curr_sum);
	}
		
	return res;
}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int b=sc.nextInt();
		int a[]=new int[b];
		for(int i=0;i<a.length;i++) {
			a[i]=sc.nextInt();
		}
		
		// TODO Auto-generated method stub
		//int a[]= {1,3,2,4,5,6,7};
		int k=2;
		int n=a.length;
		System.out.println(maxsum(a,k,n));

	}

	

}
