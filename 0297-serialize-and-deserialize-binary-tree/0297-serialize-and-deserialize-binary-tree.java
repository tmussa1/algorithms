/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "X";

        StringBuilder builder = new StringBuilder();

        String left = "X", right = "X";
        if(root.left != null){
            left = serialize(root.left);
        }
        if(root.right != null){
            right = serialize(root.right);
        }

        builder.append(root.val);
        builder.append(",");
        builder.append(left);
        builder.append(",");
        builder.append(right);

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        return construct(data.split(","));
    }

    private TreeNode construct(String [] elements){

        String element = elements[index];

        if(element.equals("X")){
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(element));
        index++;
        node.left = construct(elements);
        node.right = construct(elements);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));