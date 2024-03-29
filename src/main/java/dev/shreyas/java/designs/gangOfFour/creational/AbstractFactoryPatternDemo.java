package dev.shreyas.java.designs.gangOfFour.creational;


// Considered as another layer of abstraction over factory pattern.


// AbstractFactory : Declares an interface for operations that create abstract product objects.
// ConcreteFactory : Implements the operations declared in the AbstractFactory to create concrete product objects.
public class AbstractFactoryPatternDemo {
    enum CarType
    {
        MICRO, MINI, LUXURY
    }

    static abstract class Car
    {
        Car(CarType model, Location location)
        {
            this.model = model;
            this.location = location;
        }

        abstract void construct();

        CarType model = null;
        Location location = null;

        CarType getModel()
        {
            return model;
        }

        void setModel(CarType model)
        {
            this.model = model;
        }

        Location getLocation()
        {
            return location;
        }

        void setLocation(Location location)
        {
            this.location = location;
        }

        @Override
        public String toString()
        {
            return "CarModel - "+model + " located in "+location;
        }
    }

    static class LuxuryCar extends Car
    {
        LuxuryCar(Location location)
        {
            super(CarType.LUXURY, location);
            construct();
        }
        @Override
        protected void construct()
        {
            System.out.println("Connecting to luxury car");
        }
    }

    static class MicroCar extends Car
    {
        MicroCar(Location location)
        {
            super(CarType.MICRO, location);
            construct();
        }
        @Override
        protected void construct()
        {
            System.out.println("Connecting to Micro Car ");
        }
    }

    static class MiniCar extends Car
    {
        MiniCar(Location location)
        {
            super(CarType.MINI,location );
            construct();
        }

        @Override
        void construct()
        {
            System.out.println("Connecting to Mini car");
        }
    }

    enum Location
    {
        DEFAULT, USA, INDIA
    }

    static class INDIACarFactory
    {
        static Car buildCar(CarType model)
        {
            Car car = null;
            switch (model)
            {
                case MICRO:
                    car = new MicroCar(Location.INDIA);
                    break;

                case MINI:
                    car = new MiniCar(Location.INDIA);
                    break;

                case LUXURY:
                    car = new LuxuryCar(Location.INDIA);
                    break;

                default:
                    break;

            }
            return car;
        }
    }

    static class DefaultCarFactory
    {
        public static Car buildCar(CarType model)
        {
            Car car = null;
            switch (model)
            {
                case MICRO:
                    car = new MicroCar(Location.DEFAULT);
                    break;

                case MINI:
                    car = new MiniCar(Location.DEFAULT);
                    break;

                case LUXURY:
                    car = new LuxuryCar(Location.DEFAULT);
                    break;

                default:
                    break;

            }
            return car;
        }
    }


    static class USACarFactory
    {
        public static Car buildCar(CarType model)
        {
            Car car = null;
            switch (model)
            {
                case MICRO:
                    car = new MicroCar(Location.USA);
                    break;

                case MINI:
                    car = new MiniCar(Location.USA);
                    break;

                case LUXURY:
                    car = new LuxuryCar(Location.USA);
                    break;

                default:
                    break;

            }
            return car;
        }
    }



    private static class CarFactory
    {
        private CarFactory()
        {

        }
        private static Car buildCar(CarType type)
        {
            Car car = null;
            // We can add any GPS Function here which
            // read location property somewhere from configuration
            // and use location specific car factory
            // Currently I'm just using INDIA as Location
            Location location = Location.INDIA;

            switch(location)
            {
                case USA:
                    car = USACarFactory.buildCar(type);
                    break;

                case INDIA:
                    car = INDIACarFactory.buildCar(type);
                    break;

                default:
                    car = DefaultCarFactory.buildCar(type);

            }

            return car;

        }
    }
    public static void main(String[] args)
    {
            System.out.println(CarFactory.buildCar(CarType.MICRO));
            System.out.println(CarFactory.buildCar(CarType.MINI));
            System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }


    /*
        The main difference between a “factory method” and an “abstract factory” is that
        the factory method is a single method, and an abstract factory is an object.
        The factory method is just a method, it can be overridden in a subclass, whereas the abstract factory is an object that has multiple factory methods on it.
        The Factory Method pattern uses inheritance and relies on a subclass to handle the desired object instantiation.
     */
}
