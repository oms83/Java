public class ReverseAString {
    private static String _ReverseAString(String str)
    {
        StringBuilder reversed = new StringBuilder();

        for (int i=str.length()-1; i>=0; i--)
        {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }
    public static void main(String[] args) {
        System.out.println(_ReverseAString("Hello World"));
    }
}
