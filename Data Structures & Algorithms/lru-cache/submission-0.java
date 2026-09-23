class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        cache = new LinkedHashMap<>(12, 0.75f, true);
    }
    
    public int get(int key) {

        if(!cache.containsKey(key)){
            return -1;
        }

        return cache.get(key);
        
    }
    
    public void put(int key, int value) {

        cache.put(key, value);

        if(cache.size() > capacity){
            int firstKey = cache.entrySet().iterator().next().getKey();
            cache.remove(firstKey);
        }        
    }
}
