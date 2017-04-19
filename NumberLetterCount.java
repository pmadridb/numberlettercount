public final class NumberLetterCount {

    private static String[] ONES = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] TENS = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        System.out.println(new NumberLetterCount().run());
    }

    public String run() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += toEnglish(i).length();
        }
        return Integer.toString(sum);
    }

    private static String toEnglish(int number) {
        if (number < 0 || number > 99999) {
            throw new IllegalArgumentException();
        }

        if (number < 100) {
            return tens(number);
        } else {
            String big = "";
            if (number >= 1000) {
                big += tens(number / 1000) + "thousand";
            }
            if (number / 100 % 10 != 0) {
                big += ONES[number / 100 % 10] + "hundred";
            }

            return big + (number % 100 != 0 ? "and" + tens(number % 100) : "");
        }
    }

    private static String tens(int number) {
        if (number < 10) {
            return ONES[number];
        } else if (number < 20) {
            return TEENS[number - 10];
        } else {
            return TENS[number / 10 - 2] + (number % 10 != 0 ? ONES[number % 10] : "");
        }
    }

}