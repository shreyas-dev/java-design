package dev.shreyas.java.designs.gangOfFour.structural;

/*
    Adapter pattern works as a bridge between two incompatible interfaces
    This type of design pattern comes under structural pattern as this pattern
    combines the capability of two independent interfaces.

    This pattern involves a single class which is responsible to join functionality of
    independent or incompatible interfaces.

     Eg:-
     We can think of a mobile charger as an adapter because mobile battery needs 3 volts to charge
     but the normal socket produces either 120V (US) or 240V (India).
     So the mobile charger works as an adapter between mobile charging socket and the wall socket.

     Think of it as a sort of translator: when two heads of states who don’t speak a common language meet,
     usually an interpreter sits between the two and translates the conversation, thus enabling communication.

     Eg 2:-
     If you have two applications, with one spitting out output as XML with the other requiring JSON input,
     then you’ll need an adapter between the two to make them work seamlessly.
 */
public class AdapterDesignPatternDemo {

    // Voltage Class
   static class Volt {
        private int volts;
        public Volt(int v){
            this.volts=v;
        }
        public int getVolts() {
            return volts;
        }
        public void setVolts(int volts) {
            this.volts = volts;
        }
   }

   // US- Based Socket which gives 120 Unit of Volts
    static class Socket {
        static  Volt getVolt(){
            return new Volt(120);
        }
    }

    // Writing a SocketAdapter Interface to perform a compatibility
    public interface SocketAdapter {
       Volt get120Volt();
       Volt get12Volt();
       Volt get3Volt();
    }

    //Using inheritance for adapter pattern
    static class SocketAdapterImpl extends Socket implements SocketAdapter{
        @Override
        public Volt get120Volt() {
            return getVolt();
        }
        @Override
        public Volt get12Volt() {
            Volt v= getVolt();
            return convertVolt(v,10);
        }
        @Override
        public Volt get3Volt() {
            Volt v= getVolt();
            return convertVolt(v,40);
        }
        private Volt convertVolt(Volt v, int i) {
            return new Volt(v.getVolts()/i);
        }
    }

    public static void main(String[] args) {
        testClassAdapter();
    }
    private static void testClassAdapter() {
        SocketAdapter sockAdapter = new SocketAdapterImpl();
        // Get 3 units of Volt
        Volt v3 = getVolt(sockAdapter,3);
        Volt v12 = getVolt(sockAdapter,12);
        Volt v120 = getVolt(sockAdapter,120);
        System.out.println("v3 volts using Class Adapter="+v3.getVolts());
        System.out.println("v12 volts using Class Adapter="+v12.getVolts());
        System.out.println("v120 volts using Class Adapter="+v120.getVolts());
    }
    private static Volt getVolt(SocketAdapter sockAdapter, int i) {
        switch (i){
            case 3: return sockAdapter.get3Volt();
            case 12: return sockAdapter.get12Volt();
            default: return sockAdapter.get120Volt();
        }
    }
}
