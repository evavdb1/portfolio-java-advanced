package org.evavdb1.lifesupport;

public class Lungs implements Runnable  {

    private boolean lungsFull = false;
    private final String name;

    public Lungs(String name) {
        this.name = name;
    }

    // run here is infinite loop of in and out, once per second
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (lungsFull) {
                System.out.println("breathe out ("+name+")");
            } else {
                System.out.println("breathe in ("+name+")");
            }
            lungsFull = !lungsFull;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println(name+"'s breathing stopped");
    }
}
