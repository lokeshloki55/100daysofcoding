/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        
        return dfs(node, oldToNew);
    }
    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);           //if neigbour cloned already return that else create and add negihbours
        }
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);
        
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, oldToNew));  //adding negihobours
        }
        return copy;
    }
}
