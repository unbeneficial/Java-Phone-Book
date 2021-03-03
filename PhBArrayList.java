import java.util.*;

/*
Author: Benjamin Wang
Array List implementation of the PhoneBook interface
Contains all methods in the interface
*/
public class PhBArrayList implements PhoneBook{

    private ArrayList<Person> phBAL = new ArrayList<Person>();

    /*
    This method returns the size of the array list
    Runtime: O(1), since it says so in the API for ArrayList :)
     */
    @Override
    public int size() {
        return phBAL.size();
    }

    /*
    This method adds the person before the i-th component specified.
    If i is greater than the size of the arraylist, then it adds the person
    to the end of the list
    Runtime: O(n), since it also said so in the API.
    I will quote from the Java 8 API: "The size, isEmpty,
     get, set, iterator, and listIterator operations run in constant time. The add operation
      runs in amortized constant time, that is, adding n elements requires O(n) time. All of
      the other operations run in linear time (roughly speaking)."
    */
    @Override
    public void insert(int i, Person person) {
        if (this.phBAL.size() < i-1){
            this.phBAL.add(person);
        } else {
            this.phBAL.add(i, person);
        }
    }

    /* This method removes the person at the i-th value specified.
    If i is greater than the size of the linked list, then it returns null and
    tells the user that the input they used was invalid
    Runtime: O(n), since it also said so in the API.
    */
    @Override
    public Person remove(int i) {
        if (this.phBAL.size() > i){
            Person pAL = this.phBAL.get(i);
            this.phBAL.remove(i);
            System.out.println(pAL);
            return pAL;
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
    Runtime: O(1), since we use the get which is constant according to the API.
    */
    @Override
    public Person lookup(int i) {
        if (this.phBAL.size() > i) {
            System.out.println(this.phBAL.get(i));
            return this.phBAL.get(i);
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
        Iterator<Person> iterAL = phBAL.iterator();
        return iterAL;
    }
}
