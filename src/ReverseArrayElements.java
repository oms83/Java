public class ReverseArrayElements {
    private static void _PrintArray(int []arr)
    {
        for(int i=0; i<arr.length; System.out.print(arr[i++]+" "));
    }
    private static int[] _ReverseArray(int []arr)
    {
        int []newArr = new int[arr.length];

        int index=0;

        for (int i=arr.length-1; i>=0; newArr[index] = arr[i], index++, i--);

        return newArr;
    }

    public static void main(String[] args) {
        int []arr = {1,223,32,12,32,43,54,43,43,23};
        _PrintArray(arr);
        System.out.println();
        _PrintArray(_ReverseArray(arr));
    }
}
