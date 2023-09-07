

class LRUCache {

    class DLL{
        int key;
        int val;
        DLL prev;
        DLL next;

        DLL() {
            this.key=0;
            this.val=0;
            this.prev=null;
            this.next=null;
        }

        DLL(int key,int val) {
            this.key=key;
            this.val=val;
            this.prev=null;
            this.next=null;
        } 
    }

        //adding to tail
        private void add(DLL node){
            tail.prev.next = node;
            node.prev = tail.prev;

            tail.prev = node;
            node.next = tail;
        }

        //removing a node
        private void remove(DLL node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        //updating : moving to the end of list
        private void update(DLL node){
            remove(node);
            add(node);
        }

        
    
    private HashMap<Integer,DLL> mp;
    private DLL head;
    private DLL tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        mp = new HashMap<>();
        head = new DLL();
        tail = new DLL();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)) {
            DLL node = mp.get(key);
            update(node);
            return node.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        int x = get(key);
        if(x == -1)
        {
            if(size == capacity)
            {
                DLL node = head.next;
                remove(node);
                mp.remove(node.key);
                size--;
            }
            size++;
            DLL newNode = new DLL(key,value);
            add(newNode);
            mp.put(key,newNode);
        }
        else
        {
            DLL node = mp.get(key);
            node.val = value;
            update(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */