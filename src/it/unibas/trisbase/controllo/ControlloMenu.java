package it.unibas.trisbase.controllo;

import it.unibas.trisbase.Applicazione;
import it.unibas.trisbase.Costanti;
import it.unibas.trisbase.ResourceManager;
import it.unibas.trisbase.modello.Griglia;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private AzioneNuovoMatch azioneNuovoMatch = new AzioneNuovoMatch();
    private AzioneInterrompiMatch azioneInterrompiMatch = new AzioneInterrompiMatch();
    private AzioneEsci azioneEsci = new AzioneEsci();

    public class AzioneNuovoMatch extends AbstractAction {

        public AzioneNuovoMatch() {
            ResourceManager resManager = Applicazione.getInstance().getResourceManager();
            this.putValue(Action.NAME, resManager.getStringaFromBundle(Costanti.STR_NUOVA_PARTITA));
            this.putValue(Action.SHORT_DESCRIPTION, resManager.getStringaFromBundle(Costanti.STR_NUOVA_PARTITA_SHORT));
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl N"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ResourceManager resManager = Applicazione.getInstance().getResourceManager();
            Applicazione.getInstance().getVistaPrincipale().setConsiglioText(resManager.getStringaFromBundle(Costanti.STR_CONSIGLIO_DUE));
            Applicazione.getInstance().getVistaPrincipale().setTabellaEnabled(true);
            Griglia griglia = (Griglia) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_GRIGLIA);
            griglia.reset();
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
            Applicazione.getInstance().getVistaPrincipale().setBackgroundTabella(null);
            Applicazione.getInstance().getAudioPlayer().playClip(Costanti.PATH_AUDIO_NUOVO_GIOCO);
            this.setEnabled(false);
            azioneInterrompiMatch.setEnabled(true);
        }

    }

    public class AzioneInterrompiMatch extends AbstractAction {

        public AzioneInterrompiMatch() {
            ResourceManager resManager = Applicazione.getInstance().getResourceManager();
            this.putValue(Action.NAME, resManager.getStringaFromBundle(Costanti.STR_INTERROMPI_MATCH));
            this.putValue(Action.SHORT_DESCRIPTION, resManager.getStringaFromBundle(Costanti.STR_INTERROMPI_MATCH_SHORT));
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ResourceManager resManager = Applicazione.getInstance().getResourceManager();
            Applicazione.getInstance().getVistaPrincipale().setConsiglioText(resManager.getStringaFromBundle(Costanti.STR_MESSAGGIO_INTERROTTO));
            Applicazione.getInstance().getVistaPrincipale().setBackgroundTabella(Color.RED);
            Applicazione.getInstance().getVistaPrincipale().setTabellaEnabled(false);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
            this.setEnabled(false);
            azioneNuovoMatch.setEnabled(true);
            Applicazione.getInstance().getAudioPlayer().playClip(Costanti.PATH_AUDIO_TERMINATO);
        }

    }

    public class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            ResourceManager resManager = Applicazione.getInstance().getResourceManager();
            this.putValue(Action.NAME, resManager.getStringaFromBundle(Costanti.STR_ESCI));
            this.putValue(Action.SHORT_DESCRIPTION, resManager.getStringaFromBundle(Costanti.STR_ESCI_SHORT));
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }

    public AzioneNuovoMatch getAzioneNuovoMatch() {
        return azioneNuovoMatch;
    }

    public AzioneInterrompiMatch getAzioneInterrompiMatch() {
        return azioneInterrompiMatch;
    }

    public AzioneEsci getAzioneEsci() {
        return azioneEsci;
    }

}
