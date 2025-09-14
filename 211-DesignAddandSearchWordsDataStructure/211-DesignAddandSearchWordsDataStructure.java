// Last updated: 9/14/2025, 9:58:18 PM
import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, new HashMap<>());
    }
    
    private List<Integer> helper(String expr, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expr)) return memo.get(expr);
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = helper(expr.substring(0, i), memo);
                List<Integer> right = helper(expr.substring(i + 1), memo);
                
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') res.add(a + b);
                        else if (c == '-') res.add(a - b);
                        else res.add(a * b);
                    }
                }
            }
        }
        
        if (res.isEmpty()) {
            res.add(Integer.valueOf(expr)); // base case: expr is a number
        }
        
        memo.put(expr, res);
        return res;
    }
}
