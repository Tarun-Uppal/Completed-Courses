public class barkingdog {
    public static void main(String[] args) {
        shouldWakeUp(8 );
    }

    public static boolean shouldWakeUp(int hourOfDay) {
        boolean barking;
        if (hourOfDay < 0 && hourOfDay > 23) {
            return true;
        } else {
            return false;
        }

    }
}

