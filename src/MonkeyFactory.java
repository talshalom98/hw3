public class MonkeyFactory extends AnimalFactory {
    @Override
    /**
     * creates an instance of a monkey
     */
    public Animal createAnimal() {
        return new Monkey();
    }
}