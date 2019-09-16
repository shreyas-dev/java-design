package dev.shreyas.java.designs.gangOfFour.creational;

/*
    Let's think of an application which is agnostic of underlying OS,
    We can make you FactoryDesignPattern to make it agnostic.
 */
public class OSFactoryDesignPattern {
    // A simple OS greet behaviour
    public interface OS {
        void greet();
    }

    public enum OsType {
        WINDOWS,
        ANDROID,
        MAC
    }

    // Android OS impl
    public static class Android implements OS{
        @Override
        public void greet() {
            System.out.println(OsType.ANDROID+" says HI!!");
        }
    }

    // Windows OS impl
    public static class Windows implements OS{
        @Override
        public void greet() {
            System.out.println(OsType.WINDOWS+" says HI!!");
        }
    }

    //Mac OS impl
    public static class Mac implements OS{
        @Override
        public void greet() {
            System.out.println(OsType.MAC +" says HI!!");
        }
    }

    // OS Factory which is responsible for creating OS depending upon OsType passed
    public static class OSFactory{

        static OS getInstance(OsType osType){
            switch (osType){
                case WINDOWS: return new Windows();
                case ANDROID: return new Android();
                default:return new Mac(); // By Default Mac, cause I like it :).
            }
        }
    }



    public static void main(String[] args) {
        OS androidOS = OSFactory.getInstance(OsType.ANDROID);
        OS macOS = OSFactory.getInstance(OsType.MAC);
        OS windowsOS = OSFactory.getInstance(OsType.WINDOWS);

        androidOS.greet();
        macOS.greet();
        windowsOS.greet();
    }



}
