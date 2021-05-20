package design;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class TextJustification {

    private static final String SPACE = " ";
    // Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
    public List<String> fullJustify(String[] words, int maxWidth) {
        final List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int i = 0;
        int temp = 0;
        List<String> lineWords = new ArrayList<>();
        List<String> lastLineWords = new ArrayList<>();
        while (i < words.length ) {
            if (lineWords.size() == 0) {
                lineWords.add(words[i]);
                temp += words[i].length();
                i++;
            } else if (temp + words[i].length() +1 <= maxWidth) {
                temp += words[i].length() + 1;
                lineWords.add(words[i]);
                i++;
            } else {
                final StringBuilder line = createNewLine(maxWidth, temp, lineWords);
                result.add(line.toString());
                lastLineWords = lineWords;
                lineWords = new ArrayList<>();
                temp = 0;
            }
        }
        if (lineWords.size() > 0) {
            final StringBuilder line = createNewLine(maxWidth, temp, lineWords);
            result.add(line.toString());
            lastLineWords = lineWords;
        }
        result.set(result.size()-1, createLastLine(lastLineWords, maxWidth));
        return result;
    }

    private String createLastLine(final List<String> lastLineWords, final int maxWidth) {
        final StringBuilder line = new StringBuilder();
        for (int k = 0; k < lastLineWords.size(); k++) {
            if (k != 0){
                line.append(SPACE);
            }
            line.append(lastLineWords.get(k));

        }
        fillSpacesAtEnd(maxWidth, line);
        return line.toString();
    }

    private StringBuilder createNewLine(final int maxWidth, final int temp, final List<String> lineWords) {
        int rem = maxWidth - temp;
        int db = 1;
        if (lineWords.size() -1 > rem){
            db = rem;
        } else if ((lineWords.size() -1) > 0) {
            db = lineWords.size() -1;
        }
        int eqSpace = 0;
        int extraPaddinginLeft = 0;
        if (db > 0) {
            eqSpace = rem/db;
            extraPaddinginLeft = rem % db;
        } else {
            eqSpace = 0;
        }
        final StringBuilder line = new StringBuilder();
        int k=0;
        int addedEqSp = 0;
        while (k < lineWords.size()) {
            if (k == 0) {
                line.append(lineWords.get(k));
            } else {
                if (extraPaddinginLeft > 0) {
                    line.append(SPACE);
                    extraPaddinginLeft--;
                }
                for (int l=0; l<eqSpace && addedEqSp < (db*eqSpace); l++) {
                    line.append(SPACE);
                    addedEqSp++;
                }
                line.append(SPACE);
                line.append(lineWords.get(k));
            }
            k++;
        }
        fillSpacesAtEnd(maxWidth, line);
        return line;
    }

    private void fillSpacesAtEnd(final int maxWidth, final StringBuilder line) {
        if (line.length() != maxWidth) {
            int j = line.length();
            while (j < maxWidth) {
                line.append(SPACE);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        TextJustification jus = new TextJustification();
        //final List<String> result = jus.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        final List<String> result = jus.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 15);
        //final List<String> result = jus.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        //final List<String> result = jus.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
        //final List<String> result = jus.fullJustify(new String[]{"this","this","this","this","this","this","this","this","this","this","this","this"}, 14);
        //final List<String> result = jus.fullJustify(new String[]{"this","as","this"}, 9);
        //["What","must","be","acknowledgment","shall","be"]
        // 16
        for (String str: result) {
            System.out.println(str);
        }

    }
}
