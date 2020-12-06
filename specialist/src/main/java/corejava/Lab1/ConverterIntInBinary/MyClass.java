package corejava.Lab1.ConverterIntInBinary;

public class MyClass {

    static String getBinary(int num) {

        StringBuilder sb = new StringBuilder();

        for (int index = 0; index <= 31; index++) {

            sb.append(num & 1);
            num >>= 1;

            if (index == 7 || index == 15 || index == 23) {
                sb.append(' ');
            }
        }

        sb.reverse();

        return sb.toString();

    }

    public static void main(String[] args) {

        int[] arr = {10, 2, 7};

        for (int element :
                arr) {
            System.out.printf("Number = %d; Binary = %s\n", element, getBinary(element));
        }

    }

}
