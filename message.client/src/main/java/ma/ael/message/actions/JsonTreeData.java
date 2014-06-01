package ma.ael.message.actions;

import java.util.ArrayList;
import java.util.List;

import ma.ael.message.commun.action.MessageAction;

import com.jgeppert.struts2.jquery.tree.result.TreeNode;

public class JsonTreeData extends MessageAction {
	private static final long serialVersionUID = -2886756982077980790L;
   
	private List<TreeNode> nodes = new ArrayList<TreeNode>();
    private String id = "";
    public String execute() {

        TreeNode nodeA = new TreeNode();
        nodeA.setId("A" + id);
        nodeA.setTitle("Node A" + id);
        nodeA.setState(TreeNode.NODE_STATE_CLOSED);

        TreeNode nodeB = new TreeNode();
        nodeB.setId("B" + id);
        nodeB.setState(TreeNode.NODE_STATE_CLOSED);
        nodeB.setTitle("Node B" + id);

        TreeNode nodeC = new TreeNode();
        nodeC.setId("C" + id);
        nodeC.setState(TreeNode.NODE_STATE_CLOSED);
        nodeC.setTitle("Node C" + id);

        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
           
        
        
        System.out.println("Jsonn");
        return SUCCESS;
}

public String getJSON() {
        return SUCCESS;
}

public List<TreeNode> getNodes() {
        return nodes;
}

public void setId(String id) {
        this.id = id;
}
}
