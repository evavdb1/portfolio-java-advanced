# Portfolio Java Advanced

*Collection Java projects demonstrating advanced programming and console applications. 
Each project showcases clean code, logic and practical problem-solving skills.*
---

**Enjoy the output, in an array of topics**

---

## Tech Stack
- Java 17+
- GitHub

---

## Features
- Object-oriented design: classes, inheritance, interfaces, encapsulation
- Interactive console menus for user-friendly input
- Collections and data structures: List, Map, Set with search, sort, and filter
- Input validation and error handling for robust applications
- Separation of concerns: models, services, storage, and utilities
- Computation and business logic: calculations, statistics, and rules
- Streams, lambdas, generics, and UML diagrams for maintainability

---

## How to Run
1. Clone the repository
2. Compile the program
   ```
   javac -d out <src/**/*.java>
   ```
3. Run the program
   ```
   java -cp out org.evavdb1.pandemicsimulator.MainSorter
   java -cp out org.evavdb1.postcards.CardMainApp
   java -cp out org.evavdb1.productionfactory.ProductMainApp
   java -cp out org.evavdb1.lifesupport.PersonMain
   java -cp out org.evavdb1.bookproject.BookApp
   java -cp out org.evavdb1.studentproject.ScoreInfoApp
   ```
---
```
portfolio-java-advanced-console/
│
├── collections_pandemic/
│       └── src/org.evavdb1.pandemicsimulator/
│               ├── MainSorter.java
│               ├── InsuranceSorter.java
│               ├── Patient.java
│               ├── AgeSorter.java
│               └── TemperatureSorter.java
│
├── collections_postcards/
│       └── src/org.evavdb1.postcards/
│               ├── CardMainApp.java
│               ├── Friend.java
│               └── PostCard.java
│
├── collections_productionfactory/
│       └── src/org.evavdb1.productionfactory
│               ├── ProductMainApp.java
│               ├── ElectricProduct.java
│               ├── FoodProduct.java
│               ├── HealthProduct.java
│               ├── Product.java
│               ├── ProductFactory.java
│               └── ProductSorter.java
│
├── multithreading_lifesupport/
│       └── src/org.evavdb1.lifesupport/
│               ├── PersonMain.java
│               ├── HeartBeat.java
│               ├── Lungs.java
│               └── Person.java
│
├── streams_bookproject/
│       └── src/org.evavdb1.bookproject/
│               ├── BookApp.java
│               ├── Book.java
│               └── Person.java
│
├── streams_studentproject/
│       └── src/org.evavdb1.studentproject/
│               ├── ScoreInfoApp.java
│               ├── Person.java
│               ├── ScoreInfo.java
│               ├── ScoreInfoService.java
│               └── Student.java
│
├── README.md
└── .gitignore
```