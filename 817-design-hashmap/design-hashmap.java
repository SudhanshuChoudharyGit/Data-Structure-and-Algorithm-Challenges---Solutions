class Node{
    int key;
    int value;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {

    public static final int DEFAULT_CAPACITY = 16;
    public static final double LOAD_FACTOR_THRESHOLD = 0.75;
    ArrayList<Node>[] map;
    int capacity;
    int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new ArrayList[capacity];
        for(int i=0;i<capacity;i++)
        {
            map[i] = new ArrayList<>();
        }
    }
    
    public void put(int key, int value) {
        int ind = Integer.hashCode(key)%capacity;
        for(Node node : map[ind])
        {
            if(node.key == key)
            {
                node.value = value;
                return;
            }
        }
        map[ind].add(new Node(key,value));
        size++;
        //calculating load factory
        if((double)(size/capacity)>LOAD_FACTOR_THRESHOLD)
        {
            rehash();
        }
    }
    
    public int get(int key) {
        int ind = Integer.hashCode(key)%capacity;
        for(Node node : map[ind])
        {
            if(node.key == key)
            {
                return node.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int ind = Integer.hashCode(key)%capacity;
        for(Node node : map[ind])
        {
            if(node.key == key)
            {
                map[ind].remove(node);
                size--;
                break;
            }
        }
    }

    public void rehash() {
        int newCapacity = capacity*2;
        ArrayList<Node>[] newmap= new ArrayList[newCapacity];
        for(int i=0;i<newCapacity;i++) newmap[i] = new ArrayList<>();
        for(int i=0;i<capacity;i++)
        {
            for(Node node : map[i])
            {
                int newInd = Integer.hashCode(node.key)%newCapacity;
                newmap[newInd].add(node);
            }
        }
        capacity= newCapacity;
        map = newmap;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */