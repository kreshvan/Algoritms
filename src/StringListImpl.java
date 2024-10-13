
import ElementNotFaundException.ElementNotFoundException;
import IndexMinMaxException.IndexMinMaxException;
import NullItemException.NullItemException;
import StorageFullException.StorageFullException;


import java.util.Arrays;
import java.util.stream.Stream;

public class StringListImpl implements StringList {

    //ТО С ЧЕМ БУДЕМ РАБОТАТЬ
    private final String[] storage;
    private int size;


    public StringListImpl() {
        storage = new String[10];
    }

    public StringListImpl(int intsize) {
        storage = new String[intsize];

    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;

    }


    @Override
    public String addOne(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            add(item);
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[size++] = String.valueOf(index);
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);//проверка индекса на исключение
        validateItem(item);//проверка индекса на исключения //исключения прописаны внизу
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
validateItem(item);
        int index = indexOf(item);

        if (index == -1) {
            throw new ElementNotFoundException();
        }
        if (index == size) {
            storage[size--] = null;
            return (item);//если индекс равен(размер хранилища позволяет //) размеру хранилища 1/1, то storage[size--]=null;
        }          // -в хранилище размер 1 - 1 должно остаться null
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return (item);
    }


    @Override
    public String removeOne(int index) {
validateIndex(index);
        String item = storage[index];

        if (index != size) {
            throw new ElementNotFoundException();
        }
        System.arraycopy(storage, index + 1, storage, index, size - index);
        size--;
        return (item);
            //если индекс равен(размер хранилища позволяет //) размеру хранилища 1/1, то storage[size--]=null;
        }          // -в хранилище размер 1 - 1 должно остаться null

        // System.arraycopy-принимает параметры которые мы укажем 1.storage-хранилище-источник с чем работаем
        //2.index +1 - позиция начала нового массива.\
        //3. массив-назначения.
        //4.начальным положением целевого массива.
        //5. количество элементов, которые будут скопированы



    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
            }
            return i;
        }
        return -1;

        }
    @Override
    public int lastIndexOf(String item) {
            for (int i = size-1; i>=0; i--) {
                if (storage[i].equals(item)) {//если в хранилище i(число перебора в цикле)= item-элемент
                   // то выводим этот элемент
                }
                return i;
            }
            return -1;

        }

    @Override
    public String get(int index) {
     validateIndex(index);
     return storage[index];

    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size==0;
    }

    @Override
    public void clear() {
      size=0;

    }

    @Override
    public String[] toArray() {

        return Arrays.copyOf(storage,size);
    }

    public void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    public void validateSize() {
        if (size > storage.length) {
            throw new StorageFullException();
        }
    }


    public void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexMinMaxException();
        }

    }
}




