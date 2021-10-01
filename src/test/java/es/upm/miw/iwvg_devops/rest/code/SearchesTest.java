package es.upm.miw.iwvg_devops.rest.code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindFractionAdditionByUserId() {
        assertEquals(new Fraction(3, 1),
                new Searches().findFractionAdditionByUserId("1"));
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction(){
        assertEquals(List.of(-0.2, -0.5),
                new Searches().findDecimalFractionByNegativeSignFraction()
                        .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("F.", "B.", "L.", "B."), new Searches().findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(List.of("Blanco", "López"),
                new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct()
                        .collect(Collectors.toList()));
    }
}
