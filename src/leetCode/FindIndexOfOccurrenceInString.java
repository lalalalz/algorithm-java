package leetCode;

public class FindIndexOfOccurrenceInString {

    public int strStr(String haystack, String needle) {
        return getIndexOfOccurrenceInString(haystack, needle);
    }

    private int getIndexOfOccurrenceInString(String haystack, String needle) {
        int[] pmt = getPMT(needle);
        return runKMP(haystack, needle, pmt);
    }

    private int runKMP(String haystack, String needle, int[] pmt) {
        int result = -1;
        int begin = 0;
        int matched = 0;

        while (begin + matched < haystack.length()) {
            if (haystack.charAt(begin + matched) == needle.charAt(matched)) {
                matched++;

                if (matched == needle.length()) {
                    result = begin;
                    break;
                }
            }
            else {
                if (matched == 0) {
                    begin++;
                }
                else {
                    begin += matched - pmt[matched - 1];
                    matched = pmt[matched - 1];
                }
            }
        }

        return result;
    }

    private int[] getPMT(String needle) {
        int[] pmt = new int[needle.length()];

        int begin = 1;
        int matched = 0;

        while (begin + matched < needle.length()) {
            if (needle.charAt(begin + matched) == needle.charAt(matched)) {
                matched++;
                pmt[begin + matched - 1] = matched;
            }
            else {
                if (matched == 0) {
                    begin++;
                }
                else {
                    begin += matched - pmt[matched - 1];
                    matched = pmt[matched - 1];
                }
            }
        }

        return pmt;
    }
}