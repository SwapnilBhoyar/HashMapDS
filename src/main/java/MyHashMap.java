public class MyHashMap < K extends Comparable <K>, V>{
    private final MyLinkedList<K> myLinkedList;

    public MyHashMap() {
        this.myLinkedList = new MyLinkedList<>();
    }

    public V get(K key) {
        MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) this.myLinkedList.searchKey(key);
        return (myMapNode == null) ? null :myMapNode.getValue();
    }

    public void add(K key, V value){
        MyMapNode<K,V> myMapNode =(MyMapNode<K,V>) this.myLinkedList.searchKey(key);
        if (myMapNode==null){
            myMapNode = new MyMapNode<>(key,value);
            this.myLinkedList.append(myMapNode);
        }else {
            myMapNode.setValue(value);
        }
    }

    public String toString(){
        return "MyHashMapNodes:{"+myLinkedList+"}";
    }
}