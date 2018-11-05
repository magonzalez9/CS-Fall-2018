/*
 * acceleration = meters per second^2
 * speed = distance / time
 * time = distance / speed; 
 * distance = speed * time; 
 */
package dragrace;

import javax.swing.ImageIcon;

public class RaceCar {

    // Helper temp variables 
    private boolean use_nos = false;
    private int nos_time;
    private int nos_time_placeholder;
    private double nos_temp;
    private double acc_temp;
    private double fuel_temp;

    // Car statistics
    private final String name;
    private final ImageIcon image;
    private double top_speed;
    private double acceleration;
    private double nitro;
    private double fuel;

    private double engine_power;
    private double track_distance;

    // Stats while moving
    private double distance_traveled = 0;
    private double current_speed;

    // int values
    public int speed_value;
    public int acceleration_value;
    public int nitro_value;
    public int fuel_value;

    public RaceCar(String name, int speed, int acceleration, double nitro, double fuel, int engine_size, ImageIcon image) {
        // Set car identification 
        this.name = name;
        this.image = image;

        // Set the engine size 
        this.editRaceCar(speed, acceleration, nitro, fuel, engine_size);

        // Set slider values
        speed_value = speed;
        acceleration_value = acceleration;
        nitro_value = (int) nitro;
        fuel_value = (int) fuel;

    }

    public void setDistance(int distance) {
        track_distance = (distance - 1) * (8000 - 91.44) / (100 - 1) + 91.44;
    }

    public void activateNOS() {
        use_nos = true;
    }

    public double getTrackDistance() {
        return track_distance;
    }

    public double getDistanceTraveled() {
        return distance_traveled;
    }

    public ImageIcon getCarImage() {
        return this.image;
    }

    public String getCarName() {
        return this.name;
    }

    public double getFuel() {
        return fuel;
    }

    // Main method that moves the car based on the stats that where entered!
    public double run() {
        if (!(fuel <= 0)) {

            if (use_nos) {
                if (!(current_speed >= top_speed) && nos_time >= 0) {
                    current_speed += acceleration + nitro;

                } else if ((current_speed >= top_speed) && nos_time >= 0) {
                    current_speed = top_speed + nitro;
                    nitro += nos_temp;
                }
                nos_time--;

                if (nos_time <= 0 && current_speed >= top_speed) {
                    current_speed -= 2;
                } else {
                    use_nos = false;
                    current_speed = top_speed;
                }
            } else {
                // Run normally
                if (!(current_speed >= top_speed)) {
                    current_speed += acceleration;
                } else {
                    current_speed = top_speed;
                }
            }
            fuel -= ((current_speed * 0.44704) * ((current_speed * 0.44704) / track_distance)) + (engine_power * 2) + (acceleration * .1) + (nitro) + (top_speed * .004);
            
        } else {
            // Out of fuel... you're done buddy. 
            current_speed -= .5;
            if (current_speed <= 0) {
                current_speed = 0;
            }
        }

        // if car has crossed the finish line, then deccelerate
        // else keep going!
        return distance_traveled += ((current_speed * 0.44704) * ((current_speed * 0.44704) / track_distance));  // distance = meters per second
    }

    public void editRaceCar(int speed, int acceleration, double nitro, double fuel, int engine_size) {
        // Set the engine size 
        switch (engine_size) {
            case 4:
                engine_power = .5;
                break;
            case 6:
                engine_power = 1;
                break;
            case 8:
                engine_power = 2.5;
                break;
            default:
                engine_power = .5;
                break;
        }

        // Set car stats variables
        this.top_speed = (double) ((speed - 1) * (200 - 145) / (10 - 1) + 145); // mph
        this.acceleration = ((double) (60 / ((acceleration - 1) * (3 - 8) / (10 - 1) + 8))) + engine_power;
        this.fuel = (fuel - 1) * (25000 - 8000) / (10 - 1) + 8000;
        this.nitro = (nitro * .5) + engine_power;
        this.nos_time = (int) (((nitro - 1) * (18 - 9) / (10 - 1) + 7));

        // Set all temp variables
        acc_temp = ((double) (60 / ((acceleration - 1) * (3 - 8) / (10 - 1) + 8))) + engine_power;
        nos_temp = (nitro * .5) + engine_power;
        nos_time_placeholder = this.nos_time;
        fuel_temp = (fuel - 1) * (25000 - 8000) / (10 - 1) + 8000;

        // Set slider values
        speed_value = speed;
        acceleration_value = acceleration;
        nitro_value = (int) nitro;
        fuel_value = (int) fuel;
    }

    public void reset() {
        distance_traveled = 0;
        current_speed = 0;
        nos_time = nos_time_placeholder;
        nitro = nos_temp;
        acceleration = acc_temp;
        use_nos = false;
        fuel = fuel_temp;

    }

    @Override
    public String toString() {
        return "RaceCar{" + "name=" + name + "," + ", top_speed=" + top_speed + ", acceleration=" + acceleration + ", nitro ="
                + nitro + ", fuel=" + fuel + ", engine_power=" + engine_power + ", current dis=" + distance_traveled + " nos_time = " + nos_time + "}";
    }
}
