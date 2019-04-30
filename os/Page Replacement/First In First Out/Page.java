package chegg;
import java.util.*;
public class Page {
	public static void main(String ar[])
	{
		boolean flag;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the data : ");
		String data=s.nextLine();
		System.out.println("-----------------------------------------------------------------------------");
	    char d1[]=data.toCharArray();
		System.out.print("Enter the size of Frame : ");
		int m=s.nextInt();
		System.out.println("-----------------------------------------------------------------------------");
	    int n=d1.length;
		char m1[]=new char[m];
		int j=0,i,ph=0,num=0;
		for(i=0; i<n; i++)
	        {
	            flag = true;
	            char page = d1[i];
	            for(j=0; j<m; j++)
	            {
	                if(m1[j] == page)
	                {
	                    flag = false;
	                    ph++;
	                    break;
	                }
	            }
	            if(num == m) {
	                num = 0;}
	            if(flag)
	            {
	                m1[num] = page;
	                num++;
	            }
	        }

        System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.print("frame : ");
        for(i=0; i<m; i++) {
            System.out.print(m1[i]+" ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
	    System.out.println("No. of page hit : "+ph);
	    System.out.println("-----------------------------------------------------------------------------");
	    System.out.println("No. of page fault : "+(n-ph));
    s.close();
	}

}
