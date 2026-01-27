package org.evavdb1.postcards;
import java.util.*;

public class CardMainApp {
    public static void main(String[] args) {
        System.out.println();
        // my cards
        PostCard belgium = new PostCard("Belgium", "Europe");
        PostCard france = new PostCard("France", "Europe");
        PostCard japan = new PostCard("Japan", "Asia");
        PostCard rdc = new PostCard("Democratic Republic of Congo", "Africa");
        PostCard southKorea = new PostCard("South Korea", "Asia");
        PostCard belgium2 = new PostCard("Belgium", "Europe");
        PostCard southAfrica = new PostCard("South Africa", "Africa");
        PostCard france2 = new PostCard("France", "Europe");
        PostCard belgium3 = new PostCard("Belgium", "Europe");
        PostCard usa = new PostCard("United States of America", "North America");
        PostCard canada = new PostCard("Canada", "North America");
        PostCard peru = new PostCard("Peru", "South America");
        PostCard samoa = new PostCard("Samoa", "Oceania");
        PostCard belgium4 = new PostCard("Belgium", "Europe");
        PostCard france3 = new PostCard("France", "Europe");

        // add to arrayList
        List<PostCard> cardsArrayMe = new ArrayList<>();

        cardsArrayMe.add(belgium);
        cardsArrayMe.add(france);
        cardsArrayMe.add(japan);
        cardsArrayMe.add(rdc);
        cardsArrayMe.add(southKorea);
        cardsArrayMe.add(belgium2);
        cardsArrayMe.add(southAfrica);
        cardsArrayMe.add(france2);
        cardsArrayMe.add(belgium3);
        cardsArrayMe.add(usa);
        cardsArrayMe.add(canada);
        cardsArrayMe.add(peru);
        cardsArrayMe.add(samoa);
        cardsArrayMe.add(belgium4);
        cardsArrayMe.add(france3);

        // friend's cards
        PostCard northKorea = new PostCard("North Korea", "Asia");
        PostCard usa2 = new PostCard("United States of America", "North America");
        PostCard botswana = new PostCard("Botswana", "Africa");
        PostCard northKorea2 = new PostCard("North Korea", "Asia");

        List<PostCard> cardsArrayFriend = new ArrayList<>();

        cardsArrayFriend.add(northKorea);
        cardsArrayFriend.add(usa2);
        cardsArrayFriend.add(botswana);
        cardsArrayFriend.add(northKorea2);

        // friends
        Friend bobby = new Friend("Bobby",false, 3, 5);
        Friend melissa = new Friend("Melissa",false, 1, 6);
        Friend darla = new Friend("Darla",true, 14, 2);
        Friend bert = new Friend("Bert",false, 10, 4);
        Friend grandma = new Friend("Nana",true, 12, 7);
        Friend fester = new Friend("Fester",false, 1, 2);
        Friend anna = new Friend("Anna",false, 8, 4);

        System.out.println("My original cards: " + cardsArrayMe);
        System.out.println("My friend's original cards: " + cardsArrayFriend);

        // OPDRACHT 1
        System.out.println("\n***---------1-----------***");
        for (int i = 0; i < cardsArrayMe.size(); i++) {
            PostCard card = cardsArrayMe.get(i);
            if (Collections.frequency(cardsArrayMe, card) > 1) {
                for (Iterator<PostCard> it = cardsArrayFriend.iterator(); it.hasNext();) {
                    PostCard friendCard = it.next();
                    if (!cardsArrayMe.contains(friendCard)) {
                        cardsArrayMe.set(i, friendCard);
                        it.remove();
                        break;
                    }
                }
            }
        }
        System.out.println("\nMy friend an I traded our doubles. ");
        System.out.println("My new cards: ");
        cardsArrayMe.forEach(System.out::println);
        System.out.println("\nMy friend's new cards: ");
        cardsArrayFriend.forEach(System.out::println);

        // OPDRACHT 2
        System.out.println("\n***---------2-----------***");
        cardsArrayMe.sort(Comparator.comparing(PostCard::getCountry));
        System.out.println("\nCards sorted by country: ");
        cardsArrayMe.forEach(System.out::println);

        // OPDRACHT 3
        System.out.println("\n***----------3----------***");
        List<PostCard> dupliCards = new ArrayList<>();
        Set<PostCard> soloCards = new HashSet<>();
        Iterator<PostCard> iter = cardsArrayMe.iterator();

        while (iter.hasNext()) {
            PostCard card = iter.next();
            if (!soloCards.add(card)) {
                dupliCards.add(card);
                iter.remove();
            }
        }
        System.out.println("\nNumber of doubles: " + dupliCards.size());
        System.out.println("The doubles are: ");
        dupliCards.forEach(System.out::println);

        // OPDRACHT 4
        System.out.println("\n***---------4-----------***");
        PriorityQueue<Friend> sortedFriend = new PriorityQueue<>(
          Comparator
                  .comparing(Friend::isFamily).reversed()
                  .thenComparing(Friend::getFriendshipLevel, Comparator.reverseOrder())
                  .thenComparing(Friend::getYearsKnown)
        );

        sortedFriend.offer(bobby);
        sortedFriend.offer(melissa);
        sortedFriend.offer(darla);
        sortedFriend.offer(bert);
        sortedFriend.offer(grandma);
        sortedFriend.offer(fester);
        sortedFriend.offer(anna);

        System.out.println("\nOrder of donation: ");
        sortedFriend.forEach(System.out::println);

    }
}
