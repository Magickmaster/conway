package conway;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		ConwayMap spinner = MapReader.read(new File("testGames/spinner"));
		
		printNice(spinner.getViewport(0, 0, 4, 4));
		spinner.applyRule(Rule.DEFAULT);
		printNice(spinner.getViewport(0, 0, 4, 4));
		spinner.applyRule(Rule.DEFAULT);
		printNice(spinner.getViewport(0, 0, 4, 4));
		spinner.applyRule(Rule.DEFAULT);
		printNice(spinner.getViewport(0, 0, 4, 4));
		spinner.applyRule(Rule.DEFAULT);
		printNice(spinner.getViewport(0, 0, 4, 4));
		spinner.applyRule(Rule.DEFAULT);
		printNice(spinner.getViewport(0, 0, 4, 4));
	}

	private static void printNice(Character[][] map) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
