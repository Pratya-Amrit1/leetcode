class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()) return false;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if( !((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9') || (c=='_')) )
                return false;
        }
        return true;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);
        List<String[]> valid = new ArrayList<>();
        for(int i=0;i<code.length;i++) {
            if(!priority.containsKey(businessLine[i])) continue;
            if(!isActive[i]) continue;
            if(isValid(code[i]))
                valid.add(new String[] {code[i],businessLine[i]});
        }
        Collections.sort(valid, (a,b) -> {
            if(priority.get(a[1]) != priority.get(b[1]))
                return Integer.compare(priority.get(a[1]),priority.get(b[1]));
            else
                return a[0].compareTo(b[0]);
        });
        for(int i=0;i<valid.size();i++)
            ans.add(valid.get(i)[0]);
        return ans;
    }
}