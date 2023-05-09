class MedianFinder {
public:
    priority_queue<int> maxheap;
    priority_queue<int,vector<int>,greater<int>> minheap;


    MedianFinder() {

    }
    
    void addNum(int num) {
        if(maxheap.empty()) maxheap.push(num);
        else
        {
            if(num>maxheap.top()) minheap.push(num);
            else
            {
                int x=maxheap.top();
                maxheap.pop();
                maxheap.push(num);
                minheap.push(x);
            }
            while(minheap.size()>maxheap.size())
            {
                int x=minheap.top();
                minheap.pop();
                maxheap.push(x);
            }
        }
    }
    
    double findMedian() {
        if(maxheap.size()>minheap.size()) return (double)(maxheap.top());
        else return (double)((double)minheap.top() + (double)maxheap.top())/2;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */