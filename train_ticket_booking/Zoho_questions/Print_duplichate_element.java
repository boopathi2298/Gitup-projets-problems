package zoho;

public class Print_duplichate_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4,5,4,3,2};
		int count=0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]==a[j]) {
					count++;
					System.out.println(a[i]);
				}
			}
		}
System.out.println(count);
	}

}
