class BST {
    public static void main(String args[]) {
        int a[] = { 10, 20, 30 };
        int freq[] = { 3, 2, 5 };
        System.out.println("Cost of optimal Binary Search Tree is " + optbinsearch(a, freq, 3));
    }

    static int optbinsearch(int a[], int freq[], int n) {
        return cost(freq, 0, n - 1);
    }

    static int sum(int freq[], int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum = sum + freq[i];
        }
        return sum;
    }

    static int cost(int freq[], int a, int b) {
        if (b < a) {
            return 0;
        }
        if (a == b) {
            return freq[a];
        }
        int sum = sum(freq, a, b);

        int min = Integer.MAX_VALUE;
        for (int i = a; i <= b; ++i) {
            int cost = cost(freq, a, i - 1) + cost(freq, i + 1, b);
            if (cost < min) {
                min = cost;
            }
        }
        return min + sum;
    }
}
