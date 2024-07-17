package global.trend;
/////////////////// Question 7 ////////////////////
public class maxContainer {
    public int maxArea(int[] height) {
        int n=height.length;
        int water=0;
        int l=0;
        int r=n-1;

        while(l<r){
            final int minHt=Math.min(height[l],height[r]);
            water=Math.max(water, minHt*(r-l));
            if(height[l]<height[r]) ++l;
            else --r;

        }
        return water;
    }

}
