package solidprinciple.dependencyinversion;

public class DipNotAppliedSampleMain {
    public static void main(String[] args) {
        Switch mySwitch = new Switch();
        mySwitch.flip();
    }
}

class RedLight {
    public void turnOn() {
        System.out.println("Red Light turned on");
    }
}

class Switch {
    private RedLight light;

    public Switch() {
        this.light = new RedLight();
    }

    public void flip() {
        if (light != null) {
            light.turnOn();
        }
    }
}