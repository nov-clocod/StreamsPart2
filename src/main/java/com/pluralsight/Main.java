package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        List<Person> people = getPeopleList();

        System.out.println("Enter either a first or last name to search");
        String userInputName = myScanner.nextLine();

        getPeopleByName(people, userInputName);

        System.out.println("Average age in this group is: " + getAverageAge(people));

        System.out.println("Oldest age in this group is: " + getOldest(people));

        System.out.println("Youngest age in this group is: " + getYoungest(people));
    }

    private static int getYoungest(List<Person> peopleList) {
        return peopleList.stream()
                .map(Person::getAge).sorted()
                .findFirst()
                .orElseThrow();
    }

    private static int getOldest(List<Person> peopleList) {
        return peopleList.stream()
                .map(Person::getAge).sorted(Collections.reverseOrder())
                .findFirst()
                .orElseThrow();
    }

    private static double getAverageAge(List<Person> peopleList) {
        int totalAge = peopleList.stream()
                .map(Person::getAge).reduce(0,(temp, age) -> temp + age);

        return (double) totalAge / peopleList.size();
    }

    private static void getPeopleByName(List<Person> peopleList, String userInputName) {
        peopleList.stream()
                .filter(person ->
                        person.getFirstName().equalsIgnoreCase(userInputName) || person.getLastName().equalsIgnoreCase(userInputName))
        .forEach(System.out::println);
    }

    private static List<Person> getPeopleList() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Smith", "John", 28));
        people.add(new Person("John", "Emily", 34));
        people.add(new Person("Williams", "Michael", 22));
        people.add(new Person("Brown", "Olivia", 45));
        people.add(new Person("Jones", "Ethan", 19));
        people.add(new Person("Garcia", "Sophia", 31));
        people.add(new Person("Miller", "Daniel", 40));
        people.add(new Person("Davis", "Ava", 27));
        people.add(new Person("Rodriguez", "Liam", 36));
        people.add(new Person("Martinez", "Isabella", 25));

        return people;
    }
}
