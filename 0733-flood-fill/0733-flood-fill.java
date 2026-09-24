class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old_Color = image[sr][sc];
        
        // If target color is the same as current color, return immediately to avoid infinite recursion
        if (old_Color == color) {
            return image;
        }
        
        solve(image, sr, sc, color, old_Color);
        return image;
    }

    public void solve(int[][] image, int cr, int cc, int color, int old_Color) {
        // Base cases: check boundary conditions and matching color
        if (cr < 0 || cr >= image.length || cc < 0 || cc >= image[0].length || image[cr][cc] != old_Color) {
            return;
        }

        // Color the current pixel
        image[cr][cc] = color;

        // Recurse for all 4 adjacent directions
        solve(image, cr - 1, cc, color, old_Color); // Up
        solve(image, cr + 1, cc, color, old_Color); // Down
        solve(image, cr, cc - 1, color, old_Color); // Left
        solve(image, cr, cc + 1, color, old_Color); // Right
    }
}