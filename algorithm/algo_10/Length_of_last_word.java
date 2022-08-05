class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int pointer = s.length() - 1;
        while (pointer >= 0) {
            if (s.charAt(pointer) != ' ') {
                break;
            } else {
                pointer--;
            }
        }
        int count = 0;
        while (pointer >= 0) {
            if (s.charAt(pointer--) != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}