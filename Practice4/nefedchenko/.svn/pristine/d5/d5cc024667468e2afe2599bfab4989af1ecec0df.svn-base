package ua.nure.nefedchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;

    private int size;

    public ArrayImpl() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public static void main(String[] args) {
        Array array = new ArrayImpl();
        array.add("Q");
        array.add("W");
        array.add("R");
        array.set(2, "E");
        System.out.println(array.size());
        Iterator it = array.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
        System.out.println(array.get(0));
        System.out.println(array.indexOf("Q"));
        array.remove(0);
        System.out.println(array);
        Array arr = new ArrayImpl();
        arr.add("A");
        arr.add("B");
        arr.add("C");
        System.out.println(arr);
        Iterator it2 = arr.iterator();
        System.out.println(it2.next());
        it2.remove();
        System.out.println(it2.next());
        arr.clear();
        System.out.println(arr);
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(elementData[i]);
            if (i == size - 1) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }

    @Override
    public void add(Object element) {
        elementData[size++] = element;
    }

    @Override
    public void set(int index, Object element) {
        elementData[index] = element;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        private int indexOfNext;
        private int lastRet = -1;

        IteratorImpl() {
        }

        @Override
        public boolean hasNext() {
            return indexOfNext != size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = indexOfNext;
            indexOfNext = i + 1;
            lastRet = i;
            return elementData[lastRet];
        }

        @Override
        public void remove() {
            if (lastRet >= 0 && lastRet < ArrayImpl.this.size()) {
                ArrayImpl.this.remove(lastRet);
                indexOfNext = lastRet;
                lastRet = -1;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}

