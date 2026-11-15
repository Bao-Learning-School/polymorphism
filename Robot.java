/**
 * PROVIDED CLASS - from the Objectville Robot Factory. DO NOT MODIFY THIS FILE.
 * (Head First Java, 3rd Edition - Chapter 8, pp. 210 & 228)
 *
 * Robot lives in a COMPLETELY DIFFERENT inheritance tree from Animal.
 * It does not extend Animal. In fact, it doesn't say 'extends' at all...
 * which means it automatically extends Object (p. 210)!
 *
 * Your RoboDog class will extend Robot, so RoboDog inherits everything below.
 */
public class Robot {
    private String model = "Unnamed Robot";
    private int battery = 100;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void beep() {
        System.out.println(model + " says: BEEP BOOP!");
    }

    /**
     * Uses up some battery power (RoboDog can call this when it plays!).
     */
    public void useBattery(int amount) {
        battery = battery - amount;
        if (battery < 0) {
            battery = 0;
        }
        System.out.println("  (" + model + " battery: " + battery + "%)");
    }

    public void recharge() {
        battery = 100;
        System.out.println(model + " plugs in and recharges to " + battery + "% battery.");
    }

    /**
     * Robot OVERRIDES toString(), a method EVERY class inherits from Object (pp. 211-212).
     * Now System.out.println(someRobot) prints the model name instead of "Robot@7d277f".
     *
     * Use this as an example for TODO 3 in Animal.java!
     */
    @Override
    public String toString() {
        return model;
    }
}
