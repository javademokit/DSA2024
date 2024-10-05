package MeetingroomAndParkingSpace;

public class colormatch {


    // Function to sort the array
    // arr: array to be sorted
    // n: size of the array
    static void sortColors(int arr[], int n)
    {
      // Initialize counts of 0, 1 and 2
      // as 0
      int count0 = 0, count1 = 0, count2 = 0;

      // Traverse all array elements and
      // count number of 0's, 1's and 2's
      for (int i = 0; i < n; i++) {
        if (arr[i] == 0)
          count0++;
        if (arr[i] == 1)
          count1++;
        if (arr[i] == 2)
          count2++;
      }

      // Now modify original array
      // To put all 0's in array
      int i = 0;
      while (count0 > 0) {
        arr[i++] = 0;
        count0--;
      }

      // To put all 1's in array
      while (count1 > 0) {
        arr[i++] = 1;
        count1--;
      }

      // To put all 2's in array
      while (count2 > 0) {
        arr[i++] = 2;
        count2--;
      }
    }

    // Driver Code
    public static void main(String args[])
    {
      int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
      int n = arr.length;

      sortColors(arr, n);
      System.out.println("Array after seggregation ");
      for (int i = 0; i < n; i++)
        System.out.print(arr[i] + " ");
    }
  }

