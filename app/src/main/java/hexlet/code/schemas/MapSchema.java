package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {

        this.addCheck(s -> s == null || s instanceof Map);
    }

    @Override
    void addCheck(Predicate<Object> check) {
        super.addCheck(check);
    }

    @Override
    public void required() {

        this.addCheck(s -> s instanceof Map<?, ?>);
    }

    public MapSchema sizeof(int size) {
        this.addCheck(s -> s != null && ((Map<?, ?>) s).size() == size);
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        return super.isValid(value);
    }
}
