package spring.country.model;

import java.util.List;

/**
 * @Created 09 / 07 / 2020 - 10:56 AM
 * @project SpringCountryDBThymelead
 * @Author Hamdamboy
 */


public class ContactDto {

    List<Contact> contacts;

    public List<Contact> getContacts(){
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
