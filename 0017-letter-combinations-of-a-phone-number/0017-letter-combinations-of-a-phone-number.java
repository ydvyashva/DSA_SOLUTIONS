class Solution {
    // Index 0 and 1 are empty, so index 2 = "abc", index 3 = "def", etc.
    static String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        
        // Base case: return empty list for empty input
        if (digits == null || digits.isEmpty()) {
            return list;
        }
        
        solve(digits, "", list);
        return list;
    }

    public void solve(String digits, String ans, List<String> list) {
        if (digits.length() == 0) {
            list.add(ans);
            return;
        }

        char ch = digits.charAt(0);
        int num = ch - '0';
        String press = map[num];

        for (int i = 0; i < press.length(); i++) {
            solve(digits.substring(1), ans + press.charAt(i), list);
        }
    }
}