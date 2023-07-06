
// Application should be persistent and not like brute force if else are added
// It should be scalable , consistent and persistent

// Change its state --> change in behaviours
// Each state has its own class
// state.handle() has its own responsibility
// on change of state it is directly
// Object is changing its class as its changing the state

interface State {

    // which will handle the request
    public void handleState();
}

class Handling_Emojis implements State {
    public void handleState() {
        // TODO: if curr state knows may the next state
        System.out.println("Handling State 1 Handling Emojis 😀 -- Please go to State 2");
    }
}

class Music implements State {
    public void handleState() {
        System.out.println("Handling State 2 Music 🎵🎶 -- Please go to State 3");
    }
}

class Airplane_Mode implements State {
    public void handleState() {
        System.out.println("Handling State 3 Airplane Mode ✈️ -- Please go to State 4");
    }
}

class Context {
    State st;

    public Context(State s) {
        st = s;
    }

    public void setState(State s) {
        st = s;
    }

    public State getState(State s) {
        return st;
    }

    public void performAction() {
        st.handleState();
    }
}

public class StateDP {

    public static void main(String[] args) {

        // One initial state is required
        State s1 = new Handling_Emojis();
        State s2 = new Music();
        State s3 = new Airplane_Mode();

        Context c1 = new Context(s2);
        c1.performAction();

        c1.setState(s3);
        c1.performAction();
    }
}
