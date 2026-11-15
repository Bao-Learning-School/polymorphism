import java.util.ArrayList;

/**
 * Main test-drive caller demonstrating Serious Polymorphism: abstract classes,
 * class Object, casting, and interfaces (Head First Java, 3rd Edition - Chapter 8).
 *
 * DO NOT MODIFY THIS FILE (except to uncomment the EXPERIMENT and BONUS lines).
 *
 * Once you finish all of your TODO files, compile and run:
 *   javac *.java
 *   java PetShopSimulation
 */
public class PetShopSimulation {

    public static void main(String[] args) {
        // Make one object from each CONCRETE class (p. 204).
        // Notice: there is no "new Animal()" anywhere. Animal is abstract!
        Dog buddy = new Dog();
        buddy.setName("Buddy the Dog");

        Wolf ghost = new Wolf();
        ghost.setName("Ghost the Wolf");

        Cat whiskers = new Cat();
        whiskers.setName("Whiskers the Cat");

        Lion simba = new Lion();
        simba.setName("Simba the Lion");

        Hippo gloria = new Hippo();
        gloria.setName("Gloria the Hippo");

        // RoboDog is NOT an Animal. It comes from the Robot family tree (p. 228).
        RoboDog robo = new RoboDog();
        robo.setModel("RoboRex 3000");

        // =====================================================================
        // DEMO 1: Abstract vs. Concrete (Chapter 8, pp. 200-206)
        // =====================================================================
        System.out.println("=== DEMO 1: Abstract vs. Concrete ===");

        // Don't panic! This does NOT make an Animal object. It makes an ARRAY object
        // that can HOLD Animals. That's allowed, even though Animal is abstract (p. 209).
        Animal[] zoo = new Animal[5];
        zoo[0] = buddy;
        zoo[1] = ghost;
        zoo[2] = whiskers;
        zoo[3] = simba;
        zoo[4] = gloria;

        for (Animal animal : zoo) {
            showOff(animal);
        }

        // EXPERIMENT 1 (uncomment ONE line below at a time to test the compiler!):
        // Animal blob = new Animal();      // What would a generic Animal even look like? (pp. 201-203)
        // Canine someCanine = new Canine(); // What about a generic Canine? (p. 203)

        // EXPERIMENT 2 lives in Hippo.java: delete Hippo's eat() method, then run
        // javac *.java. What does the compiler say? (p. 206)

        // =====================================================================
        // DEMO 2: Every Class Extends Object (Chapter 8, pp. 210-212)
        // =====================================================================
        System.out.println("\n=== DEMO 2: Every Class Extends Object ===");
        // You never wrote these methods. Every class inherits them from Object (p. 211)!
        System.out.println("whiskers.getClass()       -> " + whiskers.getClass());
        System.out.println("whiskers.equals(buddy)    -> " + whiskers.equals(buddy));
        System.out.println("whiskers.equals(whiskers) -> " + whiskers.equals(whiskers));
        System.out.println("whiskers.hashCode()       -> " + whiskers.hashCode());
        // This one runs YOUR toString() override from Animal.java (TODO 3):
        System.out.println("whiskers.toString()       -> " + whiskers.toString());

        // RoboDog is not an Animal... but it still IS-A Object!
        System.out.println("robo.getClass()           -> " + robo.getClass());
        System.out.println("robo.toString()           -> " + robo.toString());

        // Class Object is NOT abstract, so you are allowed to make a plain Object (p. 212).
        // Nobody overrode its toString(), so you see the default version (p. 211):
        Object plainObject = new Object();
        System.out.println("plainObject.toString()    -> " + plainObject.toString());

        // =====================================================================
        // DEMO 3: The Lost & Found Box - ArrayList<Object> and Casting (pp. 213-218)
        // =====================================================================
        System.out.println("\n=== DEMO 3: The Lost & Found Box (ArrayList<Object>) ===");
        ArrayList<Object> lostAndFound = new ArrayList<Object>();
        lostAndFound.add(buddy);
        lostAndFound.add(whiskers);
        lostAndFound.add(robo);
        lostAndFound.add("a squeaky toy"); // A String IS-A Object, too!

        // Everything comes OUT of an ArrayList<Object> as type Object (p. 213).
        // So 'first' is an Object remote control: it has ONLY Object buttons (p. 217).
        Object first = lostAndFound.get(0);
        System.out.println("first.getClass() -> " + first.getClass() + "  (the object really IS a Dog...)");
        System.out.println("first.hashCode() -> " + first.hashCode() + "  (...but we can only press Object buttons)");

        // EXPERIMENT 3 (uncomment the line below to test the compiler!):
        // first.fetch(); // It really IS a Dog... so why won't this compile? (p. 215)

        // EXPERIMENT 4 (uncomment the line below to test the compiler!):
        // Dog d = lostAndFound.get(0); // Why won't this compile without a cast? (pp. 213-214)

        // Check with instanceof FIRST, then cast the Object back to a Dog (p. 218):
        if (first instanceof Dog) {
            Dog sameBuddy = (Dog) first;
            System.out.print("After casting to Dog -> ");
            sameBuddy.fetch();
        }

        System.out.println("\n-- Sorting the Lost & Found box with instanceof --");
        for (Object thing : lostAndFound) {
            sortLostAndFound(thing);
        }

        // EXPERIMENT 5 (uncomment the line below, then compile AND run!):
        // Dog oops = (Dog) lostAndFound.get(1); // This one COMPILES! So what goes wrong? (p. 218)

        // =====================================================================
        // DEMO 4: The Pet Interface - Pets From Different Family Trees (pp. 220-228)
        // =====================================================================
        System.out.println("\n=== DEMO 4: Objectville Pet Shop (the Pet Interface) ===");
        PetShop shop = new PetShop("Objectville Pet Shop");
        shop.checkIn(buddy);    // a Dog:     Animal -> Canine -> Dog
        shop.checkIn(whiskers); // a Cat:     Animal -> Feline -> Cat
        shop.checkIn(robo);     // a RoboDog: Robot -> RoboDog (not even an Animal!)

        // BONUS 3 (uncomment these 3 lines after you create Hamster.java - see README):
        // Hamster nibbles = new Hamster();
        // nibbles.setName("Nibbles the Hamster");
        // shop.checkIn(nibbles);

        shop.playtime();

        System.out.println("\nRoboDog IS-A Pet, but it still has all of its Robot buttons, too:");
        robo.beep();
        robo.recharge();

        System.out.println("\n-- Which animals pass the IS-A Pet test? --");
        for (Animal animal : zoo) {
            if (animal instanceof Pet) {
                System.out.println(animal + " IS-A Pet. Welcome to the shop!");
            } else {
                System.out.println(animal + " is NOT a Pet. Back to the wild!");
            }
        }

        System.out.println("\n-- Adopting a mystery pet (polymorphic return type) --");
        Pet mystery = shop.adoptMysteryPet(3);
        System.out.println("The mystery pet is really a: " + mystery.getClass());
        shop.checkIn(mystery);

        // EXPERIMENT 6 (uncomment the line below to test the compiler!):
        // shop.checkIn(gloria); // Why won't a Hippo fit through the Pet Shop door? (pp. 221 & 228)

        // EXPERIMENT 7 (uncomment the line below to test the compiler!):
        // Animal fakeAnimal = robo; // RoboDog IS-A Pet... but is it an Animal? (p. 228)

        // EXPERIMENT 8 (uncomment the line below to test the compiler!):
        // Pet pet = new Pet(); // Can you say 'new' to an interface? (p. 226)

        // =====================================================================
        // DEMO 5: One Dog, Many Remote Controls - "Polymorphism means many forms" (pp. 216-217)
        // =====================================================================
        System.out.println("\n=== DEMO 5: One Dog, Many Remote Controls ===");
        // There is only ONE Dog object on the heap, but FIVE remote controls (references) point to it.
        // Buddy IS-A Dog, IS-A Canine, IS-A Animal, IS-A Pet, and IS-A Object!
        Dog    dogRemote    = buddy;
        Canine canineRemote = buddy;
        Animal animalRemote = buddy;
        Pet    petRemote    = buddy;
        Object objectRemote = buddy;

        System.out.print("Dog remote    -> fetch()     : ");
        dogRemote.fetch();
        System.out.print("Canine remote -> roam()      : ");
        canineRemote.roam();
        System.out.print("Animal remote -> makeNoise() : ");
        animalRemote.makeNoise();
        System.out.print("Pet remote    -> play()      : ");
        petRemote.play();
        System.out.println("Object remote -> getClass()  : " + objectRemote.getClass());
        System.out.println("Do dogRemote and objectRemote point to the SAME object? " + (dogRemote == objectRemote));

        // EXPERIMENT 9 (uncomment the line below to test the compiler!):
        // petRemote.makeNoise(); // Buddy CAN make noise... so why won't this compile? (pp. 215 & 231)

        // =====================================================================
        // BONUS 2 (pp. 228-229): "Extend only one, but implement two."
        // Uncomment the lines below after you finish Bonus Challenge 2 in the README.
        // =====================================================================
        // System.out.println("\n=== BONUS: Extend Only One, But Implement Two ===");
        // Trainable[] students = { buddy, robo };
        // for (Trainable student : students) {
        //     student.doTrick();
        // }
    }

    /**
     * The parameter type is Animal (an ABSTRACT class!), so ANY concrete Animal
     * subclass can be passed in. That's the whole point of abstract classes (p. 205).
     */
    public static void showOff(Animal a) {
        System.out.println("\n[" + a + "]");
        System.out.print("  makeNoise() -> ");
        a.makeNoise(); // abstract in Animal, so the CONCRETE class's version runs
        System.out.print("  eat()       -> ");
        a.eat();       // abstract in Animal, so the CONCRETE class's version runs
        System.out.print("  roam()      -> ");
        a.roam();
        System.out.print("  sleep()     -> ");
        a.sleep();
    }

    /**
     * Uses instanceof to find out what an Object REALLY is, then casts it to
     * a reference type that has the right buttons (p. 218).
     * Notice: instanceof and casting work with interfaces (like Pet), too!
     */
    public static void sortLostAndFound(Object thing) {
        if (thing instanceof Dog) {
            Dog dog = (Dog) thing;
            System.out.print("It's a Dog! -> ");
            dog.fetch();
        } else if (thing instanceof Pet) {
            Pet pet = (Pet) thing;
            System.out.print("It's a Pet! -> ");
            pet.play();
        } else {
            System.out.println("\"" + thing + "\" is not a pet. It's a " + thing.getClass());
        }
    }
}
