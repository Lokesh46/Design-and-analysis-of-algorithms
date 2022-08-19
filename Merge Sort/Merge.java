import java.util.*;

public class Merge {
    void mergesort(int a[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergesort(a, beg, mid);
            mergesort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }

    void merge(int a[], int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        int l[] = new int[n1];
        int r[] = new int[n2];

        for (i = 0; i < n1; i++) {
            l[i] = a[beg + i];
        }
        for (j = 0; j < n2; j++) {
            r[j] = a[mid + 1 + j];
        }

        i = j = 0;
        k = beg;

        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            } else {
                a[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = l[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = r[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements of an array");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Before Merge Sort");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
        Merge m = new Merge();
        m.mergesort(a, 0, n - 1);
        System.out.println("After Merge Sort");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
