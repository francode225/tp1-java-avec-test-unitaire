package ci.miage.prg1.tp3;

/**
 *
 * @author Yeo François De Sales Gneneman <foursov@univ-rennes1.fr>
 * @author Yapi Yapo <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 *        Classe représentant des doublets *non modifiables*
 */

public class Pair implements Comparable<Pair> {

	private final int x;
	private final int y;

	public Pair(int x, int y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public int compareTo(Pair d) {

		if (d.x==x && d.y==y) return 0;

		else if (d.x <= x && d.y<=y) return 1;

		else if (d.x >= x ) return -1;

		return 1;
	}

	public Pair copyOf() {
		return new Pair(x,y);
	}

	@Override
	public String toString() {
		return "[ "+ x + " , " + y + " ]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Pair)) return false;
		// DERNIER CAS À TRAITER
		return  ((Pair) obj).x == this.x  || ((Pair) obj).y == this.y;


	}
	public static void main(String[] args) {
		Pair pair1 = new Pair(2,3);
		Pair pair3 = pair1.copyOf();

		System.out.println(pair1.equals(pair3));
	}
}