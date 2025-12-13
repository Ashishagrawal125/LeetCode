// Last updated: 12/13/2025, 11:33:09 AM
1class Solution {
2    public List<String> validateCoupons(String[] code, String[] buisnessLine, boolean[] isActive) {
3        List<Coupon> coupons = new ArrayList<>();
4        int n=code.length;
5        for(int i=0;i<n;i++) coupons.add(new Coupon(code[i],buisnessLine[i],isActive[i]));
6        coupons = coupons
7              .stream()
8              .filter(coupon -> validateCode(coupon.code))
9              .filter(coupon -> coupon.isActive)
10              .filter(coupon -> coupon.buisnessLine.equals("electronics") || coupon.buisnessLine.equals("grocery") || coupon.buisnessLine.equals("pharmacy") || coupon.buisnessLine.equals("restaurant"))
11              .collect(Collectors.toList());
12        // coupons.forEach(coupon -> System.out.print(coupon.toString()));
13        Collections.sort(coupons,(a,b)->{
14            if(!(a.buisnessLine.equals(b.buisnessLine))) {
15                char A = a.buisnessLine.charAt(0);
16                char B = b.buisnessLine.charAt(0);
17                if(A<B) return -1;
18                else if(A>B) return 1;
19                return 0;
20            }
21            return a.code.compareTo(b.code);
22        });
23        List<String> result = coupons
24                                .stream()
25                                .map(coupon -> coupon.code)
26                                .collect(Collectors.toList());
27        // Collections.sort(result);
28        return result;
29    }
30    private boolean validateCode(String code){
31        if(code.length()==0) return false;
32        for(char c : code.toCharArray()){
33           if((c >='a'&&c<='z') || (c>='A'&&c<='Z') || (c>='0'&&c<='9') || c == '_') continue;
34           return false;
35        }
36        return true;
37    } 
38
39    // private int getBuisnessLinePriority(String BuisnessLine){
40    //     switch(BuisnessLine){
41    //         case "electronics": return 1;
42    //         case "grocery": return 2;
43    //         case "pharmacy": return 3;
44    //         default: return 4;
45    //     }
46    // }
47}
48class Coupon{
49    String code;
50    String buisnessLine;
51    boolean isActive;
52    Coupon(String code,String buisnessLine,boolean isActive){
53        this.code = code;
54        this.buisnessLine = buisnessLine;
55        this.isActive = isActive;
56    }
57    @Override
58    public String toString(){
59        return "[ "+(code)+", "+(buisnessLine)+", "+(isActive)+" ]";
60    }
61}