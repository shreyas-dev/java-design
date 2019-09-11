package dev.shreyas.java.designs.gangOfFour.creational;


/*
    The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
    It provides a more handy and good way to create an object with it’s life cycle being extended to Application.
    An example of this is creating a connection to database with a single and only object to
    avoid any conflicts and maintain it throughout the application.

    Important consideration:
    It’s possible to subclass a singleton by making the constructor protected instead of private.This might be suitable
    under some circumstances. One approach taken in these scenarios is to create a register of singletons of the
    subclasses and the getInstance method can take in a parameter or use an environment variable to return the desired singleton.
    The registry then maintains a mapping of string names to singleton objects, which can be accessed as needed.
 */
public class SingletonPatternDemo {

    // Classic Implementation
    // The main problem with below method is that it is not thread safe
    static class Singleton
    {
        private static Singleton obj;

        // private constructor to force use of
        // getInstance() to create Singleton object
        private Singleton() {}

        public static Singleton getInstance()
        {
            if (obj==null)
                obj = new Singleton();
            return obj;
        }
    }

    // Thread Synchronized Java implementation of
    // singleton design pattern
    static class SingletonSynchronized{
        private static SingletonSynchronized obj;

        private SingletonSynchronized() {}

        // Only one thread can execute this at a time
        // The main disadvantage of this is method is that using synchronized every time while
        // creating the singleton object is expensive and may decrease the performance of your program.
        public static synchronized SingletonSynchronized getInstance()
        {
            if (obj==null)
                obj = new SingletonSynchronized();
            return obj;
        }
    }

    //  Eager Instantiation

    //  JVM executes static initializer when the class is loaded and hence this is guaranteed to be thread safe.
    // Use this method only when your singleton class is light and is used throughout the execution of your program.
    static class EagerSingleton
    {
        private static EagerSingleton obj = new EagerSingleton();

        private EagerSingleton() {}

        public static EagerSingleton getInstance()
        {
            return obj;
        }
    }

    // Best way
    // “Double Checked Locking”

    // Double Checked Locking based Java implementation of
    // singleton design pattern
    static class DoubleCheckedSingleton
    {
        private volatile static DoubleCheckedSingleton obj;

        private DoubleCheckedSingleton() {}

        public static DoubleCheckedSingleton getInstance()
        {
            if (obj == null)
            {
                // To make thread safe
                synchronized (DoubleCheckedSingleton.class)
                {
                    // check again as multiple threads
                    // can reach above step
                    if (obj==null)
                        obj = new DoubleCheckedSingleton();
                }
            }
            return obj;
        }
    }
    //  We have declared the obj volatile which ensures that multiple threads offer the obj variable correctly
    // when it is being initialized to Singleton instance. This method drastically reduces the overhead of
    // calling the synchronized method every time.
}
