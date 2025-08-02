class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        int n= ans.size();
        

        if(numRows==1){
            ans.push_back({1});
            return ans;
        }

        else{
        ans.push_back({1});
        ans.push_back({1,1});
        for(int i=2; i<numRows; i++){
            vector<int> temp(i+1);
            temp[0]=1;
            
            for(int j=1; j<i; j++){
                temp[j]= ans[i-1][j-1]+ans[i-1][j];
                }
            temp[i]=1;
            ans.push_back(temp);
            
        }
        return ans;
        }

        
    }
};