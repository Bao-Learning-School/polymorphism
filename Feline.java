/**
 * Family class: Feline
 * (Head First Java, 3rd Edition - Chapter 8, pp. 202-206).
 *
 * GOOD NEWS: roam() is already done for you (just like in Chapter 7).
 *
 * EXERCISE TODOs:
 * 1. Can you picture a "generic" Feline? Is it a house cat? A lion? A tiger?
 *    Nobody should be able to say "new Feline()". Make Feline ABSTRACT (pp. 202-203).
 *
 * 2. Notice what is NOT here: makeNoise() and eat()!
 *    An abstract class can "pass the buck" (p. 206): Feline does NOT have to
 *    implement Animal's abstract methods. The first CONCRETE classes below it
 *    (Cat and Lion) must implement them instead.
 */
public class Feline extends Animal {
    // TODO 1: Make this class abstract (change the class declaration above!)

    @Override
    public void roam() {
        System.out.println(getName() + " prowls around alone.");
    }
}
