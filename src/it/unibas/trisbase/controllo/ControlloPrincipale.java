package it.unibas.trisbase.controllo;

import it.unibas.trisbase.Applicazione;
import it.unibas.trisbase.Costanti;
import it.unibas.trisbase.ResourceManager;
import it.unibas.trisbase.modello.Griglia;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale {
    
    private static Logger logger = LoggerFactory.getLogger(ControlloPrincipale.class);
    
    private AzioneCellaSelezionata azioneCellaSelezionata = new AzioneCellaSelezionata();
    
    public class AzioneCellaSelezionata implements ListSelectionListener {
        
        private Random random = new Random();
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            Dimension cella = Applicazione.getInstance().getVistaPrincipale().getCellaSelezionata();
            if (cella == null) {
                return;
            }
            Griglia griglia = (Griglia) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_GRIGLIA);
            if (!griglia.isCellaVuota(cella.width, cella.height)) {
                logger.debug("La cella selezionata è piena");
                String consiglio = Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_CONSIGLIO_TRE);
                Applicazione.getInstance().getVistaPrincipale().setConsiglioText(consiglio);
                Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
                return;
            }
            griglia.setStatoCella(cella.width, cella.height, Costanti.STATO_X);
            String consiglio = Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_CONSIGLIO_DUE);
            Applicazione.getInstance().getVistaPrincipale().setConsiglioText(consiglio);
            Applicazione.getInstance().getAudioPlayer().playClip(Costanti.PATH_AUDIO_CELLA);
            this.mossaCpu();
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
            logger.debug("Tabella aggiornata");
            this.controllaStato(griglia);
        }
        
        private void mossaCpu() {
            Griglia griglia = (Griglia) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_GRIGLIA);
            if (griglia.isPiena() || griglia.controllaTris()) {
                return;
            }
            Dimension cella = this.creaCellaCasuale(griglia);
            while (!griglia.isCellaVuota(cella.width, cella.height)) {                
                cella = this.creaCellaCasuale(griglia);
            }
            griglia.setStatoCella(cella.width, cella.height, Costanti.STATO_O);
            logger.debug("Mossa Cpu terminata " + cella.toString());
        }
        
        private Dimension creaCellaCasuale(Griglia griglia) {
            int x = random.nextInt(griglia.getDimensione());
            int y = random.nextInt(griglia.getDimensione());
            return new Dimension(x, y);
        }
        
        private void controllaStato(Griglia griglia) {
            if (griglia.controllaTris()) {
                Applicazione.getInstance().getVistaPrincipale().setBackgroundTabella(Color.GREEN);
                ResourceManager resManager = Applicazione.getInstance().getResourceManager();
                Applicazione.getInstance().getVistaPrincipale().setConsiglioText(resManager.getStringaFromBundle(Costanti.STR_PARTITA_TERMINATA_TRIS));
                Applicazione.getInstance().getVistaPrincipale().setTabellaEnabled(false);
                Applicazione.getInstance().getControlloMenu().getAzioneNuovoMatch().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneInterrompiMatch().setEnabled(false);
                Applicazione.getInstance().getAudioPlayer().playClip(Costanti.PATH_AUDIO_TRIS);
                return;
            }
            if (griglia.isPiena()) {
                Applicazione.getInstance().getVistaPrincipale().setBackgroundTabella(Color.RED);
                ResourceManager resManager = Applicazione.getInstance().getResourceManager();
                Applicazione.getInstance().getVistaPrincipale().setConsiglioText(resManager.getStringaFromBundle(Costanti.STR_PARTITA_TERMINATA_NO_TRIS));
                Applicazione.getInstance().getVistaPrincipale().setTabellaEnabled(false);
                Applicazione.getInstance().getControlloMenu().getAzioneNuovoMatch().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneInterrompiMatch().setEnabled(false);
                Applicazione.getInstance().getAudioPlayer().playClip(Costanti.PATH_AUDIO_TERMINATO);
                return;
            }
        }
        
    }

    public AzioneCellaSelezionata getAzioneCellaSelezionata() {
        return azioneCellaSelezionata;
    }
    
}
