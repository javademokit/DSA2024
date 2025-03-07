package FinalLocaInnerClassInsideaMethod;

class Outer {
    void display() {
        final class Inner {
            void show() {
                System.out.println("Inside final local Inner class");
            }
        }
        Inner inner = new Inner();
        inner.show();
    }
}

public class Main {
    public static void main(String[] args) {
        new Outer().display();
    }
}
