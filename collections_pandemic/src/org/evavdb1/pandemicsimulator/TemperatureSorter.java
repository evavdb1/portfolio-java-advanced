package org.evavdb1.pandemicsimulator;
import java.util.Comparator;

public class TemperatureSorter implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return Integer.compare(o2.getTemperature(), o1.getTemperature());
    }
}
