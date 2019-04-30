package chegg;
import java.util.*;
public class Sjfs {
		public static void main(String d[])
		{
			int i,j,key0,key1,key2,avg=0;
			Scanner s=new Scanner(System.in);
			System.out.print("Enter the total no. of processes : ");
			int n=s.nextInt();
			int p[]=new int[n];
			int at[]=new int[n];
			int bt[]=new int[n];
			int wt[]=new int[n];
			System.out.println("-----------------------------------------------------------------------------");
			for(i=0;i<n;i++)
			{
				System.out.print("Enter Arrival time for process p"+i+" : ");
				at[i]=s.nextInt();
			}
			System.out.println("-----------------------------------------------------------------------------");
			for(i=0;i<n;i++)
			{
				System.out.print("Enter burst time for process p"+i+" : ");
				bt[i]=s.nextInt();
			}
			for(i=0;i<n;i++)
			{
				p[i]=i;
			}
			for(i=1;i<n;i++) 
		        { 
					key0 = p[i];  
					key1 = at[i]; 
					key2 = bt[i];
					j = i-1; 
		        while(j>=0 && at[j]>key1) 
		            { 
		                at[j+1] = at[j]; 
		                p[j+1] = p[j];
		                bt[j+1] = bt[j];
		                j = j-1;      
		            } 
		            p[j+1] = key0;
		        	at[j+1] = key1; 
		            bt[j+1] = key2;
		        }
			for(i=2;i<n;i++) 
		        { 
					key0 = p[i];  
					key1 = at[i]; 
					key2 = bt[i];
					j = i-1; 
		        while(j>=0 && bt[j]>key2) 
		            { 
		                at[j+1] = at[j]; 
		                p[j+1] = p[j];
		                bt[j+1] = bt[j];
		                j = j-1; 
		            } 
		            p[j+1] = key0;
		        	at[j+1] = key1; 
		            bt[j+1] = key2;
		        } 
			wt[0]=0;
			for(i=1;i<n;i++)
			{
				wt[i]=(wt[i-1]+bt[i-1])-1;
			}
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");
		    System.out.printf("%10s | %10s | %10s | %10s |", "Process", "Arrival time", "Burst Time", "Waiting Time");
		    System.out.println();
		    System.out.println("-----------------------------------------------------------------------------");
		    for(i=0;i<n;i++){
		        System.out.format("%10d | %12s | %10d | %12d |",p[i],at[i],bt[i],wt[i]);
		        System.out.println();
		    }
		    System.out.println("-----------------------------------------------------------------------------");
		    System.out.println();	
		    for(i=0;i<n;i++)
		    {
		    	avg+=wt[i];
		    }
		    System.out.println("Average Waiting time = "+avg/n);
		    s.close();
		}

}
