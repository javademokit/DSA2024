package Array;

public class ArrayDublicate {
	public static int removeDuplicateElements(int arr[], int n){  
        if (n==0 || n==1){  
            return n;  
        }    
        int j = 0;//for next element  
        for (int i=0; i < n-1; i++){  
            if (arr[i] != arr[i+1]){  
                arr[j++] = arr[i];  
            }  
        }  
        arr[j++] = arr[n-1];  
        return j;  
    }  
       
	public void removeDbulicateUnsorted()
	{
		
		int []arr= {1,2,4,2,5,6,5,6};
		int index =0;
		for(int i=0;i<arr.length-1;i++)
		{
			
			boolean isDuplicate = false;
			
			for(int k=0;k<index;k++)
			{
				if(arr[i]==arr[k])
				{
					isDuplicate=true;
					break;
				}
				
			}
			
			if(!isDuplicate)
			{
				arr[index]=arr[i];
				index++;
			}

		}
		
		int[] result = new int[index];
        // Copy unique elements from original array to result array
        for (int i = 0; i < index; i++) {
            result[i] = arr[i];
        }
		
	}
	
    public static void main (String[] args) {  
        int arr[] = {10,20,20,30,30,40,50,50};  
        int length = arr.length;  
        length = removeDuplicateElements(arr, length);  
        //printing array elements  
        for (int i=0; i<length; i++)  
           System.out.print(arr[i]+" ");  
    }  
	}


