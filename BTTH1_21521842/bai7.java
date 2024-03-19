package BTTH1_21521842;

import java.util.Arrays;

public class bai7 {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5 };
        int n = A.length;

        // Tạo mảng B gồm 3 phần tử ngẫu nhiên
        int m = 3; // số phần tử của mảng B
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = (int) (Math.random() * 100); // giá trị ngẫu nhiên từ 0 đến 99
        }

        // In ra mảng A và mảng B
        System.out.println("Array B: " + Arrays.toString(B));

        // Sao chép mảng A sang mảng C
        int[] C = Arrays.copyOf(A, n);

        // Sao chép 3 phần tử cuối của mảng B vào mảng C
        // elements of array B
        System.arraycopy(B, m - 3, C, 0, 3);

        // Sắp xếp mảng C
        Arrays.sort(C);
        System.out.println("Array C: " + Arrays.toString(C));
    }
}
