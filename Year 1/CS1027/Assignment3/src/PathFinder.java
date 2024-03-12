import java.io.FileNotFoundException;
import java.io.IOException;

public class PathFinder {
	/**
	 * Represents a method of finding the best path in a map of chambers. 
	 * @author Ria Haque 251164501
	 */
	
	private Map pyramidMap; // the map to be analyzed
	private int treasuresFound; // number of treasures found already 
	
	/**
	 * Constructor for PathFinder object for a given map file , throws Exceptions if map file cannot be found and 
	 * new object created 
	 * @param fileName file containing map to be analyzed 
	 * @throws InvalidMapCharacterException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public PathFinder(String fileName) throws InvalidMapCharacterException, FileNotFoundException, IOException {
		try {
			pyramidMap = new Map(fileName);
		}
		catch (Exception e) {
			System.out.println("Error in generating map");
		}
	}
	
	/**
	 * Creates a stack of chambers to be traversed in the best path possible 
	 * @return DLL stack containing order of chambers to follow
	 */
	public DLStack path() {
		DLStack chambers = new DLStack();
		Chamber entrance = pyramidMap.getEntrance();
		int treasures = pyramidMap.getNumTreasures();
		chambers.push(entrance);
		entrance.markPushed();
		while (!chambers.isEmpty()) {
			Chamber currentChamber = (Chamber)chambers.peek();
			if (currentChamber.isTreasure() && treasuresFound == treasures) break;
			Chamber nextChamber = bestChamber(currentChamber);
			if (nextChamber != null) {
				chambers.push(nextChamber);
				nextChamber.markPushed();
			}
			else {
				Chamber poppedChamber = (Chamber)chambers.pop();
				poppedChamber.markPopped();
			}
		}
		return chambers;
	}
	
	
	/**
	 * Getter for the map
	 * @return Map being used
	 */
	public Map getMap() {
		return pyramidMap;
	}
	
	/**
	 * Returns if chamber is dim or not
	 * @param currentChamber chamber to be analyzed
	 * @return true if chamber is dim, otherwise false 
	 */
	public boolean isDim(Chamber currentChamber) {
		boolean conditions = false;
		if (currentChamber != null && !currentChamber.isSealed() && !currentChamber.isLighted()) conditions = true;
		boolean lightNeighbor = false;
		for (int i = 0; i < 6; i++) {
			Chamber neighbor = currentChamber.getNeighbour(i);
			if (neighbor != null) {
				if (neighbor.isLighted()) lightNeighbor = true;
			}
		}
		return (conditions && lightNeighbor);
		
	}
	
	/**
	 * Finds next best chamber to enter from the current chamber
	 * @param currentChamber starting point 
	 * @return Chamber that is the best to enter next
	 */
	public Chamber bestChamber(Chamber currentChamber) {
		Chamber best = null;
		boolean found = false;
		int i = 0;
		while (!found && i < 6) {
			Chamber neighbor = currentChamber.getNeighbour(i);
			if (neighbor.isTreasure() && !neighbor.isMarked()) {
				best = neighbor;
				found = true;
			}
			i++;
		}
		i = 0;
		while (!found && i < 6) {
			Chamber neighbor = currentChamber.getNeighbour(i);
			if (neighbor.isLighted() && !neighbor.isMarked()) {
				best = neighbor;
				found = true;
			}
			i++;
		}
		i = 0;
		while (!found && i < 6) {
			Chamber neighbor = currentChamber.getNeighbour(i);
			if (isDim(neighbor) && !neighbor.isMarked()) {
				best = neighbor;
				found = true;
			}
			i++;
		}
		return best;
	}

	
	//testing
	public static void main(String[] args) {
	}

}
