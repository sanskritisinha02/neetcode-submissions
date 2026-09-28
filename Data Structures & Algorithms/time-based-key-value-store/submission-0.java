class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Pair> list = map.get(key);

        int start = 0;
        int end = list.size() - 1;

        String result = "";

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).value;
            }

            else if (list.get(mid).timestamp < timestamp) {
                result = list.get(mid).value;
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return result;
    }
}