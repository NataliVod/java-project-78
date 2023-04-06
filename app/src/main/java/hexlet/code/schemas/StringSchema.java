package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public final class StringSchema {

    private final List<Predicate<Object>> checkList = new ArrayList<>();
    public StringSchema() {
        this.addCheck(s -> s == null || s instanceof String);
    }

    private void addCheck(Predicate<Object> check) {
        checkList.add(check);
    }

    public void required() {
        this.addCheck(s -> s instanceof String && !(s.equals("")));
    }

    public StringSchema minLength(int length) {
        this.addCheck(s -> s != null && ((String) s).length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        this.addCheck(s -> s != null && ((String) s).contains(substring));
        return this;
    }

    public boolean isValid(Object value) {
        for (var check : checkList) {
            if (!check.test(value)) {
                return false;
            }
        }

        return true;
    }

}
