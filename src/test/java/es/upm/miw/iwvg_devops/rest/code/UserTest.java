package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    private User user;

    @BeforeEach
    void before() {

        user = new User("0", "Maria", "Vernia", null);
    }
    @Test
    void findAllUsersId() {
        assertEquals("0",user.getId());
    }

    @Test
    void findAllUsersName() {
        assertEquals("Maria", user.getName());
    }

    @Test
    void findUsersFamilyName() {
        assertEquals("Vernia", user.getFamilyName());
    }

    @Test
    void findAllUsersFractions() {
        assertEquals(List.of(), user.getFractions());
    }

    @Test
    void findAllUsersFullName() {
        assertEquals("Maria Vernia" , user.fullName());
    }

    @Test
    void findAllUsersInitials() {
        assertEquals("M." , user.initials());
    }
}
