class Solution {


    public List<String> letterCombinations(String digits) {
       
        List<String> list=new ArrayList<>();
        String s[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        combination(0,digits,new StringBuilder(),list,s);
         return list;

    }

    public static void combination(int i,String digits,StringBuilder sb,List<String> list,String s[])
    {
        if(i==digits.length())
        {
            list.add(sb.toString());
            return;
        }

        String t=s[digits.charAt(i)-'0'];
        for(char c:t.toCharArray())
        {
            sb.append(c);
            combination(i+1,digits,sb,list,s);
            sb.deleteCharAt(sb.length()-1);
        }
 
        

    }
}