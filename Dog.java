/**
 * Concrete animal class: Dog
 * (Head First Java, 3rd Edition - Chapter 8, pp. 206, 217-218 & 226-227).
 *
 * A Dog IS-A Canine (through inheritance) AND a Dog IS-A Pet (through the interface)!
 *
 * EXERCISE TODOs:
 * 1. Make Dog extend Canine AND implement the Pet interface (p. 227):
 *        public class Dog extends Canine implements Pet {
 *    ('extends' always comes first, then 'implements'.)
 *
 * 2. Dog is CONCRETE, so it MUST implement EVERY abstract method it inherits (p. 206):
 *        - makeNoise()   (abstract in Animal - Canine passed the buck to you!)
 *        - eat()         (abstract in Animal)
 *        - beFriendly()  (from the Pet interface)
 *        - play()        (from the Pet interface)
 *    Make all four 'public'. Put @Override above each one, so the compiler
 *    double-checks your spelling!
 *
 * 3. Add one Dog-ONLY method. It is NOT in Animal, Canine, or Pet:
 *        - public void fetch()
 *    PetShopSimulation uses it to test CASTING (p. 218) and REMOTE CONTROLS (p. 217).
 *
 * Hint: 'name' is private in Animal, so use getName() in your messages:
 *        System.out.println(getName() + " fetches the tennis ball!");
 */
public class Dog {
    // TODO: Add 'extends ... implements ...' above, implement the 4 methods, and add fetch()!

}
