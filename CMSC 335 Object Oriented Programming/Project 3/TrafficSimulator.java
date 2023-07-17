
/**
 * Joel Goode - CMSC335 - Project 3
 * 4/18/23
 * The Main class is the entry point of the traffic simulation application.
 * It initializes and controls GUI components,
 * sets up traffic lights, and manages car behavior in response to traffic light signals.
 */

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficSimulator extends JFrame implements Runnable, ChangeListener {

    private static boolean proRunning;
    private boolean startRunning;
    private int carCount;
    private int lightCount;

    private Lock lock = new ReentrantLock();

    // JLabels for trafficlight, car, position and speed.
    static JLabel date = new JLabel();
    static JLabel trafficLightIconOne = new JLabel();
    static JLabel trafficLightIconTwo = new JLabel();
    static JLabel trafficLightIconThree = new JLabel();

    static JLabel carIconOne = new JLabel();
    static JLabel carIconTwo = new JLabel();
    static JLabel carIconThree = new JLabel();
    static JLabel carIconFour = new JLabel();

    static JLabel firstPosition = new JLabel();
    static JLabel secondPosition = new JLabel();
    static JLabel thirdPosition = new JLabel();
    static JLabel fourthPosition = new JLabel();

    static JLabel firstSpeed = new JLabel();
    static JLabel secondSpeed = new JLabel();
    static JLabel thirdSpeed = new JLabel();
    static JLabel fourthSpeed = new JLabel();

    // JButtons for the start/stop, pause, and add more cars/tl.
    private final JButton START = new JButton("Start");
    private final JButton STOP = new JButton("Stop");
    private final JButton PAUSE = new JButton("Pause");
    private final JButton ADD_CAR = new JButton("Add Car");
    private final JButton ADD_TRAFFIC_LIGHT = new JButton("Add Light");

    // Main thread.
    static Thread simulator;
    TrafficLight firstLight = new TrafficLight(trafficLightIconOne);
    TrafficLight secondLight = new TrafficLight(trafficLightIconTwo);
    TrafficLight thirdLight = new TrafficLight(trafficLightIconThree);
    TrafficLight[] trafficLightThreads = { firstLight, secondLight, thirdLight };

    // car threads
    Car firstCar = new Car(1, carIconOne, firstPosition, firstSpeed);
    Car secondCar = new Car(2, carIconTwo, secondPosition, secondSpeed);
    Car thirdCar = new Car(3, carIconThree, thirdPosition, thirdSpeed);
    Car fourthCar = new Car(4, carIconFour, fourthPosition, fourthSpeed);
    Car[] carThreads = { firstCar, secondCar, thirdCar, fourthCar };

    // JProgressBars showing the horizontal position of cars.
    JProgressBar firstCarProgress = new JProgressBar(0, 3000);
    JProgressBar secondCarProgress = new JProgressBar(0, 3000);
    JProgressBar thirdCarProgress = new JProgressBar(0, 3000);
    JProgressBar fourthCarProgress = new JProgressBar(0, 3000);

    // Traffic light trackers
    boolean firstLightSniffer;
    boolean secondLightSniffer;
    boolean thirdLightSniffer;

    public TrafficSimulator() {
        setSize(1200, 355);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Project 3");
        proRunning = Thread.currentThread().isAlive();
        gui();
    }

    // GUI with components and ActionListeners.
    private void gui() {
        setLayout(null);

        JLabel title = new JLabel(">> Traffic Simulator <<");
        JLabel timeLabel = new JLabel("The current time is: ");
        JLabel instructionOne = new JLabel("Click 'Start' to begin the simulation.'Pause' to pause simulation.");
        JLabel instructionTwo = new JLabel("<html>Click 'Resume', or 'Stop'.<br>Add up to (4) cars (3) lights.</html>");

        // Frame.
        add(title);
        add(instructionOne);
        add(instructionTwo);

        // Time.
        add(timeLabel);
        add(date);

        // Program control buttons.
        add(START);
        add(PAUSE);
        add(STOP);
        add(ADD_CAR);
        add(ADD_TRAFFIC_LIGHT);
        PAUSE.setEnabled(false);
        STOP.setEnabled(false);
        ADD_CAR.setEnabled(false);
        ADD_TRAFFIC_LIGHT.setEnabled(false);

        // First car.
        add(trafficLightIconOne);
        add(carIconOne);
        add(firstPosition);
        add(firstSpeed);

        // SetBounds for all the J variables.
        title.setBounds(10, 15, 225, 25);
        instructionOne.setBounds(10, 35, 400, 25);
        instructionTwo.setBounds(10, 55, 400, 25);
        timeLabel.setBounds(10, 80, 225, 25);
        date.setBounds(155, 80, 225, 25);
        START.setBounds(10, 110, 100, 25);
        PAUSE.setBounds(120, 110, 100, 25);
        ADD_CAR.setBounds(230, 110, 100, 25);
        ADD_TRAFFIC_LIGHT.setBounds(375, 110, 110, 25);
        trafficLightIconOne.setBounds(25 + 1000 / 3, 255, 10, 30);

        // Add change listeners.
        firstCarProgress.addChangeListener(this);
        secondCarProgress.addChangeListener(this);
        thirdCarProgress.addChangeListener(this);

        // START button - starts the car and light threads.
        START.addActionListener((ActionEvent e) -> {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            simulator.start();
            firstCar.start();
            firstLight.start();
            firstLightSniffer = true;
            startRunning = true;

            // Display other buttons.
            STOP.setBounds(10, 110, 100, 25);
            STOP.setEnabled(true);
            PAUSE.setEnabled(true);
            ADD_CAR.setEnabled(true);
            ADD_TRAFFIC_LIGHT.setEnabled(true);
            START.setEnabled(false);
            START.setBounds(0, 0, 0, 0);
        }); // End of start listener

        // STOP button - swaps with start button.
        STOP.addActionListener((ActionEvent e) -> {
            lock.lock();
            try {
                if (proRunning) {
                    for (Car car : carThreads) {
                        car.pause();
                    }
                    for (TrafficLight trafficLight : trafficLightThreads) {
                        trafficLight.pause();
                    }
                    startRunning = false; // stop threads
                    proRunning = false; // stop everything

                    // disable the other buttons
                    START.setEnabled(false);
                    PAUSE.setEnabled(false);
                    ADD_CAR.setEnabled(false);
                    ADD_TRAFFIC_LIGHT.setEnabled(false);
                    STOP.setText("Exit");
                } else {
                    System.exit(0);
                }
            } finally {
                lock.unlock();
            }
        }); // End of stop listener

        // PAUSE button - pauses all threads under startRunning.
        PAUSE.addActionListener((ActionEvent e) -> {
            synchronized (lock) {
                if (startRunning) {
                    for (Car car : carThreads) {
                        car.pause();
                    }
                    for (TrafficLight trafficLight : trafficLightThreads) {
                        trafficLight.pause();
                    }
                    startRunning = false;
                    PAUSE.setText("Resume");
                    lock.notifyAll();
                } else {
                    for (Car car : carThreads) {
                        if (car.paused) {
                            car.resume();
                        }
                    }
                    for (TrafficLight trafficLight : trafficLightThreads) {
                        trafficLight.resume();
                    }
                    startRunning = true;
                    PAUSE.setText("Pause");
                    lock.notifyAll();
                }
            }
        }); // End of pause listener

        // ADD_CAR listener
        ADD_CAR.addActionListener((ActionEvent e) -> {
            synchronized (lock) {
                carCount++;

                switch (carCount) {
                    case 1:
                        secondCar.start();
                        add(carIconTwo);
                        add(secondPosition);
                        add(secondSpeed);
                        ADD_CAR.setText("Add Another Car");
                        ADD_CAR.setBounds(230, 110, 135, 25);
                        lock.notifyAll();
                        break;
                    case 2:
                        thirdCar.start();
                        add(carIconThree);
                        add(thirdPosition);
                        add(thirdSpeed);
                        ADD_CAR.setEnabled(true);
                        lock.notifyAll();
                        break;
                    case 3: // on third click
                        fourthCar.start();
                        add(carIconFour);
                        add(fourthPosition);
                        add(fourthSpeed);
                        ADD_CAR.setEnabled(false);
                        lock.notifyAll();
                        break;
                }
            }

        }); // End of Add_Car listener

        // ADD_TRAFFIC_LIGHT listener
        ADD_TRAFFIC_LIGHT.addActionListener((ActionEvent e) -> {
            synchronized (lock) {
                lightCount++;

                switch (lightCount) {
                    case 1:
                        secondLight.start();
                        secondLightSniffer = true;
                        add(trafficLightIconTwo);
                        trafficLightIconTwo.setBounds(25 + 2000 / 3, 255, 10, 30);
                        ADD_TRAFFIC_LIGHT.setBounds(375, 110, 140, 25);
                        ADD_TRAFFIC_LIGHT.setText("Add Another Light");
                        lock.notifyAll();
                        break;
                    case 2:
                        thirdLight.start();
                        thirdLightSniffer = true;
                        add(trafficLightIconThree);
                        trafficLightIconThree.setBounds(25 + 3000 / 3, 255, 10, 30);
                        ADD_TRAFFIC_LIGHT.setEnabled(false);
                        lock.notifyAll();
                        break;
                }
            }

        }); // End of add_Traffic_Light listener.

    } // End gui() method.

    // run() method checks if simulator is running and sets car position.
    @Override
    public void run() {
        try {
            while (proRunning) {
                sniffer();
                TrafficSimulator.date.setText(date());
                if (startRunning) {
                    firstCarProgress.setValue(firstCar.position());
                    secondCarProgress.setValue(secondCar.position());
                    thirdCarProgress.setValue(thirdCar.position());
                    fourthCarProgress.setValue(fourthCar.position());
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred during the run method:");
            e.printStackTrace();
        }
    } // End of Run() method.

    // sniffer() Method to sniff positions of cars at lights and stop/resume cars
    public synchronized void sniffer() {
        int stoppingDistance = 3;

        lock.lock();
        try {
            for (Car car : carThreads) {
                int carPosition = car.position();
                if (firstLightSniffer) {
                    switch (firstLight.getColor()) {
                        case RED:
                            if (carPosition > 750 - stoppingDistance && carPosition < 999) {
                                car.pause();
                                car.CAR_SPEED.setText("Speed: " + 0 + " MPH");
                            }
                            break;
                        case GREEN:
                            if (car.paused && carPosition > 750 - stoppingDistance && carPosition < 999) {
                                car.resume();
                            }
                            break;
                        default:
                            break;
                    }
                }
                if (secondLightSniffer) {
                    switch (secondLight.getColor()) {
                        case RED:
                            if (carPosition > 1750 - stoppingDistance && carPosition < 1999) {
                                car.pause();
                                car.CAR_SPEED.setText("Speed: " + 0 + " MPH");
                            }
                            break;
                        case GREEN:
                            if (car.paused && carPosition > 1750 - stoppingDistance && carPosition < 1999) {
                                car.resume();
                            }
                            break;
                        default:
                            break;
                    }
                }
                if (thirdLightSniffer) {
                    switch (thirdLight.getColor()) {
                        case RED:
                            if (carPosition > 2750 - stoppingDistance && carPosition < 2999) {
                                car.pause();
                                car.CAR_SPEED.setText("Speed: " + 0 + " MPH");
                            }
                            break;
                        case GREEN:
                            if (car.paused && carPosition > 2750 - stoppingDistance && carPosition < 2999) {
                                car.resume();
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }// End of sniffer() method.

    // date() method gets system date and time.
    public String date() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        } catch (Exception e) {
            System.err.println("An error occurred while getting the date:");
            e.printStackTrace();
            return "Error getting date";
        }
    }

    // Update car position and speed.
    @Override
    public void stateChanged(ChangeEvent e) {
        carIconOne.repaint();
        carIconTwo.repaint();
        carIconThree.repaint();
        carIconFour.repaint();

        firstPosition.repaint();
        secondPosition.repaint();
        thirdPosition.repaint();
        fourthPosition.repaint();

        firstSpeed.repaint();
        secondSpeed.repaint();
        thirdSpeed.repaint();
        fourthSpeed.repaint();

        // Update car Icon positions.
        carIconOne.setBounds(5 + firstCarProgress.getValue() / 3, 268, 35, 20);
        firstPosition.setBounds(5 + firstCarProgress.getValue() / 3, 283, 118, 20);
        firstSpeed.setBounds(5 + firstCarProgress.getValue() / 3, 298, 105, 20);
        carIconTwo.setBounds(5 + secondCarProgress.getValue() / 3, 268, 35, 20);
        secondPosition.setBounds(5 + secondCarProgress.getValue() / 3, 235, 105, 20);
        secondSpeed.setBounds(5 + secondCarProgress.getValue() / 3, 250, 105, 20);
        carIconThree.setBounds(5 + thirdCarProgress.getValue() / 3, 268, 35, 20);
        thirdPosition.setBounds(5 + thirdCarProgress.getValue() / 3, 205, 115, 20);
        thirdSpeed.setBounds(5 + thirdCarProgress.getValue() / 3, 220, 105, 20);
        carIconFour.setBounds(5 + fourthCarProgress.getValue() / 3, 268, 35, 20);
        fourthPosition.setBounds(5 + fourthCarProgress.getValue() / 3, 168, 115, 20);
        fourthSpeed.setBounds(5 + fourthCarProgress.getValue() / 3, 183, 105, 20);
    }// End of stateChanged() method.

    // Main method.
    public static void main(String[] args) {
        try {
            TrafficSimulator main = new TrafficSimulator();
            simulator = new Thread(main);
        } catch (Exception e) {
            System.err.println("An error occurred during the simulation:");
            e.printStackTrace();
        }
    }

}// end Main class