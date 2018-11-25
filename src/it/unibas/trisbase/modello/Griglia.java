package it.unibas.trisbase.modello;

import it.unibas.trisbase.Applicazione;
import it.unibas.trisbase.Costanti;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Griglia {

    private static final Logger logger = LoggerFactory.getLogger(Griglia.class);
    
    private Cella[][] griglia;
    private int dimensione;

    public Griglia(int dimensione) {
        this.dimensione = dimensione;
        this.griglia = new Cella[this.dimensione][this.dimensione];
        this.inizializzaCelle();
    }

    private void inizializzaCelle() {
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                this.griglia[i][j] = new Cella(Costanti.STATO_VUOTO);
            }
        }
    }

    public int getDimensione() {
        return dimensione;
    }

    public void setStatoCella(int x, int y, char stato) {
        if (!this.isPosizioneConsentita(x) || !this.isPosizioneConsentita(y)) {
            throw new IllegalArgumentException(Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_ECCEZIONE_POSIZIONE));
        }
        this.griglia[x][y].setStato(stato);
    }

    public char getStatoCella(int x, int y) {
        if (!this.isPosizioneConsentita(x) || !this.isPosizioneConsentita(y)) {
            throw new IllegalArgumentException(Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_ECCEZIONE_POSIZIONE));
        }
        return this.griglia[x][y].getStato();
    }

    public boolean isCellaVuota(int x, int y) {
        if (!this.isPosizioneConsentita(x) || !this.isPosizioneConsentita(y)) {
            throw new IllegalArgumentException(Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_ECCEZIONE_POSIZIONE));
        }
        return this.griglia[x][y].getStato() == Costanti.STATO_VUOTO;
    }

    private boolean isPosizioneConsentita(int posizione) {
        return posizione >= 0 && posizione < dimensione;
    }
    
    public void reset() {
        this.inizializzaCelle();
    }

    public boolean isPiena() {
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                if (this.isCellaVuota(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean controllaTris() {
        if (this.trisRiga()) {
            return true;
        } else if (this.trisColonna()) {
            return true;
        } else if (this.trisDiagonalePrincipale()) {
            return true;
        } else if (this.trisDiagonaleSecondaria()) {
            return true;
        }
        return false;
    }

    private boolean trisRiga() {
        for (int i = 0; i < this.dimensione; i++) {
            if (this.isTris(griglia[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean trisColonna() {
        Cella[][] trasposta = this.trasponi();
        for (int i = 0; i < this.dimensione; i++) {
            if (this.isTris(trasposta[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean trisDiagonalePrincipale() {
        Cella[] diagonale = new Cella[this.dimensione];
        for (int i = 0; i < this.dimensione; i++) {
            diagonale[i] = new Cella(this.griglia[i][i].getStato());
        }
        return this.isTris(diagonale);
    }

    private boolean trisDiagonaleSecondaria() {
        Cella[] diagonale = new Cella[this.dimensione];
        for (int i = 0; i < this.dimensione; i++) {
            diagonale[i] = new Cella(this.griglia[i][(this.dimensione - 1) - i].getStato());
        }
        return this.isTris(diagonale);
    }

    private boolean isTris(Cella[] cella) {
        char stato = cella[0].getStato();
        if (stato == Costanti.STATO_VUOTO) {
            return false;
        }
        for (int i = 1; i < this.dimensione; i++) {
            if (cella[i].getStato() != stato) {
                return false;
            }
        }
        return true;
    }

    private Cella[][] trasponi() {
        Cella[][] trasposta = new Cella[this.dimensione][this.dimensione];
        for (int i = 0; i < this.dimensione; i++) {
            for (int j = 0; j < this.dimensione; j++) {
                trasposta[i][j] = new Cella(this.griglia[j][i].getStato());
            }
        }
        return trasposta;
    }

}
