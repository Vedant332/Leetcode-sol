/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode ele=q.poll();
                temp.add(ele.val);
                if(ele.left!=null) q.add(ele.left);
                if(ele.right!=null) q.add(ele.right);
            }
            ans+=minSwaps(temp);
        }
        return ans;
    }

    public int minSwaps(List<Integer> temp){
        Pair[] pairs=new Pair[temp.size()];
        for(int i=0;i<temp.size();i++){
            pairs[i]=new Pair(temp.get(i),i);
        }

        Arrays.sort(pairs,(a,b)->a.value-b.value);

        int swaps=0;

        for(int i=0;i<pairs.length;i++){
            if(pairs[i].index==i) continue;
            ++swaps;
            swap(pairs, i, pairs[i].index);
            --i;
        }
        return swaps;
    }

    private void swap(Pair[] pairs, int i, int j) {
        Pair temp = pairs[i];
        pairs[i] = pairs[j];
        pairs[j] = temp;
    }
}