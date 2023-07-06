/*
       * subject and ovservers make a lousely coupled system.
       * We can undependently add or remoce observers at any time
       * 
       * Subject :- Change the state
       * Subscriber :- Adding Number of liist of fans
       * Unsubscribe also available
       * When state of subject is changed , all the respectuve objets shoud be changed
       * automatically.
       * JAVA GUI Event listener works the same way
       * attach , detach --> subscribe , unsubscribe
       * Notify --> internally calls the update method
       */

import java.util.*;

class SubjectEntity {

    private int numberState;

    public int getNumberState() {
        return numberState;
    }

    public void setNumberState(int numberState) {
        this.numberState = numberState;
        // changing the number , when subject is going to change its state
        notifyAllObservers();
    }

    private List<ObserverEntity> ls = new ArrayList<ObserverEntity>();

    public void registerObserver(ObserverEntity oe) {
        ls.add(oe);
    }

    public void unregisterObserver(ObserverEntity oe) {
        ls.remove(oe);
    }

    // keeps one integer
    public void notifyAllObservers() {
        for (ObserverEntity oe : ls) {
            oe.update();
        }
    }
}

// Binary , Hex, Octal Representations
// 3 Different Representations

abstract class ObserverEntity {

    // reference of Subject Entity
    SubjectEntity se;

    abstract public void update();
}

class BinaryObserverEntity extends ObserverEntity {
    public BinaryObserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberState();
        // getting the state from the SubjectEntity
        System.out.println("Subject Entity has changed the state");

        System.out.println("Representation Number : " + n + " to Binary : " + Integer.toBinaryString(n));
    }
}

class HexObserverEntity extends ObserverEntity {
    public HexObserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberState();
        // getting the state from the SubjectEntity
        System.out.println("Subject Entity has changed the state");
        System.out.println("Representation Number : " + n + " to Hex : " + Integer.toHexString(n));
    }
}

class OctalObserverEntity extends ObserverEntity {
    public OctalObserverEntity(SubjectEntity e) {
        se = e;
    }

    public void update() {
        int n = se.getNumberState();
        // getting the state from the SubjectEntity
        System.out.println("Subject Entity has changed the state");
        System.out.println("Representation Number : " + n + " to Octal : " + Integer.toOctalString(n));
    }
}

public class Obs {
    public static void main(String[] args) {

        // Creating the Subject Entity
        SubjectEntity se = new SubjectEntity();

        // Two Observers
        ObserverEntity o1 = new BinaryObserverEntity(se);
        ObserverEntity o2 = new HexObserverEntity(se);
        ObserverEntity o3 = new OctalObserverEntity(se);

        se.registerObserver(o1);
        se.setNumberState(12);

        se.registerObserver(o2);
        se.setNumberState(10);

        se.registerObserver(o3);
        se.setNumberState(11);
    }
}
