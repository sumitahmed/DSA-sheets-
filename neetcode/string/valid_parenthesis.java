import java.util.Scanner;

public class valid_parenthesis {

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (top == -1) {
                    return false;
                }

                char last = stack[top--];

                if ((ch == ')' && last != '(')
                        || (ch == '}' && last != '{')
                        || (ch == ']' && last != '[')) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return top == -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(isValid(input));
        scanner.close();
    }
}