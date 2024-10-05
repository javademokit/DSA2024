package Array;

public class SecondHightestArrayElement {
  public static void main(String[] args) {
  int [] arr={1,2,3,7,9,6};
   int max=arr[0];
   int secondmax=arr[0];
    for(int i=0;i<arr.length;i++)
    {
     if(arr[i]>max)
     {
       secondmax=max;
       max=arr[i];

     }
     else if (arr[i] > secondmax && arr[i] != max)
     {
       secondmax=arr[i];
     }

    }

    System.out.println(secondmax);





  }

}
