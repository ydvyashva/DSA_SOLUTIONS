import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        // Precompute factorials: fact[i] = i!
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Create a list of numbers [1, 2, ..., n]
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Convert k to 0-based index
        k = k - 1;

        StringBuilder sb = new StringBuilder();

        // Build the permutation character by character
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k = k % fact[i];
        }

        return sb.toString();
    }
}