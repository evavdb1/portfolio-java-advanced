package org.evavdb1.postcards;
import java.util.Objects;

public class Friend {

    public String name;
    public boolean family;
    public int yearsKnown;
    public int friendshipLevel;

    public Friend(String name, boolean family, int yearsKnown, int friendshipLevel) {
        this.name = name;
        this.family = family;
        this.yearsKnown = yearsKnown;
        this.friendshipLevel = friendshipLevel;
    }

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }
    public boolean isFamily() {        return family;    }
    public void setFamily(boolean family) {        this.family = family;    }
    public int getYearsKnown() {        return yearsKnown;    }
    public void setYearsKnown(int yearsKnown) {        this.yearsKnown = yearsKnown;    }
    public int getFriendshipLevel() {        return friendshipLevel;    }
    public void setFriendshipLevel(int friendshipLevel) {        this.friendshipLevel = friendshipLevel;    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return family == friend.family && yearsKnown == friend.yearsKnown && friendshipLevel == friend.friendshipLevel && Objects.equals(name, friend.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, family, yearsKnown, friendshipLevel);
    }

    @Override
    public String toString() {
        return name + ", family? " + family + ", yearsKnown: " + yearsKnown + ", friendshipLevel: " + friendshipLevel;
    }
}
