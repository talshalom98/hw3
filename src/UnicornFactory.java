public class UnicornFactory extends AnimalFactory {
    @Override
    /**
     * creates an unicorn
      */
    public Animal createAnimal() {
        return new Unicorn();
    }
}