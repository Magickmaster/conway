package conway;

import java.util.LinkedList;
import java.util.List;

public class Coordinate {
	final long x;
	final long y;

	public Coordinate(long x, long y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object other) {
		if (other instanceof Coordinate) {
			Coordinate oth = (Coordinate) other;
			return this.x == oth.x && this.y == oth.y;
		}
		return false;
	}

	public List<Coordinate> getNeighboursInRange(int range) {
		List<Coordinate> neighbours = new LinkedList<>();
		for (long tx = x - range; tx <= x + range; tx++) {
			for (long ty = y - range; ty <= y + range; ty++) {
				if (x != tx || y != ty)
					neighbours.add(new Coordinate(tx, ty));
			}
		}
		return neighbours;
	}

	@Override
	public int hashCode() {
		int result = (int) (x ^ (x >>> 32));
		result = 31 * result + (int) (y ^ (y >>> 32));
		return result;
	}

	public String toString() {
		return "(" + x + "|" + y + ")";
	}
}
