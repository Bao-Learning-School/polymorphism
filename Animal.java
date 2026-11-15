/**
 * Root superclass for all animals in the Objectville Pet Shop
 * (Head First Java, 3rd Edition - Chapter 8, pp. 200-206 & 210-212).
 *
 * GOOD NEWS: The Chapter 7 parts are already done for you below
 * (the name variable, getName()/setName(), sleep(), and roam()).
 *
 * EXERCISE TODOs:
 *
 * 1. Make Animal an ABSTRACT class (pp. 201-203).
 *    What would a "new Animal()" look like? What shape? What color? How many legs?
 *    Nobody should EVER be able to make a generic Animal object! Add the keyword
 *    'abstract' to the class declaration:
 *        public abstract class Animal {
 *
 * 2. Add two ABSTRACT METHODS (p. 205):
 *        - makeNoise()
 *        - eat()
 *    There is no sensible "generic" animal noise or "generic" way to eat, so these
 *    methods get NO BODY. No curly braces - just end the line with a semicolon:
 *        public abstract void eat();
 *    Now every CONCRETE animal (Dog, Cat, Wolf, Lion, Hippo) will be FORCED by the
 *    compiler to write its own version (p. 206)!
 *
 * 3. Override toString() - a method Animal inherits from class Object (pp. 210-212).
 *    Make it return the animal's name, so System.out.println(anyAnimal) prints
 *    "Buddy the Dog" instead of something like "Dog@7d277f".
 *    (Look at toString() in Robot.java for an example!)
 *
 * Remember (p. 205): an abstract class can have BOTH abstract methods (no body)
 * AND normal methods (with a body, like sleep() and roam() below).
 */
public class Animal {
    // TODO 1: Make this class abstract (change the class declaration above!)

    // 'private' means subclasses can't touch 'name' directly...
    // ...but they DO inherit the public getName() and setName() methods!
    private String name = "Unnamed Animal";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Every animal sleeps the same way, so ALL subclasses inherit this one.
    public void sleep() {
        System.out.println(name + " curls up and takes a nap. Zzz...");
    }

    // A generic way to roam. Canine and Feline override this (Hippo doesn't!).
    public void roam() {
        System.out.println(name + " wanders around.");
    }

    // TODO 2: Add the two abstract methods here: makeNoise() and eat()

    // TODO 3: Override toString() here, so it returns the animal's name

}
