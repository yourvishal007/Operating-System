package chegg;
import java.util.*;
public class Fcfs{
	public static void main(String ar[])
	{
		int i;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the total no. of processes : ");
		int n=s.nextInt();
		int bt[]=new int[n];
		int wt[]=new int[n];
		System.out.println("-----------------------------------------------------------------------------");
		for(i=0;i<n;i++)
		{
			System.out.print("Enter burst time for process p"+i+" : ");
			bt[i]=s.nextInt();
		}
		wt[0]=0;
		for(i=1;i<n;i++)
		{
			wt[i]=(wt[i-1]+bt[i-1]);
		}
		 System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%10s | %10s | %10s | %10s |", "Process", "Arrival time", "Burst Time", "Waiting Time");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
	    for(i=0;i<n;i++){
	        System.out.format("%10d | %12s | %10d | %12d |",i,"0",bt[i],wt[i]);
	        System.out.println();
	    }
	    System.out.println("-----------------------------------------------------------------------------");
	    System.out.println();
	    int avg=0;
	    for(i=0;i<n;i++)
	    {
	    	avg+=wt[i];
	    }
	    System.out.println("Average Waiting time = "+avg/n);
	    s.close();
	}
}
