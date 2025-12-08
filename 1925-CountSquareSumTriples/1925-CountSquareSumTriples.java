// Last updated: 12/8/2025, 11:04:41 PM
1class Solution {
2    public int countTriples(int n) {
3        int c=0;
4        for(int a=1;a<=n;a++){
5            for(int b=1;b<=n;b++){
6                int s=a*a+b*b;
7                int cRoot=(int)Math.sqrt(s);
8                if(cRoot<=n && cRoot*cRoot==s) c++;
9            }
10        }
11        return c;
12    }
13}
14