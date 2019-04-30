package chegg;
import java.util.Scanner;
class RoundRobin
{
public static void main(String args[])
{
int i,j,k,tq,flag=0,avg=0;
Scanner s=new Scanner(System.in);
System.out.print("Enter the total no. of processes : ");
int n=s.nextInt();
int p[]=new int[n];
int tat[]=new int[n];
int bt[]=new int[n];
int bt1[]=new int[n];
int at[]=new int[n];
int wt[]=new int[n];
int et[]=new int[n];
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
	bt1[i]=bt[i];
}
for(i=0;i<n;i++)
{
	p[i]=i;
}
for(i=1;i<n;i++) 
{ 
	int key0 = p[i];  
	int key1 = at[i]; 
	int key2 = bt[i];
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
System.out.println("-----------------------------------------------------------------------------");
System.out.println("Enter Time Quantum:");
tq=s.nextInt();
System.out.println("-----------------------------------------------------------------------------");
for(j=0;j<n;j++)
{
	while(bt[j]>0) {
		for(i=0;i<n;i++)
		{
			if(bt[i]>0)
			{
				if(bt[i]<tq)
				{
					k=tq-bt[i];
					bt[i]=bt[i]-k;
					flag=flag+k;
				}
				else 
				{
					bt[i]=bt[i]-tq;
					flag=flag+tq;
				}
				et[i]=flag;
			}	
		}
		
	}
}

for(i=0;i<n;i++)
{
	tat[i]=et[i]-at[i];
}
for(i=0;i<n;i++)
{
	wt[i]=tat[i]-bt1[i];
}


System.out.println();
System.out.println("-----------------------------------------------------------------------------");
System.out.printf("%7s | %10s | %10s | %10s | %4s | %11s |", "Process", "Arrival Time","Burst Time","Exit Time","TAT", "Waiting Time");
System.out.println();
System.out.println("-----------------------------------------------------------------------------");
for(i=0;i<n;i++){
    System.out.format("%7d | %12s | %10d | %10d | %4s | %12s |",p[i],at[i],bt1[i],et[i],tat[i],wt[i]);
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