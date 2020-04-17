package conway;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MapReader {

	public static ConwayMap read(File file) {

		ConwayMap map = new ConwayMap();
		try (Scanner sc = new Scanner(file)) {

			while (sc.hasNextLong()) {

				long x = sc.nextLong();
				if (sc.hasNextLong()) {
					long y = sc.nextLong();
					map.addCell(new Coordinate(x, y), Cell.DEFAULTCELL);
				} else {
					throw new InputMismatchException("There is no y coordinate to a suppl. point");
				}
			}
		} catch (FileNotFoundException | InputMismatchException e) {
			e.printStackTrace();
		}
		return map;
	}
}
