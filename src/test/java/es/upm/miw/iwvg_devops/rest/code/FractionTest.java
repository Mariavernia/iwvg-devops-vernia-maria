package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class FractionTest {
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
    void findAllFractionsNumerator() {
        assertEquals(0,user.getFractions().get(0).getNumerator());
        assertEquals(1,user.getFractions().get(1).getNumerator());
    }

    @Test
    void findAllFractionsDenominator() {
        assertEquals(4,user.getFractions().get(0).getDenominator());
        assertEquals(-3,user.getFractions().get(1).getDenominator());
    }

    @Test
    void findAllFractionsDecimal() {
        assertEquals(3.0,user.getFractions().get(2).decimal());
    }
}
