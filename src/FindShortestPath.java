/**
 * @author Mshaik52 Student Number 250959996
 * This java class computes the path for the program and has 1 private and one main method
 * this program makes use of the queue ADT.
 * To find the correct path to the customer from the UWO store.
 * @version 1.0
 *
 */

import java.io.IOException;

public class FindShortestPath {
    /**
     * method to determine is current cell is next to any towers.
     * @param cell
     * @return is cell next to tower
     */
    private static boolean interference(MapCell cell) {

        int i = 0;
        boolean flag = false;

        while (flag == false && i < 6) {

            if (cell.getNeighbour(i) == null) {
                i++;
            } else if (cell.getNeighbour(i).isTower() == true) {
                flag = true;
                break;
            } else {
                flag = false;
                i++;
            }

        }

        return flag;
    }

    /**
     *
     * @param args
     * @throws IOException
     * main method for finding the customer cell
     */

    public static void main(String[] args) throws IOException {
        //create new queue
        DLPriorityQueue<MapCell> newQ = new DLPriorityQueue<MapCell>();

        boolean flag=false;
        try {
            Map cityMap = new Map(args[0]);
            int count;
            MapCell initialCell = cityMap.getUWOstore();
            newQ.enqueue(initialCell, 0);
            initialCell.markEnqueued();

            //while the queue is not empty and destination has not been reached
            try{ // try catch statment
            while (!newQ.isEmpty() && !initialCell.isCustomer()) {

                MapCell next;
                //get the smallest cell and mark is dequeued
                MapCell smallestCell = newQ.getSmallest();
                smallestCell.markDequeued();
                //is the smallest cell is the customer end the loop
                if (smallestCell.isCustomer()) {
                    count = smallestCell.getDistanceToStart() + 1;
                    System.out.println("Destination reached, number of cells " + count);
                    flag=true;
                    break;
                }

                //if not tower or next to tower, get the neighbouring cell and get the priority.
                for (int i = 0; i < 6; i++) {
                    int distance;
                    double priority;
                    //if next cell is not null then continue
                    next = smallestCell.getNeighbour(i);
                    if (next != null) {
                            //check to make sure next cell is not tower or next to tower
                        if (interference(smallestCell) == true || smallestCell.isTower()) {
                            continue;
                        }
                        //check to make sure cell is not marked and is not flying cell
                        if (!next.isMarkedDequeued() && !next.isNoFlying()) {
                            next = smallestCell.getNeighbour(i);
                            distance = smallestCell.getDistanceToStart() + 1;
                            //compare distance from old cell to start to new cell to start
                            if (next.getDistanceToStart() > distance) {
                                //set distance of next cell to distance from smallest cell to start plus 1
                                next.setDistanceToStart(distance);
                                //set the predessor cell to smallestCell
                                next.setPredecessor(smallestCell);

                            }
                            //calculate the priority of the next cell
                            priority = next.getDistanceToStart() + next.euclideanDistToDest(cityMap);
                            //if cell is marked already and new priority is less than current priority
                            if (next.isMarkedEnqueued() && priority < newQ.getPriority(next)) {
                                newQ.changePriority(next, priority);
                            }
                            //is cell is not marked add to queue and mark it
                            if (!next.isMarkedEnqueued()) {
                                newQ.enqueue(next, priority);
                                next.markEnqueued();
                            }

                        }
                    }
                }


            }
                if (flag == false) {//exit for loop means that there is not valid route or customer cell does not exist

                    System.out.println("No Valid Route");
                }
            //try and catch statements for possible exceptions that may need to be handled
            }catch(EmptyPriorityQueueException e){
                System.out.println("Trying to access Empty Queue");
            }
            catch(InvalidDataItemException e){
                System.out.println("Invalid Data Item");
            }
            catch(InvalidNeighbourIndexException e){
                System.out.println("Invalid Neighbour");
            }
            catch(InvalidMapException e){
                System.out.println("Invalid Map");
            }
            //if wrong file name is entered
        }catch(IOException e){
            System.out.println("File Not Found!");
        }
    }
}


