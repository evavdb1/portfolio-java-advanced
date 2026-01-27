package org.evavdb1.pandemicsimulator;
import java.util.Comparator;

public class InsuranceSorter implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return Boolean.compare(o2.isEnsured(), o1.isEnsured());
    }
}
