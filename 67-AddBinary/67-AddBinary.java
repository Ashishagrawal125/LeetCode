// Last updated: 8/27/2025, 12:54:20 PM
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        
        int i = a.length() - 1;  // Pointer for string a
        int j = b.length() - 1;  // Pointer for string b
        int carry = 0;  // Carry for the addition
        
        // Iterate over both strings from right to left
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            
            // Add the corresponding digit from string a if it exists
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            
            // Add the corresponding digit from string b if it exists
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            // The current digit in the result is sum % 2 (0 or 1)
            result.append(sum % 2);
            
            // The carry for the next iteration is sum / 2 (either 0 or 1)
            carry = sum / 2;
        }
        
        // The result is built backwards, so reverse it before returning
        return result.reverse().toString();
    }
}
