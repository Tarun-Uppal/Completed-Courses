public class Main {
    public static void main(String[] args) {

        System.out.println(sumOdd(1,11));

    }
    public static boolean isOdd(int number) {
        if (number < 0) {
            return false;
        }
        if (number % 2== 0) {
            return false;
        }
        else{
            return true;
        }
    }

    public static int sumOdd(int start, int end) {
        if ((start<=end) && (start>0) && (end>0)) {
            int total=0;
            for (int i;start<end ; start++) {
                if(isOdd(start)==true) {
                    total=start+total;
                }
                }
            System.out.println(total);
            }

        return -1;
          }
}
