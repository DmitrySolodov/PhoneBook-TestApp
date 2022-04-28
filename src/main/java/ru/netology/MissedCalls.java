package ru.netology;

import java.time.LocalDateTime;
import java.util.*;

public class MissedCalls {
    private NavigableMap<LocalDateTime, String> missedCallsList = new TreeMap<>();

    public void addMissedCall (LocalDateTime callTime, String phoneNumber) {
        missedCallsList.put(callTime, phoneNumber);
    }

    public void getMissedCallsList (PhoneBook phoneBook) {
        Map<LocalDateTime, String> reverseMissedCallsList = missedCallsList.descendingMap();
        System.out.println("Список пропущенных вызовов:");
        for (NavigableMap.Entry<LocalDateTime, String> entry: reverseMissedCallsList.entrySet()) {
            System.out.print("- " + entry.getKey() + " ");
            phoneBook.getContactFromPhoneNumber(entry.getValue());
        }
    }
}

