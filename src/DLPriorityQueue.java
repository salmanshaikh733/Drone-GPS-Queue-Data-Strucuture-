/**
 * @author Mshaik52 Student Number 250959996
 * Class for priority queue to hold nodes
 * this program makes use of the queue ADT.
 * To find the correct path to the customer from the UWO store.
 * @version 1.0
 */
public class DLPriorityQueue<T> implements PriorityQueueADT<T> {
    /**
     * declare instance variables
     */
    private PriorityNode<T> front;
    private PriorityNode<T> rear;
    private int count;

    /**
     * create an empty queue
     */
    public DLPriorityQueue() {
        this.front = null;
        this.rear = null;
        count = 0;

    }

    /**
     *
     * @param dataItem
     * @param priority
     */
    public void enqueue(T dataItem, double priority) {
        PriorityNode newNode = new PriorityNode(dataItem, priority);
        PriorityNode oldLast = rear;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            //get the nextnode
            rear = newNode;
            rear.setNext(null);
            oldLast.setNext(newNode);
            newNode.setPrevious(oldLast);

        }
        count++;
    }

    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     */
    public T dequeue() throws EmptyPriorityQueueException {

        PriorityNode firstNode;
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Empty Queue");
        }
        T result = front.getDataItem();
        front = front.getNext();
        count--;

        if (!isEmpty()) {

            front.setPrevious(null);
        }
        return result;
    }

    /**
     *
     * @return boolean
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return int
     */
    public int numItems() {
        return count;
    }

    /**
     *
     * @param dataItem
     * @return
     * @throws InvalidDataItemException
     */
    public double getPriority(T dataItem) throws InvalidDataItemException {

        PriorityNode<T> currentNode = front;
        int counter=0;
        while (counter<numItems()) {
            if (currentNode.getDataItem().equals(dataItem)) {
                break;
            }

            currentNode = currentNode.getNext();
            counter++;
        }
        if (counter == numItems()) {
            throw new InvalidDataItemException("DataItem not in the Priority Queue");
        }
        return currentNode.getPriority();
    }

    /**
     *
     * @param dataItem
     * @param newPriority
     * @throws InvalidDataItemException
     */
    public void changePriority(T dataItem, double newPriority) throws InvalidDataItemException {

        PriorityNode<T> currentNode = front;
        int counter=0;
        while (counter<numItems()) {
            if (currentNode.getDataItem().equals(dataItem)) {
                break;
            }

            currentNode = currentNode.getNext();
            counter++;

        }
        if (counter == numItems()) {
            throw new InvalidDataItemException("DataItem not in the Priority Queue");
        }
        currentNode.setPriority(newPriority);
    }

    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     * get the node with the smallest priority
     */

    public T getSmallest() throws EmptyPriorityQueueException {
        PriorityNode<T> current = front;
        PriorityNode<T> smallestValue = current;
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Empty Queue!");
        }

        PriorityNode nextNode = current.getNext();
        //while (current != (null) && nextNode != (null)) {
        if (numItems() == 1) {
            return dequeue();
        }
        for (int i = 0; i < count ; i++) {
            if (current.getPriority() < smallestValue.getPriority()) {
                smallestValue = current;
            } else {
                current = current.getNext();
            }
        }

        //if smallest node is at front
        if (smallestValue == front) {
            //if smallest node only node in queue
            if (smallestValue == rear) {
                front = null;
                rear = null;
                //if smallest node is only at front but there are other nodes in queue
            } else {
                front = smallestValue.getNext();
                smallestValue.getNext().setPrevious(null);
            }
            //if not is not at front
        } else if (smallestValue != front) {
            //if not is not at front and rear meaning it is middle then remove by pointing to nodes before and after
            if (smallestValue != rear) {
                smallestValue.getNext().setPrevious(smallestValue.getPrevious());
                smallestValue.getPrevious().setNext(smallestValue.getNext());
                //if node is at rear and there are items in queue
            } else {
                rear = smallestValue.getPrevious();
                rear.getNext().setNext(null);
            }
        }
        count--;
        //return the smallestValue
        return (T) smallestValue.getDataItem();
    }

    /**
     *
     * @return String representation of items
     */
    public String toString() {
        String result = "";
        PriorityNode current=front;
        //current=front;
        //int counter = 0;
        while (current != null) {
            result = current.toString()+result;
            current = current.getNext();
          //  counter++;
        }
        return result;
    }

}
