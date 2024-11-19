import java.util.Arrays;

public class CountElementFrequency {
    private static void _PrintArray(int []arr)
    {
        for(int i=0; i<arr.length; System.out.print(arr[i++]+" "));
    }

    private static int _GetMaxValInArr(int []arr)
    {
        int max = arr[0];
        for (int i=0; i<arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

    private static int[] _GetCountElementFrequency(int []arr, int[]freq)
    {
        for (int i=0; i<arr.length; i++)
        {
            freq[arr[i]]++;
        }
        return freq;
    }

    private static void _PrintFrequentElementInArr(int []freq)
    {
        for (int i=0; i<freq.length; i++)
        {
            if (freq[i] != 0)
            {
                System.out.println( i + ": frequent " + freq[i] + " times");
            }

        }
    }

    public static void main(String[] args) {

        int []arr = {12,12,32,43,12,43,54,1,1,1,32};
        int [] frequentArr = new int[_GetMaxValInArr(arr)+1];
        Arrays.fill(frequentArr, 0);
        _PrintFrequentElementInArr(_GetCountElementFrequency(arr, frequentArr));
    }
}
