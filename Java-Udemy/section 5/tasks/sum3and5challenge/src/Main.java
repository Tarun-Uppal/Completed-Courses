public class Main {
    public static void main(String[] args) {
        int total= 0;
        int total2 =0;
        for (int i=1;i<=1000;i++){
            if((i%3==0)&&(i%5==0)){
                total++;
                total2 = total2+i;
                System.out.println("Found number=" + i);
                if(total<5){
                    total2 +=i;
                }
                else {
                    break;
                }

        }
        }
        System.out.println(total);
        System.out.println(total2 );
    }
}
