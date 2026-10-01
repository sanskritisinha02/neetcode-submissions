class LRUCache {

    class Node{

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;

            prev = null;
            next = null;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    HashMap <Integer, Node> map;
    int limit;

    public LRUCache(int capacity) {

        limit = capacity;
        map = new HashMap<> ();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {

        //does not exist
        if(!map.containsKey(key)){
            return -1;
        }

        Node ansNode = map.get(key);

        delNode(ansNode);
        addNode(ansNode);

        return ansNode.value;
    }
    
    public void put(int key, int value) { //O(1)

        //3 cases - 1. already exist in map, 2. capacity is full, 3. addNode

        //1. already exist in map
        if(map.containsKey(key)){

            Node oldNode = map.get(key);
            delNode(oldNode);
            map.remove(key);
        }

        //2. capacity is full
        if(map.size() == limit){

            //delete LRU data
            Node lruNode = tail.prev;
            map.remove(lruNode.key);
            delNode(lruNode);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }

    public void addNode(Node newNode){

        Node oldNext = head.next;

        head.next = newNode;
        oldNext.prev = newNode;

        newNode.next = oldNext;
        newNode.prev = head;
    }

    public void delNode(Node oldNode){

        Node oldPrev = oldNode.prev;
        Node oldNext = oldNode.next;

        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
    }
}
