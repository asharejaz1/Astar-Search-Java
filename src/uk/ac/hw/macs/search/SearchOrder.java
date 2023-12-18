package uk.ac.hw.macs.search;

import java.util.List;
import java.util.Set;

/**
 * Encodes a search order by describing how nodes are added to the fringe. Note that nodes are 
 * always removed from the front of the fringe.
 */
public interface SearchOrder {
	public void addToFringe(List<FringeNode> frontier, FringeNode parent, Set<ChildWithCost> children);
}

class AStarSearchOrder implements SearchOrder {
	public void addToFringe(List<FringeNode> frontier, FringeNode parent, Set<ChildWithCost> children) {
		for (ChildWithCost child : children) {
			boolean shouldInsert = true;

				// Create a new FringeNode for the child
				FringeNode fringeChild = new FringeNode(child.node, parent, child.cost);

				int fValue = fringeChild.getFValue();

			/*Sorted insertion of nodes into fringe by order of increasing fVal*/
			// Find the appropriate position in the frontier based on fValue
			int index = 0;
			while (index < frontier.size() && fValue > frontier.get(index).getFValue()) {
				index++;
			}

			// Insert the child node at the calculated index in the frontier
			frontier.add(index, fringeChild);

		}
	}

}