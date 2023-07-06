
class vehicleFactory {

    Vehicle createVehicle(String ride) {
        if (ride.toLowerCase().equals("car")) {
            return new car();
        }

        else if (ride.toLowerCase().equals("auto")) {
            return new auto();
        } else if (ride.toLowerCase().equals("bike")) {
            return new bike();
        }

        else {
            return null;
        }
    }
}

// Rental Auto Bookingn
// Car Booking Requirements come in
// charge/km
// To and From location
// Add layer of abstraction and not only for Auto
// Book a ride for a kind for vehicle and provide the type (car ,rickshaw )

// Factory --> Produce Something
// Retutns the required obj --> ride by car ,rode by auto
// Seperate Responsibility , we are not exposing
// super class has to be ABSTRACT CLASS ( INterface )
// fixed charge and per/km price
// single point of creation

interface Vehicle {
    public int getFixedCharge();

    public int getPerKMCharge();
}

class auto implements Vehicle {
    @Override
    public int getFixedCharge() {
        return 50;
    }

    @Override
    public int getPerKMCharge() {
        return 15;
    }
}

class car implements Vehicle {
    @Override
    public int getFixedCharge() {
        return 60;
    }

    @Override
    public int getPerKMCharge() {
        return 20;
    }

}

class bike implements Vehicle {
    @Override
    public int getFixedCharge() {
        return 10;
    }

    @Override
    public int getPerKMCharge() {
        return 20;
    }

}

public class Factory {
    public static void main(String[] args) {
        vehicleFactory v = new vehicleFactory();

        System.out.println("Fixed Charge of Entered Vehicle is " + v.createVehicle("car").getFixedCharge());
        System.out.println("Fixed Per KM Charge of Entered Vehicle is " + v.createVehicle("car").getPerKMCharge());
    }
}