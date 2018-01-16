public class StringTurnAround {

    private static String streng = "";

    public static String VendStrengOm(String input) {
        return VendStrengOm(input, input.length()-1);
    }

    private static String VendStrengOm(String input, int index) {
        char[] temp = input.toCharArray();
        if (index == 0) {
            streng += temp[index];
            return streng;
        }
        else {
            streng += temp[index];
            return VendStrengOm(input, index-1);
        }
    }
}