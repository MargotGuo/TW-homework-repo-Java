package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DistinctIterable<Character> implements Iterable<Character> {
    private Iterable<Character> iterable;

    public DistinctIterable(Iterable<Character> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<Character> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<Character> toList() {
        List<Character> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<Character> implements Iterator<Character> {
    // TODO: Implement the class to pass the test.
    // <--start
    private final Iterator<Character> iterator;

    DistinctIterator(Iterator<Character> iterator) {
        Set<Character> characterSet = new HashSet<>();
        while (iterator.hasNext()) {
            characterSet.add(iterator.next());
        }
        this.iterator = characterSet.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Character next() {
        return iterator.next();
    }

    // --end->
}