class Solution {
    public void func(int i,String path,long res,long prev,String num, int target,List<String> ans){
        if(i==num.length()){
            if(res==target) ans.add(new String(path));
            return;
        }
        for(int j=i;j<num.length();j++){
            if(j>i && num.charAt(i)=='0') break;
            long currnum=Long.parseLong(num.substring(i,j+1));
            if(i==0) func(j+1,path+currnum,currnum,currnum,num,target,ans);
            else{
                func(j+1,path+"+"+currnum,res+currnum,currnum,num,target,ans);
                func(j+1,path+"-"+currnum,res-currnum,-currnum,num,target,ans);
                func(j+1,path+"*"+currnum,res-prev+prev*currnum,prev*currnum,num,target,ans);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> ans=new ArrayList<>();
        func(0,"",0,0,num,target,ans);
        return ans;
    }
}