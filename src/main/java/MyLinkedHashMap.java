import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
    private final int numBuckets;
    ArrayList<MyLinkedList> myBucketArray;

    public MyLinkedHashMap() {
        numBuckets = 10;
        myBucketArray = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++)
            this.myBucketArray.add(null);
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        System.out.println("Key: " + key + " HashCode: " + hashCode + " index: " + index);
        return index;
    }


    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList myLinkedList = myBucketArray.get(index);
        if (myLinkedList == null)
            return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.searchKey((Comparable) key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }


    public void add(K key, V value) {
        int index = getBucketIndex(key);
        MyLinkedList myLinkedList = myBucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList();
            myBucketArray.set(index, myLinkedList);
        }
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.searchKey((Comparable) key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<K, V>(key, value);
            myLinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }

    public String toString() {
        return "MyLinkedHashMap List{" + myBucketArray + "}";
    }
}