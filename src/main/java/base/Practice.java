package base;

import java.sql.Date;

public class Practice {  
	
public long str(int a){  
long res=a*1234;
return res;
}  
public static void main(String args[]){  
	
	Practice p=new Practice();
	for(int i=1;i<1000000;i++)
	{
	System.out.println(p.str(i));
	System.out.println(Thread.currentThread().getId());
	}

 }  
}  