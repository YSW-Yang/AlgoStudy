import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int num;
        int x;
        int y;
        Node left;
        Node right;
        
        Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node other){
            if(this.y == other.y){
                return Integer.compare(this.x, other.x);
            }
            
            return Integer.compare(other.y, this.y);
        }
    }
    
    
    public List<Integer> preArr;
    public List<Integer> postArr;
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];
        preArr = new ArrayList<>();
        postArr = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        
        int index = 1;
        for(int[] info : nodeinfo){
            nodeList.add(new Node(index++, info[0], info[1]));
        }
        Collections.sort(nodeList);
        
        Node root = nodeList.get(0);
        for(int i = 1; i < n; i++){
            insert(root, nodeList.get(i));
        }
        preOrder(root);
        postOrder(root);
        
        
        for(int i = 0; i < n; i++){
            answer[0][i] = preArr.get(i);
        }
        for(int i = 0; i < n; i++){
            answer[1][i] = postArr.get(i);
        }
        
        return answer;
    }
    
    public void insert(Node parent, Node child){
        if(parent.x > child.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                insert(parent.left, child);
            }
        }else{
            if(parent.right == null){
                parent.right = child;
            }else{
                insert(parent.right, child);
            }
        }
    }
    
    public void preOrder(Node node){
        if(node == null){
            return;
        }
        
        preArr.add(node.num);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void postOrder(Node node){
        if(node == null){
            return;
        }
        
        postOrder(node.left);
        postOrder(node.right);
        postArr.add(node.num);
    }
}