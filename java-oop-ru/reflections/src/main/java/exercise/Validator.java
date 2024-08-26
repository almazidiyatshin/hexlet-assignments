package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.List;

class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<String>();
        var fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                if (field.isAnnotationPresent(NotNull.class)) {
                    var value = field.get(address);

                    if (value == null) {
                        result.add(field.getName());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
// END
