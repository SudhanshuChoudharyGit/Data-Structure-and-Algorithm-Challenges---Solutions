import java.util.*;

class Solution {

    class ArrayValIndex {
        int val;
        int index;

        ArrayValIndex(int val,int index) {
            this.val = val;
            this.index = index;
        }
    }

    public void mergeSort(ArrayValIndex[] arr,int l,int r,ArrayList<Integer> ans){
        if(l>=r) return;
        int m = l + (r-l)/2;
        mergeSort(arr,l,m,ans);
        mergeSort(arr,m+1,r,ans);
        
        int left = l;
        int right = m+1;
        int temp = 0;
        int smallerOnRight = 0;

        ArrayValIndex[] merged = new ArrayValIndex[r-l+1];

        while(left<=m && right<=r)
        {
            if(arr[left].val>arr[right].val)
            {
                merged[temp]=arr[right];
                smallerOnRight++;
                right++;
            }
            else
            {
                merged[temp]=arr[left];
                ans.set(arr[left].index,ans.get(arr[left].index)+smallerOnRight);
                left++;
            }
            temp++;
        }
        while(left<=m)
        {
            merged[temp]=arr[left];
            ans.set(arr[left].index,ans.get(arr[left].index)+smallerOnRight);
            left++;
            temp++;
        }
        while(right<=r)
        {
            merged[temp]=arr[right];
            right++;
            temp++;
        }

        temp=0;
        for(int i=l;i<=r;i++)
        {
            arr[i]=merged[temp];
            temp++;
        }    
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>(n);
        for(int i=0;i<n;i++) ans.add(0);
        ArrayValIndex[] arr = new ArrayValIndex[n];
        for(int i=0;i<n;i++) arr[i] = new ArrayValIndex(nums[i],i);
        mergeSort(arr,0,n-1,ans);
        return ans;
    }
}