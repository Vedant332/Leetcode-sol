class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        my_hashMap={}
        for i in range(len(nums)):
            if target-nums[i] in my_hashMap:
                return [i,my_hashMap[target-nums[i]]]
            else:
                my_hashMap[nums[i]]=i      
        return[-1,-1]