class Floyd_warshall {
    final static int INF = 99999, vertex = 4;

    public static void main(String[] args) {
        int graph[][] = { { 5, INF, 0, 1 },
                { 2, INF, INF, 0 },
                { 0, 3, INF, 7 },
                { 8, 0, 2, 0 }
        };

        floydWarshall(graph);
    }

    static void printSolution(int distance[][]) {
        System.out.println("floydWarshall");
        for (int i = 0; i < vertex; ++i) {
            for (int j = 0; j < vertex; ++j) {
                if (distance[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void floydWarshall(int graph[][]) {
        int distance[][] = new int[vertex][vertex];

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < vertex; k++) {
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < vertex; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
        printSolution(distance);
    }
}
