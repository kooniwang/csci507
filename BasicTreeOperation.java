import utils.TreeNode;
import java.util.*;

public class BasicTreeOperation<E> {
    TreeNode<E> root;
    HashMap<String, TreeNode<E>> cityMap = new HashMap<>();

    public void addChildNode(TreeNode<E> parent, TreeNode<E> child){
        if(parent == null) this.root = child;
        else{
            TreeNode<E> node = getNode(root, parent);
            if(node != null){
                if(node.hasChildren()) node.getChildren().add(child);
                else{
                    node.setChildren(new ArrayList<>(Arrays.asList(child)));
                }
            }
        }
        cityMap.put(child.getVal().toString(), child);

    }

    //get the maximum of the children's height
    public int getHeight(TreeNode<E> city){
        if(city == null) return -1;
        int maxH = -1;
        if(city.hasChildren()){
            for(TreeNode<E> node : city.getChildren()){
                int nodeH = getHeight(node);
                if(nodeH > maxH) maxH = nodeH;
            }
        }
        return ++maxH;
    }
    public int getDepth(TreeNode<E> root, TreeNode<E> city, int depth){
        if(root.getVal().equals(city.getVal())) return depth;
        if(root.hasChildren()){
            for(TreeNode<E> node : root.getChildren()){
                int dp = getDepth(node, city, depth+1);
                if(dp != -1) return dp;
            }
        }
        return -1;
    }

    public TreeNode<E> getNode(TreeNode<E> root, TreeNode<E> city){
        if(root.getVal().equals(city.getVal())) return root;
        if(root.hasChildren()){
            for(TreeNode<E> node : root.getChildren()){
                TreeNode<E> pivot = getNode(node, city);
                if(pivot != null) return pivot;
            }
        }
        return null;
    }

    public String displayDepthandHeight(TreeNode<E> root, TreeNode<E> city){
        if(city == null) return "This city doesn't exist!";
        return city.getVal() + "'s depth is: " + getDepth(root, city, 0) + ", height is: "+ getHeight(city);
    }

    /*
    *                                British Columbia
    *           |               |                 |             |                  |
    *       Burnaby         Coquitlam          Surrey       Richmond            Vancouver
    *       /                   /               /                               /        \
    *   Metro Town      PortMoody        Newton Exchange                    Downtown    YaleTown
    * */
    public static void main(String[] args){
        //create city nodes
        TreeNode<String> bc = new TreeNode<>("British Columbia");
        TreeNode<String> burnaby = new TreeNode<>("Burnaby");
        TreeNode<String> coquitlam = new TreeNode<>("Coquitlam");
        TreeNode<String> surrey = new TreeNode<>("Surrey");
        TreeNode<String> richmond = new TreeNode<>("Richmond");
        TreeNode<String> vancouver = new TreeNode<>("Vancouver");

        TreeNode<String> metroTown = new TreeNode<>("Metro Town");
        TreeNode<String> portMoody = new TreeNode<>("Port Moody");
        TreeNode<String> newtonExchange = new TreeNode<>("Newton Exchange");
        TreeNode<String> downTown = new TreeNode<>("Down Town");
        TreeNode<String> yaleTown = new TreeNode<>("Yale Town");

        //construct the connections between parent and children
        BasicTreeOperation<String> var = new BasicTreeOperation<>();
        var.addChildNode(null, bc);
        var.addChildNode(bc, burnaby);
            var.addChildNode(burnaby, metroTown);
        var.addChildNode(bc, coquitlam);
            var.addChildNode(coquitlam, portMoody);
        var.addChildNode(bc, surrey);
            var.addChildNode(surrey, newtonExchange);
        var.addChildNode(bc, richmond);
        var.addChildNode(bc, vancouver);
            var.addChildNode(vancouver, downTown);
            var.addChildNode(vancouver, yaleTown);

        System.out.println("Please choose a city from the following list to display it's height and depth");
        System.out.println(var.cityMap.keySet());
        Scanner scanner = new Scanner(System.in);
        System.out.println(var.displayDepthandHeight(bc, var.cityMap.get(scanner.nextLine())));
        System.out.println(var.displayDepthandHeight(bc, var.cityMap.get(scanner.nextLine())));
        System.out.println(var.displayDepthandHeight(bc, var.cityMap.get(scanner.nextLine())));

    }
}
