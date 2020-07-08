package spring.country.model;

import java.util.List;

/**
 * @Created 08 / 07 / 2020 - 2:00 PM
 * @project SpringCountryDBThymelead
 * @Author Hamdamboy
 */


public class ContactDto {

    List<Contact> contacts;

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
