class TimeMap {

    HashMap<String, ArrayList<String>> values;
    HashMap<String, ArrayList<Integer>> timestamps;

    public TimeMap() {
        values = new HashMap<>();
        timestamps = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!values.containsKey(key)) {
            values.put(key, new ArrayList<>());
            timestamps.put(key, new ArrayList<>());
        }

        values.get(key).add(value);
        timestamps.get(key).add(timestamp);
    }

    public String get(String key, int timestamp) {

        if (!values.containsKey(key)) {
            return "";
        }

        ArrayList<Integer> list = timestamps.get(key);
        ArrayList<String> valueList = values.get(key);

        int start = 0;
        int end = list.size() - 1;

        String result = "";

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (list.get(mid) == timestamp) {
                return valueList.get(mid);
            }

            else if (list.get(mid) < timestamp) {
                result = valueList.get(mid);
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return result;
    }
}