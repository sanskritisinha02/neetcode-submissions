class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        Integer[] indices = new Integer[n];

        for(int i = 0; i < n; i++){
            indices[i] = i;
        }

        Arrays.sort(indices, (a,b) -> position[b] - position[a]);

        int fleets = 0;
        double lastTime = 0;

        for(int j = 0; j < indices.length; j++){

            int i = indices[j];
            double time = (double) (target - position[i])/ speed[i];

            if(time > lastTime){
                fleets++;
                lastTime = time;
            }
        } 
        return fleets;
    }
}
