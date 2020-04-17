package conway;

public class Cell {

	public static final Cell DEFAULTCELL = new Cell(false);
	public static final Cell IMMORTALCELL = new Cell(true);
	private boolean isImmortal = false;

	public Cell() {
	}

	public Cell(boolean immortal) {
		this();
		this.isImmortal = immortal;
	}

	public boolean isImmortal() {
		return isImmortal;
	}

	public void setImmortal(boolean fact) {
		isImmortal = fact;
	}

}
