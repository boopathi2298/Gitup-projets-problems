package zoho;

public class Find_maximum_sub_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,-5,8,6};
		int sum=0;
		int max=a[0];
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			if(max<sum) {
				max=sum;
			}
		if(sum<0) {
			sum=0;
		}
		}
		
		System.out.println(max);

	}

}
