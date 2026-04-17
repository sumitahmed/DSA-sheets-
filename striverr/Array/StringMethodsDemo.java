// Wap to show the use of following methods in java

// substring()
// charAt()
// indexof()
// length()

class A {
    public static void main(String[] args) {
        String text = "java in not fully an OOP language";

        int total = text.length();
        char one = text.charAt(6);
        String first = text.substring(0, 5);
        String rest = text.substring(6);
        int where = text.indexOf("java");

        System.out.println("Original String: " + text);
        System.out.println("length(): " + total);
        System.out.println("charAt(6): " + one);
        System.out.println("substring(0, 5): " + first);
        System.out.println("substring(6): " + rest);
        System.out.println("indexOf(\"java\"): " + where);
    }
}
