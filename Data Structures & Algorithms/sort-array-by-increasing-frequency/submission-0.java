class Solution {
    public int[] frequencySort(int[] nums) {

        HashMap <Integer, Integer> map = new HashMap<> ();

        for(int i = 0; i< nums.length; i++){

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

            return Integer.compare(b[1], a[1]);
        }
        );

        Iterator <Integer> it = map.keySet().iterator();

        while(it.hasNext()){
            int num = it.next();
            int freq = map.get(num);

            minH.add(new int[]{freq, num});
        }

        int[] result = new int[nums.length];

        int index = 0;

        while(minH.size() > 0){
            int [] current = minH.poll();
            int freq = current[0];
            int num = current [1];

            for(int i = 0; i < freq; i++){
                result[index] = num;
                index++;
            }
        }

        return result;
    }
}