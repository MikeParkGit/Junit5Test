package mcm.personal.junit5.contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ContactManagerTest {

	private static ContactManager contactManager  ;
	
	@BeforeAll
	public static void inicializa() {
		contactManager = new ContactManager();
	}
	
	
	@Test
	@DisplayName("Should create contact")
	public void shouldCreateContact() {
        
        contactManager.addContact("Miguel", "Cruz", "0123456789");
        assertFalse(contactManager.getAllContacts().isEmpty());
        //assertEquals(1, contactManager.getAllContacts().size());
	}
	
    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Doe", "0123456789");
        });
    }
    
    @Test
    @DisplayName("Should Not Create Contact When Last Name is Null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
    
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", null, "0123456789");
        });
    }
	
    @Test
    @DisplayName("Should Not Create Contact When Phone Number is Null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {

        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("John", "Doe", null);
        });
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number size is different to 10")
    public void elNumeroDebeTenerDiezDigitos() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
    		 contactManager.addContact("Diego", "Fernandez", "023456789");
    	});
    }

    @Test
    @DisplayName("Should Not Create Contact When Phone Number contains letters")
    public void elNumeroSoloDebeTenerDigitos() {
    	Assertions.assertThrows(RuntimeException.class, () -> {
    		 contactManager.addContact("Diego", "Fernandez", "0l23456789");
    	});
    }
    
	@Test
	@DisplayName("Inserts another contact")
	void shouldCreateAnotherContact() {
        
        contactManager.addContact("Demetrio", "Medina", "0555511111");
        assertFalse(contactManager.getAllContacts().isEmpty());
	}

	@Test
	@DisplayName("La lista debe tener longitud dos")
	@AfterAll
	public static void DebeTenerLongitudDos () {
		assertEquals(2, contactManager.getAllContacts().size());
	}
	

		
}
