class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        solve(k, n, ans, 1, cur);
        return ans;
    }

    public void solve(int k, int n, List<List<Integer>> ans, int start, List<Integer> cur) {
        if (cur.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) {
                break;
            }
            cur.add(i);

            solve(k, n - i, ans, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}