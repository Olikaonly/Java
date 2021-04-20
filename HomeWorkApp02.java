package lesson02.online;

public class HomeWorkApp02 {
    public static void main(String[] args) {

        System.out.println(summa10and20(7, 1));
        System.out.println(numberPositive(-9));
        System.out.println(numberNegative(-30));
        numberText("Hello", 3);
        System.out.println(leapYear(1932));
    }
    public static boolean summa10and20(int x1, int x2) {

        return (x1 + x2 >= 10 && x1 + x2 <= 20);
    }
    public static String numberPositive(int a) {

        if (a >= 0) {
        return "Число положительное";
        }   else {
        return "Число отрицательное";
    }
}
    public static boolean numberNegative(int b) {

        return (b < 0);
    }
    public static void numberText(String x3, int x4) {

        for (int i = 0; i < x4; i++) {
            System.out.println(x3);
        }
    }
    public static boolean leapYear(int c) {

        return (c % 4 == 0 && c % 100 !=0 || c % 400 == 0);
    }
}

