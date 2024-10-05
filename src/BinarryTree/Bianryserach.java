package BinarryTree;

public class Bianryserach {
	
	public  static int  binarysearch(int[]a ,int x) {

	 int low=0;
	 int high=a.length-1;
	 while(low<=high)
	 {
		 
		 int mid = low+(high-low)/2;
		 if(a[mid]==x)
			return mid;
		
		  if (a[mid]<x) 
			 low= mid+1;
		  else
		  {
			  high = mid-1;
		  }
	 }
		
		return -1;
	}
	
	public static  int recurBinarysearch(int [] a , int low, int high, int y)
	{
		
	   if(low <=high)
	   {
		   int mid =low+(high-low)/2;
		   
		   if(a[mid]==y)
			   return mid;
		   
		   if(a[mid]<y)
             return recurBinarysearch(a,mid+1, high,y);
		   else
		   {
			   return recurBinarysearch(a,low,mid-1,y);
		   }
	   }
		
		
		return -1;
	}

	public static void main(String[] args) {
		
		int a[] = {1,2,3,4,5,6,7};
		System.out.println(binarysearch(a,4));
		System.out.println(recurBinarysearch( a , 0, a.length-1,  4));

		
	}
	
}
