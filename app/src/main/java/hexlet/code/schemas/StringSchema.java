package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        this.addCheck(s -> s == null || s instanceof String);
    }

    @Override
    void addCheck(Predicate<Object> check) {
        super.addCheck(check);
    }

    @Override
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

    @Override
    public boolean isValid(Object value) {
        return super.isValid(value);
    }

}
