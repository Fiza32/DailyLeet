class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {
        // code here
        for(int i = 0; i < N - 1; i++){
            if(arr[i] >= arr[i + 1]){
                return 0;
            }
        }
        
        return 1;
    }
}

/*
 * Inorder traversal is defined as a type of tree traversal technique which follows the Left-Root-Right pattern, 
 * such that:

  1.   The left subtree is traversed first
  2.   Then the root node for that subtree is traversed
  3.   Finally, the right subtree is traversed
 */