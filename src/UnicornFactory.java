public class UnicornFactory extends AnimalFactory {
    @Override
    /**
     * creates an instance of a unicorn
      */
    public Animal createAnimal() {
        return new Unicorn();
    }
}