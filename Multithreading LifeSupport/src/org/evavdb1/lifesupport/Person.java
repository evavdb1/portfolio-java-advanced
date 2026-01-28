package org.evavdb1.lifesupport;
import java.util.Random;

public class Person implements Runnable {

    private final String name;
    private final int age;
    private final Thread heart;
    private final Thread breathing;
    private final Thread life;

    public Person(String name, int age, int heartBeatMilliseconds) {
        this.name = name;
        this.age = age;
        this.heart = new Thread(new Heartbeat(heartBeatMilliseconds, name), name+" heart");
        this.breathing = new Thread(new Lungs(name), name+" lungs");
        this.life = new Thread(this, name+ " life");
    }


    // to start the threads
    public void startLife() {
        heart.start();
        breathing.start();
        life.start();
    }

    // called when person dies. Interrupts Thread Life. Stops heartbeat and lungs
    public void endLife() {
        heart.interrupt();
        breathing.interrupt();
        life.interrupt();
    }

    @Override
    public void run() {
        Random number = new Random();

        for (int i = age; i<105; i++) {
            int lifeBeat = number.nextInt(20);
            System.out.println(name+" is "+i+" years old.");
            System.out.println("(lifebeat "+name+": "+lifeBeat+")");

            if (lifeBeat == 13 || i == 104) {
                System.out.println(name + " has died.");
                endLife();
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                    break;
            }
        }
    }
}
