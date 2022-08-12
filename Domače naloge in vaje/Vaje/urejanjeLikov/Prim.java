
public class Prim {

    /**
     * Skupni imenovalec vseh primerjalni"skih razredov.
     */
    public static interface Primerjalnik {

        /** 
         * Vrne true natanko v primeru, "ce lik a po izbranem urejevalnem
         * kriteriju sodi pred lik b.
         */
        public boolean jePred(Lik a, Lik b);
    }

    /**
     * Objekt tega razreda je primerjalnik za primerjavo likov po tipu.
     */
    public static class PrimerjalnikTip implements Primerjalnik {

        public boolean jePred(Lik a, Lik b) {
            return a.tip() < b.tip();
        }
    }

    /**
     * Objekt tega razreda je primerjalnik za primerjavo likov po plo"s"cini.
     */
    public static class PrimerjalnikPloscina implements Primerjalnik {

        public boolean jePred(Lik a, Lik b) {
            return a.ploscina() < b.ploscina();
        }
    }

    /**
     * Objekt tega razreda je primerjalnik za primerjavo likov po plo"s"cini.
     */
    public static class PrimerjalnikObseg implements Primerjalnik {

        public boolean jePred(Lik a, Lik b) {
            return a.obseg() < b.obseg();
        }
    }

    /**
     * Objekt tega razreda je primerjalnik, ki par likov najprej primerja po
     * prvem izhodi"s"cnem primerjalniku, v primeru enakosti glede na prvi
     * primerjalnik pa "se po drugem.
     */
    public static class Kombinacija implements Primerjalnik {

        private Primerjalnik prvi;
        private Primerjalnik drugi;

        public Kombinacija(Primerjalnik prvi, Primerjalnik drugi) {
            this.prvi = prvi;
            this.drugi = drugi;
        }

        public boolean jePred(Lik a, Lik b) {
            // "ce se lika razlikujeta po prvem kriteriju, vrni true oz. false
            if (this.prvi.jePred(a, b)) {
                return true;
            }
            if (this.prvi.jePred(b, a)) {
                return false;
            }
            // sicer primerjaj lika "se po drugem kriteriju
            return this.drugi.jePred(a, b);
        }

    }
}
