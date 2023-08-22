class MedianFinder {
public:

    priority_queue<int> maxheap;
    priority_queue<int,vector<int>,greater<>> minheap;

    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(maxheap.empty()) maxheap.push(num);
        else
        {
            if(num<=maxheap.top()) maxheap.push(num);
            else minheap.push(num);
        }

        while(minheap.size()>maxheap.size())
        {
            int x = minheap.top();
            minheap.pop();
            maxheap.push(x);
        }

        while(maxheap.size()-minheap.size()>1)
        {
            int x = maxheap.top();
            maxheap.pop();
            minheap.push(x);
        }
    }
    
    double findMedian() {
        if(maxheap.size()>minheap.size()) return (double)maxheap.top();
        return (double)(((double)maxheap.top() + (double)minheap.top() )/ 2);
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */