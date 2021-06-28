public class UnicornCreate extends CreateAnimal {
    @Override
    /**
     * creates an unicorn
      */
    public Animal createAnimal() {
        return new Unicorn();
    }
}