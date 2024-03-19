
package BTTH1_21521842;

import java.util.Calendar;

public class bai6 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Calendar a = Calendar.getInstance();
        Calendar b = Calendar.getInstance();

        // Ví du: Ngày 29/2/2024 và ngày 14/2/2019
        a.set(2024, 1, 29);
        b.set(2019, 1, 14);

        // 1. So sánh 2 ngày
        int compareResult = a.compareTo(b);
        if (compareResult < 0) {
            System.out.println("Date a is before date b");
        } else if (compareResult > 0) {
            System.out.println("Date a is after date b");
        } else {
            System.out.println("Date a is equal to date b");
        }

        // 2. Ngày trước a và ngày sau a
        a.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println("Previous date of date a: " + a.getTime());
        a.add(Calendar.DAY_OF_YEAR, 2);
        System.out.println("Next date of date a: " + a.getTime());

        // 3. Xác định ngày thứ mấy trong năm là ngày a
        int dayOfYear = a.get(Calendar.DAY_OF_YEAR);
        System.out.println("Day of the year for date a: " + dayOfYear);

        // 4. Xác định số ngày trong tháng chứa ngày a
        int daysInMonth = a.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("Number of days in the month containing date a: " + daysInMonth);

        // 5. Kiểm tra năm nhuận
        int year = a.get(Calendar.YEAR);
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeapYear) {
            System.out.println("The year containing date a is a leap year");
        } else {
            System.out.println("The year containing date a is not a leap year");
        }
    }
}