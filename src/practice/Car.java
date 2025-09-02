package practice;


class Engine {
    void start () {
        System.out.println("Start");
    }
}


public class Car {
    // The Car is LOOSELY COUPLED. It depends on the Engine interface, not a concrete class.
    private Engine engine;

    // DEPENDENCY INJECTION via Constructor
    // "Give me any kind of Engine that meets the contract, I don't care which one."
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public static void main(String[] args) {

    }
}



