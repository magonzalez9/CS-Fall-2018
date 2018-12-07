package dragrace;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RaceFrame extends javax.swing.JFrame {

    DisplayRace displayRace;
    CarFreeList freeList = new CarFreeList();
    CarList carList = new CarList();
    RacerAI AIRacer;
    int i;
    int max_stats = 25;

    public RaceFrame() {
        initComponents();
        setVisible(true);
        setSize(930, 400);
        displayRace = new DisplayRace();

        // set slider values
        speedSlider.setMinimum(1);
        speedSlider.setMaximum(10);
        speedSlider.setValue(1);
        accSlider.setMinimum(1);
        accSlider.setMaximum(10);
        accSlider.setValue(1);
        nitroSlider.setMinimum(1);
        nitroSlider.setMaximum(10);
        nitroSlider.setValue(1);
        distanceSlider.setMinimum(1);
        distanceSlider.setMaximum(100);
        distanceSlider.setValue(1);
        comboBox.removeAllItems();
        //distanceSlider.setEnabled(false);
        populationField.setText("10");
        crossoverField.setText("2");
        muRateField.setText(".001");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        goButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox();
        speedSlider = new javax.swing.JSlider();
        addButton = new javax.swing.JButton();
        list_label = new javax.swing.JLabel();
        accSlider = new javax.swing.JSlider();
        nitroSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        accLabel = new javax.swing.JLabel();
        nitroLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        distanceSlider = new javax.swing.JSlider();
        saveButton = new javax.swing.JButton();
        milesLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        statsLabel = new javax.swing.JLabel();
        AIRACER = new javax.swing.JLabel();
        populationField = new javax.swing.JTextField();
        populationLabel = new javax.swing.JLabel();
        crossoverField = new javax.swing.JTextField();
        cOverLabel = new javax.swing.JLabel();
        muRateField = new javax.swing.JTextField();
        muLabel = new javax.swing.JLabel();
        popLabel = new javax.swing.JLabel();
        trainButton = new javax.swing.JButton();
        addAIButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        goButton.setBackground(new java.awt.Color(0, 255, 0));
        goButton.setForeground(new java.awt.Color(0, 153, 0));
        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goButton);
        goButton.setBounds(440, 210, 100, 30);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(comboBox);
        comboBox.setBounds(350, 80, 170, 30);

        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });
        speedSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                speedSliderMousePressed(evt);
            }
        });
        getContentPane().add(speedSlider);
        speedSlider.setBounds(30, 70, 190, 20);

        addButton.setText("Add Car");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(350, 120, 80, 30);

        list_label.setText("Edit Race Car");
        getContentPane().add(list_label);
        list_label.setBounds(400, 50, 110, 20);

        accSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                accSliderStateChanged(evt);
            }
        });
        getContentPane().add(accSlider);
        accSlider.setBounds(30, 140, 190, 30);

        nitroSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nitroSliderStateChanged(evt);
            }
        });
        getContentPane().add(nitroSlider);
        nitroSlider.setBounds(30, 200, 190, 26);

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel2.setText("Race Car Simulation 2.0");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 0, 250, 40);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setText("Top Speed:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 40, 110, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setText("Acceleration:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 100, 110, 40);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setText("Boost:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 170, 110, 30);

        speedLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        speedLabel.setText("10");
        getContentPane().add(speedLabel);
        speedLabel.setBounds(230, 60, 30, 40);

        accLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        accLabel.setText("10");
        getContentPane().add(accLabel);
        accLabel.setBounds(230, 130, 50, 40);

        nitroLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        nitroLabel.setText("10");
        getContentPane().add(nitroLabel);
        nitroLabel.setBounds(230, 190, 50, 50);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 210, 110, 30);

        distanceSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                distanceSliderStateChanged(evt);
            }
        });
        getContentPane().add(distanceSlider);
        distanceSlider.setBounds(30, 260, 150, 26);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(440, 120, 80, 30);

        milesLabel.setText("miles");
        getContentPane().add(milesLabel);
        milesLabel.setBounds(190, 250, 70, 40);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel8.setText("Track Length:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 230, 110, 30);

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(600, 70, 290, 110);

        statsLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        statsLabel.setText("4");
        getContentPane().add(statsLabel);
        statsLabel.setBounds(200, 300, 60, 30);

        AIRACER.setText("AI Racer");
        getContentPane().add(AIRACER);
        AIRACER.setBounds(720, 40, 90, 40);

        populationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populationFieldActionPerformed(evt);
            }
        });
        getContentPane().add(populationField);
        populationField.setBounds(620, 100, 70, 20);

        populationLabel.setText("Population");
        getContentPane().add(populationLabel);
        populationLabel.setBounds(620, 80, 70, 14);

        crossoverField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crossoverFieldActionPerformed(evt);
            }
        });
        getContentPane().add(crossoverField);
        crossoverField.setBounds(710, 100, 70, 20);

        cOverLabel.setText("Crossover");
        getContentPane().add(cOverLabel);
        cOverLabel.setBounds(710, 80, 70, 14);

        muRateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muRateFieldActionPerformed(evt);
            }
        });
        getContentPane().add(muRateField);
        muRateField.setBounds(800, 100, 70, 20);

        muLabel.setText("MU Rate");
        getContentPane().add(muLabel);
        muLabel.setBounds(800, 80, 70, 14);

        popLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(popLabel);
        popLabel.setBounds(320, 70, 220, 110);

        trainButton.setText("Train");
        trainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainButtonActionPerformed(evt);
            }
        });
        getContentPane().add(trainButton);
        trainButton.setBounds(650, 140, 80, 23);

        addAIButton.setText("Add");
        addAIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAIButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addAIButton);
        addAIButton.setBounds(760, 140, 70, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        displayRace.go();
    }//GEN-LAST:event_goButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Get car infomation
        String car_name = JOptionPane.showInputDialog("Please input the name of the car: ");
        int speed = speedSlider.getValue();
        int acceleration = accSlider.getValue();
        int nitro = nitroSlider.getValue();

        // Create the car object and store it in CarFreeList
        ImageIcon car_image = new ImageIcon(new ImageIcon(getClass().getResource("images/" + freeList.remove(0))).getImage());
        RaceCar race_car = new RaceCar(car_name, speed, acceleration, nitro, car_image);
        race_car.setDistance(distanceSlider.getValue());

        // Now we want to draw the car on the panel
        carList.add(race_car);
        displayRace.addCar(race_car);

        // Combo box
        comboBox.addItem(race_car.getCarName());
        //enable trackLength
        distanceSlider.setEnabled(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void speedSliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speedSliderMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_speedSliderMousePressed

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        speedLabel.setText("" + speedSlider.getValue());
        max_stats = speedSlider.getValue() + accSlider.getValue() + nitroSlider.getValue();
        statsLabel.setText("" + max_stats + "/ 16");

        if (max_stats > 16) {
            saveButton.setEnabled(false);
            addButton.setEnabled(false);
        } else {
            saveButton.setEnabled(true);
            addButton.setEnabled(true);
        }
    }//GEN-LAST:event_speedSliderStateChanged

    private void accSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_accSliderStateChanged
        accLabel.setText("" + accSlider.getValue());
        max_stats = speedSlider.getValue() + accSlider.getValue() + nitroSlider.getValue();
        statsLabel.setText("" + max_stats + "/ 16");
        if (max_stats > 16) {
            saveButton.setEnabled(false);
            addButton.setEnabled(false);
        } else {
            saveButton.setEnabled(true);
            addButton.setEnabled(true);
        }
    }//GEN-LAST:event_accSliderStateChanged

    private void nitroSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nitroSliderStateChanged
        nitroLabel.setText("" + nitroSlider.getValue());
        max_stats = speedSlider.getValue() + accSlider.getValue() + nitroSlider.getValue();
        statsLabel.setText("" + max_stats + "/ 16");
        if (max_stats > 16) {
            saveButton.setEnabled(false);
            addButton.setEnabled(false);
        } else {
            saveButton.setEnabled(true);
            addButton.setEnabled(true);
        }
    }//GEN-LAST:event_nitroSliderStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        displayRace.reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void distanceSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_distanceSliderStateChanged

        milesLabel.setText(Math.round((((distanceSlider.getValue() - 1) * (8000 - 91.4) / (100 - 1) + 91.4) * 0.000621371192) * 100.0) / 100.0 + " Mile(s)");

        if (distanceSlider.getValue() >= 15) {

        }
        if (carList.size() >= 1) {
            carList.get(0).setDistance(distanceSlider.getValue());
//             System.out.println(" DISTANCE: " + carList.get(0).getTrackDistance());
        }
        if (carList.size() >= 2) {
            carList.get(1).setDistance(distanceSlider.getValue());
//             System.out.println(" DISTANCE: " + carList.get(1).getTrackDistance());
        }
        if (carList.size() >= 3) {
            carList.get(2).setDistance(distanceSlider.getValue());
//             System.out.println(" DISTANCE: " + carList.get(2).getTrackDistance());
        }
        if (carList.size() >= 4) {
            carList.get(3).setDistance(distanceSlider.getValue());
//             System.out.println(" DISTANCE: " + carList.get(3).getTrackDistance());
        }
        if (carList.size() >= 5) {
            carList.get(4).setDistance(distanceSlider.getValue());
//            System.out.println(" DISTANCE: " + carList.get(4).getTrackDistance());
        }
    }//GEN-LAST:event_distanceSliderStateChanged

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (comboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "There are no cars added yet!");
        } else {
            int speed = speedSlider.getValue();
            int acceleration = accSlider.getValue();
            int nitro = nitroSlider.getValue();

            carList.get(i).editRaceCar(speed, acceleration, nitro);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        i = comboBox.getSelectedIndex();
        if (!carList.isEmpty()) {

            speedSlider.setValue(carList.get(i).speed_value);
            accSlider.setValue(carList.get(i).acceleration_value);
            nitroSlider.setValue(carList.get(i).nitro_value);
        }
    }//GEN-LAST:event_comboBoxActionPerformed

    private void populationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_populationFieldActionPerformed

    private void crossoverFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crossoverFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crossoverFieldActionPerformed

    private void muRateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muRateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_muRateFieldActionPerformed

    private void trainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainButtonActionPerformed
        int population = Integer.parseInt(populationField.getText());
        int crossOver = Integer.parseInt(crossoverField.getText());
        double muRate = Double.parseDouble(muRateField.getText());

        Trainer t = new Trainer(population, crossOver, muRate, distanceSlider.getValue());
        t.train();
        AIRacer = t.getBestRacer();
    }//GEN-LAST:event_trainButtonActionPerformed

    private void addAIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAIButtonActionPerformed
        // Get car infomation
        String car_name = JOptionPane.showInputDialog("Please input the name of the car: ");
        int speed = AIRacer.getSpeed();
        int acceleration = AIRacer.getAcceleration();
        int nitro = AIRacer.getNos();

        speedSlider.setValue(speed);
        speedLabel.setText("" + speedSlider.getValue());
        accSlider.setValue(acceleration);
        accLabel.setText("" + accSlider.getValue());
        nitroSlider.setValue(nitro);
        nitroLabel.setText("" + nitroSlider.getValue());

        // Create the car object and store it in CarFreeList
        ImageIcon car_image = new ImageIcon(new ImageIcon(getClass().getResource("images/" + freeList.remove(0))).getImage());
        RaceCar race_car = new RaceCar(car_name, speed, acceleration, nitro, car_image);
        race_car.setDistance(distanceSlider.getValue());

        // Now we want to draw the car on the panel
        carList.add(race_car);
        displayRace.addCar(race_car);

        // Combo box
        comboBox.addItem(race_car.getCarName());
        //enable trackLength
        distanceSlider.setEnabled(true);
    }//GEN-LAST:event_addAIButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RaceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AIRACER;
    private javax.swing.JLabel accLabel;
    private javax.swing.JSlider accSlider;
    private javax.swing.JButton addAIButton;
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel cOverLabel;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JTextField crossoverField;
    private javax.swing.JSlider distanceSlider;
    private javax.swing.JButton goButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel list_label;
    private javax.swing.JLabel milesLabel;
    private javax.swing.JLabel muLabel;
    private javax.swing.JTextField muRateField;
    private javax.swing.JLabel nitroLabel;
    private javax.swing.JSlider nitroSlider;
    private javax.swing.JLabel popLabel;
    private javax.swing.JTextField populationField;
    private javax.swing.JLabel populationLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JLabel statsLabel;
    private javax.swing.JButton trainButton;
    // End of variables declaration//GEN-END:variables

}
