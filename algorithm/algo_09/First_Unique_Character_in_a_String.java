class Solution {
    public int firstUniqChar(String s) {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i) - 'a'] != 0) {
                index[s.charAt(i) - 'a'] = -1;
            } else {
                index[s.charAt(i) - 'a'] = i + 1;
            }
        }

        int min = s.length() + 1;
        for (int i = 0; i < 26; i++) {
            if (index[i] > 0) {
                min = Math.min(min, index[i]);
            }
        }

        return min == s.length() + 1 ? -1 : min - 1;
    }
}
