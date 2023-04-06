package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        this.addCheck(s -> s == null || s instanceof Number);
    }

    private void addCheck(Predicate<Object> check) {

        checkList.add(check);
    }

    @Override
    public void required() {

        this.addCheck(s -> s instanceof Number);
    }

    public NumberSchema positive() {
        this.addCheck(s -> s != null && ((int) s) > 0);
        return this;
    }

    public NumberSchema range(int begin, int end) {
        this.addCheck(s -> s != null && ((int) s) >= begin && ((int) s) <= end);
        return this;
    }

    public boolean isValid(Object value) {
        return super.isValid(value);
    }

}
