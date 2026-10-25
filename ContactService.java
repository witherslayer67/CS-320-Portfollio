package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contactMap = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contact == null || contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact cannot be null and ID must be unique.");
        }
        contactMap.put(contact.getContactId(), contact);
        return true;
    }

    public void deleteContact(String contactId) {
        if (contactId == null || !contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contactMap.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    public Contact getContact(String contactId) {
        if (contactId == null || !contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return contactMap.get(contactId);
    }
}