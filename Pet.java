/**
 * The Pet interface
 * (Head First Java, 3rd Edition - Chapter 8, pp. 220-228).
 *
 * Why an INTERFACE, and not a class?
 *   - Putting pet methods in Animal would give Hippos and Wolves pet methods (pp. 221-222)!
 *   - Putting them ONLY in Dog and Cat means no contract and no polymorphism (p. 223).
 *   - Making Pet a second superclass is impossible: a Java class can have only ONE
 *     superclass, because of the "Deadly Diamond of Death" (pp. 224-225).
 *   - An interface is like a 100% abstract class: a ROLE that ANY class can play,
 *     no matter which family tree it comes from (pp. 226-228).
 *
 * EXERCISE TODOs:
 * 1. Change the keyword 'class' below to 'interface' (p. 226).
 *
 * 2. Add the two methods that EVERY Pet must have (p. 227):
 *        - beFriendly()
 *        - play()
 *    Both return void and take no arguments. Interface methods are automatically
 *    public and abstract, so they have NO BODY. End each one with a semicolon:
 *        void play();
 */
public class Pet {
    // TODO: Change 'class' to 'interface' above, then add the 2 Pet methods!

}
