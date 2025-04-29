class Solution {
    
    public int trap(int[] h) {  

       // by dp
       
        int l = 0, r = h.length - 1, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE, ans = 0;
        while (l < r) {
        lmax = Math.max(lmax, h[l]);
        rmax = Math.max(rmax, h[r]);
        ans += (lmax < rmax) ? lmax - h[l++] : rmax - h[r--];
        }
        return ans;
    


	//     int i;
    //     int n= height.length;
	//     int pMax[]= new int[n]; 
	//      pMax[0]=height[0];
	//     for(i=1;i<n;i++)
	//     {
	//         pMax[i]=Math.max(pMax[i-1],height[i]);
	//     }
    //     int sMax[]=new int[n];
    //     sMax[n-1]=height[n-1];
    //     for(i=n-2;i>=0;i--){
    //         sMax[i]=Math.max(sMax[i+1],height[i]);
    //     }
    //     int min,r=0;
    //     for(i=0;i<n;i++){
    //          min=Math.min(pMax[i],sMax[i]);
    //          r+=(min-height[i]);
    //     }
    //    return r;
        }
    }

   