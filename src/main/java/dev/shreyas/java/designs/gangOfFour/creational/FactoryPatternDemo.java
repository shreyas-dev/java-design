package dev.shreyas.java.designs.gangOfFour.creational;


// In Factory pattern, we create an object with hiding the original complexities
// or creational logic to client and share a common interface.
public class FactoryPatternDemo {
    interface Color {
        void paint();
    }

    static class Red implements Color {
        @Override
        public void paint() {
            System.out.println("Inside Red::paint() method.");
        }
    }

    static class Yellow implements Color {
        @Override
        public void paint() {
            System.out.println("Inside Yellow::paint() method.");
        }
    }
    static class Green implements Color {
        @Override
        public void paint() {
            System.out.println("Inside Green::paint() method.");
        }
    }
    enum ColorType {
        RED,GREEN,YELLOW
    }
    private static class ColorFactory {
        //use getColor method to get object of type Color
        // here we return an interface of Color agnostic of class implementation
        private Color getColor(ColorType colorType){
            if(colorType == null){
                return null;
            }
            if(colorType.equals(ColorType.YELLOW)){
                return new Yellow();
            } else if(colorType.equals(ColorType.RED)){
                return new Red();
            } else if(colorType.equals(ColorType.GREEN)){
                return new Green();
            }
            return null;
        }
    }
    public static void main(String[] args) {
            ColorFactory ColorFactory = new ColorFactory();
            //get an object of Yellow and call its paint method.
            Color color1 = ColorFactory.getColor(ColorType.YELLOW);
            //call paint method of Yellow
            color1.paint();
            //get an object of Red and call its paint method.
            Color color2 = ColorFactory.getColor(ColorType.RED);
            //call paint method of Red
            color2.paint();
            //get an object of Green and call its paint method.
            Color color3 = ColorFactory.getColor(ColorType.GREEN);
            //call paint method of Yellow
            color3.paint();
    }
}
