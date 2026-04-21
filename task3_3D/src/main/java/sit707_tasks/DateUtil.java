package sit707_tasks;

public class DateUtil {

    public static final int MIN_YEAR = 1700;
    public static final int MAX_YEAR = 2024;

    private int day;
    private int month;
    private int year;

    public DateUtil(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new RuntimeException("Invalid date: " + day + "-" + month + "-" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static int daysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            throw new RuntimeException("Invalid month: " + month);
        }

        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1) {
            return false;
        }
        return day <= daysInMonth(month, year);
    }

    public DateUtil nextDate() {
        int newDay = day;
        int newMonth = month;
        int newYear = year;

        if (day < daysInMonth(month, year)) {
            newDay++;
        } else if (month < 12) {
            newDay = 1;
            newMonth++;
        } else {
            if (year == MAX_YEAR) {
                throw new RuntimeException("Next date exceeds allowed year range.");
            }
            newDay = 1;
            newMonth = 1;
            newYear++;
        }

        return new DateUtil(newDay, newMonth, newYear);
    }

    public DateUtil previousDate() {
        int newDay = day;
        int newMonth = month;
        int newYear = year;

        if (day > 1) {
            newDay--;
        } else if (month > 1) {
            newMonth--;
            newDay = daysInMonth(newMonth, year);
        } else {
            if (year == MIN_YEAR) {
                throw new RuntimeException("Previous date exceeds allowed year range.");
            }
            newYear--;
            newMonth = 12;
            newDay = daysInMonth(newMonth, newYear);
        }

        return new DateUtil(newDay, newMonth, newYear);
    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }
}