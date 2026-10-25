package contact.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertTrue(service.addContact(contact));
        Assertions.assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.getContact("1");
        });
    }

    @Test
    public void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1", "Jane");
        Assertions.assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("1", "Smith");
        Assertions.assertEquals("Smith", service.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("1", "0987654321");
        Assertions.assertEquals("0987654321", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("1", "456 Elm St");
        Assertions.assertEquals("456 Elm St", service.getContact("1").getAddress());
    }
}