package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        this.addCheck(v -> v == null || v instanceof Map);
    }

    @Override
    void addCheck(Predicate<Object> check) {
        super.addCheck(check);
    }

    @Override
    public MapSchema required() {
        this.addCheck(v -> v instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        this.addCheck(v -> v != null && ((Map<?, ?>) v).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> pair : schemas.entrySet()) {
            String key = pair.getKey();
            BaseSchema schema = pair.getValue();
            this.addCheck(v -> (v instanceof Map) && (schema.isValid(((Map<?, ?>) v).get(key))));
        }
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        return super.isValid(value);
    }
}
