package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class FractionTest {
    private User user;

    @BeforeEach
    void before() {
        List<Fraction> fractions1 = List.of(
                new Fraction(0, 4),
                new Fraction(1, -3),
                new Fraction(4, 2),
                new Fraction(2, 1),
                new Fraction(7, 2)
        );
        user = new User("0", "Maria", "Vernia", fractions1);
    }

    @Test
    void findAllFractionsNumerator() {
        assertEquals(0, user.getFractions().get(0).getNumerator());
        assertEquals(1, user.getFractions().get(1).getNumerator());
    }

    @Test
    void findAllFractionsDenominator() {
        assertEquals(4, user.getFractions().get(0).getDenominator());
        assertEquals(-3, user.getFractions().get(1).getDenominator());
    }

    @Test
    void findAllFractionsDecimal() {
        assertEquals(2.0, user.getFractions().get(2).decimal());
    }

    @Test
    void findIfAreProperFunctions() {
        assertEquals(true, user.getFractions().get(0).isProper());
        assertEquals(false, user.getFractions().get(1).isProper());
    }

    @Test
    void findIfAreImproperFunctions() {
        assertEquals(false, user.getFractions().get(0).isImproper());
        assertEquals(true, user.getFractions().get(1).isImproper());
    }

    @Test
    void findMultiply() {
        assertEquals(new Fraction(0, -12), user.getFractions().get(0).multiply(user.getFractions().get(1)));
    }

    @Test
    void findDivide() {
        assertEquals(new Fraction(0, 4), user.getFractions().get(0).divide(user.getFractions().get(1)));
    }

    @Test
    void findIfAreEquivalentFunctions() {
        assertEquals(false, user.getFractions().get(0).isEquivalent(user.getFractions().get(1)));
        assertEquals(true, user.getFractions().get(3).isEquivalent(user.getFractions().get(2)));
    }

    @Test
    void findFractionsSum() {
        assertEquals(new Fraction(4, -12), user.getFractions().get(0).add(user.getFractions().get(1)));
        assertEquals(new Fraction(11, 2), user.getFractions().get(2).add(user.getFractions().get(4)));
    }
}

