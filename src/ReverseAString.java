public class ReverseAString {
    private static String _ReverseAString(String source)
    {
        StringBuilder reversed = new StringBuilder();

        for (int i=source.length()-1; i>=0; i--)
        {
            reversed.append(source.charAt(i));
        }

        return reversed.toString();
    }
    public static void main(String[] args) {
        System.out.println(_ReverseAString("Hello World"));
    }
}
