/**
 * @author Mshaik52 Student Number 250959996
 * Class for nodes creates node objects and getter and setter methods
 * this program makes use of the queue ADT.
 * stores data item and priority.
 * @version 1.0
 *
 */
public class PriorityNode<T> {

    /**
     * declare instance variables
     */
    private T dataItem;
    private PriorityNode<T> next;
    private PriorityNode<T> previous;
    private double priority;

    /**
     * create node with arguments passed into it
     * @param data
     * @param prio
     */
    public PriorityNode(T data, double prio){
        this.dataItem=data;
        this.priority=prio;
    }

    /**
     * constructor create empty node with null
     */
    public PriorityNode(){
        this.dataItem=null;
        this.priority=0;
    }

    /**
     *
     * @return PriocirtyNode
     */
    public PriorityNode<T> getPrevious() {
        return this.previous;
    }

    /**
     *
     * @return
     */
    public PriorityNode<T> getNext() {
        return this.next;
    }

    /**
     *
     * @return
     */
    public double getPriority(){
        return this.priority;
    }

    /**
     *
     * @return
     */
    public T getDataItem(){
        return this.dataItem;
    }

    /**
     *
     * @param item
     */
    public void setDataItem(T item){
        this.dataItem=item;

    }

    /**
     *
     * @param next
     */
    public void setNext(PriorityNode<T> next){
        this.next=next;
    }

    /**
     *
     * @param previous
     */
    public void setPrevious(PriorityNode<T> previous){
        this.previous=previous;
    }

    /**
     *
     * @param priority
     */
    public void setPriority(double priority){
        this.priority=priority;
    }

    /**
     *
     * @return
     */
    public String toString(){
        String data=getDataItem()+"";
        String prio = getPriority()+"";
        return data+" "+prio;

    }

}
