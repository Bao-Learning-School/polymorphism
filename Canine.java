/**
 * Family class: Canine
 * (Head First Java, 3rd Edition - Chapter 8, pp. 202-206).
 *
 * GOOD NEWS: roam() is already done for you (just like in Chapter 7).
 *
 * CHECKPOINT (before you change anything in this file!):
 *    Finish Animal.java first, then run javac *.java and find the error message
 *    about Canine. What is the compiler telling you? TODO 1 below will fix it.
 *
 * EXERCISE TODOs:
 * 1. Can you picture a "generic" Canine? Is it a dog? A wolf? A fox?
 *    Nobody should be able to say "new Canine()". Make Canine ABSTRACT (pp. 202-203).
 *
 * 2. Notice what is NOT here: makeNoise() and eat()!
 *    An abstract class can "pass the buck" (p. 206): Canine does NOT have to
 *    implement Animal's abstract methods. The first CONCRETE classes below it
 *    (Dog and Wolf) must implement them instead.
 */
public class Canine extends Animal {
    // TODO 1: Make this class abstract (change the class declaration above!)

    @Override
    public void roam() {
        System.out.println(getName() + " roams around with its pack.");
    }
}
