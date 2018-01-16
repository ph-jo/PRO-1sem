public class Array {

    private static int max = 0;
    private static int sum = 0;

    public static int StørsteElement(int[] list) {
        return StørsteElement(list, 0);
    }

    private static int StørsteElement(int[] list, int index) {
        if (index == list.length-1) {
            if (max < list[index]) {
                max = list[index];
            }
            return max;
        }
        else {
            if (max < list[index]) {
                max = list[index];
            }
            return StørsteElement(list, index+1);
        }
    }

    public static int Sum(int[] list) {
        return Sum(list, 0);
    }

    private static int Sum(int[] list, int index) {
        if (index == list.length-1) {
            sum = sum + list[index];
            return sum;
        }
        else {
            sum = sum + list[index];
            return Sum(list,index+1);
        }
    }
}