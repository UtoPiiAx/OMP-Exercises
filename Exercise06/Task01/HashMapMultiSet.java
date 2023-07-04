import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class HashMapMultiSet <T> implements MultiSet <T> {

    private Map<T, Integer> map = new HashMap<>();

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }
    @Override
    public void add (T element) {
        Integer count = map.get(element);
        if (count == null) {
            count = 0;
        }
        count++;
        map.put(element, count);
    }

    @Override
    public int count (T element) {
        Integer count = map.get(element);
        if (count == null) {
            count = 0;
        }
        return count;
    }
}
