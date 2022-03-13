package app;

import jdk.jshell.spi.ExecutionControl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class Series implements List {

    private final ArrayList<Object> elements;
    public ArrayList<Object> getElements() {
        return this.elements;
    }

    public Series() {
        this.elements = new ArrayList<>();
    }


    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : this.elements) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object o) {
        int startingSize = this.elements.size();
        this.elements.add(o);
        return this.elements.size() == startingSize + 1;
    }

    @Override
    public void add(int index, Object element) {
        if (index >= this.elements.size()) {
            this.elements.add(element);
        } else if (index < 0) {
            this.elements.add(0, element);
        } else {
            this.elements.add(index, element);
        }
    }

    @Override
    public boolean addAll(Collection c) {
        return this.elements.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return this.elements.addAll(index, c);
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public Object get(int index) {
        return this.elements.get(index);
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = this.elements.size() - 1; i >= 0; i--) {
            if (this.elements.get(i).equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return this.elements.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        if (!this.contains(o)) {
            return false;
        } else {
            this.remove(this.indexOf(o));
            return true;
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean contained = false;
        for (Object o : c) {
            if (this.contains(o)) {
                contained = true;
                this.remove(o);
            }
        }
        return contained;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }



    // not implementing

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
