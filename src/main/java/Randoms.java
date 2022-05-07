import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    protected Random random;
    private int min;
    private int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        random = new Random();
    }

    private int nextIntInRange() {
        return min + random.nextInt(max - min + 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                if (random != null) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return nextIntInRange();
                } else {
                    throw new RuntimeException("Ошибка создания объекта");
                }
            }
        };
    }
}
