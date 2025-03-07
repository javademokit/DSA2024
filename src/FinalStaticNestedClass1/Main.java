package FinalStaticNestedClass1;

class Outer {
    static final class Inner {
        void show() {
            System.out.println("Inside static final Inner class");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner(); // No outer instance needed
        inner.show();
    }
}
