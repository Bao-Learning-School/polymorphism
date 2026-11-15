/**
 * Caller class demonstrating INTERFACE polymorphism
 * (Head First Java, 3rd Edition - Chapter 8, pp. 208-209 & 220-228).
 *
 * DO NOT MODIFY THIS FILE (unless trying the bonus challenges!).
 *
 * Notice that PetShop only ever talks to the 'Pet' type. It has no idea whether
 * a pet is a Dog, a Cat, or even a RoboDog from a totally different family tree.
 * All it knows is: "Anything that IS-A Pet can beFriendly() and play()."
 */
public class PetShop {
    private final String shopName;

    // Don't panic! This does NOT make any Pet objects (you can't - Pet is an interface!).
    // It makes an ARRAY object that can HOLD anything that IS-A Pet (just like p. 209).
    private final Pet[] kennel = new Pet[5];
    private int nextIndex = 0;

    public PetShop(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Interface as a polymorphic ARGUMENT type (pp. 227-228):
     * You can pass in ANY object whose class implements Pet,
     * no matter which inheritance tree it comes from!
     */
    public void checkIn(Pet pet) {
        if (nextIndex < kennel.length) {
            kennel[nextIndex] = pet;
            nextIndex++;
            // Every Pet is also an Object, so even a Pet reference has toString() (p. 210).
            System.out.println("[" + shopName + "] Checked in: " + pet + " (kennel #" + nextIndex + ")");
            pet.beFriendly();
        } else {
            System.out.println("[" + shopName + "] Sorry, the kennel is full!");
        }
    }

    /**
     * Presses ONLY the Pet buttons. At runtime, each object runs ITS OWN play() method.
     */
    public void playtime() {
        System.out.println("[" + shopName + "] It's playtime!");
        for (int i = 0; i < nextIndex; i++) {
            kennel[i].play();
        }
    }

    /**
     * Interface as a polymorphic RETURN type:
     * Declared to return 'Pet', so it can return an object of ANY class that implements Pet.
     */
    public Pet adoptMysteryPet(int ticketNumber) {
        if (ticketNumber == 1) {
            Dog puppy = new Dog();
            puppy.setName("Lucky the Puppy");
            return puppy;
        } else if (ticketNumber == 2) {
            Cat kitten = new Cat();
            kitten.setName("Mittens the Kitten");
            return kitten;
        } else {
            RoboDog roboPup = new RoboDog();
            roboPup.setModel("RoboPup Mini");
            return roboPup;
        }
    }
}
