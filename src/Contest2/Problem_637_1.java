package Contest2;


import entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem_637_1.java
 * Description:
 *
 * @author v_yuanjiankai
 * @date 2018/6/30
 * @since 1.8 or after
 */
public class Problem_637_1 {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(true) {
            Queue<TreeNode> temp = new LinkedList<>();
            double sum = 0;
            int count = 0;
            while(!nodes.isEmpty()) {
                TreeNode n = nodes.poll();
                sum += n.val;
                count++;
                if(n.left != null) {
                    temp.add(n.left);
                }
                if(n.right != null) {
                    temp.add(n.right);
                }
            }
            result.add(sum / count);
            if(temp.isEmpty()) {
                break;
            } else {
                nodes = temp;
            }
        }
        return  result;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        List<Double> result = averageOfLevels(root);
        System.out.println(result.toString());

    }
}
