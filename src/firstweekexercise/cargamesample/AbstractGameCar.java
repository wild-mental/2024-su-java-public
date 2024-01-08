package firstweekexercise.cargamesample;

abstract public class AbstractGameCar implements IMovementControllable, ISpecModifiable {
    int maxSpeed;
    int currentSpeed;
    String color;

    abstract int getMaxSpeed();

    abstract String getColor();

    abstract String getSignal(String inputSignal);

    abstract void interpretSignal(String signal);
}
