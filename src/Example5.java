import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Example5 {
    public <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        SplitIterator<T> zipSpliterator = new SplitIterator<>(first.spliterator(), second.spliterator());
        boolean parallel = first.isParallel() || second.isParallel();
        return StreamSupport.stream(zipSpliterator, parallel);
    }

    private static class SplitIterator<T> implements Spliterator<T> {
        private final Spliterator<T> firstSpliterator;
        private final Spliterator<T> secondSpliterator;

        public SplitIterator(Spliterator<T> firstSpliterator, Spliterator<T> secondSpliterator) {
            this.firstSpliterator = firstSpliterator;
            this.secondSpliterator = secondSpliterator;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            boolean hasMoreFromFirst = firstSpliterator.tryAdvance(action);
            boolean hasMoreFromSecond = secondSpliterator.tryAdvance(action);
            return hasMoreFromFirst || hasMoreFromSecond;
        }

        @Override
        public Spliterator<T> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return Math.min(firstSpliterator.estimateSize(), secondSpliterator.estimateSize());
        }

        @Override
        public int characteristics() {
            return firstSpliterator.characteristics() & secondSpliterator.characteristics() &
                    ~(Spliterator.SIZED | Spliterator.SUBSIZED);
        }
    }
}
