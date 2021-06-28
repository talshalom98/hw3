import java.util.ArrayList;
import java.util.HashSet;

public class Zoo {
    private static Zoo instance = null;
    int happiness;
    int hunger;
    ArrayList<Animal> animals;
    ArrayList<ZooObserver> observers;
    HashSet<String> animalTypes;


    private Zoo() {
        /**
         * creates a singleton style instance of a zoo
         */
        hunger = 3;
        happiness = 2;
        animals = new ArrayList<>();
        observers = new ArrayList<>();
        animalTypes = new HashSet<>();

    }


    public int numOfAnimals(String type){
        /**
         *
         * @param type is a type of an animal
         * @return the number of animals that there type is in the zoo
         */
        int count = 0;
        for(Animal animal : animals){
            String animalType = animal.getClass().getName();
            if (animalType.equals(type))
                count++;
        }
        return count;


    }


    public static Zoo getInstance() {
        /**
         * makes sure the user can create only one zoo
         * @return the instance of the one and only zoo
         */
        if (instance == null) {
            instance = new Zoo();
            System.out.println("Creating zoo...");
        }
        else
        System.out.println("The zoo already exists...");
        return instance;
    }


    public void AnimalsInfo() {
        /**
         * prints the current status of the zoo
         */
        System.out.println("The zoo contains total of " + animals.size() + " animals:");
        for (String animalType : animalTypes){
            System.out.println("- "+animalType+": "+numOfAnimals(animalType));
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


    public void feedAnimals() {
        /**
         * lowers the hunger level by one and informs the observers
         */
        if(hunger>1)
        hunger--;
        for (Animal animal : animals) {
            animal.eat();
        }
        System.out.println("Notifying observers:");
        for (Observer observer : observers) {
            observer.update("The animals are being fed");
        }
    }


    public void addAnimal(Animal animal) {
        /**
         * adds an animal to the zoo and informs the observers
         * @param animal an animal to add
         */
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


    public void watchAnimals() {
        /**
         * raises happiness and hunger level and informs the observers
         */
        if(happiness<5)
        happiness++;
        if(hunger<5)
        hunger++;
        for (Animal animal : animals) {
            animal.perform();
        }
        System.out.println("Notifying observers:");
        for (Observer observer : observers) {
            observer.update("The animals are being watched");
        }
    }
}
