//
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
// P   A   H   N
// A P L S I I G
// Y   I   R
//
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
//
// Write the code that will take a string and make this conversion given a number of rows:
//
// string convert(string text, int nRows);
//
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
//


class Solution {
    public String convert(String s, int numRows) {
        if (s == "") return "";
        if (numRows == 1) return s;

        char[] chs = s.toCharArray();
        char[] result = new char[s.length()];
        int position = 0;

        for (int row = 0; row < numRows; row++) {
            if (row == 0) {
                for (int i = row; i < s.length(); i = (2 * numRows - 2) + i) {
                    result[position++] = chs[i];
                }
            } else if (row != numRows - 1) {
                int zig = 1;
                for (int i = row; i < s.length(); ) {
                    if (zig == 0) {
                        result[position++] = chs[i];
                        i = i + 2 * row;
                        zig = 1;

                    } else {
                        result[position++] = chs[i];
                        i = (2 * numRows - 2 - 2 * row) + i;
                        zig = 0;
                    }
                }
            } else {
                for (int i = row; i < s.length(); i = (2 * numRows - 2) + i) {
                    result[position++] = chs[i];
                }
            }
        }
        return new String(result);
    }
}
