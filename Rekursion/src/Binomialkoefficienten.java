public class Binomialkoefficienten {

    public static int binomial(int m, int n) {
        if (m == 0 || m == n) {
            return 1;
        }
        else if (0 > m || m > n) {
            return 0;
        }
        else {
            return binomial(m,n-1) + binomial(m-1, n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(binomial(5, 7));
        System.out.println(binomial(7, 5));
    }
}
