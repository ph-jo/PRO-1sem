public class EuclidsAlgoritme {

    public static int sfd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return sfd(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println(sfd(4,2));
    }
}