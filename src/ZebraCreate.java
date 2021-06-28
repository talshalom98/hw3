public class ZebraCreate extends CreateAnimal {
    @Override
    /**
     * creates a zebra
     */
    public Animal createAnimal() {
        return new Zebra();
    }
}
