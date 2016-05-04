package random;

/**
 * Created by pjain11 on 2/6/16.
 */
public class Power {
        public static double pow(double x, int n) {
            System.out.println("x = "+x+ " n = "+n);
            if(n == 0)
                return 1;
            if(n == 1)
                return x;
            if(n<0){
                n = -n;
                x = 1/x;
            }
            return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
        }

    public static void main(String[] args) {
        System.out.println(pow(4, 4));
    }

}
