package ci.miage.prg1.tp3;

/**
 * @author Yeo François <foursov@univ-rennes1.fr>
 * @author Yapi Yapo <foursov@univ-rennes1.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 */

public class Fourmis {

	/**
	 * @param s un terme de la suite des fourmis
	 * @pre s.length() > 0
	 * @return le terme suivant de la suite des fourmis
	 */
	public static String next(String s) {

		StringBuilder chaine = new StringBuilder();
		int compteur=1;
		if(s.isEmpty()){
			return "";
		}

		for (int i=1;i<s.length();i++) {
			if ( s.charAt(i)== s.charAt(i-1)){
				compteur++;
			} else {
				chaine.append(Integer.toString(compteur));
				chaine.append(s.charAt(i-1));
				compteur=1;
			}
		}

		chaine.append(Integer.toString(compteur));
		chaine.append(s.charAt(s.length()-1));

		return chaine.toString();

	}
}