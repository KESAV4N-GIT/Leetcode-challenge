class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxweight=0;
        int total=0;
        for(int i:weights){
            maxweight=Math.max(maxweight,i);
            total+=i;
        }
        int left=maxweight;
        int right=total;
        while(left<right){
            int mid=left+(right-left)/2;
            if(ship(weights,days,mid)){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean ship(int weights[],int days,int cap){
        int day=1;
        int weight=0;
        for(int i:weights){
            if(weight+i>cap){
                day++;
                weight=0;
            }
            weight+=i;
        }
        return day<=days;
    }
}