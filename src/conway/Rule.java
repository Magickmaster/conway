package conway;

import java.util.Map;

public class Rule {

	public static final Rule DEFAULT = new Rule();

	private static final int RANGE = 1;

	public void apply(final Map<Coordinate, Cell> oldMap, Map<Coordinate, Cell> newMap, Coordinate coord) {
		apply(oldMap, newMap, coord, null);
	}

	public void apply(Map<Coordinate, Cell> oldMap, Map<Coordinate, Cell> newMap, Coordinate coord, Cell cell) {
		boolean isDead = cell == null;
		long livingNeighbours = coord.getNeighboursInRange(RANGE).stream().filter(oldMap::containsKey).count();
		if (livingNeighbours == 3 || (!isDead && livingNeighbours == 2)) {
			newMap.put(coord, Cell.DEFAULTCELL);
		}
	}

	public int getRange() {
		return RANGE;
	}

}
