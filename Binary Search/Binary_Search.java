import java.util.*;

public class Binary_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements of an array");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter number to be searched");
        int ch = sc.nextInt();
        int b = BinarySearch(a, 0, n - 1, ch);
        if (b != -1) {
            System.out.println("Number is found at " + b);
        } else {
            System.out.println("Number is not present in the array");
        }

    }

    static int BinarySearch(int a[], int beg, int end, int ch) {
        int mid;
        if (end >= beg) {
            mid = (beg + end) / 2;
            if (a[mid] == ch) {
                return mid + 1;
            } else if (a[mid] < ch) {
                return BinarySearch(a, mid + 1, end, ch);
            } else if (a[mid] > ch) {
                return BinarySearch(a, beg, mid - 1, ch);
            }
        }
        return -1;
    }
}
