// Last updated: 8/27/2025, 12:54:53 PM
class Solution {
    static String[] key = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        Print(digits,"",list);
        return list;
    }
    public static void Print(String ques,String ans,List<String> list){
        if(ques.length() == 0){
            list.add(ans);
            return;
        }
        char ch = ques.charAt(0);
        String getString = key[ch-'0'];
        for (int i = 0; i < getString.length(); i++) {
            Print(ques.substring(1),ans+getString.charAt(i),list);
        }
    }
}