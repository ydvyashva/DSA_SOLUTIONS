class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> list of [v, weight]
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        // Min-heap storing {accumulated_weight, u, count}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 1});
        Map<Long, Integer> dist = new HashMap<>();
        dist.put(0L * (k + 1) + 1, 0);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            int count = curr[2];
            if (u == n - 1) {
                return d;
            }

            long stateKey = (long) u * (k + 1) + count;
            if (d > dist.getOrDefault(stateKey, Integer.MAX_VALUE)) {
                continue;
            }

            // Explore neighbors
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                char charU = labels.charAt(u);
                char charV = labels.charAt(v);

                int nextCount = (charU == charV) ? count + 1 : 1;

                if (nextCount <= k) {
                    long nextStateKey = (long) v * (k + 1) + nextCount;
                    int newDist = d + weight;

                    if (newDist < dist.getOrDefault(nextStateKey, Integer.MAX_VALUE)) {
                        dist.put(nextStateKey, newDist);
                        pq.offer(new int[]{newDist, v, nextCount});
                    }
                }
            }
        }

        return -1;
    }
}