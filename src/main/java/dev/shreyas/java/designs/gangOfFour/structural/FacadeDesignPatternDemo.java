package dev.shreyas.java.designs.gangOfFour.structural;


/*
    Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system.
    This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities.



 */
public class FacadeDesignPatternDemo {

    interface Color {
        void paint();
    }

    static class Red implements Color {
        @Override
        public void paint() {
            System.out.println("Red::paint()");
        }
    }
    static class Yellow implements Color {
        @Override
        public void paint() {
            System.out.println("Yellow::paint()");
        }
    }

    static class Green implements Color {
        @Override
        public void paint() {
            System.out.println("Green::paint()");
        }
    }

    // Create a Facade Class which takes care of instantiation of Color Objects.
    static public class ColorMaker {
        private Color Red;
        private Color Yellow;
        private Color Green;
        public ColorMaker() {
            Red = new Red();
            Yellow = new Yellow();
            Green = new Green();
        }
        public void paintRed(){
            Red.paint();
        }
        public void paintYellow(){
            Yellow.paint();
        }
        public void paintGreen(){
            Green.paint();
        }
    }
    public static void main(String[] args) {
        ColorMaker ColorMaker = new ColorMaker();
        ColorMaker.paintRed();
        ColorMaker.paintYellow();
        ColorMaker.paintGreen();
    }
}
