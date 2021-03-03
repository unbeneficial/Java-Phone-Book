import java.util.*;

/*
Author: Benjamin Wang
Linked List implementation of the PhoneBook interface
Contains all methods in the interface
*/
public class PhBLinkedList implements PhoneBook{

    private LinkedList<Person> phBLL = new LinkedList<Person>();

    /*
    This method returns the size of the linked list
    Runtime: O(1) since we are just returning a stored int value
    */
    @Override
    public int size() {
        return this.phBLL.size();
    }

    /*
    This method adds the person before the i-th component specified.
    If i is greater than the size of the linked list, then it adds the person
    to the end of the list
    Runtime: O(n) since we are traversing through the list
    */
    @Override
    public void insert(int i, Person person) {
        if (this.phBLL.size() < i-1) {
            this.phBLL.add(person);
        } else {
            this.phBLL.add(i, person);
        }
    }

    /*
    This method removes the person at the i-th value specified.
    If i is greater than the size of the linked list, then it returns null and
    tells the user that the input they used was invalid
    Runtime: O(n) since we are traversing through the list
    */
    @Override
    public Person remove(int i) throws IndexOutOfBoundsException {
        if (this.phBLL.size() > i) {
            Person pLL = this.phBLL.get(i);
            this.phBLL.remove(i);
            System.out.println(pLL);
            return pLL;
        } else {
            System.out.println("Removal Error: invalid input");
            return null;
        }
    }

    /*
    Looks up the person at the specified i value.
    When it does that, it returns their name and phone number.
    If the person cannot be found, which happens when i is greater than
    the size if the list, the method returns null and tells the user
    that the input they used was invalid
    Runtime: O(n) since we are traversing to the list
    */
    @Override
    public Person lookup(int i) throws IndexOutOfBoundsException {
        if (this.phBLL.size() > i) {
            System.out.println(this.phBLL.get(i));
            return this.phBLL.get(i);
        } else {
            System.out.println("Search Error: invalid input");
            return null;
        }
    }

    /*
    This method returns the iterator
    Runtime: O(1) since it is just returning the iterator
     */
    @Override
    public Iterator<Person> getIterator() {
        Iterator<Person> iterLL = phBLL.iterator();
        return iterLL;
    }
}
