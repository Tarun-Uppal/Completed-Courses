public class decimalcomparetor {
    public static int areEqualByThreeDecimalPlaces(double first, double second, double third){


        boolean result1 = compareDecimal(first, second);
        boolean result2 = compareDecimal(first,third);

        System.out.println("Compare x, y = " + result1);
        System.out.println("Compare x, z = " + result2);
    }

    public static boolean compareDecimal(double a, double b) {
        return (int) (a*1000) == (int) (b * 1000);

    }
