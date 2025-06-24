class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        r=0
        ans=[]
        n=len(nums)
        for j in range(len(nums)):
            if nums[j]==key:
                l=max(r,j-k)
                r=min(j+k,n-1)+1
                for i in range(l,r):
                    ans.append(i)
        return ans