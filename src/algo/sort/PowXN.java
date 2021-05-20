package algo.sort;

public class PowXN {
    public double myPow(double x, int n) {
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double h = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return h * h;
        }
        return h * h * x;
    }

    public static void main(String[] args) {
        PowXN p = new PowXN();
        //System.out.println(Integer.MIN_VALUE);
        //System.out.println(Integer.MAX_VALUE);
        System.out.println(p.myPow(1.00000,-2147483648));
    }
}
