import java.util.*;
/*
Author: Benjamin Wang
Interface for the phonebook.
Contains the method stubs
*/
public interface PhoneBook {

    int size();

    void insert(int i, Person person);

    Person remove(int i);

    Person lookup(int i);

    Iterator<Person> getIterator();

}
