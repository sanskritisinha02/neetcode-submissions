class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap <Integer, Integer> map = new HashMap<> ();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }

            else{
                map.put(nums[i], 1);
            }
        }

        PriorityQueue <int[]> minH = new PriorityQueue <> ((a,b) -> 

        {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        }
        );

        Iterator <Integer> it = map.keySet().iterator();
        while(it.hasNext()){
            int num = it.next();
            int freq = map.get(num);

            minH.add(new int[]{freq, num});

            if(minH.size() > k){
                minH.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minH.poll()[1];
        }
        return result;
        
    }
}
