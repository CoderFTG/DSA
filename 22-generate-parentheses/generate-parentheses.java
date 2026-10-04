class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, 0, 0, res, sb);
        return res;
    }

    public void helper(int n, int open, int close, List<String> ans, StringBuilder temp) {
        if(open == n && close == n) {
            ans.add(temp.toString());
            return;
        }

        if(open < n) {
            temp.append('(');
            helper(n, open + 1, close, ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }

        if(open > close) {
            temp.append(')');
            helper(n, open, close + 1, ans, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}