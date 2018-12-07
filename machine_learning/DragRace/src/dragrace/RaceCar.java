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
    private double top_speed_temp;

    // Car statistics
    private final String name;
    private final ImageIcon image;
    private double top_speed;
    private double acceleration;
    private double nitro;

    private double track_distance;

    // Stats while moving
    private double distance_traveled = 0;
    private double current_speed;

    // int values
    public int speed_value;
    public int acceleration_value;
    public int nitro_value;

    public RaceCar(String name, int speed, int acceleration, double nitro, ImageIcon image) {
        // Set car identification 
        this.name = name;
        this.image = image;

        // edit the race car
        this.editRaceCar(speed, acceleration, nitro);

        // Set slider values
        speed_value = speed;
        acceleration_value = acceleration;
        nitro_value = (int) nitro;

    }

    public void setDistance(int distance) {
        track_distance = (distance - 1) * (8000 - 91.44) / (100 - 1) + 91.44; // meters
    }

    public void activateNOS() {
        use_nos = true;
    }

    public double getTop_speed() {
        return top_speed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getNitro() {
        return nitro;
    }

    public double getDistance() {
        return track_distance;
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

    // Main method that moves the car based on the stats that where entered!
    public double run() {

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

        // if car has crossed the finish line, then deccelerate
        // else keep going!
        return distance_traveled += ((current_speed * 0.44704) * ((current_speed * 0.44704) / track_distance));  // distance = meters per second
    }

    public void editRaceCar(int speed, int acceleration, double nitro) {

        // Set car stats variables
        this.top_speed = (double) ((speed - 1) * (160 - 125) / (10 - 1) + 140); // mph
        this.acceleration = ((double) (60 / ((acceleration - 1) * (4 - 9.5) / (10 - 1) + 9.5)));
        this.nitro = (nitro * .7);
        this.nos_time = (int) (((nitro - 1) * (35 - 10) / (10 - 1) + 10));

        // Set all temp variables
        top_speed_temp = (double) ((speed - 1) * (160 - 125) / (10 - 1) + 140);
        acc_temp = ((double) (60 / ((acceleration - 1) * (4 - 9.5) / (10 - 1) + 9.5)));
        nos_temp = (nitro * .7);
        nos_time_placeholder = this.nos_time;

        // Set slider values
        speed_value = speed;
        acceleration_value = acceleration;
        nitro_value = (int) nitro;
    }

    public void reset() {
        distance_traveled = 0;
        current_speed = 0;
        nos_time = nos_time_placeholder;
        nitro = nos_temp;
        acceleration = acc_temp;
        top_speed = top_speed_temp;
        use_nos = false;

    }

    @Override
    public String toString() {
        return "RaceCar{" + "name=" + name + "," + ", top_speed=" + top_speed + ", acceleration=" + acceleration + ", nitro ="
                + nitro + ", current dis=" + distance_traveled + " nos_time = " + nos_time + "}";
    }
}
