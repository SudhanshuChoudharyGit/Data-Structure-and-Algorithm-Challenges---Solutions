class FrontMiddleBackQueue {

    static class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node front;
    Node back;
    Node middle;
    int size;

    public FrontMiddleBackQueue() {
        front = new Node(0);
        back = new Node(0);
        middle = null;
        front.next = back;
        back.prev = front;
        size = 0;
    }

    public void pushNext(Node node, int val){
        Node curr = new Node(val);
        node.next.prev = curr;
        curr.next = node.next;
        node.next = curr;
        curr.prev = node;
    }

    public void pushPrev(Node node, int val){
        Node curr = new Node(val);
        node.prev.next = curr;
        curr.prev = node.prev;
        curr.next = node;
        node.prev = curr;
    }

    public int popCurr(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node.val;
    }

    
    public void pushFront(int val) {
        pushNext(front,val);
        if(size==0) middle = front.next;
        else if(size%2!=0) middle = middle.prev;
        size++;
    }
    
    public void pushMiddle(int val) {
        if(size==0) pushFront(val);
        else
        {
            if(size%2==0)
            {
                pushNext(middle,val);
                middle = middle.next;
            }
            else 
            {
                pushPrev(middle,val);
                middle = middle.prev;
            }
            size++;
        }
    }
    
    public void pushBack(int val) {
        pushPrev(back,val);
        if(size==0) middle = back.prev;
        else if(size%2==0) middle = middle.next;
        size++;
    }
    
    public int popFront() {
        if(size==0) return -1;
        int val = popCurr(front.next);
        if(size%2==0) middle = middle.next;
        size--;
        return val;
    }
    
    public int popMiddle() {
        if(size==0) return -1;
        int val = popCurr(middle);
        if(size%2==0) middle = middle.next;
        else middle = middle.prev;
        size--;
        return val;
    }
    
    public int popBack() {
        if(size==0) return -1;
        int val = popCurr(back.prev);
        if(size%2!=0) middle = middle.prev;
        size--;
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */