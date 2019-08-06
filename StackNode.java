
class StackNode{

    int data;
    StackNode next;

    StackNode(int data){
        this.data = data;
        this.next = null;
    }

    public static void push(int d, StackNode s){
        if (s == null){
            s = new StackNode(d);
        }
        else{
            if (s.next == null){
                s.next = new StackNode(d);
            }
            else{
                push(d, s.next);
            }
        }
    }

    public static void pop(StackNode s){
        if(s.next == null){
            s = null;
        }
        else{
            if (s.next.next == null){
                s.next = null;
            }
            else{
                pop(s.next);
            }
        }
    }

    public static void displayAll(StackNode s){
        if (s != null){
            System.out.print(s.data+" ");
            displayAll(s.next);
        }
    }

    public static void main(String[] args){     

        StackNode s = new StackNode(10);
        push(2, s);
        push(7, s);
        push(12, s);


        System.out.print("Stack: ");
        displayAll(s);

        pop(s);
        pop(s);

        System.out.println("");
        System.out.print("Stack: ");
        displayAll(s);
       

    }

}