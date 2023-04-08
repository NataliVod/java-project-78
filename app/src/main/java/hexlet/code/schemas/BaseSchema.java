package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


/**
 * The `BaseSchema` class is used to create data validators and can be extended by creating subclasses.
 */
public class BaseSchema {

    /**
     * Adds a check for the required presence of a value.
     * @return An instance of this object with the added check.
     */
    public BaseSchema required()  {
        this.addCheck(Objects::nonNull);
        return this;
    }

    private final List<Predicate<Object>> checkList = new ArrayList<>();

    /**
     * Adds a check to the list of checks.
     * @param check The check to add to the list.
     */
    void addCheck(Predicate<Object> check) {

        checkList.add(check);
    }

    /**
     * Checks whether the given value is valid according to the set of checks.
     * @param value The value to check.
     * @return true if the value passes all checks, false otherwise.
     */
    boolean isValid(Object value) {
        for (var check : checkList) {
            if (!check.test(value)) {
                return false;
            }
        }
        return true;
    }
}
