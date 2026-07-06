func twoSum(nums []int, target int) []int {
    var mp=map[int]int{}
    for i:=0;i<len(nums);i++{
        if idx,ok := mp[target-nums[i]];ok{
            return []int{idx,i}
        }
       mp[nums[i]]=i
    }
    return []int{-1,-1}
}