package BTTH1_21521842;

public class bai5 {
    public static void main(String[] args) {
        String s1 = "Information";
        String s2 = "Technology";

        // 1. Cho biết tổng chiều dài 2 chuỗi s1 và s2.
        int totalLength = s1.length() + s2.length();
        System.out.println("Total length: " + totalLength);

        // 2. Lấy 3 kí tự đầu tiên chuỗi s1.
        String firstThreeChars = s1.substring(0, 3);
        System.out.println("First three characters of s1: " + firstThreeChars);

        // 3. Lấy 3 kí tự cuối của chuỗi s2.
        String lastThreeChars = s2.substring(s2.length() - 3);
        System.out.println("Last three characters of s2: " + lastThreeChars);

        // 4. Lấy kí tự thứ 6 của chuỗi s1
        char sixthChar = s1.charAt(5);
        System.out.println("Sixth character of s1: " + sixthChar);

        // 5. Kiểm tra 2 chuỗi s1 và s2 có bằng nhau không?
        boolean areEqual = s1.equals(s2);
        System.out.println("Are s1 and s2 equal? " + areEqual);

        // 6. Cho biết s2 có xuất hiện trong s1 hay không? Nếu có thì đó là vị trí nào?
        int position = s1.indexOf(s2);
        if (position != -1) {
            System.out.println("s2 appears in s1 at position: " + position);
        } else {
            System.out.println("s2 does not appear in s1");
        }
    }
}
