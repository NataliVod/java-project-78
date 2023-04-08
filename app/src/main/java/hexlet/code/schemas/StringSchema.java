package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        this.addCheck(v -> v == null || v instanceof String);
    }

    @Override
    void addCheck(Predicate<Object> check) {
        super.addCheck(check);
    }

    @Override
    public  StringSchema required() {
        this.addCheck(v -> v instanceof String && !(v.equals("")));
        return this;
    }

    public StringSchema minLength(int length) {
        this.addCheck(v -> v != null && ((String) v).length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        this.addCheck(v -> v != null && ((String) v).contains(substring));
        return this;
    }

    @Override
    public boolean isValid(Object value) {

        return super.isValid(value);
    }

}
