package Helpers;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;

public class ObjectHelper {

    public ObjectHelper() {
    }


    public String generateRandomUsername() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getUsername();
    }

    public String firstName() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getFirstName();
    }

    public String lastName() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getLastName();
    }
    public String address() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getLastName();
    }
    public String city() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getLastName();
    }
    public String state() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getLastName();
    }
    public String country() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getLastName();
    }
    public String email() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getEmail();
    }
    public String phone() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getTelephoneNumber();
    }
    public String username() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        return person.getUsername();
    }



}