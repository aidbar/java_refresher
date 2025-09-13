public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println("Some sound");
    }

    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        System.out.println("Dog's name is: " + dog.getName());
        dog.makeSound();
        Animal cat = new Cat("Whiskers");
        System.out.println("Cat's name is: " + cat.getName());
        cat.makeSound();
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
