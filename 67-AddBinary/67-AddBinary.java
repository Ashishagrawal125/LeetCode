// Last updated: 2/15/2026, 9:03:32 PM
1public class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder result = new StringBuilder();
4        
5        int i = a.length() - 1;  // Pointer for string a
6        int j = b.length() - 1;  // Pointer for string b
7        int carry = 0;  // Carry for the addition
8        
9        // Iterate over both strings from right to left
10        while (i >= 0 || j >= 0 || carry != 0) {
11            int sum = carry;
12            
13            // Add the corresponding digit from string a if it exists
14            if (i >= 0) {
15                sum += a.charAt(i) - '0';
16                i--;
17            }
18            
19            // Add the corresponding digit from string b if it exists
20            if (j >= 0) {
21                sum += b.charAt(j) - '0';
22                j--;
23            }
24            
25            // The current digit in the result is sum % 2 (0 or 1)
26            result.append(sum % 2);
27            
28            // The carry for the next iteration is sum / 2 (either 0 or 1)
29            carry = sum / 2;
30        }
31        
32        // The result is built backwards, so reverse it before returning
33        return result.reverse().toString();
34    }
35}
36