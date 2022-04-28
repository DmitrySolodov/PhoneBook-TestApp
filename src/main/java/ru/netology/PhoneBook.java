package ru.netology;

import java.util.*;

public class PhoneBook {
    private Map<Group, List<Contact>> map = new HashMap<>();

    public void addGroup(Group group) {
        map.put(group, new ArrayList<>());
    }

    public void addContactToGroup(Group group, Contact contact) {
        List<Contact> userContacts = map.get(group);
        userContacts.add(contact);
    }

    public void getMyPhoneBook() {
        System.out.println("Ваш телефонный справочник по группам:");
        for (Map.Entry<Group, List<Contact>> entry : map.entrySet()) {
            System.out.println("- " + entry.getKey() + ": ");
            for (Contact contact : entry.getValue()) {
                System.out.println(contact.toString());
            }
        }
    }

    public void getGroup(Group group) {
        System.out.println("Контакты из группы " + "\"" + group.toString() + "\"");
        System.out.println(map.get(group));
    }

    public boolean getContactFromPhoneNumber(String phoneNumber) {
        for (Map.Entry<Group, List<Contact>> entry : map.entrySet()) {
            for (Contact contact : entry.getValue()) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    System.out.println(contact.getName());
                    return true;
                }
            }
        }
        System.out.println(phoneNumber);
        return false;
    }

    public Map<Group, List<Contact>> getMap() {
        return map;
    }

    public void setMap(Map<Group, List<Contact>> map) {
        this.map = map;
    }
}

