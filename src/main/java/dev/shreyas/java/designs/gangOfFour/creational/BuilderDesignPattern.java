package dev.shreyas.java.designs.gangOfFour.creational;
/*
        Why Builder Pattern ?
        There are classes without setters, called "Immutable Classes".
        They are used in distributed and multi-threaded programs where multiple threads can alter
        the states of an object. Developers use 'synchronize' to prevent this.

        But a more convenient approach is to use Immutable classes so that threads can't alter the states via setters.
        (If states need to be altered a new object is created! This consumes memory which is a cons of Immutable Classes
        but its worth, compared to the state-altered-havocs)

        Thus for Immutable Classes, Builder Pattern has to be used instead of setters.

        Let's take an example of a phone which has only all args constructor
 */
public class BuilderDesignPattern {

    public static class Phone {
        private String os;
        private String processor;
        private int ram;
        private int rom;
        private String camera;

        // All args constructor
        public Phone(String os, String processor, int ram, int rom, String camera) {
            this.os = os;
            this.processor = processor;
            this.ram = ram;
            this.rom = rom;
            this.camera = camera;
        }

        @Override
        public String toString() {
            return "Phone{" +
                    "os='" + os + '\'' +
                    ", processor='" + processor + '\'' +
                    ", ram=" + ram +
                    ", rom=" + rom +
                    ", camera='" + camera + '\'' +
                    '}';
        }
    }

    public static class PhoneBuilder{
        private String os;
        private String processor;
        private int ram;
        private int rom;
        private String camera;

        public PhoneBuilder() {
        }

        public PhoneBuilder setOs(String os) {
            this.os = os;
            return this;
        }

        public PhoneBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public PhoneBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public PhoneBuilder setRom(int rom) {
            this.rom = rom;
            return this;
        }

        public PhoneBuilder setCamera(String camera) {
            this.camera = camera;
            return this;
        }

        // builder method to create a phone
        public Phone build(){

            return new Phone(os,processor,ram,rom,camera);
        }
    }

    public static void main(String[] args) {
        // BuilderDesignPattern
        // setting only new parameters , others are taken care of by the builder class, if not provided.
        Phone phone = new PhoneBuilder().setOs("Android").setRam(2).setCamera("12 MP").build();
        System.out.println(phone);
    }
}
