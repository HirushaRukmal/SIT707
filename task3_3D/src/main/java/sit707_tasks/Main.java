package sit707_tasks;

public class Main {

    public static void main(String[] args) {

        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Original: " + date);

        DateUtil next = date.nextDate();
        System.out.println("Next Date: " + next);

        DateUtil prev = date.previousDate();
        System.out.println("Previous Date: " + prev);

        System.out.println("Leap Year Check: " + DateUtil.isLeapYear(2024));
        System.out.println("Days in Feb 2024: " + DateUtil.daysInMonth(2, 2024));
    }
}