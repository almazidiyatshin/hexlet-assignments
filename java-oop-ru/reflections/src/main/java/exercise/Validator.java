package exercise;

import java.lang.reflect.Field;
// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<String>();
        var fields = address.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                if (field.isAnnotationPresent(NotNull.class)) {
                    String value = field.get(address);

                    if (value == null) {
                        result.add(field.getName());
                    }
                }
            } catch (e) {
                System.out.println('Error');
            }
        }

        return result;
    }
}
// END
