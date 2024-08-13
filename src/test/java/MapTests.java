import eu.witherxse.dsa.map.LRUMap;
import eu.witherxse.dsa.map.SimpleHashMap;
import eu.witherxse.dsa.map.SimpleMap;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

public class MapTests {

    @Test
    public void testHashMapWithRehash() {
        //Sure there is a better way to write this test but its for educational purposes mainly
        SimpleMap<String, String> map = new SimpleHashMap<>();
        Field[] fields = map.getClass().getDeclaredFields();
        Field tableSize = null;
        Field initialSize = null;
        for (Field field : fields) {
            if (field.getName().equals("tableSize")) {
                tableSize = field;
            } else if (field.getName().equals("INITIAL_SIZE")) {
                initialSize = field;
            }
        }
        int initialSizeValue = 0;
        try {
            initialSize.setAccessible(true);
            initialSizeValue = initialSize.getInt(map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        IntStream.range(0, (int) Math.pow(initialSizeValue, 2)).forEach(i -> map.put("key" + i, "value" + i));

        assert tableSize != null;
        try {
            tableSize.setAccessible(true);
            assert tableSize.getInt(map) > initialSizeValue;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        assert map.get("key1").equals("value1");
        assert map.get("key32").equals("value32");
        assert map.get("key45").equals("value45");
        assert map.get("key20").equals("value20");
        assert map.contains("key1");
        assert !map.contains("key" + (int) Math.pow(initialSizeValue, 2));
        map.remove("key1");
        assert !map.contains("key1");
    }

    @Test
    public void testLRUMap() {
        SimpleMap<String, String> map = new LRUMap<>(3);
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        assert map.get("key1").equals("value1");
        map.put("key4", "value4");
        assert !map.contains("key2");
        assert map.get("key1").equals("value1");
        assert map.get("key3").equals("value3");
        assert map.get("key4").equals("value4");
    }
}
