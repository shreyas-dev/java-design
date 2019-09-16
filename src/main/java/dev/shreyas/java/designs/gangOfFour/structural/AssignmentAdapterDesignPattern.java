package dev.shreyas.java.designs.gangOfFour.structural;

public class AssignmentAdapterDesignPattern {
    // Adapter pattern connects two incompatible interfaces  or classes
    // Let's take example of Assignment which you are given and you have a
    // book but don't have a Pen to write on it.
    interface Pen{
        void write(String str);
    }

    // A pilot pen which has a method mark instead of a write.
    public static class PilotPen{
        public void mark(String str){
            System.out.println(str);
        }
    }

    // To make Pen and PilotPen compatible we make use of PenAdapter

    public static class PenAdapter implements Pen {
        PilotPen pen;

        public PenAdapter() {
            this.pen = new PilotPen();
        }
        // Pen.write is called mark is called internally
        @Override
        public void write(String str) {
            this.pen.mark(str);
        }
    }

    public static void main(String[] args) {
        Pen pen = new PenAdapter();
        pen.write("Assignment completed");
    }
}
