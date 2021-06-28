import java.util.ArrayList;
import java.util.HashSet;

public class Zoo {
    private static Zoo instance = null;
    int happiness;
    int hunger;
    ArrayList<Animal> animals;
    ArrayList<ZooObserver> observers;
    HashSet<String> animalTypes;

    /**
     * creates a singleton style instance of a zoo
      */
    private Zoo() {
        hunger = 3;
        happiness = 2;
        animals = new ArrayList<>();
        observers = new ArrayList<>();
        animalTypes = new HashSet<>();

    }

    /**
     *
     * @param type a type of an animal
     * @return number of animals of that type in the zoo
     */
    public int numberOfAnimalByType(String type){
        int counter = 0;
        for(Animal animal : animals){
            String animalType = animal.getClass().getName();
            if (animalType.equals(type))
                counter = counter+1;
        }
        return counter;


    }

    /**
     * makes sure the user can create only one zoo
      * @return the instance of the one and only zoo
     */
    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
            System.out.println("Creating zoo...");
        }
        else
        System.out.println("The zoo already exists...");
        return instance;
    }

    /**
     * prints the current status of the zoo
     */
    public void showAnimalsInfo() {
        System.out.println("The zoo contains total of " + animals.size() + " animals:");
        for (String animalType : animalTypes){
            System.out.println("- "+animalType+": "+numberOfAnimalByType(animalType));
        }
        System.out.println("Happiness level: "+happiness);
        if (happiness < 3)
            System.out.println("The animals are not happy, you should watch them...");
        else
            System.out.println("The animals are very happy, keep working hard...");
        System.out.println("Hunger level: "+hunger);
        if (hunger > 3)
            System.out.println("The animals are hungry, you should feed them...");


    }

    /**
     * lowers the hunger level by one and informs the observers
      */
    public void feedAnimals() {
        if(hunger>1)
        hunger = hunger - 1;
        for (Animal animal : animals) {
            animal.eat();
        }
        System.out.println("Notifying observers:");
        for (Observer observer : observers) {
            observer.update("The animals are being fed");
        }
    }

    /**
     * adds an animal to the zoo and informs the observers
     * @param animal an animal to add
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
        String animalType = animal.getClass().getName();
        animalTypes.add(animalType);
        System.out.println("Notifying observers:");
        for (Observer observer : observers) {
            observer.update(animalType + " has been added to the zoo!");
        }

    }

    /**
     * adds an observer to the zoo
     * @param observer an observer to add
     */
    public void addObserver(ZooObserver observer) {
        observers.add(observer);
    }

    /**
     * removes an observer from the zoo
     * @param observer an observer to remove
     */
    public void removeObserver(ZooObserver observer) {
        observers.remove(observer);
    }

    /**
     * raises happiness and hunger level and informs the observers
     */
    public void watchAnimals() {
        if(happiness<5)
        happiness = happiness + 1;
        if(hunger<5)
        hunger = hunger + 1;
        for (Animal animal : animals) {
            animal.perform();
        }
        System.out.println("Notifying observers:");
        for (Observer observer : observers) {
            observer.update("The animals are being watched");
        }
    }
}
