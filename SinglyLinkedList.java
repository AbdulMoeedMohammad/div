class SinglyLinkedList{ 

    Node start;

    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }


    //Insertion of a new node after given node.
    public static void insertNodeAfter(Node node, int new_data){

        Node new_node = new Node(new_data);

        if (node == null){
            System.out.println("Given node does not exist.");
        }

        else{

            if (node.next == null){
                node.next = new_node;
            }

            else{
                Node tmp_node = node.next;
                node.next = new_node;
                new_node.next = tmp_node;
            }
        }
    }

    //Insertion of a new node at the end.
    public static SinglyLinkedList insertNode(SinglyLinkedList list, int new_data){

        Node new_node = new Node(new_data);

        if (list.start == null){
            list.start = new_node;
        }
        else{
            Node end = list.start;
            while(end.next != null){
                end = end.next;
            }
            end.next = new_node;
        }
        return list;
    }

    //Display all nodes.
    public static void displayList(SinglyLinkedList list){

        Node node = list.start;

        if (node == null){
            System.out.println("Empty list.");
        }
        else{
            int node_num = 1;
            while(node != null){
                System.out.println("Node position: "+node_num+". Data: "+node.data);
                node = node.next;
                node_num++;
            }
        }
    }


    //Counts nodes in list.
    public static int countNodes(SinglyLinkedList list){

        int node_num = 0;

        Node node = list.start;
        while(node != null){
            node = node.next;
            node_num++;
        }
        return node_num;
    }

    
    //Deletion of a node after given node.
    public static void deleteNodeAfter(Node node){

        if (node.next == null){
            System.out.println("No node after given node.");
        }

        else{
            if(node.next.next == null){
                node.next = null;
            }

            else{
                node.next = node.next.next;
            }
        }

    }


    //Searches and deletes a node.
    public static SinglyLinkedList deleteNode(SinglyLinkedList list, int data){

        Node node = list.start;
        Node previous_node = null;

        while(node != null){

            if (node.data == data){

                if (previous_node == null){
                    list.start = node.next;
                }
                else{
                    if (node.next == null){
                        previous_node.next = null;
                    }
                    else{
                        previous_node.next = node.next;
                    }
                }

            }

            previous_node = node;
            node = node.next;
        }

        return list;
    }


    public static boolean searchList(SinglyLinkedList list, int data){

        Node node = list.start;
        boolean inList = false;

        while(node != null && !inList){
            if (node.data == data){
                inList = true;
            }
            node = node.next;   
        }

        return inList;
    }

    public static void main(String[] args){
            
        //New list.
        SinglyLinkedList list = new SinglyLinkedList();

        //Adding nodes.
        list.start = new Node(1);
        list = insertNode(list, 2);
        list = insertNode(list, 4);
        list = insertNode(list, 8);

        //Searching for nodes.
        System.out.println("1 is in the list: "+searchList(list, 1));
        System.out.println("4 is in the list: "+searchList(list, 4));
        System.out.println("8 is in the list: "+searchList(list, 8));

        //Displaying nodes.
        displayList(list);
        System.out.println("Total nodes: "+countNodes(list));

        //Deleting, displaying and counting.
        deleteNode(list, 2);
        displayList(list);
        System.out.println("Total nodes: "+countNodes(list));

        //Deleting, displaying and counting.
        deleteNode(list, 1);
        displayList(list);
        System.out.println("Total nodes: "+countNodes(list));

        //Deleting, displaying and counting.
        deleteNode(list, 8);
        displayList(list);
        System.out.println("Total nodes: "+countNodes(list));

        //Inserting nodes at the end.
        list = insertNode(list, 7);
        list = insertNode(list, 12);
        displayList(list);
        System.out.println("Total nodes: "+countNodes(list));

        //Inserting a node between the two first nodes.
        insertNodeAfter(list.start, 100);
        displayList(list);
        System.out.println("Total nodes: "+countNodes(list));

        //Deleting the second node.
        deleteNodeAfter(list.start);
        displayList(list);
        System.out.println("Total nodes: "+countNodes(list));
    }
}

