
// 
// (na konec prej"snje vrstice zapi"site va"so vpisno "stevilko)

public class Druga {

    public static void main(String[] args) {
        // koda za ro"cno testiranje (po "zelji)
    }

    //=========================================================================
    public static class Predmet {
        private String naziv;
        private int kreditneTocke;
        private boolean strokovni;
        private int dan;

        public Predmet(String naziv, int kreditneTocke, boolean strokovni, int dan) {
            this.naziv = naziv;
            this.kreditneTocke = kreditneTocke;
            this.strokovni = strokovni;
            this.dan = dan;
        }

        // po potrebi dodajte svoje metode ...

        public String vrniNaziv() {
            return this.naziv;
        }

        public boolean jeStrokovni() {
            return this.strokovni;
        }

        public int vrniKreditneTocke() {
            return this.kreditneTocke;
        }

        public int vrniDan() {
            return this.dan;
        }
    }

    //=========================================================================
    public static class Student {
        private String ime;
        private Predmet[] predmeti;
        private int[] ocene;

        public Student(String ime, Predmet[] predmeti, int[] ocene) {
            this.ime = ime;
            this.predmeti = predmeti;
            this.ocene = ocene;
        }

        // po potrebi dodajte svoje metode ...

        public String vrniIme() {
            return this.ime;
        }

        public boolean imaProstoIzbirni() {
            for (int i = 0; i < this.predmeti.length; i++) {
                if (!this.predmeti[i].jeStrokovni())
                    return true;
            }
            return false;
        }

        public int[] steviloKT() {
            int strokovni = 0;
            int izbirni = 0;
            for (int i = 0; i < this.predmeti.length; i++) {
                if (this.ocene[i] > 5) {
                    if (this.predmeti[i].jeStrokovni())
                        strokovni += this.predmeti[i].vrniKreditneTocke();
                    else
                        izbirni += this.predmeti[i].vrniKreditneTocke();
                }
            }
            return new int[] {strokovni, izbirni};
        }

        public boolean jeNeuspesen() {
            int pozitivno = 0;
            for (int i = 0; i < this.predmeti.length; i++) {
                if (this.ocene[i] > 5)
                    pozitivno++;
            }
            return (pozitivno == 0);
        }
    }

    //=========================================================================
    public static class Letnik {
        private Student[] studenti;

        public Letnik(Student[] studenti) {
            this.studenti = studenti;
        }

        // po potrebi dodajte svoje metode ...

        public int steviloNeuspesnih() {
            int stevilo = 0;
            for (int i = 0; i < this.studenti.length; i++) {
                Student student = this.studenti[i];
                if (student.jeNeuspesen())
                    stevilo++;
            }
            return stevilo;
        }

        public int morebitnaPrekrivanja(int dan) {
            int prekrivanja = 0;
           for (int i = 0; i < this.studenti.length; i++) {
               int dni = 0;
               for (int j = 0; j < this.studenti[i].predmeti.length; j++) {
                    if (this.studenti[i].predmeti[j].vrniDan() == dan)
                        dni++;
               }
               if (dni >= 2)
                    prekrivanja++;
            }
            return prekrivanja;
        }
    }
}
