public class ZebraFactory extends AnimalFactory {
    @Override
    /**
     * creates a zebra
     */
    public Animal createAnimal() {
        return new Zebra();
    }
}
