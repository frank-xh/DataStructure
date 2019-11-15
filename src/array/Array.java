package array;

import java.lang.Object;

public class Array<E> {
    private Object[] data;
    //用来记录数组中元素的个数
    private int size;

    //构造函数，使用者可以指定数组的初始化大小
    public Array(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    //当使用者没有指定数组初始大小时，默认为10
    public Array() {
        //调用上面带参的构造器
        this(10);
    }

    //获取数组中元素的个数
    public int getSize() {
        return size;
    }

    //得到数组的容量大小
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在数组末尾添加元素
    public void addLast(E e) {
     //直接调用Insert方法，插入的位置为最后一个
        add(size,e);
    }
    public void addFirst(E e){
        add(0,e);
    }
    //在数组指定位置插入元素
    public void add(int index,E e) {
        if (index<0||index>size)
            throw new IllegalArgumentException("添加失败，请输入合法的index值");
        if (size == data.length)
            resize(2*data.length);
        //从后往前，先把后面的元素挪位置
        for (int i =  size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = e;
            size++;
    }
    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
        res.append('[');
        for (int i = 0; i <size; i++) {
            res.append(data[i]);
            if (i!=size-1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
    //获取index位置的元素
    public Object get(int index){
        //保证传入的index是合法的
//        if(index<0||index>=size)
//            throw new IllegalArgumentException("Index is illegal ");
        return data[index];
    }
    //更新index位置的元素
    public void set(int index,E e){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Index is illegal ");
        data[index]=e;
    }
    //查询数组中是否有元素e
    public boolean contains(E e){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }
    //查询数组中元素的索引，如果不存在，则返回-1
    public int find(E e){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    //从数组中删除index位置的元素，并将其返回
    public Object remove(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Index is illegal ");
        Object res=data[index];
        for (int i = index+1; i <size ; i++) {
            data[i-1]=data[i];
            return res;
        }
        size--;
        //让其值为null，可以被垃圾回收
        data[size]=null;
        return res;
    }
    //从数组中删除带一个元素，并返回
    public Object removeFirst(){
        return remove(0);
    }
    //从数组中删除最后一个元素，并返回
    public Object removeLast(){
        return remove(size-1);
    }
    //从数组中删除元素
    public void removeElement(E e){
        int index=find(e);
        if(index!=-1)
            remove(index);
    }
    //为数组扩容的方法，设置为private，禁止用户访问
    private void resize(int newCapacity){
        Object[] newData= new Object[newCapacity];
        for (int i = 0; i <size ; i++) {
            newData[i]=data[i];
        }
        data=newData;

    }
}