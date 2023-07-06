import java.util.ArrayList;
import java.util.List;

// MEMNTO DESIGN PATTERN
// State is Current Propertiers Value
// Storing the states of the Objects
// Machine m1 = new Machine("p1" , "p2" , "p3");

// we are reliaing on a single object and view its lifecycles at diff times
// all properties of an object are  private
// capture the snapshot of that particular state

// Originator --> where THE STATE IS COMING FOR
// Memento --> MEMENTO Itself which will have the steps to  restore the objects
// Care Taker --> taken the snaps , ( same as List of snapshots )

class OriginatorObject {
    private int temperature;
    private int volume;

    public OriginatorObject(int t, int v) {
        temperature = t;
        volume = v;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public MementoObject saveObjectState() {
        return new MementoObject(temperature, volume);
    }

    public void restoreOriginatorObjectState(MementoObject m) {
        temperature = m.getTemperature();
        volume = m.getVolume();
    }

    public void operateMachine() {
        System.out.println("Machine has temperatures as " + temperature + " and Volume is : " + volume);
    }
}

class MementoObject {
    private int temperature;
    private int volume;

    public MementoObject(int t, int v) {
        temperature = t;
        volume = v;
    }

    /// will never come up with Setter Method
    public int getTemperature() {
        return temperature;
    }

    public int getVolume() {
        return volume;
    }
}

class CareTaker {
    // presereves the states of the Mementos
    List<MementoObject> m1 = new ArrayList<MementoObject>();

    public void addMementoObject(MementoObject m) {
        m1.add(m);
    }

    public MementoObject getMementoObject(int i) {
        return m1.get(i);
    }
}

public class Memento {
    public static void main(String[] args) {
        OriginatorObject o1 = new OriginatorObject(20, 10);
        MementoObject temp = o1.saveObjectState();
        o1.operateMachine();
        o1.setTemperature(21);
        o1.setVolume(33);

        CareTaker c = new CareTaker();
        c.addMementoObject(temp);

        o1.restoreOriginatorObjectState(c.getMementoObject(0));
        o1.operateMachine();
    }
}
