package org.bookerbuddies.bookease.client;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.client.dto.Login;
import org.bookerbuddies.bookease.client.dto.RegisterAccount;
import org.bookerbuddies.bookease.client.exception.ClientException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@SpringBootTest
class ClientServiceImplTest {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;
    Client client;
    Account account;
    RegisterAccount registerAccount;

    @BeforeEach
    public void createNewClient() {
        account = new Account("aa", 10008.0, "client");
        registerAccount = new RegisterAccount(11, "aa@gmail.com", "aa123", "aa", account);
    }

    @AfterEach
    public void DeleteValue() {
        account = null;
        registerAccount = null;
    }

    @Test
    void createNewClientPositiveTest() {
        try {
            assertNotNull(clientService.newRegistration(registerAccount));
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void when_newRegistration_is_called_with_null_accountName_and_null_balance_then_it_should_throw_ClientException()
    {
        RegisterAccount registerAccount = new RegisterAccount(11, "aa@gmail.com", "aa123", null, new Account(null, null, "client"));
        ClientException exception = assertThrows(ClientException.class, () -> clientService.newRegistration(registerAccount));
        assertEquals("Account balance & name is null", exception.getMessage());
    }

    @Test
    void when_newRegistration_is_called_with_null_email_then_it_should_throw_ClientException() {
        RegisterAccount registerAccount = new RegisterAccount(11, null, "aa123", "aa", new Account("aa", 10008.0, "client"));
        ClientException exception = assertThrows(ClientException.class, () -> clientService.newRegistration(registerAccount));

        assertEquals("You have not filled all your client credentials.Check it once.", exception.getMessage());
    }

    @Test
    void when_newRegistration_is_called_with_null_password_then_it_should_throw_ClientException() {
        RegisterAccount registerAccount = new RegisterAccount(11, "aa@gmail.com", null, "aa", new Account("aa", 10008.0, "client"));

        ClientException exception = assertThrows(ClientException.class, () -> clientService.newRegistration(registerAccount));

        assertEquals("You have not filled all your client credentials.Check it once.", exception.getMessage());
    }


    @Test
    void LoginTheAccount() {
        try {
            account = new Account("reenaa", 10008.0, "client");
            registerAccount = new RegisterAccount(11, "reenaa@gmail.com", "reenaa123", "reenaa", account);
            assertNotNull(clientService.newRegistration(registerAccount));
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
        try {
            assertNotNull(clientService.loginPage("reenaa@gmail.com", "reenaa123"));
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void LoginTheAccountIfValueDoesnotMatch() {
        Login login = new Login("sujitha@gmail.com", "sujitha123");
        ClientException exception = assertThrows(ClientException.class, () -> clientService.loginPage(login.getEmail(), login.getPassword()));
        assertEquals("You have not entered the credentials properly", exception.getMessage());
    }





    @Test
    void when_getClientbyId_is_called_with_clientId_11_then_it_should_return_the_details_of_the_clientId_11() {
        try {
            account = new Account("dd", 10008.0, "client");
            registerAccount = new RegisterAccount(102, "dd@gmail.com", "dd123", "dd", account);
            assertNotNull(clientService.newRegistration(registerAccount));
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
        try {
            account = new Account("aa", 10008.0, "client");
            registerAccount = new RegisterAccount(102, "aa@gmail.com", "aa12345", "aa", account);
            assertNotNull(clientService.updateClient(registerAccount));
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }






    @Test
    void when_getClientbyId_is_called_with_non_existing_clientId_it_should_throw_ClientException() {
        Client client = new Client(122, "sujii@gmail.com", "12345", "sujii");
        clientRepository.save(client);
        String expected = "Your clientId might be null or doesn't match";
        String actual = null;

        try {
            clientService.deleteClientById(1023);
        } catch (ClientException e) {
            actual = e.getMessage();
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testGetClientById_WrongClientId() {
        Client client = new Client(122, "sujii@gmail.com", "12345", "sujii");
        ClientException exception = assertThrows(ClientException.class, () -> clientService.getClientbyId(123));
        assertEquals("Your clientId cannot be null or doesn't match", exception.getMessage());
    }

    @Test
    void testGetClientById_NoClientIdGiven() {
        Client client = new Client(122, "sujii@gmail.com", "12345", "sujii");
        ClientException exception = assertThrows(ClientException.class, () -> clientService.getClientbyId(0));
        assertEquals("Your clientId cannot be null or doesn't match", exception.getMessage());
    }


    @Test
    void when_deleteClientById_is_called_with_non_existing_clientId_it_should_throw_ClientException() {
        Client client = new Client(122, "sujii@gmail.com", "12345", "sujii");
        clientRepository.save(client);

        String expected = "Your clientId might be null or doesn't match";
        String actual = null;

        try {
            clientService.deleteClientById(1023);
        } catch (ClientException e) {
            actual = e.getMessage();
        }
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void when_deeleteClientById_is_called_with_non_existing_clientId_it_should_throw_ClientException() {
        Client client = new Client(334, "sharmi@gmail.com", "12345", "sharmi");
        clientRepository.save(client);

        String expected = "Your clientId might be null or doesn't match";
        String actual = null;

        try {
            clientService.deleteClientById(335);
        } catch (ClientException e) {
            actual = e.getMessage();
        }
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void when_deeleteClientById_is_called_with_existing_clientId_it_should_delete_id() {
        Client client = new Client(334, "sharmi@gmail.com", "12345", "sharmi");
        clientRepository.save(client);

        String expected = "Your clientId might be null or doesn't match";
        String actual = null;

        try {
            clientService.deleteClientById(334);
        } catch (ClientException e) {
            actual = e.getMessage();
        }
        Assertions.assertEquals(expected, actual);
    }


}
