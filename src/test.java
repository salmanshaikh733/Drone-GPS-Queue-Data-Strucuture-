/*
import java.io.FileNotFoundException;
import java.io.IOException;
public class test {


 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


*
     *
     * @author Gugsa Challa


    public class FindShortestPath {

        Map cityMap;

        private static boolean interference(MapCell cell) throws InvalidNeighbourIndexException {
            //try{
            for (int i = 0; i < 6; i++) {

                if (cell == null) {
                    System.out.println("Cell should not be null, need to check while loop");

                }

                if (cell.getNeighbour(i) != null && cell.getNeighbour(i).isTower()) {
                    return true;
                    //adjacent[i]= cell.getNeighbour(i);
                }

            }

            return false;
        }

        public static void main(String[] args) throws InvalidMapException, FileNotFoundException, IOException, InvalidNeighbourIndexException,InvalidMapException, InvalidElementException{
            //create priority queue
            try {
                Map cityMap = new Map(args[0]);
                DLPriorityQueue<MapCell> QueueMap = new DLPriorityQueue<MapCell>();

                MapCell initialCell = cityMap.getUWOstore();
                QueueMap.enqueue(initialCell, 0);
                initialCell.markEnqueued();
                int counter;
                int Distance;
                double Priority;
                while (!QueueMap.isEmpty() && !initialCell.isCustomer()) {
                    MapCell currentCell;
                    MapCell smallestCell = QueueMap.getSmallest();
                    smallestCell.markDequeued();
                    if (smallestCell.isCustomer()) {
                        counter = smallestCell.getDistanceToStart() + 1;
                        System.out.println("The number of cells to the customer from the start is " + counter + "");
                        break;

                    }

                    for (int i = 0; i < 6; i++) {
                        if (smallestCell.getNeighbour(i) != null) {
                            currentCell = smallestCell.getNeighbour(i);

                            if (interference(smallestCell) == true || smallestCell.isTower()) {
                                continue;
                            }

                            if (!smallestCell.getNeighbour(i).isNoFlying() && !smallestCell.getNeighbour(i).isMarkedDequeued()) {
                                currentCell = smallestCell.getNeighbour(i);
                                Distance = 1 + smallestCell.getDistanceToStart();
                                if (currentCell.getDistanceToStart() > Distance) {
                                    currentCell.setDistanceToStart(Distance);
                                    currentCell.setPredecessor(smallestCell);
                                }

                                Priority = currentCell.getDistanceToStart() + currentCell.euclideanDistToDest(cityMap);
                                if (currentCell.isMarkedEnqueued() && Priority < QueueMap.getPriority(currentCell)) {
                                    QueueMap.changePriority(currentCell, Priority);
                                }
                                if (!currentCell.isMarkedEnqueued()) {
                                    QueueMap.enqueue(currentCell, Priority);
                                    currentCell.markEnqueued();
                                }

                            }
                        }

                    }
                    if (QueueMap.isEmpty()) {
                        System.out.println("The Queue is empty");
                    }
                }

                // if (interference(smallestCell) == false || !smallestCell.isTower()){
                //  if (!smallestCell.getNeighbour(i).isMarkedDequeued)
            } catch (InvalidMapException e) {
                System.out.println("Map is not valid");
            } catch (FileNotFoundException e) {
                System.out.println("The file name does not exist ");
            } catch (IOException e) {
                System.out.println("incorrect arguement");
            }

        }
    }
}
*/
