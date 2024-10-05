package Array;

import java.util.Collections;

public class AB {
public static void main(String[] args) {
	
	
	System.out.println("Tomcat"+20+40);

	System.out.println(40+20+"Tomcat");
	int[] list = {1,3,2,7,5,1};  //    taget  3    4 

	   int left =0;
	  int right =list.length-1;
	  
	  for(int i=0;i<list.length;i++) // 0  1  print sum of index = no index 
	  {
		  
		 for(int j=i+1;j<list.length;j++)   // n2 // const 
		 {
			 
			 if(list[i]+list[j]==(i+j))
			 {
				 System.out.println((i+j));
				 System.out.println(list[i]+list[j]);
				 System.out.println("Index"+i+","+"index"+j);
			 }
			 
			 
		 }
		  
	  }
	   
	   
	   
	
	
	
	
	
	
	
		 
	
	
}
}
