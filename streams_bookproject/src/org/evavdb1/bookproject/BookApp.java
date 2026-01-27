package org.evavdb1.bookproject;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class BookApp {
    public static void main(String[] args) {

        Person homes = new Person("AM", "Homes", LocalDate.of(1961, 12, 18));
        Person vanDale = new Person("Henri", "Van Dale", LocalDate.of(1946, 11, 15));
        Person mawer = new Person("Simon", "Mawer", LocalDate.of(1948, 5, 2));
        Person townsend = new Person("Sue", "Townsend", LocalDate.of(1946, 4, 2));
        Person boyarsky = new Person("Boyarsky", "/ Selikoff", LocalDate.of(1981, 3, 25));

        Book[] books = {
                new Book("This book will save your life", homes, LocalDate.of(2006, 5, 1), "contemporary fiction"),
                new Book("En Appels aan de overkant", vanDale, LocalDate.of(1991, 12, 1), "biography, fiction"),
                new Book("Mendel's dwarf", mawer, LocalDate.of(1998, 1, 1), "biography, historical science"),
                new Book("Adrian Mole Series", townsend, LocalDate.of(1982, 1, 5), "diary, fiction"),
                new Book("OCA Study Guide", boyarsky, LocalDate.of(2016, 6, 30), "technical nonFiction"),
        };

        // apply methods
        getNewestBook(books);
        printYoungestWriter(books);
        printSortedByName(books);
        countBooksPerAuthor(books);
        printBooksReleasedIn2016(books);

        // print all books, sorted by genre
        System.out.println("All books, sorted by genre: ");
        Arrays.stream(books)
                .sorted(Comparator.comparing(Book::getGenre))
                .forEach(System.out::println);


    }

    public static Book getNewestBook(Book[] books) {
        Book newest = Arrays.stream(books)
                .max(Comparator.comparing(Book::getReleaseDate))
                .orElse(null);
        System.out.println("\nThe most recent book is: " + newest);
        return newest;
    }

    public static void printYoungestWriter(Book[] books) {
        Person youngest = Arrays.stream(books)
                .map(Book::getAuthor)
                .max(Comparator.comparing(Person::getDateOfBirth))
                .orElse(null);
        System.out.println("\nThe youngest author is: " + youngest);
    }

    public static void printSortedByName(Book[] books) {
        System.out.println("\nAll books, sorted by title: ");
        Arrays.stream(books)
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);
    }

    public static void countBooksPerAuthor(Book[] books) {
        System.out.println("\nNumber of books per author: ");
        Map<Person, Long> count = Arrays.stream(books)
                    .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
        count.forEach((author, total) -> System.out.println(author + ": " + total));
    }

    public static void printBooksReleasedIn2016(Book[] books) {
        System.out.println("\nBooks, released in 2016: ");
        Arrays.stream((books))
                .filter(book -> book.getReleaseDate().getYear() == 2016)
                .forEach(System.out::println);
    }
}
