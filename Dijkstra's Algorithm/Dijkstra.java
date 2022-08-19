class Dijkstra {
    static int V = 6;

    public static void main(String args[]) {
        int graph[][] = new int[][] { { 0, 7, 9, 0, 0, 14 },
                { 7, 0, 10, 15, 0, 0 },
                { 9, 10, 0, 11, 0, 2 },
                { 0, 15, 11, 0, 6, 0 },
                { 0, 0, 0, 6, 0, 9 },
                { 14, 0, 2, 0, 9, 0 } };
        dijkstras(graph, 0);
    }

    static int minDistance(int dist[], Boolean a[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < V; i++) {
            if (a[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }

    static void dijkstras(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean a[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            a[i] = false;
        }
        dist[src] = 0;
        for (int j = 0; j < V - 1; j++) {
            int u = minDistance(dist, a);
            a[u] = true;
            for (int i = 0; i < V; i++) {
                if (!a[i] && graph[u][i] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][i] < dist[i]) {
                    dist[i] = dist[u] + graph[u][i];
                }
            }
        }
        printSolution(dist);
    }

    static void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
