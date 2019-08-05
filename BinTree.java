
class BinTree{

    static BinNode root;

    BinTree(){
        this.root = null;
    }

    static class BinNode{

        int data;
        BinNode left;
        BinNode right;

        BinNode(int data){
            this.data = data;
            this.left = null;
            this.right= null;
        }

    }

    public static boolean isEmptyTree(){
        return root == null;
    }

    //Counting number of nodes.
    public static int number(BinNode t){

        if (isEmptyTree()){
            return 1;
        }
        else{
            if (t == null){
                return 0;
                }
            else{
                return 1+number(t.left)+number(t.right);
            }
        }
    }

    //Traversal of tree and adding data values.
    public static int sum(BinNode t){

        if (t == null){
            if (!isEmptyTree()){
                return 0;
            }
            else{
                return -1;
            }
        }
        else{
            return t.data+sum(t.left)+sum(t.right);
        }
    }


    

    public static void main(String[] args){

        BinTree bt = new BinTree();
        //bt.root = new BinNode(1);
        //bt.root.left = new BinNode(2);
        //bt.root.right = new BinNode(3);
        //bt.root.left.left = new BinNode(4);

        System.out.println(bt.sum((bt.root)));

    }
}

