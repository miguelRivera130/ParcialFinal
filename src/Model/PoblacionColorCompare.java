package Model;

import java.util.Comparator;

public class PoblacionColorCompare implements Comparator<Poblacion> {

	public PoblacionColorCompare() {
	}

	@Override
	public int compare(Poblacion o1, Poblacion o2) {
		return o1.getColor().compareTo(o2.getColor());
	}
}