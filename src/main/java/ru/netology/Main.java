package ru.netology;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Contact contact1 = new Contact("Ольга", "8-913-888-12-13");
        Contact contact2 = new Contact("Василий", "8-909-538-22-17");
        Contact contact3 = new Contact("Олег", "8-987-234-77-66");
        Group groupFriends = new Group("Друзья");
        Group groupJob = new Group("Работа");
        phoneBook.addGroup(groupFriends);
        phoneBook.addGroup(groupJob);
        phoneBook.addContactToGroup(groupFriends, contact1);
        phoneBook.addContactToGroup(groupFriends, contact3);
        phoneBook.addContactToGroup(groupJob, contact1);
        phoneBook.addContactToGroup(groupJob, contact2);
        phoneBook.getGroup(groupFriends);
        phoneBook.getGroup(groupJob);
        System.out.println();
        System.out.println();
        MissedCalls missedCalls = new MissedCalls();
        missedCalls.addMissedCall(LocalDateTime.of(2022, 3, 6, 7, 05), "8-495-456-87-67");
        missedCalls.addMissedCall(LocalDateTime.of(2022, 3, 6, 6, 00), "8-909-538-22-17");
        missedCalls.addMissedCall(LocalDateTime.of(2022, 3, 6, 7, 15), "8-913-888-12-13");
        missedCalls.addMissedCall(LocalDateTime.now(), "8-913-888-12-17");
        missedCalls.addMissedCall(LocalDateTime.of(2022, 3, 5, 17, 44), "8-987-234-77-66");
        missedCalls.getMissedCallsList(phoneBook);
    }
}
