class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left=max(weights)
        right=sum(weights)
        while(left<right):
            mid=left+(right-left)//2
            if(self.ship(weights,days,mid)):
                right=mid
            else:
                left=mid+1
        return left
    def ship(self,weights,days,cap):
        day=1
        weight=0
        for i in weights:
            if(weight+i>cap):
                day+=1
                weight=0
            weight+=i
        return day<=days                        