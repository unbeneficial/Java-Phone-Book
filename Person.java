/*
Author: Benjamin Wang
This class represents a person
*/
public class Person extends Object{
    // Name of Person
    private String personID;
    // Phone number of Person
    private String phoneNum;

    /* Constructor for a Person
    Formatted as (name, phone number)
    Runtime: O(1)
    */
    public Person (String personID, String phoneNum) {
        this.personID = personID;
        this.phoneNum = phoneNum;
    }

    // Returns the name of the person
    // Runtime: O(1)
    public String getPersonID(){
        return this.personID;
    }

    // Returns the phone number of the person
    public String getPhoneNum() {
        return this.phoneNum;
    }

    /*
    Equals method
    Runtime:O(1)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = ((Person) o);
            return p.getPersonID().equals(personID) && p.getPhoneNum().equals(phoneNum);
        }
        else return false;
    }

    // Gives a formatted String output of a Person
    public String toString() {
        return "Name: " + this.getPersonID() + " || " + " Number: " + this.getPhoneNum();
    }
}
