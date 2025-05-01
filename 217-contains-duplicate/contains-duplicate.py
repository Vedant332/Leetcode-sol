class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        x=set();
        for i in range(len(nums)):
            if nums[i] in x:
                return True
            x.add(nums[i])
            
        return False
        