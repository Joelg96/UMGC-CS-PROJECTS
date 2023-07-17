
/**
 * Joel Goode - CMSC335 - Project 3
 * 4/18/23
 * The TrafficLight class represents a simulation of a traffic light.
 * It manages the traffic light's color and behavior, and provides methods
 * to start, pause, resume, and retrieve the current color.
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

enum LightColor {
    RED, YELLOW, GREEN
}

class TrafficLight implements Runnable {

    private Thread thread;
    private LightColor color;
    private boolean stopped;
    private boolean paused;
    private final JLabel TRAFFIC_LIGHT_IMAGE;
    private static final int GREEN_DURATION = 8000;
    private static final int YELLOW_DURATION = 3000;
    private static final int RED_DURATION = 7000;

    private final Object lock = new Object();

    public TrafficLight(JLabel trafficImage) {
        color = LightColor.GREEN;
        this.TRAFFIC_LIGHT_IMAGE = trafficImage;
    }

    // Start traffic lights.
    public void run() {
        while (!stopped) {
            try {
                switch (getColor()) {
                    case GREEN:
                        BufferedImage greenURL = ImageIO
                                .read(this.getClass().getResourceAsStream("images/greenlight.png"));
                        Image greenlight = greenURL;
                        ImageIcon greenIcon = new ImageIcon(greenlight);
                        setTrafficLightIcon(greenIcon);
                        Thread.sleep(GREEN_DURATION);
                        break;

                    case YELLOW:
                        BufferedImage yellowURL = ImageIO
                                .read(this.getClass().getResourceAsStream("images/yellowlight.png"));
                        Image yellowlight = yellowURL;
                        ImageIcon yellowIcon = new ImageIcon(yellowlight);
                        setTrafficLightIcon(yellowIcon);
                        Thread.sleep(YELLOW_DURATION);
                        break;

                    case RED:
                        BufferedImage redURL = ImageIO.read(this.getClass().getResourceAsStream("images/redlight.png"));
                        Image redlight = redURL;
                        ImageIcon redIcon = new ImageIcon(redlight);
                        setTrafficLightIcon(redIcon);
                        Thread.sleep(RED_DURATION);
                        break;
                }

                synchronized (lock) {
                    while (paused) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                changeColor();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    } // End of run().

    private void setTrafficLightIcon(ImageIcon icon) {
        synchronized (TRAFFIC_LIGHT_IMAGE) {
            TRAFFIC_LIGHT_IMAGE.setIcon(icon);
        }
    }

    // Thread synchronization.
    public void changeColor() {
        synchronized (lock) {
            switch (color) {
                case RED:
                    color = LightColor.GREEN;
                    break;
                case YELLOW:
                    color = LightColor.RED;
                    break;
                case GREEN:
                    color = LightColor.YELLOW;
            }
        }
    }

    public void start() {
        synchronized (lock) {
            if (thread == null) {
                thread = new Thread(this);
                thread.start();
            }
        }
    }

    public void stop() {
        synchronized (lock) {
            stopped = true;
        }
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        synchronized (lock) {
            paused = false;
            lock.notifyAll();
        }
    }

    public LightColor getColor() {
        synchronized (lock) {
            return color;
        }
    }
}
