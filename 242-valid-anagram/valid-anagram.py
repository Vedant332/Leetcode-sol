class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        my_dict={}
        for i in range(len(s)):
            if s[i] in my_dict:
                my_dict[s[i]]+=1
            else:
                my_dict[s[i]]=1    

        for j in range(len(t)):
            if t[j] in my_dict:
                my_dict[t[j]]-=1   
                if my_dict[t[j]] == 0:
                    del my_dict[t[j]] 
            else: 
                return False

        return len(my_dict)==0