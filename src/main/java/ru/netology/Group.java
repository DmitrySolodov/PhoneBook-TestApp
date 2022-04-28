package ru.netology;

import java.util.Objects;

public class Group {
    private String groupName;

    public Group() {

    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(Group.class)) {
            return false;
        }
        Group alternativeGroup = (Group) obj;
        return groupName.equals(alternativeGroup.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        return groupName;
    }
}
