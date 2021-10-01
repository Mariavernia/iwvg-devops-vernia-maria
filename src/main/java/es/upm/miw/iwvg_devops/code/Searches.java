package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {


    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(fractions -> fractions.getFractions().stream())
                .reduce(Fraction::add)
                .orElse(new Fraction());
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .flatMap(fractions -> fractions.getFractions().stream())
                .filter(Fraction::negativeSignFraction)
                .map(Fraction::decimal);
    }

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isProper))
                .map(User::initialsFamilyName);
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return new UsersDatabase().findAll()
                .filter(fractions -> fractions.getFractions().stream()
                        .anyMatch(Fraction::negativeSignFraction))
                .map(User::getFamilyName);
    }
}
