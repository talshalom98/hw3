public class MonkeyCreate extends CreateAnimal {
    @Override
    /**
     * creates monkey
     */
    public Animal createAnimal() {
        return new Monkey();
    }
}