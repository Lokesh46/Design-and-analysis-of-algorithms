import java.util.*;

public class Linear_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp = 0;
        System.out.println("Enter size of an array");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter elements of an array");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println("Enter number to be searched");
        int ch = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (a[i] == ch) {
                System.out.println("Number is present at position: " + (i + 1));
                temp = 1;
                break;
            }
        }
        if (temp == 0) {
            System.out.println("Number is not found");
        }
    }
}
