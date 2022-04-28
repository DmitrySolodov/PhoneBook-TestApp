package ru.netology;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.*;


public class AppTest {
    //Junit Test
    @org.junit.jupiter.api.Test
    public void testAddGroupAndContacts() {
        //given
        PhoneBook phoneBook = new PhoneBook();
        Contact contact1 = new Contact("Ольга", "8-913-888-12-13");
        Contact contact2 = new Contact("Василий", "8-909-538-22-17");
        List<Contact> list = new ArrayList<>();
        list.add(contact1);
        list.add(contact2);
        Group groupJob = new Group("Работа");
        Map<Group, List<Contact>> expectedMap = new HashMap<>();
        expectedMap.put(groupJob, list);

        //when
        phoneBook.addGroup(groupJob);
        phoneBook.addContactToGroup(groupJob, contact1);
        phoneBook.addContactToGroup(groupJob, contact2);
        Map<Group, List<Contact>> resultMap = phoneBook.getMap();

        //then:
        Assertions.assertEquals(expectedMap, resultMap);
    }

    //Hamcrest Test
    @Test
    public void hamcrestTestAddGroupAndContacts() {
        //given
        PhoneBook phoneBook = new PhoneBook();
        Contact contact1 = new Contact("Ольга", "8-913-888-12-13");
        Contact contact2 = new Contact("Василий", "8-909-538-22-17");
        List<Contact> list = new ArrayList<>();
        list.add(contact1);
        list.add(contact2);
        Group groupJob = new Group("Работа");

        //when
        phoneBook.addGroup(groupJob);
        phoneBook.addContactToGroup(groupJob, contact1);
        phoneBook.addContactToGroup(groupJob, contact2);

        //then:
        assertThat(phoneBook.getMap(), hasKey(new Group("Работа")));
        assertThat(phoneBook.getMap(), hasValue(list));
        assertThat(phoneBook.getMap(), hasEntry(groupJob, list));
    }

    @Test
    public void givenBeanAndCheckProperty() {
        PhoneBook phoneBook = new PhoneBook();
        Group group = new Group("Friends");
        Contact contact = new Contact("Ivan", "8-800-2000-600");
        assertThat(group, Matchers.<Group> hasProperty("groupName", equalTo("Friends")));
        assertThat(phoneBook, Matchers.<PhoneBook> hasProperty("map"));
        assertThat(contact, hasToString("Ivan 8-800-2000-600"));
    }
}