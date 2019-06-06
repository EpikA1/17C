package priorityq;

public class LinkedList {

    // head node
    private Node head; // beginning of linked list
    private Node tail; // end of linked list
    
    // keep track of number of items in linked list
    private int listCount;
    private int where;

    // default constructor to create an empty linked list
    public LinkedList() {
        head = null;
        tail = null;
        listCount = 0;
    }
            
    // add a node with the specified element to the end of this list
    public void addE(int dataValue, int priority) 
    {
        // to do: 3/22/17
        Node temp = new Node(dataValue, priority); // create our new node        
        // if head is null, newly created node is head and tail for starters
        if ( head == null )
        {
            head = temp;
            tail = head;
        }
        else
        {
            tail.setNext(temp);
            tail = temp;
        }
        listCount++;
    }
    
    public void insert(int dataValue, int priority) 
    {
        int indexPosition;
        // to do: 3/22/17       
        if (size()!=0){
            indexPosition = getP(priority);
        }
        else indexPosition = 0;
        
        if (indexPosition == 0 )
        {
            Node temp = new Node(dataValue, priority); // create our new node
            temp.setNext(head);
            head=temp;
            listCount++;
        }        
        else if ( indexPosition >= listCount )
        {
            this.addE(dataValue, priority);
        }
        else
        {
            Node previous = null;
            Node current = head;
            for(int i=0;i<indexPosition;i++)
            {
                previous = current;
                current = current.getNext();
            }
            Node temp = new Node(dataValue,priority); // create our new node
            previous.setNext(temp);
            temp.setNext(current);
            listCount++;
        }       
    }
    
    // returns the element at the specified index position in this list
    public int getP(int priority)
    {
        // index must be 0 or higher
        if (priority < 0) {
            throw new IllegalArgumentException();
        }

        Node current = head.getNext();
        for (int i = 0; i < size(); i++) {
            if (current.getPriority() > priority)
                where++;
                current = current.getNext();
        }
        return where;
    }

    // remove node from head
    public int remove_maximum()
    {
        if ( head==null)
            return 0; // better to throw an exception?
        
        int temp = head.getData();
        Node old_head = head;
        head = head.getNext();
        old_head.setNext(null);
        old_head = null; // flag old_head as null for garbage collection
        
        listCount--;
        return temp;
    }
    
    public void decrease(int element, int priority_d){
        int pos = 0;
        boolean tf = false;
        Node current = head;
        
        while (tf == false && current != null)
        if (current.getData() == element){
            int newP = current.getPriority() - priority_d;
            int oldD = current.getData();
            deleteNode(pos);
            insert(oldD, newP);
            tf = true;
        }
        else current = current.getNext();
        pos++;
    }
    
    void deleteNode(int position) 
    { 
        if (head == null) 
            return; 
  
        Node temp = head; 
  
        if (position == 0) 
        { 
            head = temp.next;   // Change head 
            return; 
        } 
  
        for (int i=0; temp!=null && i<position-1; i++) 
            temp = temp.next; 
  
        if (temp == null || temp.next == null) 
            return; 
        
        Node next = temp.next.next; 
  
        temp.next = next;
    } 
    
    public void increase(int element, int priority_d){
        int pos = 0;
        boolean tf = false;
        Node current = head;
        
        while (tf == false && current != null)
        if (current.getData() == element){
            int newP = current.getPriority() + priority_d;
            int oldD = current.getData();
            deleteNode(pos);
            insert(oldD, newP);
            tf = true;
        }
        else current = current.getNext();
        pos++;
    }

    // returns the number of items (elements) in the linked list
    public int size()
    {
        return listCount;
    }

    // utility method to print out items in linked list
    public String display() {
        Node current = head;
        String output = "";
        while (current != null) {
            output += "[" + current.getData() + "]";
            current = current.getNext();
        }
        return output;
    }

    // this is a private inner class, only needs to be used by the
    // public outer linkedlist class
    private class Node {
        // next node in the linked list, if null, then end of list

        private Node next;
        // data element of the node
        private int data;
        
        private int priority;

        // constructor to create node with empty value
        public Node() {
            next = null;
            data = 0;
            priority = 0;
        }

        // constructor to create node with a value in the node
        public Node(int dataValue, int priorityV) {
            next = null;
            data = dataValue;
            priority = priorityV;
        }

        // constructor for if we want to specify a particular node for
        // the node to point to
        public Node(int dataValue, Node nextNode, int priorityV) {
            next = nextNode;
            data = dataValue;
            priority = priorityV;
        }

        // return the data in the node
        public int getData() {
            return data;
        }
        
        public int getPriority() {
            return priority;
        }

        // set the data in the node to a value
        public void setData(int dataValue) {
            data = dataValue;
        }
        
        public void setValue(int priorityV) {
            priority = priorityV;
        }

        // returns the next node, if any
        public Node getNext() {
            return next;
        }

        // set the next node to point to some other node
        public void setNext(Node nextNode) {
            next = nextNode;
        }
    }
}
