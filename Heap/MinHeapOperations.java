package ImportantQ.Heap;

public class MinHeapOperations {
    int[] heap;
    int capacity, heap_size;
    MinHeapOperations(int cap) {
        heap_size = 0;
        capacity = cap;
        heap = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    //Function to extract minimum value in heap and then to store
    //next minimum value at first index.
    int extractMin()
    {
        if(heap_size <= 0)
            return -1;

        if(heap_size == 1){
            heap_size--;
            return heap[0];
        }


        int ans = heap[0];
        heap[0] = heap[heap_size - 1];
        heap_size--;
        MinHeapify(0);

        return ans;
    }

    //Function to insert a value in Heap.
    void insertKey(int k)
    {
        // Your code here.
        if(heap_size == capacity)
            return;

        heap_size++;
        int i = heap_size - 1;
        heap[i] = k;


        while(i >= 0 && heap[i] < heap[parent(i)]){
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;

            i = parent(i);
        }
    }

    //Function to delete a key at ith index.
    void deleteKey(int i)
    {
        // Your code here.
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    //Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val)
    {
        heap[i] = new_val;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && heap[l] < heap[i]) smallest = l;
        if (r < heap_size && heap[r] < heap[smallest]) smallest = r;
        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
