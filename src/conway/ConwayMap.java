package conway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ConwayMap {
	private Map<Coordinate, Cell> map = new HashMap<>();

	public void addCell(Coordinate coordinate, Cell cell) {
		map.putIfAbsent(coordinate, cell);
	}

	public void applyRule(Rule rule) {
		Map<Coordinate, Cell> newMap = new HashMap<>();

		// TODO batch parallelize
		for (Entry<Coordinate, Cell> e : map.entrySet()) {
			Cell cell = e.getValue();
			Coordinate coord = e.getKey();
			if (!cell.isImmortal())
				rule.apply(map, newMap, coord, cell);

			// Apply to neighbours in range that don't have cells themselves
			List<Coordinate> neighbours = coord.getNeighboursInRange(rule.getRange());
			neighbours.removeIf(map::containsKey);
			neighbours.stream().forEach(n -> rule.apply(map, newMap, n));
		}
		map = newMap;
	}

	public String toString() {
		return map.keySet().toString();
	}

	public Character[][] getViewport(Coordinate bot, Coordinate top) {
		return getViewport(bot.x, bot.y, top.x, top.y);
	}

	public Character[][] getViewport(long x0, long y0, long x1, long y1) {
		Character[][] array = new Character[(int) (x1 - x0)][(int) (y1 - y0)];
		for (long x = x0; x < x1; x++) {
			for (long y = y0; y < y1; y++) {
				if (map.containsKey(new Coordinate(x, y))) {
					array[(int) (x - x0)][(int) (y - y0)] = '#';
				} else {
					array[(int) (x - x0)][(int) (y - y0)] = ' ';
				}
			}
		}
		return array;
	}
}
