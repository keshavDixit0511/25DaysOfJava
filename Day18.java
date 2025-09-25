import java.util.ArrayList;

/**
 * A class to represent a Min-Heap data structure.
 * A Min-Heap is a complete binary tree where the value of each node
 * is less than or equal to the value of its children.
 * This implementation uses an ArrayList to store the heap elements.
 */
public class Day18 {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        /**
         * Adds a new element to the heap while maintaining the heap property.
         * The new element is added to the end and then "up-heapified" to its correct position.
         *
         * @param data The integer to be added to the heap.
         */
        public void add(int data) {
            // Add the new data to the end of the ArrayList.
            arr.add(data);

            // Get the index of the newly added element (child) and its parent.
            int childIndex = arr.size() - 1;
            int parentIndex = (childIndex - 1) / 2;

            // Up-heapify: compare the child with its parent and swap if the child is smaller.
            // Repeat until the child is at the root or is no longer smaller than its parent.
            while (childIndex > 0 && arr.get(childIndex) < arr.get(parentIndex)) {
                // Swap the child and parent elements.
                int temp = arr.get(childIndex);
                arr.set(childIndex, arr.get(parentIndex));
                arr.set(parentIndex, temp);

                // Update indices for the next iteration.
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
        }

        /**
         * Returns the minimum element of the heap without removing it.
         * The minimum element is always at the root (index 0).
         *
         * @return The smallest integer in the heap, or -1 if the heap is empty.
         */
        public int peek() {
            if (arr.isEmpty()) {
                System.out.println("Heap is empty");
                return -1;
            }
            return arr.get(0);
        }

        /**
         * Returns the number of elements in the heap.
         *
         * @return The size of the heap.
         */
        public int size() {
            return arr.size();
        }

        /**
         * Checks if the heap is empty.
         *
         * @return true if the heap is empty, false otherwise.
         */
        public boolean isEmpty() {
            return arr.isEmpty();
        }

        /**
         * Removes and returns the minimum element from the heap.
         * The root element is removed, the last element is moved to the root,
         * and the new root is "down-heapified" to its correct position.
         *
         * @return The smallest integer that was in the heap, or -1 if the heap was empty.
         */
        public int remove() {
            if (arr.isEmpty()) {
                System.out.println("Heap is empty");
                return -1;
            }

            // The value of the root (minimum element) to be returned.
            int data = arr.get(0);

            // Step 1: Swap the first and last elements.
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2: Remove the last element, which is the old root.
            arr.remove(arr.size() - 1);

            // Step 3: Down-heapify the new root to restore the heap property.
            minHeapify(0);

            return data;
        }

        /**
         * Recursively restores the heap property by "down-heapifying" a node at a given index.
         * This method finds the smallest child and swaps the current node with it if necessary.
         *
         * @param index The index of the node to start the heapify process from.
         */
        public void minHeapify(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int minIndex = index;

            // Check if the left child exists and is smaller than the current minimum.
            if (leftChildIndex < arr.size() && arr.get(leftChildIndex) < arr.get(minIndex)) {
                minIndex = leftChildIndex;
            }

            // Check if the right child exists and is smaller than the current minimum.
            if (rightChildIndex < arr.size() && arr.get(rightChildIndex) < arr.get(minIndex)) {
                minIndex = rightChildIndex;
            }

            // If the smallest element is not the current node, swap and continue heapifying.
            if (minIndex != index) {
                // Swap the current element with the minimum child.
                int temp = arr.get(index);
                arr.set(index, arr.get(minIndex));
                arr.set(minIndex, temp);

                // Recursively call minHeapify on the new position of the swapped element.
                minHeapify(minIndex);
            }
        }
    }

    public static void main(String[] args) {
        // Create a new Min-Heap instance.
        Heap heap = new Heap();
        
        // Add elements to the heap. The heap will automatically maintain the min-heap property.
        heap.add(3);
        heap.add(4);
        heap.add(1);
        heap.add(5);
        heap.add(2);

        // Print elements of the heap in sorted order by repeatedly removing the minimum element.
        while (!heap.isEmpty()) {
            System.out.println(heap.peek()); // Print the current minimum element.
            heap.remove(); // Remove the minimum element.
        }
    }
}