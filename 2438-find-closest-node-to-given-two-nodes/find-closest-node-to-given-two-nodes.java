class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
       int n = edges.length;

        int[] dist1 = dijkstra(edges, node1, n);
        int[] dist2 = dijkstra(edges, node2, n);

        int minDistance = Integer.MAX_VALUE;
        int minNode = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    minNode = i;
                }
            }
        }

        return minNode;
    }

    private int[] dijkstra(int[] edges, int startNode, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{startNode, 0});

        while (!pq.isEmpty()) {
            int[] nodeInfo = pq.poll();
            int node = nodeInfo[0];
            int currDist = nodeInfo[1];

            if (currDist > dist[node]) {
                continue;
            }

            int neighbor = edges[node];
            if (neighbor != -1) {
                int newDist = currDist + 1; 
                if (newDist < dist[neighbor]) {
                    dist[neighbor] = newDist;
                    pq.offer(new int[]{neighbor, newDist});
                }
            }
        }

        return dist;
    }
}