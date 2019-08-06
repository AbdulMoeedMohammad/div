
class QueueNode{

    int data;
    QueueNode next;

    QueueNode(int data){
        this.data = data;
        this.next = null;
    }

    public static void push(int d, QueueNode s){
        if (s == null){
            s = new QueueNode(d);
        }
        else{
            if (s.next == null){
                s.next = new QueueNode(d);
            }
            else{
                push(d, s.next);
            }
        }
    }

    public static QueueNode pop(QueueNode s){
        if (s == null){
            return null;
        }
        else{
            if (s.next != null){
                return s.next;
            }
            else{
                return null;
            }
        }
    }

    public static void displayAll(QueueNode s){
        if (s != null){
            System.out.print(s.data+" ");
            displayAll(s.next);
        }
    }

    public static void main(String[] args){     

        QueueNode s = new QueueNode(10);
        push(5, s);
        push(7, s);
        push(13, s);

        System.out.print("Queue: ");
        displayAll(s);

        s = pop(s);
        s = pop(s);

        System.out.println("");
        System.out.print("Queue: ");
        displayAll(s);
       

    }

}