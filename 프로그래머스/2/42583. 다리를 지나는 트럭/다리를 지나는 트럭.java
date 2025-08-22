import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeWeight = 0; 
        
        Queue<Integer> waitingQueue = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            waitingQueue.offer(truckWeight);
        }
        
        Queue<int[]> bridgeQueue = new LinkedList<>();

        while (!waitingQueue.isEmpty() || !bridgeQueue.isEmpty()) {
            time++;

            if (!bridgeQueue.isEmpty()) {
                if (bridgeQueue.peek()[1] <= time) {
                    int[] truck = bridgeQueue.poll();
                    bridgeWeight -= truck[0]; 
                }
            }

            if (!waitingQueue.isEmpty()) {
                int nextTruckWeight = waitingQueue.peek();

                if (bridgeWeight + nextTruckWeight <= weight) {
                    int nextTruck = waitingQueue.poll();
                    bridgeQueue.offer(new int[]{nextTruck, time + bridge_length});
                    bridgeWeight += nextTruck;
                }
            }
        }
        
        return time;
    }
}