import java.util.ArrayList;

/**
 * This class represents a Used Car Lot.
 * @author Max Klot
 *
 */

public class UsedCarLot
{
    /**The Array of Cars*/
    private ArrayList<Car> inventory = new ArrayList<Car>();

    /**Constructor for Used Car Lot object. No parameters.*/
    public UsedCarLot()
    {

    }

    /**
     * Adds new Car to inventory array.
     * @param car The car added to the lot.
     */
    public void addCar(Car car)
    {
        inventory.add(car);
    }

    /**
     * This method swaps cars at indices f and s.
     * @param f arbitrary first index
     * @param s arbitrary second index
     * @return whether or not the swap was succesful.
     */
    public boolean swap(int f, int s)
    {
        if(f < 0 || s < 0 || f > inventory.size() - 1 || s > inventory.size() - 1)
        {
            return false;
        }
        else
        {
            Car temp = inventory.get(f);
            inventory.set(f, inventory.get(s));
            inventory.set(s, temp);
        }
        return true;
    }

    /**
     * Getter method for inventory Array of cars in lot.
     * @return Inventory Array of Cars
     */
    public ArrayList getInventory()
    {
        return inventory;
    }


    /**
     * Adds a Car to the inventory list at the index specified
     * by indexToAdd; this method increases the size of inventory by 1
     * <p>
     * PRECONDITION: 0 &lt;= indexToAdd &lt; inventory.size()
     * DUE TO THIS PRECONDITION, you do NOT need to check for boundary errors
     * like you did the other addCar method; also note that this method is void
     * @param indexToAdd Which index the car is added to.
     * @param carToAdd The car being added to determined index.
     */
    public void addCar(int indexToAdd, Car carToAdd)
    {
        inventory.add(indexToAdd, carToAdd);
    }

    /**
     * "sells" the Car located at indexOfCarToSell which
     *  removes it from the inventory list and shifting the remaining
     *  Cars in the inventory list to the left to fill in the gap;
     *  this method reduces the size of inventory by 1
     * <p>
     *  PRECONDITION: indexOfCarToSell &lt; inventory.size()
     * @param indexOfCarToSell index of the car being sold
     * @return Returns the Car that is being "sold" (removed from lot)
     */
    public Car sellCarShift(int indexOfCarToSell)
    {
        Car fake = inventory.get(indexOfCarToSell);
        inventory.remove(indexOfCarToSell);
        return fake;
    }

    /**
     * "sells" the Car located at indexOfCarToSell,
     * but instead of removing it and shifting the inventory
     * list to the left, REPLACE the Car at indexOfCarToSell
     * with NULL, thus creating an "empty parking spot" on the lot;
     * this method does NOT reduce the size of inventory by 1
     * <p>
     * PRECONDITION: indexOfCarToSell &lt; inventory.size()
     * @param indexOfCarToSell index of the car being sold
     * @return This method returns the Car that is being "sold" (replaced with null)
     */
    public Car sellCarNoShift(int indexOfCarToSell)
    {
        Car fake = inventory.get(indexOfCarToSell);
        inventory.add(indexOfCarToSell + 1, null);
        inventory.remove(indexOfCarToSell);
        return fake;
    }

    /**
     * moves Car located at index indexOfCarToMove to index destinationIndex;
     * if destinationIndex > indexOfCarToMove, moves the Car to the right in
     * inventory; if destinationIndex &lt; indexOfCarToMove, moves the
     * Car to the left in the inventory. All other cars in the inventory
     * should shift accordingly
     * <p>
     * PRECONDITIONS: indexOfCarToMove &lt; inventory.size()
     *                destinationIndex &lt; inventory.size()
     * @param indexOfCarToMove index of the Car that is moving
     * @param destinationIndex index the car is moving to
     */
    public void moveCar(int indexOfCarToMove, int destinationIndex)
    {
        Car temp = inventory.get(destinationIndex);
        inventory.set(destinationIndex, inventory.get(indexOfCarToMove));
        {
            if(destinationIndex > indexOfCarToMove)
            {
                inventory.remove(indexOfCarToMove);
                inventory.add(destinationIndex - 1, temp);
            }
            else
            {
                inventory.remove(indexOfCarToMove);
                inventory.add(destinationIndex + 1, temp);
            }
        }
    }

}
