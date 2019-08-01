
class Tree{ 

    Node root;

    static class Node{

        private Node[] children;
        private Node parent;
        private String label;

        Node(String label, Node parent){
            this.label = label;
            this.parent = parent;
            this.children = null;
        }
    }

    //Checks is node is root.
    public static boolean isRoot(Node node){
        return node.parent == null;
    }

    //Checks if node is internal.
    public static boolean isInternalNode(Node node){
        return node.children != null;
    }

    //Checks is node is leaf.
    public static boolean isLeaf(Node node){
        return node.children == null;
    }


    //Computes the depth of a given node.
    public static int depthNode(Node node){

        int depth = 0;

        if (node.parent == null){
            return depth;
        }

        else{
            return 1+depthNode(node.parent);
        }
    }

    //Computes the maximum depth of a given node.
    public static int maxDepth(Node node){

        int height = 0;

        if (!isLeaf(node)){
            for (int i=0; i<node.children.length; i++){
                height = Math.max(height, maxDepth(node.children[i]));
            }
            return 1+height;
        }

        return height;
    }


    //Computes the height of a tree.
    public static int getHeight(Tree tree){
        return maxDepth(tree.root);
    }

    public static void main(String[] args){
            
        //New tree.
        Tree tree = new Tree();

        //Depth 0.
        tree.root = new Node("A", null);

        //Depth 1.
        tree.root.children = new Node[3];
        tree.root.children[0] = new Node("B", tree.root);
        tree.root.children[1] = new Node("C", tree.root);
        tree.root.children[2] = new Node("D", tree.root);

        //Depth 2.
        tree.root.children[0].children = new Node[2];
        tree.root.children[0].children[0] = new Node("E", tree.root.children[0]);
        tree.root.children[0].children[1] = new Node("F", tree.root.children[0]);
        tree.root.children[1].children = new Node[2];
        tree.root.children[1].children[0] = new Node("G", tree.root.children[1]);
        tree.root.children[1].children[1] = new Node("H", tree.root.children[1]);

        //Depth 3.
        tree.root.children[0].children[1].children = new Node[3];
        tree.root.children[0].children[1].children[0] = new Node("I", tree.root.children[0].children[1]);
        tree.root.children[0].children[1].children[1] = new Node("J", tree.root.children[0].children[1]);
        tree.root.children[0].children[1].children[2] = new Node("K", tree.root.children[0].children[1]);

        //Testing type of nodes.
        System.out.println("A is a root: "+isRoot(tree.root));
        System.out.println("G is a root: "+isRoot(tree.root.children[1].children[0]));
        System.out.println("A is an internal node: "+isInternalNode(tree.root));
        System.out.println("C is an internal node: "+isInternalNode(tree.root.children[1]));
        System.out.println("G is an internal node: "+isInternalNode(tree.root.children[1].children[0]));
        System.out.println("A is a leaf node: "+isLeaf(tree.root));
        System.out.println("C is a leaf node: "+isLeaf(tree.root.children[1]));
        System.out.println("G is a leaf node: "+isLeaf(tree.root.children[1].children[0]));

        //Testing depth of nodes.
        System.out.println("Depth of A is: "+depthNode(tree.root));
        System.out.println("Depth of C is: "+depthNode(tree.root.children[1]));
        System.out.println("Depth of G is: "+depthNode(tree.root.children[1].children[0]));
        System.out.println("Depth of K is: "+depthNode(tree.root.children[0].children[1].children[2]));

        //Height of tree.
        System.out.println("Height of tree is: "+getHeight(tree));

    }
}

