package firstweekexercise.cargamesample;

public class GameCar extends AbstractGameCar {

    public GameCar() {
        this.maxSpeed = 10;
        this.color = "흰색";
    };

    public GameCar(int maxSpeed, String color) {
        setMaxSpeed(maxSpeed);
        setColor(color);
    }

    @Override
    int getMaxSpeed() {
        return this.maxSpeed;
    }
    @Override
    public void setMaxSpeed(int speed) {
        this.maxSpeed = speed;
    }

    @Override
    String getColor() {
        return this.color;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    String getSignal(String inputSignal) {
        return inputSignal;
    }

    @Override
    void interpretSignal(String signal) {
        switch (signal) {
            case "acc": {
                accelerate();
                break;
            }
            case "brk": {
                breakSlower();
                break;
            }
            case "left": {
                turnLest();
                break;
            }
            case "right": {
                turnRight();
                break;
            }
        }
    }

    // movement control
    @Override
    public void accelerate() {
        if (currentSpeed < maxSpeed) {
            this.currentSpeed++;
            System.out.printf("가속합니다 (현재속도 %d)\n", this.currentSpeed);
        } else {
            System.out.printf("최대 속도입니다. (현재속도 %d)\n", this.currentSpeed);
        }
    }

    @Override
    public void breakSlower() {
        if (currentSpeed > 0) {
            this.currentSpeed--;
            System.out.printf("감속합니다 (현재속도 %d)\n", this.currentSpeed);
        } else {
            System.out.printf("멈췄습니다. (현재속도 %d)\n", this.currentSpeed);
        }
    }

    @Override
    public void turnLest() {
        System.out.println("좌회전합니다.");
    }

    @Override
    public void turnRight() {
        System.out.println("우회전합니다.");
    }
}
