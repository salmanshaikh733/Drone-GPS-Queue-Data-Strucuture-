public class test2 {
    public class DLPriorityQueue<T> implements PriorityQueueADT<T>{
        private PriorityNode<T> front;
        private PriorityNode<T> rear;
        private int count;
        public DLPriorityQueue(){
            front = null;
            rear = null;
            count = 0;
        }
        public void enqueue (T dataItem, double priority){
            PriorityNode<T>node = new PriorityNode<T>(dataItem,priority);
            if (isEmpty()){
                front= node;
                rear = node;
            }
            else{
                node.setPrevious(rear);
                rear.setNext(node);
                rear = node;
            }

            count++;

        }
        public T dequeue ( ) throws EmptyPriorityQueueException {
            //try{
            if (isEmpty()){
                throw new EmptyPriorityQueueException ("The Priority Queue is Empty");
            }
            T result = front.getDataItem( );
            front = front.getNext( );
            count--;
            if (!isEmpty()){
                front.setPrevious(null);
            }
            // }
            //catch(EmptyPriorityQueueException e){

            // }
            return result;
        }

        public double getPriority(T dataItem) throws InvalidDataItemException{
            PriorityNode<T> current = front;
            while(current!= null){
                if (current.getDataItem().equals(dataItem)){
                    break;
                }

                current = current.getNext();

            }
            if(current == null){
                throw new InvalidDataItemException ("The given dataItem is not in the Priority Queue");
            }
            return current.getPriority();
        }
        public void changePriority (T dataItem, double newPriority) throws InvalidDataItemException{
            PriorityNode<T> current = front;
            while(current!= null){
                if (current.getDataItem().equals(dataItem)){
                    break;
                }
                current = current.getNext();

            }
            if(current == null){
                throw new InvalidDataItemException ("The given dataItem is not in the Priority Queue");
            }
            current.setPriority(newPriority);
        }

        public T getSmallest() throws EmptyPriorityQueueException{
            PriorityNode<T> current = front;
            PriorityNode<T> small = current;
            if (isEmpty()){
                throw new EmptyPriorityQueueException ("The Priority Queue is Empty");
            }
            double smallest;
            if (count == 1) return dequeue();
            for (int i =0; i<count-1;i++){
                if (current.getPriority()<= small.getPriority()){
                    small = current;
                }
                current = current.getNext();
            }
            if (small == front){
                if(small == rear){
                    front = null;
                    rear = null;
                }
                else{
                    front = small.getNext();
                    small.getNext().setPrevious(null);
                }
            }
            else if(small!= front){
                if(small!= rear){
                    small.getNext().setPrevious(small.getPrevious());
                    small.getPrevious().setNext(small.getNext());
                }
                else{
                    rear = small.getPrevious();
                    rear.getNext().setNext(null);
                }
            }
            //small.getPrevious().setNext(small.getNext());
            //small.getNext().setPrevious(small.getPrevious());
            count--;

            return small.getDataItem();
        }
        public boolean isEmpty(){
            if (count == 0){
                return true;
            }
            return false;
        }
        public int numItems(){
            return count;
        }
        public String toString(){
            PriorityNode<T> current = front;
            PriorityNode<T> previous;
            String output = "";
            while(current!=null){
                output = output+current.getDataItem().toString()+"";
                current = current.getNext();

            }
            return output;
        }

    }
}
