// Last updated: 4/14/2026, 4:43:26 PM
class Solution {
    public int countTriples(int n) {
        int c=0;
        for(int a=1;a<=n;a++){
            for(int b=1;b<=n;b++){
                int s=a*a+b*b;
                int cRoot=(int)Math.sqrt(s);
                if(cRoot<=n && cRoot*cRoot==s) c++;
            }
        }
        return c;
    }
}
