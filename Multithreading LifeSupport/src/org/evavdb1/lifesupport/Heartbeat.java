package org.evavdb1.lifesupport;

public class Heartbeat implements Runnable {

    private final int milliSecondsBetweenBeats;
    private final String name;

    public Heartbeat(int milliSecondsBetweenBeats, String name) {
        this.milliSecondsBetweenBeats = milliSecondsBetweenBeats;
        this.name = name;
    }

    // run is infinite loop, prints one heartbeat according to millisecondsBetweenBeats
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(" \uD83D\uDC93 ("+name+")");
            try {
                Thread.sleep(milliSecondsBetweenBeats);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(" \uD83D\uDC94 ("+name+")");
    }
}
