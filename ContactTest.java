package contact.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertEquals("12345", contact.getContactId());
        Assertions.assertEquals("John", contact.getFirstName());
        Assertions.assertEquals("Doe", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhone());
        Assertions.assertEquals("12345 Main St", contact.getAddress());
    }

    @Test
    public void testContactIdTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testContactIdNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "JohnathanTooLong", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "DoeLongerThanTen", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main St");
        });
    }

    @Test
    public void testPhoneInvalidLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
        });
    }

    @Test
    public void testPhoneNotDigits() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123456789a", "123 Main St");
        });
    }

    @Test
    public void testPhoneNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main St");
        });
    }

    @Test
    public void testAddressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "1234567890123456789012345678901");
        });
    }

    @Test
    public void testAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        Assertions.assertEquals("Jane", contact.getFirstName());
        Assertions.assertEquals("Smith", contact.getLastName());
        Assertions.assertEquals("0987654321", contact.getPhone());
        Assertions.assertEquals("456 Elm St", contact.getAddress());
    }
}