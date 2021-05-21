public class MyLinkedList<K extends Comparable<K>> {
    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null)
            this.tail = newNode;
        if (this.head == null)
            this.head = newNode;
        else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void append(INode newNode) {
        if(this.head == null)
            this.head = newNode;
        if(this.tail == null)
            this.tail = newNode;
        else {
            INode tempNode = this.tail;
            this.tail = newNode;
            tempNode.setNext(newNode);
        }
    }

    public void insert(INode myNode, INode newNode) {
        this.head.setNext(myNode);
        myNode.setNext(newNode);
    }

    public INode pop() {
        INode  tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode popLast(){
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = null;
        return tempNode;
    }

    public INode <K> search(INode<K> myNode){
        INode<K> tempNode = head;
        while (tempNode.getNext()!=myNode){
            tempNode=tempNode.getNext();
        }
        tempNode = tempNode.getNext();
        System.out.println("Searched Element is = " +tempNode.getKey());
        return tempNode;
    }

    public INode<K> searchKey(K key) {
        INode<K> tempNode = head;
        while (tempNode != null && tempNode.getNext() != null){
            if(tempNode.getKey().equals((K) key)){
                return tempNode;
            }

            tempNode = tempNode.getNext();
        }
        return null;
    }

    public  INode<K> delete(K i) {
        INode tempNode = head, prev = null;

        if (tempNode.getKey() == i && tempNode != null) {
            head = tempNode.getNext();
        }
        while (tempNode != null && tempNode.getKey() != i) {
            prev = tempNode;
            tempNode = tempNode.getNext();
        }

        if(tempNode!=null) {
            prev.setNext(tempNode.getNext());
        }else{
            return null;
        }
        return tempNode;
    }


    public void size(INode head) {
        int count = 0;
        INode node = head;
        while (node != null) {
            count++;
            node = node.getNext();
        }
        System.out.println("Size of LinkedList is: " + count);
    }

    public void sortedLinkedList(INode<K> newNode) {
        INode tempNode = head;
        INode prevNode = null;
        while (tempNode != null && (newNode.getKey()).compareTo((K) tempNode.getKey()) > 0) {
            prevNode = tempNode;
            tempNode = tempNode.getNext();
        }
        if (prevNode == null) {
            this.head = newNode;
        } else {
            prevNode.setNext(newNode);
        }
        newNode.setNext(tempNode);
        tempNode =head;
        while (tempNode!=null){
            this.tail=tempNode;
            tempNode=tempNode.getNext();
        }
    }

    public void printMyNodes(){
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempNode = head;
        while (tempNode.getNext()!=null){
            myNodes.append(tempNode.getKey());
            if(!tempNode.equals(tail))
                myNodes.append("->");
            tempNode=tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }
}