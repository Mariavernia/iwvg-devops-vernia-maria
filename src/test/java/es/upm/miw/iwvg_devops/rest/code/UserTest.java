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
        List<Fraction> fractions1 = List.of(
                new Fraction(0, 4),
                new Fraction(1, -3),
                new Fraction(3, 1)
        );
        user = new User("0", "Maria", "Vernia", fractions1);
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
        assertEquals(List.of(
                new Fraction(0, 4),
                new Fraction(1, -3),
                new Fraction(3, 1))
                , user.getFractions());
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
