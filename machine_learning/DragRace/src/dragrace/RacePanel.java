package dragrace;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class RacePanel extends javax.swing.JPanel {

    boolean flag_1 = false;
    boolean print_1 = true;

    boolean flag_2 = false;
    boolean print_2 = true;

    boolean flag_3 = false;
    boolean print_3 = true;

    boolean flag_4 = false;
    boolean print_4 = true;

    boolean flag_5 = false;
    boolean print_5 = true;

    static CarList car_list = new CarList();
    Graphics g;

    public RacePanel() {
        initComponents();
        setLayout(null);
        setVisible(true);
        setSize(500, 500);

        // set Controller
        Controller c = new Controller(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }

        super.paintComponent(g);

        // Draw the car as the user adds them
        ImageIcon racetrack = new ImageIcon(new ImageIcon(getClass().getResource("racetrack.png")).getImage());
        g.drawImage(racetrack.getImage(), 0, 0, null);
        drawCar(g);

    }

    // Draw cars as the user adds them
    void drawCar(Graphics g) {
        if (car_list.size() >= 1) {
            if (car_list.get(0).getDistanceTraveled() == 0) {
                flag_1 = false;
                print_1 = true;

                flag_2 = false;
                print_2 = true;

                flag_3 = false;
                print_3 = true;

                flag_4 = false;
                print_4 = true;

                flag_5 = false;
                print_5 = true;
            }
            g.drawImage(car_list.get(0).getCarImage().getImage(), (int) car_list.get(0).getDistanceTraveled(), 20, 60, 30, null);
            if (car_list.get(0).getDistanceTraveled() >= 1055) {
                flag_1 = true;
                if (flag_1 && print_1) {
                    if (car_list.get(0).getDistanceTraveled() >= 1055) {
                        System.out.println(car_list.get(0).getCarName());
                    }
                    print_1 = false;
                }

            }
        }
        if (car_list.size() >= 2) {
            boolean finish_flag = false;
            g.drawImage(car_list.get(1).getCarImage().getImage(), (int) car_list.get(1).getDistanceTraveled(), 80, 60, 30, null);
            if (car_list.get(1).getDistanceTraveled() >= 1055) {
                flag_2 = true;
                if (flag_2 && print_2) {
                    if (car_list.get(1).getDistanceTraveled() >= 1055) {
                        System.out.println(car_list.get(1).getCarName());
                    }
                    print_2 = false;
                }
            }
        }
        if (car_list.size() >= 3) {

            g.drawImage(car_list.get(2).getCarImage().getImage(), (int) car_list.get(2).getDistanceTraveled(), 140, 60, 30, null);
            if (car_list.get(2).getDistanceTraveled() >= 1055) {
                flag_3 = true;
                if (flag_3 && print_3) {
                    if (car_list.get(2).getDistanceTraveled() >= 1055) {
                        System.out.println(car_list.get(2).getCarName());
                    }
                    print_3 = false;
                }
            }
        }
        if (car_list.size() >= 4) {

            g.drawImage(car_list.get(3).getCarImage().getImage(), (int) car_list.get(3).getDistanceTraveled(), 200, 60, 30, null);
            if (car_list.get(3).getDistanceTraveled() >= 1055) {
                flag_4 = true;
                if (flag_4 && print_4) {
                    if (car_list.get(3).getDistanceTraveled() >= 1055) {
                        System.out.println(car_list.get(3).getCarName());
                    }
                    print_4 = false;
                }
            }
        }
        if (car_list.size() >= 5) {
            g.drawImage(car_list.get(4).getCarImage().getImage(), (int) car_list.get(4).getDistanceTraveled(), 260, 60, 30, null);
            if (car_list.get(4).getDistanceTraveled() >= 1055) {
                flag_5 = true;
                if (flag_5 && print_5) {
                    if (car_list.get(4).getDistanceTraveled() >= 1055) {
                        System.out.println(car_list.get(4).getCarName());
                    }
                    print_5 = false;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    void go() {
        if (car_list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no cars added to the track!");
        } else {
            Controller.setCarList(car_list);
            Controller.move();
        }

    }

    void addCar(RaceCar car) {
        car_list.addCar(car);

//        System.out.println("Car TOSTRING: " + car_list.get(0).toString());
    }

    void toggle() {
        Controller.toggleRunning();
    }

    void reset() {
        for (int i = 0; i < car_list.size(); i++) {
            car_list.get(i).reset();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
