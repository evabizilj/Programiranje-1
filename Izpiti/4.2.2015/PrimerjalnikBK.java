
/**
 * Napi"site razred PrimerjalnikBK tako, da bo metoda urediJedi v razredu
 * Obrok, "ce ji podamo objekt tega razreda, jedi obroka this uredila najprej
 * po beljakovinskosti (v urejeni tabeli bodo najprej nanizane vse
 * nebeljakovinske, nato pa vse beljakovinske jedi), obe kategoriji posebej pa
 * bo nara"s"cajo"ce uredila po "stevilu kalorij.
 */

public class PrimerjalnikBK implements Primerjalnik {

    public boolean jePred(Jed a, Jed b) {
        if (a.jeBeljakovinska() && (!b.jeBeljakovinska())) {
            return false;
        }
        else if (a.jeBeljakovinska() && b.jeBeljakovinska()) {
            return a.kalorije() < b.kalorije();
        } else if ((!a.jeBeljakovinska()) && b.jeBeljakovinska()) {
            return true;
        } else if ((!a.jeBeljakovinska() && (!b.jeBeljakovinska()))){
            return a.kalorije() < b.kalorije();
        }
        return false;
    }
}
