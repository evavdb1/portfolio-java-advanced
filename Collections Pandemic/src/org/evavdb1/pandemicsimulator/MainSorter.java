package org.evavdb1.pandemicsimulator;

import java.util.*;

public class MainSorter {
    public static void main(String[] args) {

//Opdracht 1 List incoming patients
        LinkedHashSet<Patient> intakeOrder = new LinkedHashSet<>(Patient.getAllPatients());

        System.out.println("\n ** LIST OF CURRENT PATIENTS **");
        intakeOrder.forEach(System.out::print);
        System.out.println();

//Opdracht 2 List sorted patients (temp>age>insurance)
        List<Patient> sortedList = intakeOrder.stream()
                .sorted(new TemperatureSorter()
                        .thenComparing(new AgeSorter())
                        .thenComparing(new InsuranceSorter()))
                .toList();

        Queue<Patient> queue01 = new LinkedList<>(sortedList);

        System.out.println("\n ** LIST OF SORTED PATIENTS **: ");
        queue01.forEach(System.out::print);
        System.out.println();

//Opdracht 3 Lists of categorized patients
        Map<Integer, List<Patient>> categeorizedMap = new HashMap<>();
        for (int i = 1; i<=4; i++) {
            categeorizedMap.put(i, new ArrayList<>());
        }

        while (!queue01.isEmpty()) {
            Patient patient = queue01.poll();

            boolean cat01 = ((patient.getTemperature() >=40 || (patient.getAge() >=65 && patient.getTemperature() >= 38)) && patient.isUnknownVirus());
            boolean cat02 = (patient.getTemperature() >=38 && patient.isUnknownVirus() && !cat01);
            boolean cat03 = (patient.getTemperature() <38 && patient.isUnknownVirus());
            boolean cat04 = (patient.getTemperature() >=38 && !patient.isUnknownVirus());

            if (cat01) categeorizedMap.get(1).add(patient);
            else if (cat02) categeorizedMap.get(2).add(patient);
            else if (cat03) categeorizedMap.get(3).add(patient);
            else if (cat04) categeorizedMap.get(4).add(patient);
        }

        System.out.println("\n ** CATEGORIZED LISTS OF PATIENTS **");
        for (Map.Entry<Integer, List<Patient>> entry : categeorizedMap.entrySet()) {
            System.out.println("\nCategory "+ entry.getKey() + ".");
            entry.getValue().forEach(System.out::print);
            System.out.println();
        }
        System.out.println("\nEmpty queue? "+ queue01.isEmpty());
    }
}

/*
CAT1    high fever and +65, fever and has virus
CAT2    fever and has virus
CAT3    no fever and has virus
CAT4    fever and no virus
*/
