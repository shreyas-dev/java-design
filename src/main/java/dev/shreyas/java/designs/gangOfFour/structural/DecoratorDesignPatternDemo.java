package dev.shreyas.java.designs.gangOfFour.structural;

/*
    Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
    This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.

    This pattern creates a decorator class which wraps the original class and provides additional functionality
    keeping class methods signature intact.
 */
public class DecoratorDesignPatternDemo {
    interface Color {
        void paint();
    }

    static class Red implements Color {
        @Override
        public void paint() {
            System.out.println("Color: Red");
        }
    }

    static class Green implements Color {
        @Override
        public void paint() {
            System.out.println("Color: Green");
        }
    }

    // Create a abstract class to extend more functionality
    static abstract class ColorDecorator implements Color {
        protected Color decoratedColor;
        public ColorDecorator(Color decoratedColor){
            this.decoratedColor = decoratedColor;
        }
        public void paint(){
            decoratedColor.paint();
        }
    }

    // Allow Blue to be mixed with the Color
    static class BlueColorDecorator extends ColorDecorator {
        public BlueColorDecorator(Color decoratedColor) {
            super(decoratedColor);
        }
        @Override
        public void paint() {
            decoratedColor.paint();
            paintBlue(decoratedColor);
        }
        private void paintBlue(Color decoratedColor){
            System.out.println("paint one more Color: Blue");
        }
    }

    static class RedColorDecorator extends ColorDecorator {
        public RedColorDecorator(Color decoratedColor) {
            super(decoratedColor);
        }
        @Override
        public void paint() {
            decoratedColor.paint();
            paintBlue(decoratedColor);
        }
        private void paintBlue(Color decoratedColor){
            System.out.println("paint one more Color: Blue");
        }
    }

    public static void main(String[] args) {
            Color Green = new Green();
            Color blueGreen = new RedColorDecorator(new Green());
            Color blueRed = new RedColorDecorator(new Red());
            System.out.println("Simple Green");
            Green.paint();
            System.out.println("\nGreen with Blue mixer");
            blueGreen.paint();
            System.out.println("\nRed with blue mixer");
            blueRed.paint();
    }
}
