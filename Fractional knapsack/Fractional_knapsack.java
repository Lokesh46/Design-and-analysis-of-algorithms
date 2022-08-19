import java.util.*;

public class Fractional_knapsack {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of values");
        int n = sc.nextInt();

        int a[] = new int[n];
        System.out.println("Enter Values: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int wt[] = new int[n];
        System.out.println("Enter Weights: ");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter Capacity");
        int c = sc.nextInt();

        System.out.println("Result: " + answer(wt, a, c, n));
    }

    static class ItemValue {
        Double cost;
        double wt, a, c;

        public ItemValue(int wt, int a, int c) {
            this.wt = wt;
            this.a = a;
            this.c = c;
            cost = new Double((double) a / (double) wt);
        }
    }

    private static double answer(int[] a, int[] wt, int c, int n) {
        ItemValue[] x = new ItemValue[n];

        for (int i = 0; i < n; i++) {
            x[i] = new ItemValue(wt[i], a[i], i);
        }

        Arrays.sort(x, new Comparator<ItemValue>() {
            public int compare(ItemValue n1, ItemValue n2) {
                return n2.cost.compareTo(n1.cost);
            }
        });

        double tv = 0d;
        for (ItemValue i : x) {
            int cw = (int) i.wt;
            int cv = (int) i.a;
            if (c - cw >= 0) {
                c = c - cw;
                tv += cv;
            } else {
                double ft = ((double) c / (double) cw);
                tv += (cv * ft);
                c = (int) (c - (cw * ft));
                break;
            }
        }
        return tv;
    }
}
