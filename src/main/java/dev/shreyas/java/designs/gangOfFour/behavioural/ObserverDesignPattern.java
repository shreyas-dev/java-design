package dev.shreyas.java.designs.gangOfFour.behavioural;

import java.util.ArrayList;
import java.util.List;

/*
    Observer pattern is used when there is one-to-many relationship between objects such
    as if one object is modified, its dependent objects are to be notified automatically.
    Observer pattern falls under behavioral pattern category

    Eg:-
    Observer pattern uses three actor classes. Subject, Observer and Client.
    Subject is an object having methods to attach and detach observers to a client object.
    We have created an abstract class Observer and a concrete class Subject that is extending class Observer.
 */
public class ObserverDesignPattern {

    static class Subject {
        private List<Observer> observers = new ArrayList<Observer>();
        private int state;
        public int getState() {
            return state;
        }
        public void setState(int state) {
            this.state = state;
            notifyAllObservers();
        }
        public void attach(Observer observer){
            observers.add(observer);
        }
        public void notifyAllObservers(){
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

    static abstract class Observer {
        protected Subject subject;
        public abstract void update();
    }

    // Create concrete observer classes
    static class BinaryObserver extends Observer{
        Subject subject;
        public BinaryObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }
        @Override
        public void update() {
            System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
        }
    }

    static class OctalObserver extends Observer{
        Subject subject;
        public OctalObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }
        @Override
        public void update() {
            System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
        }
    }

    static class HexaObserver extends Observer{
        Subject subject;
        public HexaObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }
        @Override
        public void update() {
            System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
        }
    }


    // Use Subject and concrete observer objects.
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }

}
