import java.util.*;
/*
Author: Benjamin Wang
A demo program to showcase the features of the phonebook
*/
public class Demo {

    /*
    This method loops through the iterations of the first list pb1, and then loops through
    the iterations of the second list and compares them with the equals method. If they are
    equal, the method removes the identical element from the second list.
    This method works with both PhBLinkedList and PhBArrayList.
    Runtime: O(nm^2). This is because there are two operations happening at the same time. There is
    the iteration through pb1 which has a runtime of O(n), which we will label as n, and then the iteration
    through pb2, which is also O(n). Here, we label this as m. On top of iterating through pb2, the method
    calls the remove() function for pb2, thus making the worst case m^2. Putting these two together, the
    worst case runtime is O(nm^2).
     */
    public static void removeDuplicates(PhoneBook pb1, PhoneBook pb2) {
        Iterator<Person> i1 = pb1.getIterator();
        while (i1.hasNext()) {
            Person p = i1.next();
            Iterator<Person> i2 = pb2.getIterator();
            while (i2.hasNext()) {
                if (p.equals(i2.next())) {
                    i2.remove();
                }
            }
        }
    }

    /*
    Here, I will test the PhoneBook. I will add Persons a through i into a PhBLinkedList and Persons j through o
    in a PhBArrayList. I will also add Persons a, b, and c into the PhBArrayList as duplicates. I will also add
    spammers and scammers to remove individually.
     */
    public static void main(String[] args) {

        Person a = new Person("Amy", "111-111-1111");
        Person b = new Person("Bob", "222-222-2222");
        Person c = new Person("Claire", "333-333-3333");
        Person d = new Person("Devin", "444-444-4444");
        Person e = new Person("Emma", "555-555-5555");
        Person f = new Person("Fred", "666-666-6666");
        Person g = new Person("Grace", "777-777-7777");
        Person h = new Person("Hannah", "888-888-8888");
        Person i = new Person("Izzy", "999-999-9999");
        Person remove1 = new Person("Spam", "1-800-420-1337");
        Person remove2 = new Person("Scammer", "1-800-420-6969");

        Person j = new Person("Jenny", "100-100-1000");
        Person k = new Person("Kate", "200-200-2000");
        Person l = new Person("Larry", "300-300-3000");
        Person m = new Person("Mason", "400-400-4000");
        Person n = new Person("Nate", "500-500-5000");
        Person o = new Person("Octavia", "600-600-6000");
        Person remove3 = new Person("Spam2", "1-888-420-1337");
        Person remove4 = new Person("Scammer2", "1-888-420-6969");


        /*
        New instance of a linked list from PhbLinkedList
        Adding Persons a through i
        Adding Spam and Scammer to the list as well
         */
        PhBLinkedList ll = new PhBLinkedList();
        ll.insert(0, a);
        ll.insert(0, b);
        ll.insert(0, c);
        ll.insert(0, d);
        ll.insert(0, e);
        ll.insert(0, f);
        ll.insert(0, g);
        ll.insert(0, h);
        ll.insert(0, i);
        ll.insert(0, remove1);
        ll.insert(5, remove2);

        /*
        New instance of an array list from PhbArrayList
        Adding Persons j through o along with a, b, and c in the middle as duplicates to be removed
        Adding Spam2 and Scammer2 to the list as well
         */
        PhBArrayList al = new PhBArrayList();
        al.insert(0, j);
        al.insert(0, k);
        al.insert(0, l);
        al.insert(0, a);
        al.insert(0, b);
        al.insert(0, c);
        al.insert(0, m);
        al.insert(0, n);
        al.insert(0, o);
        al.insert(0,remove3);
        al.insert(3,remove4);

        /*
        Removing Scammer at 0 and Spam at 5
        Attempting to remove an element that is beyond the size of the list
        We should expect to see Scammer and Spam's information returned after
        their removal, along with an error message for saying that the input we
        entered (100) was invalid
         */
        ll.remove(5);
        ll.remove(0);
        ll.remove(100);

        /*
        Removing Scammer2 at 0 and Spam2 at 3
        Attempting to remove an element that is beyond the size of the list
        We should expect to see Scammer2 and Spam2's information returned after
        their removal, along with an error message for saying that the input we
        entered (50) was invalid
         */
        al.remove(3);
        al.remove(0);
        al.remove(50);

        /*
        Looking up the people at the beginning of the list, at element 4, element 5, and 500.
        We should expect to see an error message for 500 saying that the input was invalid
         */
        ll.lookup(0);
        ll.lookup(4);
        ll.lookup(5);
        ll.lookup(500);

        /*
        Looking up the people at the beginning of the list, and the duplicates at elements 3,4, and 5.
        We will also input 1000.
        This will return whoever is at the beginning of the list, along with the duplicates in their spot
        as we have not removed them yet
        We should expect to see an error message for 1000 saying that the input was invalid
         */
        al.lookup(0);
        al.lookup(3);
        al.lookup(4);
        al.lookup(5);
        al.lookup(1000);


        /*
        This will remove the duplicates from the PhBArrayList, which are
        Amy, Bob, and Clair
         */
        Demo.removeDuplicates(ll, al);

        /*
        This will output the final PhBLinkedList. Notice how Spam and Scammer are missing.
         */
        Iterator<Person> iteratorLL = ll.getIterator();
        System.out.println("LL Phone Book List:");
        while (iteratorLL.hasNext()) {
            System.out.println(iteratorLL.next());
        }

        /*
        This will output the final PhBArrayList. Notice how Spam2 and Scammer2 are missing,
        along with the duplicates
         */
        Iterator<Person> iteratorAL = al.getIterator();
        System.out.println("AL Phone Book List:");
        while (iteratorAL.hasNext()) {
            System.out.println(iteratorAL.next());
        }
    }

}
