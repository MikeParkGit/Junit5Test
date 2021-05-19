package mcm.personal.junit5.contact;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


class ContactManagerTest2 {

	public ContactManager contactManager  ;
	
	@BeforeEach
	public void inicializa() {
		contactManager = new ContactManager();
	}

    @DisplayName("Phone Number should match the required Format")
	@ParameterizedTest
	@ValueSource(strings = {"0l23456789", "034567890", "+123456789"})
    public void debeTenerElFormatoRequerido(String phoneNumber) {
    	Assertions.assertThrows(RuntimeException.class, () -> {
    		 contactManager.addContact("Diego", "Fernandez", phoneNumber);
    	});
	    assertTrue(contactManager.getAllContacts().isEmpty());
	    assertEquals(0, contactManager.getAllContacts().size());
    }

    
	@DisplayName("Method Source Case - Phone Number should match the required Format")
	@ParameterizedTest
	@MethodSource("phoneNumberList")
	public void shouldTestPhoneNumberFormatUsingMethodSource(String phoneNumber) {
	    contactManager.addContact("John", "Doe", phoneNumber);
	    assertFalse(contactManager.getAllContacts().isEmpty());
	    assertEquals(1, contactManager.getAllContacts().size());
	}

	public static List<String> phoneNumberList() {
	    return Arrays.asList("012345789", "1234567890", "+0123456789");
	}
		
		

	/**
	 * Comprueba el formato del numero telefónico con un test parametrizado
	 * @param phoneNumber
	 */
	@DisplayName("Phone Number should match the required Format")
	@ParameterizedTest
	@ValueSource(strings = {"0123456789", "1234567890", "+123456789"})
	public void shouldTestPhoneNumberFormat(String phoneNumber) {
	    contactManager.addContact("John", "Doe", phoneNumber);
	    assertEquals(1, contactManager.getAllContacts().size());
	}

	

}
