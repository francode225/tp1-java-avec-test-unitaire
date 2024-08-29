package ci.miage.prg1.tp3;
import java.util.Scanner;

/**
 *
 * @author YEO François <foursov@univ-rennes1.fr>
 * @author YAPI Yapo <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 *        Partie II
 *
 *        Lecture, au clavier, d'une suite de doublets d'entiers terminée par -1
 *
 *        Cette suite peut comporter des doublets identiques.
 * 
 *        Construction et affichage d'un tableau contenant les doublets
 *        distincts triés selon l'ordre croissant des doublets, à savoir : (x1,
 *        y1) < (x2, y2) <==> (x1<x2) ou (x1==x2 et y1<y2)
 * 
 *        En entrée : 3 8 1 4 3 8 1 3 -1 ==> En sortie : [1 3] [1 4] [3 8]
 */

public class InsertionPair {

	private static final int SIZE_MAX = 10;
	private static final int END_MARKER = -1;
	/**
	 * nombre de doublets présents dans t, 0 <= size <= SIZE_MAX
	 */
	private int size =0;
	private Pair[] array = new Pair[SIZE_MAX];

	/**
	 * @return copie de la partie remplie du tableau
	 */
	public Pair[] toArray() {
		Pair[] tableauCopie = new Pair[size];
		System.arraycopy(array,0, tableauCopie, 0, size);
		return tableauCopie;
	}

	/**
	 * array est rempli, par ordre croissant, en utilisant la fonction insert, avec
	 * les valeurs lues par scanner.
	 * 
	 * @param scanner
	 */

	public void createArray(Scanner scanner) {

		int[] tableauPair = new  int[2];
		int indice=0;
		int nombre = scanner.nextInt();

		while (nombre != END_MARKER){
			tableauPair[indice]=nombre;

			if (tableauPair[1] == 0) {
				tableauPair[1] = (tableauPair[0] > nombre) ? tableauPair[0] : nombre;
				tableauPair[0] = (tableauPair[0] > nombre) ? nombre : tableauPair[0];
			}
			indice++;
			if (indice>= 2){
				Pair pair = new Pair(tableauPair[0],tableauPair[1]);
				insert(pair);
				indice=0;
				tableauPair = new int[2];
			}
			nombre = scanner.nextInt();
		}
	}

	/**
	 * Si pair n'appartient pas à array[0..size-1] et size < SIZE_MAX, size est
	 * incrémenté de 1, pair est inséré dans array et les entiers array[0..size]
	 * sont triés par ordre croissant. Sinon array est inchangé.
	 * 
	 * @param pair doublet à insérer
	 * 
	 * @pre les doublets de array[0..size-1] sont triés par ordre croissant
	 * 
	 * @return false si pair appartient à array[0..size-1] ou si array est
	 *         complètement rempli; true si pair n’appartient pas à array[0..size-1]
	 */
	public boolean insert(Pair pair) {

		if (size>=SIZE_MAX){
			return false;
		}
		if (size == 0){
			array[0]=pair;
			size = 1;
			return true;
		}
		for (int i=0;i<size;i++){
			if (array[i].compareTo(pair) == 0){
				return false;
			}
		}

		size++;

		if (array[size-2].compareTo(pair) < 0){
			array[size-1]=pair;
			return true;
		}

		int j = size -1;


		while (j>0){
			if (array[j-1].compareTo(pair) > 0){
				array[j] = array[j-1];
				array[j-1] =pair;
			}else{
				break;
			}
			j--;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder("");
		for (int i=0; i<size;i++){
			chaine.append(array[i]);
			chaine.append(" ");
		}
		return chaine.toString().trim();
	}

}