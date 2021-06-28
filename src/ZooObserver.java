public class ZooObserver implements Observer {
    /**
     * informs the observer
      * @param info is the update from the zoo
     */
    public void update(String info) {
        System.out.println("["+name+"] "+info);
    }

    String name;

    ZooObserver(String name) {
        this.name = name;
    }
}
