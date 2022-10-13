/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
  */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        
        if(root==NULL)
            return root;
        
        
        // if we reach any one node p or q return node itself
        
        if(root==p || root==q)
            return root;
        
        
        // traverse left and right
        
        TreeNode* left=lowestCommonAncestor(root->left,p,q);
        TreeNode* right=lowestCommonAncestor(root->right,p,q);
        
        
        //now we have to check for left and right we have to push forward not null node
        // so if left is null we push forward right and vice versa
        // and if both are not null means we got our ans 
        
        if(left==NULL)
            return right;
        else if(right==NULL)
            return left;
        else
            return root;
        
    }
};