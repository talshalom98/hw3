public class MonkeyFactory extends AnimalFactory {
    @Override
    /**
     * creates monkey
     */
    public Animal createAnimal() {
        return new Monkey();
    }
}