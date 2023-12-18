package uk.ac.hw.macs.search;

/**
 * Represents a state in the search space. You need to include a method for determining whether a state is a 
 * goal state, and one for computing the heuristic value.
 */
public interface State {
	public boolean isGoal();
	public int getHeuristic();
}

class IntState implements State {
	private int currentX;
	private int currentY;
	private int goalX;
	private int goalY;
	private int heuristic;

	//constructor
	public IntState (int currentX, int currentY, int goalX, int goalY) {
		this.currentX = currentX;
		this.currentY = currentY;
		this.goalX = goalX;
		this.goalY = goalY;
		this.heuristic = getHeuristic();
	}


	@Override
	public boolean isGoal() {
        return (currentX == goalX && currentY == goalY); //returns false if conditions doesn't match
    }

	@Override
	public int getHeuristic() {
        return Math.abs(goalX - currentX) + Math.abs(goalY - currentY); //calculates heuristic
	}

	@Override
	public String toString() { return "GridState [XY=" + currentX + currentY + ", Heuristic=" + heuristic + ", Goal=" + goalX + " " + goalY + "]"; }


}