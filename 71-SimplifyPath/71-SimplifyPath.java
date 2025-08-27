// Last updated: 8/27/2025, 12:54:16 PM
public class Solution {
    public String simplifyPath(String path) {
        // Split the path by "/"
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Ignore empty parts (due to consecutive slashes) or current directory (".")
                continue;
            } else if (part.equals("..")) {
                // ".." means go up one directory (pop from stack)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // It's a valid directory, so push to stack
                stack.push(part);
            }
        }
        
        // Build the final path
        StringBuilder result = new StringBuilder();
        
        // If the stack is empty, the path should be "/"
        if (stack.isEmpty()) {
            return "/";
        }
        
        // Otherwise, join all parts from the stack
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }
        
        return result.toString();
    }
}
