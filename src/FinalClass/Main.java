package FinalClass;

class Outer {
    final class Inner {
        void display() {
            System.out.println("Inside final inner class.");
        }
    }

    // Method to return an instance of Inner
    Inner getInnerInstance() {
        return new Inner();
    }
}

public class Main {
    public static void main(String[] args) {
        // First, create an instance of the outer class
        Outer outer = new Outer();

        // Then, create an instance of the final inner class
        Outer.Inner inner = outer.new Inner();

        // Call the method of the inner class
        inner.display();
    }
}
