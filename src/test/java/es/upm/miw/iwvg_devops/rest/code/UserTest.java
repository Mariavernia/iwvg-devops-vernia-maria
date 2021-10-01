package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void findAllUsersId() {
        assertEquals(null, new User().getId());
    }

    @Test
    void findAllUsersName() {
        assertEquals(null, new User().getName());
    }

    @Test
    void findUsersFamilyName() {
        assertEquals(null, new User().getFamilyName());
    }

    @Test
    void findAllUsersFractions() {
        assertEquals(List.of( ), new User().getFractions());
    }

    @Test
    void findAllUsersFullName() {
        assertEquals("null null" , new User().fullName());
    }
}
