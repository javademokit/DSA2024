package FinalClass;

class Outer1 {
    class Inner {
        void show() {
            System.out.println("Inside Inner class");
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        Outer1.Inner inner = outer.new Inner();  // Creating instance of Inner class
        inner.show();
    }
}
