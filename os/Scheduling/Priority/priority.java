package chegg;
import java.util.Scanner;
public class priority {
	public static void main(String ar[])
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the total no. of processes : ");
		int n=s.nextInt();
		int bt[]=new int[n];
		int wt[]=new int[n];
		int pr[]=new int[n];
		int at[]=new int[n];
		int p[]=new int[n];
		
		int j,avg=0,i,temp,temp1,temp2,temp3;
		System.out.println("-----------------------------------------------------------------------------");
		for(i=0;i<n;i++)
		{
			System.out.print("Enter Arrival time for process p"+i+" : ");
			at[i]=s.nextInt();
		}
		System.out.println("-----------------------------------------------------------------------------");
		for(i=0;i<n;i++)
		{
			System.out.print("Enter Priority for process p"+i+" : ");
			pr[i]=s.nextInt();
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
			temp = p[i];  
			temp1=pr[i];
			temp2 = at[i]; 
			temp3 = bt[i];
			j = i-1; 
        while(j>=0 && at[j]>temp2) 
            { 
                at[j+1] = at[j];
                pr[j+1] = pr[j];
                p[j+1] = p[j];
                bt[j+1] = bt[j];
                j = j-1;      
            } 
            p[j+1] = temp;
            pr[j+1] = temp1;
        	at[j+1] = temp2; 
            bt[j+1] = temp3;
        }
		for(i=1;i<n;i++)
		{
			temp=pr[i];
			temp1=at[i];
			temp2=bt[i];
			temp3=p[i];
			j=i-1;
			while(j>=0 && temp<pr[j])
			{
				
				pr[j+1]=pr[j];
				p[j+1]=p[j];
				bt[j+1]=bt[j];
				at[j+1]=at[j];
				j=j-1;
			}
			pr[j+1]=temp;
			at[j+1]=temp1;
			bt[j+1]=temp2;
			p[j+1]=temp3;
			
		}
		wt[0]=0;
		for(i=1;i<n;i++)
		{
			wt[i]=(wt[i-1]+bt[i-1]);
		
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%7s | %10s | %8s | %10s | %11s |", "Process", "Arrival Time","Priority","Burst Time", "Waiting Time");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
	    for(i=0;i<n;i++){
	        System.out.format("%7d | %12s | %8d | %10d | %12d |",p[i],at[i],pr[i],bt[i],wt[i]);
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
