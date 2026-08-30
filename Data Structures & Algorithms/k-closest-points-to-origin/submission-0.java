class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue <int[]> maxH = new PriorityQueue<> ((a,b) ->

        Integer.compare(

            b[0] * b[0] + b[1] * b[1], 
            a[0] * a[0] + a[1] * a[1]
        )
        );
        
        for(int i = 0; i < points.length; i++){
            maxH.add(points[i]);

            if(maxH.size() > k){
                maxH.poll();
            }
        }

        int [][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = maxH.poll();
        }

        return result;

    }
}
