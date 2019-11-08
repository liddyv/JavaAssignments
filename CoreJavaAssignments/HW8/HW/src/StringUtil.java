

public class StringUtil {

	/*  
	 * @HomeWork #8: StringUtil.java
	 * @Author: WanLing Hsieh
	 * @Description: 
	 * This utility class add the necessary spaces to a string to reach a specified length
	 */
    public static String padWithSpaces(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
}
