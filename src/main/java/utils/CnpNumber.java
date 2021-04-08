package utils;

import config.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CnpNumber {
    private static final String DIGIT_SEQUENCE_TO_MULTIPLY = Configuration.getConfigurationValue("cnp_number_sequence");

    public static String generateRandomCNP() throws ParseException {
        int[] twelveDigits = generateTwelveCNPDigits();
        int thirteenthDigit = calculateLastDigit(twelveDigits);

        return Arrays.toString(twelveDigits)
                .replaceAll("\\[|\\]|,|\\s", "")
                .concat(String.valueOf(thirteenthDigit));
    }

    private static int[] generateTwelveCNPDigits() throws ParseException {
        int firstDigit = generateRandomFirstDigit();
        int[] firstDigitAsArr = new int[]{firstDigit};
        int[] dateDigits = parseDateToCnpDigits(firstDigit);
        int[] areaCodeDigits = generateAreaCodeDigits();
        int[] orderNumberDigits = generateRandomLastDigits();

        return Stream.of(firstDigitAsArr, dateDigits, areaCodeDigits, orderNumberDigits)
                .flatMapToInt(IntStream::of).toArray();
    }

    private static int calculateLastDigit(int[] twelveDigits){
        int[] multiplierDigits = Stream.of(DIGIT_SEQUENCE_TO_MULTIPLY.split(""))
                .mapToInt(Integer::parseInt).toArray();

        int thirteenthDigit = 0;
        for (int i = 0; i < twelveDigits.length; i++) {
            if(i == twelveDigits.length-1) {
                int prevDigit = twelveDigits[i-1];
                int currentDigit = twelveDigits[i];
                int additionalDigitToMultiply = Integer.parseInt(String.format("%d%d", prevDigit, currentDigit));

                thirteenthDigit+= prevDigit*multiplierDigits[i];
                thirteenthDigit+= additionalDigitToMultiply*multiplierDigits[i];
            } else {
                thirteenthDigit += twelveDigits[i]*multiplierDigits[i];
            }
        }

        thirteenthDigit = thirteenthDigit % 11;
        return thirteenthDigit == 10 ? 1 : thirteenthDigit;
    }

    private static int generateRandomFirstDigit(){
        int min = 1;
        int max = 9;

        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    private static int[] generateRandomLastDigits(){
        int min = 1;
        int max = 12;

        int randomInt = ThreadLocalRandom.current().nextInt(min, max+1);
        return convertNumberIntoThreeDigits(randomInt);
    }

    private static int generateAreaCodeNumber() {
        int min = 1;
        int max = 52;

        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    private static int[] generateAreaCodeDigits() {
        int areaCode = generateAreaCodeNumber();
        return convertNumberIntoTwoDigits(areaCode);
    }

    private static int[] parseDateToCnpDigits(int firstDigit) throws ParseException {
        Instant instantDate = generateRandomDateForCnp(firstDigit);
        LocalDate localDate = LocalDate.ofInstant(instantDate, ZoneId.systemDefault());

        int lastTwoDigitsOfYear = localDate.getYear() % 100;
        int[] yearDigits = convertNumberIntoTwoDigits(lastTwoDigitsOfYear);

        int month = localDate.getMonthValue();
        int[] monthDigits = convertNumberIntoTwoDigits(month);

        int day = localDate.getDayOfMonth();
        int[] dayDigits = convertNumberIntoTwoDigits(day);

        return Stream.of(yearDigits, monthDigits, dayDigits).flatMapToInt(IntStream::of).toArray();
    }

    private static int[] convertNumberIntoTwoDigits(int number) {
        int[] twoDigits = new int[2];
        String strNumber= String.valueOf(number);

        if(strNumber.length() == 1) {
            twoDigits[1] = number;
        }else if(strNumber.length() == 2) {
            char[] chars = strNumber.toCharArray();
            twoDigits[0] = Integer.parseInt(Character.toString(chars[0]));
            twoDigits[1] = Integer.parseInt(Character.toString(chars[1]));
        }

        return twoDigits;
    }

    private static int[] convertNumberIntoThreeDigits(int number) {
        int[] threeDigits = new int[3];
        String strNumber= String.valueOf(number);

        if(strNumber.length() == 1) {
            threeDigits[2] = number;
        }else if(strNumber.length() == 2) {
            char[] chars = strNumber.toCharArray();
            threeDigits[1] = Integer.parseInt(Character.toString(chars[0]));
            threeDigits[2] = Integer.parseInt(Character.toString(chars[1]));
        }

        return threeDigits;
    }

    private static Instant generateRandomDateForCnp(int firstDigit) throws ParseException {
        String now = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now()));

        if(firstDigit == 1 || firstDigit == 2){
            return generateRandomDateBetween("1900-01-01", "1999-12-31");
        }else if(firstDigit == 3 || firstDigit == 4){
            return generateRandomDateBetween("1800-01-01", "1899-12-31");
        }else if(firstDigit == 5 || firstDigit == 6){
            return generateRandomDateBetween("2000-01-01", now);
        }

        return generateRandomDateBetween("1900-01-01", now);
    }

    private static Instant generateRandomDateBetween(String startInclusive, String endExclusive) throws ParseException {
        Instant start = dateToInstant(startInclusive);
        Instant end = dateToInstant(endExclusive);

        long startSeconds = start.getEpochSecond();
        long endSeconds = end.getEpochSecond();
        long random = ThreadLocalRandom
                .current()
                .nextLong(startSeconds, endSeconds);

        return Instant.ofEpochSecond(random);
    }

    private static Instant dateToInstant(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateString).toInstant();
    }
}
