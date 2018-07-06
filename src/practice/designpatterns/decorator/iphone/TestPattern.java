package practice.designpatterns.decorator.iphone;

/**
 * main 메소드가 구현된 메인 클래스.
 *
 * @version     1.0 06 Jul 2018
 * @author      Seokgyu Hwang
 */
public class TestPattern {
    public static void main(String[] args) {
        /* printf()에서 사용할 문자열과 포맷 */
        final String title1 = "device & available os";
        final String title2 = "chip & features";
        final int    maxLength;        // title1과 title2의 길이 중 최댓값
        final String stringFormat;     // 포맷.

        maxLength = (title1.length() > title2.length()) ? title1.length()
                                                        : title2.length();
        stringFormat = "%" + maxLength + "s : [%s]\n";

        /* iPhone 6 */
        Phone phone6 = new PhoneSix();
        phone6 = new OSSix(phone6);

        System.out.printf(stringFormat, title1, phone6.getDeviceOs());
        System.out.printf(stringFormat + "\n", title2,
                phone6.arrangeChipAndFeatures());

        /* iPhone 7 */
        Phone phone7 = new PhoneSeven();
        phone7 = new OSSix(phone7);
        phone7 = new OSEight(phone7);

        System.out.printf(stringFormat, title1, phone7.getDeviceOs());
        System.out.printf(stringFormat + "\n", title2,
                phone7.arrangeChipAndFeatures());

        /* iPhone 8 */
        Phone phone8 = new PhoneEight();
        phone8 = new OSNine(phone8);

        System.out.printf(stringFormat, title1, phone8.getDeviceOs());
        System.out.printf(stringFormat + "\n", title2,
                phone8.arrangeChipAndFeatures());
    }
}
