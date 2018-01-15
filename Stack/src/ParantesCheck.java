public class ParantesCheck {

    public static boolean checkParanteses(String s) {
        ArrayStack stack = new ArrayStack();

        for (Character c : s.toCharArray()) {
            if (c == (Character) '{' || c == (Character) '[' || c == (Character) '(') {
                stack.push(c);
            }
            else if (c == (Character) ')' && stack.peek() == (Character) '(') {
                stack.pop();
            }
            else if (c == (Character) ']' && stack.peek() == (Character) '[') {
                stack.pop();
            }
            else if (c == (Character) '}' && stack.peek() == (Character) '{') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkParanteses("(3+{5{99{*}}[23[{67}67]]})"));
        System.out.println(checkParanteses("(}){"));
    }
}
