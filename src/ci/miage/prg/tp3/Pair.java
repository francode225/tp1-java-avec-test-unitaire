package ci.miage.prg.tp3;

/**
 * 
 * @author Mickaël Foursov <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 *        Classe représentant des doublets *non modifiables*
 */

public class Pair implements Comparable<Pair> {

	public Pair(int x, int y) {
	}

	@Override
	public int compareTo(Pair d) {
		return 0;
	}

	public Pair copyOf() {
		return null;
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pair)) {
			return false;
		}
		// DERNIER CAS À TRAITER
		return false;
	}
}