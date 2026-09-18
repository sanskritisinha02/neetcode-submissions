class TimeMap {

    Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)){
            map.put(key, new ArrayList<> ());
        }
        map.get(key).add(new Pair (timestamp, value));
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)){
            return "";
        }

        ArrayList<Pair> list = map.get(key);

        int start = 0;
        int end = list.size() - 1;

        String answer = "";

        while(start <= end){

            int mid = start + (end - start)/2;

            if(list.get(mid).timestamp <= timestamp){
                answer = list.get(mid).value;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return answer;
    } 
}

class Pair{

    int timestamp;
    String value;

    Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}
