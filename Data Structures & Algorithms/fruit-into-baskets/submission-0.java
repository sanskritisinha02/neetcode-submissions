class Solution {
    public int totalFruit(int[] fruits) {

        int i = 0;
        int j = 0;
        int k = 2;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<> ();

        while(j < n){

            map.put(fruits[i], map.getorDefault(fruits[i], 0) + 1);

            if(map.size() <= k){

                count = Math.max(count, j-i+1);
                j++;
            }

            else if(map.size() > k){

                while(map.size() > k){
                    

                }




            }







        }


        
    }
}