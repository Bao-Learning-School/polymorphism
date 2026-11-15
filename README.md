# Objectville Pet Shop — Chapter 8 Exercise

Welcome to **Serious Polymorphism** (*Head First Java, 3rd Edition*, Chapter 8)!

Your Chapter 7 animals were such a hit that the **Objectville Pet Shop** wants to reuse them. But the shop owner found three problems:

1. Somebody wrote `new Animal()`. What does a generic Animal even look like?! What shape? What color? (pp. 201–202)
2. The shop needs pet behaviors, `beFriendly()` and `play()`, but Wolves, Lions, and Hippos are **not** pets! (pp. 220–223)
3. The Robot Factory built a **RoboDog**. It isn't an Animal at all, but it wants to be a Pet too! (p. 228)

Just like Chapter 7, **the caller code is already written for you** (`PetShop.java` and `PetShopSimulation.java`). Your job is to fix all three problems with **abstract classes** and an **interface**, so the callers compile, run, and show off *serious* polymorphism!

---

## Files in This Project

### Provided (Already Complete — Read Them!)
- `PetShop.java` — Uses the `Pet` **interface** as a polymorphic argument (`checkIn(Pet pet)`), array (`Pet[] kennel`), and return type (`adoptMysteryPet()`).
- `PetShopSimulation.java` — Main test-drive program with **5 demos** and **compiler experiments**.
- `Robot.java` — From the Robot Factory, a totally different family tree. Don't change it, but do read its `toString()`!

### Your Files to Fill In
- **Abstract superclasses:** `Animal.java`, `Canine.java`, `Feline.java` (the Chapter 7 parts are already done!)
- **Concrete animals:** `Dog.java`, `Cat.java`, `Wolf.java`, `Lion.java`, `Hippo.java`
- **Interface:** `Pet.java`
- **Robot pet:** `RoboDog.java`

> **Don't panic** if `javac *.java` shows lots of errors at the start! The callers need your classes. The errors disappear one by one as you finish each step.

---

## Chapter 8 in 60 Seconds

| Idea | What it means | Java example | Pages |
|---|---|---|---|
| Abstract class | Nobody can say `new` on it | `public abstract class Animal` | 202–203 |
| Concrete class | Specific enough to make objects from | `public class Dog` | 204 |
| Abstract method | No body; subclasses **must** write it | `public abstract void eat();` | 205 |
| First concrete class rule | Must implement **all** inherited abstract methods | `Dog` writes `eat()` | 206 |
| Class `Object` | The superclass of **every** class | `getClass()`, `equals()`, `hashCode()`, `toString()` | 210–212 |
| Reference type rule | The compiler checks the **reference** type, not the object type | `Object o = dog; o.fetch(); // NO!` | 215, 217 |
| Cast + `instanceof` | Get a more specific "remote control" back, safely | `if (o instanceof Dog) { Dog d = (Dog) o; }` | 218 |
| Interface | A 100% abstract **role** that any class can play | `public interface Pet` | 226–227 |
| `implements` | Sign the interface's contract | `class Dog extends Canine implements Pet` | 227 |
| Extend one, implement many | Only one superclass, but many interfaces | `class Dog extends Canine implements Pet, Trainable` | 228–229 |
| `super` | Run the superclass version of a method | `super.beep();` | 230 |

---

## Step-by-Step Instructions

### Step 1: Make `Animal` Abstract (pp. 200–206 & 210–212)
Open `Animal.java`. The Chapter 7 parts (`name`, `getName()`/`setName()`, `sleep()`, `roam()`) are already done.

1. **Make the class abstract:** add the keyword `abstract` to the class declaration.
2. **Add two abstract methods:** `makeNoise()` and `eat()`. They have **no body**: no curly braces, just a semicolon (p. 205):
   ```java
   public abstract void eat();
   ```
3. **Override `toString()`**, a method `Animal` inherits from `Object`! Return the animal's name, so printing an animal shows `Buddy the Dog` instead of `Dog@7d277f` (p. 211). Peek at `Robot.java` for an example.

> **Tip:** An abstract class can mix abstract methods (no body) with normal methods (with a body), like `sleep()` and `roam()` (p. 205).

> **Checkpoint:** Compile now, *before* you touch `Canine.java`, and look for this error:
> `Canine is not abstract and does not override abstract method eat() in Animal` (it may say `makeNoise()` instead).
> What is the compiler telling you? Step 2 fixes it!

### Step 2: Make `Canine` and `Feline` Abstract (pp. 202–206)
`roam()` is already written in both. Your job:
1. Add `abstract` to each class declaration. (Can you picture a "generic" Canine? Is it a dog? A wolf? A fox?) Compile again: the Checkpoint error is gone!
2. Notice what's **missing**: `makeNoise()` and `eat()`! An abstract class can **pass the buck**, so the first **concrete** class below it must implement them instead (p. 206).

### Step 3: Write the Wild Animals: `Wolf`, `Lion`, `Hippo` (pp. 204–206)
1. Add `extends` with the most specific superclass (use the IS-A test from Chapter 7!).
2. Implement `makeNoise()` and `eat()`. *Implementing an abstract method is just like overriding a method* (p. 206).
3. **Do NOT make them Pets.** "When was the last time you saw a Hippo at a pet shop?" (p. 221)

> **Hint:** `name` is `private` in `Animal`, so use `getName()` in your messages:
> `System.out.println(getName() + " howls: Aroooooo!");`

### Step 4: Create the `Pet` Interface (pp. 220–227)
First, read pp. 221–225. Why not put `beFriendly()` and `play()` in `Animal`? Why not make `Pet` a second superclass? (Hint: the **Deadly Diamond of Death**!)

1. Change the keyword `class` to `interface` in `Pet.java`.
2. Add the two Pet methods, with **no body** (end each one with a semicolon):
   ```java
   void beFriendly();
   void play();
   ```
   Interface methods are automatically `public` and `abstract` (p. 227).

### Step 5: Write the Pets: `Dog` and `Cat` (pp. 226–228)
1. Extend a class **and** implement the interface (`extends` first, then `implements`):
   ```java
   public class Dog extends Canine implements Pet {
   ```
2. Implement **all four** methods: `makeNoise()` and `eat()` (from `Animal`), plus `beFriendly()` and `play()` (from `Pet`).
3. `Dog` only: add `public void fetch()`. It's not in `Animal` or `Pet`. Demos 3 and 5 use it to test **casting** and **remote controls**.

> **Overriding Contract Reminder (pp. 192 & 227):** Interface methods are `public`, so your versions **must** be `public` too! Put `@Override` above each one so the compiler double-checks your spelling.

### Step 6: Build `RoboDog` (p. 228)
1. `RoboDog` is **not** an Animal. It comes from the Robot family tree:
   ```java
   public class RoboDog extends Robot implements Pet {
   ```
2. Implement `beFriendly()` and `play()`. Use `getModel()` (inherited from `Robot`) in your messages.
3. Think: why doesn't `RoboDog` have to write `makeNoise()` or `eat()`?

### Step 7: Compile and Run!
From inside the `polymorphism` folder, run:

```bash
javac *.java
java PetShopSimulation
```

Check your output against the **5 Demos**:
1. **Demo 1 (Abstract vs. Concrete):** Every animal makes its own noise and eats its own way, even though `makeNoise()` and `eat()` have **no body** in `Animal`! `roam()` comes from `Canine` or `Feline` (or `Animal`, for the Hippo), and `sleep()` always comes from `Animal`.
2. **Demo 2 (Every Class Extends `Object`):** Your animals have `getClass()`, `equals()`, and `hashCode()` methods that you never wrote. `toString()` prints a name (not `Cat@7d277f`) thanks to your override.
3. **Demo 3 (Lost & Found `ArrayList<Object>`):** Everything comes out as a plain `Object`. After an `instanceof` check, a cast turns it back into a `Dog` that can `fetch()`.
4. **Demo 4 (Pet Shop):** A Dog, a Cat, and a RoboDog all check in, even though RoboDog comes from a **completely different family tree** (Robot, not Animal)! Only **Buddy** and **Whiskers** pass the IS-A Pet test. **Ghost**, **Simba**, and **Gloria** go back to the wild.
5. **Demo 5 (Remote Controls):** One Dog object, five reference types, and each remote control has only its own buttons.

### Step 8: Be the Compiler! (pp. 203, 206, 215 & 218)
`PetShopSimulation.java` has `// EXPERIMENT` spots. Try them **one at a time**: uncomment the line, run `javac *.java` (for #5, also run `java PetShopSimulation`), explain what happened **in your own words**, then put the `//` back.

| # | Try this | Think about it |
|---|---|---|
| 1 | `new Animal()`, then `new Canine()` | What would a generic Animal look like? (pp. 201–203) |
| 2 | Delete `eat()` from `Hippo.java` | Who **forces** you to write it? (p. 206) |
| 3 | `first.fetch();` | It really *is* a Dog... so why? (p. 215) |
| 4 | `Dog d = lostAndFound.get(0);` | What comes out of an `ArrayList<Object>`? (pp. 213–214) |
| 5 | `Dog oops = (Dog) lostAndFound.get(1);` | It compiles! Now **run** it. What happens? Did Demos 4 and 5 run? (p. 218) |
| 6 | `shop.checkIn(gloria);` | Why won't a Hippo fit through the Pet Shop door? (pp. 221 & 228) |
| 7 | `Animal fakeAnimal = robo;` | RoboDog IS-A Pet... but IS-A Animal? (p. 228) |
| 8 | `Pet pet = new Pet();` | Can you `new` an interface? Why does the error say "abstract"? (pp. 226–227) |
| 9 | `petRemote.makeNoise();` | Buddy *can* make noise... so why? (pp. 215 & 231) |

---

## Decoding Compiler Errors

| If `javac` says... | It means... |
|---|---|
| `Dog is not abstract and does not override abstract method play() in Pet` | `Dog` is concrete but is missing `play()`. A concrete class must implement **every** abstract method it inherits (p. 206). |
| `Canine is not abstract and does not override abstract method eat() in Animal` | Mark `Canine` abstract, so it can pass the buck (p. 206). If it says `Animal is not abstract...`, you forgot `abstract` on the `Animal` class itself! |
| `Animal is abstract; cannot be instantiated` | You tried to `new` an abstract class **or an interface** (an interface is 100% abstract, p. 226). |
| `abstract methods cannot have a body` or `interface abstract methods cannot have body` | Remove the `{ }` and end the method with a semicolon instead. |
| `befriendly() in Dog does not override or implement a method from a supertype` | `@Override` caught a typo! Check the spelling and capital letters: `beFriendly()`. |
| `play() in Dog cannot implement play() in Pet` ... `attempting to assign weaker access privileges; was public` | Add `public` in front of the method. (Same fix for `toString() in Animal cannot override toString() in Object`.) |
| `interface expected here` | `Pet` is still a `class`. Change it to `interface`. |
| `'{' expected` (on the class line) | Check the order: `extends` comes first, then `implements`. |
| `name has private access in Animal` | Use `getName()` instead of `name`. |
| `cannot find symbol` | The **reference type** doesn't have that method (button), or there's a typo. |
| `incompatible types: X cannot be converted to Y` | An `X` doesn't pass the IS-A test for `Y` (or you need a cast). |

> You can ignore the line `Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output`. Just fix the errors above it!

---

## Bonus Challenges (After Everything Runs!)

1. **Use `super` (p. 230):** In `RoboDog.java`, override `beep()`. Call `super.beep()` first, then print your own doggy beep, like `"...WOOF.EXE!"`. Demo 4 calls `robo.beep()`, so you'll see both lines!
2. **Extend Only One, But Implement Two (pp. 228–229):** Create `Trainable.java`, an interface with one method: `void doTrick();`. Make **both** `Dog` and `RoboDog` implement `Pet` *and* `Trainable`:
   `public class Dog extends Canine implements Pet, Trainable {`
   Then write a `public void doTrick()` method in **both** classes (roll over? moonwalk?), and uncomment the **BONUS 2** block at the end of `PetShopSimulation.java`.
3. **The New Pet Test:** Create `Hamster.java` (`extends Animal implements Pet`), then uncomment the **BONUS 3** lines in Demo 4 of `PetShopSimulation.java` to check a hamster in at the shop. You won't change a single line of `PetShop.java`! Why does that work?
4. **What's the Picture? (p. 232):** Draw this project's class diagram. Use a **solid** arrow for `extends` and a **dashed** arrow for `implements`, and label each box *class*, *abstract class*, or *interface*.
5. **Abstract or Concrete? (pp. 204, 207 & 229):** In our Pet Shop, `Dog` is concrete. In a dog-breeding app with `Poodle`, `Beagle`, and `Husky` classes, should `Dog` be abstract? And why is `Robot` a plain class, while `Pet` is an interface?
