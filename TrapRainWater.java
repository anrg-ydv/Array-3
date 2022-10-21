//  TC = O(N)
//  SC = O(1)

class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length -1;
        int lw = 0; //  left wall
        int rw = 0; //  right wall
        
        int res = 0;
        
        while (l<=r){
            if(lw <= rw){   // there exist a wall rw higher than lw
                if(lw > height[l]){
                    res+= (lw-height[l]);      // water trap
                }else{
                    lw = height[l];
                }
                l++;
            }else{  // there exist a wall lw higher than rw
                if(rw > height[r]){
                    res+= (rw-height[r]);      // water trap
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return res;
    }
}
