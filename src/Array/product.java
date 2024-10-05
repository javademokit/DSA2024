package Array;

import java.util.HashMap;
import java.util.Stack;

public class product {
	

	static public void tripplesumbufff()
	{
		
		int [] arr = {1,-2,3,4,-5}; 
		
		for(int i=0;i<arr.length-2;i++)
		{
			
			for(int j=i+1;j<arr.length-1;j++)
			{
				
				
				for(int k=j+1;k<arr.length;k++)
				{
					
					if(arr[i]+arr[j]+arr[k]==5)
					{
						System.out.println(arr[i]+","+arr[j]+","+arr[k]);
						
					}
					
					
				}
			}
			
		}
			
		
	}
	
	static public void twoforloop(int sum )
	{
		int [] arr = {1,2,3,4,5}; 
		
		for(int i=0;i<arr.length-2;i++)
		{
			int left =i+1;
			int right =arr.length-1;
			while(left<right)
			{
				int intsum =arr[i]+arr[left]+arr[right];
				if(intsum==sum)
				{
					
			System.out.println(arr[i]+","+arr[left]+","+arr[right]);
			return;
				}
				else if(intsum<sum)
				{
					left++;
					
				}
				else
				{
					
					right--;
				}
				
				
			}
		}
		
	}
	
	
	static public void maxplatno()
	{
		
		
		int [] arr = {1,2,3,4,5}; 
		int [] dep = {1,2,3,4,5}; 
		
		int result =1;
		int palno=1;
		
		for(int i=0;i<arr.length;i++)
		{
			palno =1;
			for(int j=0;j<arr.length;j++)
			{
				if(i!=j)
					if(arr[i]>=arr[j]&& dep[j]>=arr[i])
								
						palno++;
				
			}
			
			result =Math.max(palno, result);
			
		}

		System.out.println("platformno----"+ result);
		
	}
	public static  void ConvertIntToroamn(int num)
	{
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
		String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
		StringBuilder roman = new StringBuilder();  
		
		
		for(int i=0;i<values.length;i++)   
		{  
		while(num >= values[i])   
		{  
		num = num - values[i];  
		roman.append(romanLetters[i]);  
		}  
		}  
		System.out.println("Corresponding Roman Numerals is: " + roman.toString());  
		}  
		
	
	public static  void findmaxwatercapcity() {
		
		int arr[]= {1,-2,4,-5,6,7};
		
		int result=0;
		
		for(int i=1;i<arr.length-1;i++)
		{
			
			int left =arr[i];
			
			for(int j=0;j<i;j++)
			{
				
				left=Math.max(left, arr[j]);

				
			}
			int right =arr[i];
			
			for(int k=i+1;k<arr.length;k++)
			{
				right =Math.max(right, arr[k]);
			}
			
			result+=Math.min(left, right)-arr[i];
		}
		System.out.println("Result of water "+result);
		
	}
	
	public static  void  getTwo(int target)
	{
		
		int [] numbers = {2, 7, 10, 10,1,2,4,6}; // 4 5 1 2 3  3 45123
		int[] ret = new int[2];
		for (int i = 0; i < numbers.length; i++) {
		for (int j = i + 1; j < numbers.length; j++) {
		if (numbers[i] + numbers[j] == target) {
		ret[0] = i ;
		ret[1] = j ;
		}
		}
		}
		System.out.println(ret[0]+"--"+ret[1]);
		
	}
	
	public void reverarray()
	{
		
		int [] arr = {2, 7, 11, 15}; // 4 5 1 2 3  3 45123
		   int start =0;
		   int end =arr.length-1;
		   while(start< end)
		   {
			   int temp=arr[start];
			   arr[start]=arr[end];
			   arr[end]=temp;
			   end--;
			   start++;   
			   
		   }
		  
	for(int i=0;i<arr.length;i++)
	{
		System.out.println(arr[i]);
	}
	}
	
  static  public boolean isvalidate(String str)
   {
	   HashMap<Character, Character> map = new HashMap<Character, Character>();
	   map.put('[', ']');
	   map.put('{', '}');
	   map.put('(', ')');

	   Stack<Character>stack = new Stack<Character>();
	   
	   for (Character c : str.toCharArray()) {
		   if (map.keySet().contains(c)) {
		   stack.push(c);
		   } else if (map.values().contains(c)) 
		   {
		   if (!stack.isEmpty() && map.get(stack.peek()) == c)
		   {
		   stack.pop();
		   }
		   else 
		   {
		   return false;
		   }
		   }
		   }
		   return stack.isEmpty();

	   
   }
	   
  
  public static boolean isBalanced(String input) {
      Stack<Character> stack = new Stack<>();
      for (char ch : input.toCharArray()) {
          switch (ch) {
              case '(':
              case '{':
              case '[':
                  // Push opening brackets onto the stack
                  stack.push(ch);
                  break;
              case ')':
                  // Check if the stack is empty or the top of the stack is not the matching opening bracket
                  if (stack.isEmpty() || stack.peek() != '(') {
                      return false;
                  }
                  stack.pop();
                  break;
              case '}':
                  if (stack.isEmpty() || stack.peek() != '{') {
                      return false;
                  }
                  stack.pop();
                  break;
              case ']':
                  if (stack.isEmpty() || stack.peek() != '[') {
                      return false;
                  }
                  stack.pop();
                  break;
              default:
                  // Ignore non-bracket characters
                  break;
          }
      }

      // If the stack is empty, all brackets are balanced
      return stack.isEmpty();
      
  }
  
  
  public static  int climbStairs(int n) {
      if(n<=2) return n;
      int[] dp = new int[n];
      dp[0] = 1;
      dp[1] = 2;
      for(int i=2;i<n;i++){
          dp[i] = dp[i-1]+dp[i-2];
      }
      return dp[n-1];
  }
	public static void main(String[] args) {
		

		tripplesumbufff();
		twoforloop(6);
		maxplatno();
		ConvertIntToroamn(7);
		findmaxwatercapcity();
		getTwo(10);
		System.out.println(isvalidate("{12}[wee"));
	
		System.out.println(climbStairs(5)); // 1 1 1 1 1  ->1  1 1 2 1 -> 2   2 2 1> 3 1 2 2->4   
    
		
	}

}
