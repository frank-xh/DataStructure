package stack;

import array.Array;

public class ArrayStack<E> implements Stack {
    Array<Object> array;

    public ArrayStack(int capacity){
        array=new Array<>(capacity);
    }
    public ArrayStack(){
        array=new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(Object o) {
        array.addLast(o);
    }

    @Override
    public Object pop() {
        return array.removeLast();
    }

    @Override
    public Object peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
