package com.expedia.interview.java;

public class RunTimePolymorfhism {

    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.eat();


        Animal a2 = new Dog();
        a2.eat();

        Animal a3 = new BabyDog();
        a3.eat();
    }

}

class Animal {
    void eat() {
        System.out.println("animal is eating");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating");
    }
}

class BabyDog extends Dog {

}