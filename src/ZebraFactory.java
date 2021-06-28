public class ZebraFactory extends AnimalFactory {
    @Override
    /**
     * creates an instance of a zebra
     */
    public Animal createAnimal() {
        return new Zebra();
    }
}
