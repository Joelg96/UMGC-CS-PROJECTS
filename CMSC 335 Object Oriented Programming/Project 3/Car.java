
/**
 * Joel Goode - CMSC335 - Project 3
 * 4/18/23
 * The Car class represents a car in the traffic simulation. It manages the car's
 * position, speed, and behavior in response to traffic light signals.
 */

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car implements Runnable {

    private Thread thread;
    boolean paused;
    Random random = new Random();
    private boolean running = true;
    private int carPosition;
    private double carSpeed;
    private double scaledSpeed;
    private int carId;
    private final JLabel CAR_IMAGE;
    private final JLabel CAR_POSITION;
    final JLabel CAR_SPEED;
    private final Lock lock = new ReentrantLock();
    private final Condition notPaused = lock.newCondition();

    public Car(int carId, JLabel carImage, JLabel carPosition, JLabel carSpeed) {
        this.carPosition = random.nextInt(100);
        this.carSpeed = 10 + random.nextInt(20);
        this.scaledSpeed = random.nextInt(5);
        this.CAR_IMAGE = carImage;
        this.CAR_POSITION = carPosition;
        this.CAR_SPEED = carSpeed;
        this.carId = carId;
    }

    // Start Car.
    public void run() {
        while (running) {
            try (InputStream inputStream = this.getClass().getResourceAsStream("images/car.png")) {
                BufferedImage carURL = ImageIO.read(inputStream);
                Image car = carURL;
                ImageIcon carIcon = new ImageIcon(car);
                CAR_IMAGE.setIcon(carIcon);

                while (true) {
                    lock.lock();
                    try {
                        if (running) {
                            if (carPosition >= 3000) {
                                carPosition = 0;
                            }
                            carPosition += scaledSpeed();
                            Thread.sleep(15);
                        }
                        while (paused) {
                            notPaused.await();
                        }
                    } finally {
                        lock.unlock();
                    }
                    String positionText = String.valueOf(carPosition);
                    CAR_POSITION.setText(carId + ": Position: " + positionText + " m");
                    double speedMph = carSpeed * 2.237;
                    String speedText = String.format("%.2f", speedMph);
                    CAR_SPEED.setText("Speed: " + speedText + " MPH");
                }
            } catch (InterruptedException e) {
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Thread synchronization.
    void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    void pause() {
        lock.lock();
        try {
            paused = true;
        } finally {
            lock.unlock();
        }
    }

    void resume() {
        lock.lock();
        try {
            paused = false;
            notPaused.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int position() {
        return carPosition;
    }

    public double speed() {
        if (running) {
            return carSpeed;
        } else {
            carSpeed = 0;
            return carSpeed;
        }
    }

    public double scaledSpeed() {
        scaledSpeed = carSpeed / 10;
        return scaledSpeed;
    }
}
