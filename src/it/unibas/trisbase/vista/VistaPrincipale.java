package it.unibas.trisbase.vista;

import it.unibas.trisbase.Applicazione;
import it.unibas.trisbase.Costanti;
import it.unibas.trisbase.controllo.ControlloPrincipale;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VistaPrincipale extends JPanel {
    
    private static final Logger logger = LoggerFactory.getLogger(VistaPrincipale.class);
    
    private JTable tabellaGriglia;
    private JLabel consiglio;
    
    public void inizializza() {
        this.setLayout(new BorderLayout());
        this.setMessaggio();
        this.setConsiglio();
        this.setTabella();
        this.setAzioni();
    }

    private void setMessaggio() {
        JPanel pannelloMessaggio = new JPanel();
        pannelloMessaggio.setBorder(new LineBorder(Color.BLACK));
        JLabel messaggio = new JLabel(Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_MESSAGGIO));
        pannelloMessaggio.add(messaggio);
        messaggio.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(pannelloMessaggio, BorderLayout.NORTH);
    }
    
    private void setConsiglio() {
        JPanel pannelloMessaggio = new JPanel();
        pannelloMessaggio.setBorder(new LineBorder(Color.BLACK));
        this.consiglio = new JLabel(Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_CONSIGLIO_UNO));
        pannelloMessaggio.add(this.consiglio);
        this.consiglio.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(pannelloMessaggio, BorderLayout.SOUTH);
    }
    
    private void setTabella() {
        this.tabellaGriglia = new JTable(new ModelloTabellaTris());
        this.tabellaGriglia.setRowHeight(133);
        this.tabellaGriglia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tabellaGriglia.setCellSelectionEnabled(true);
        this.tabellaGriglia.setSelectionBackground(Costanti.COLORE_BIANCO_SPORCO);
        this.tabellaGriglia.setEnabled(false);
        this.add(tabellaGriglia, BorderLayout.CENTER);
    }
    
    private void setAzioni() {
        ControlloPrincipale controlloPrincipale = Applicazione.getInstance().getControlloPrincipale();
        this.tabellaGriglia.getColumnModel().getSelectionModel().addListSelectionListener(controlloPrincipale.getAzioneCellaSelezionata());
    }
    
    public void setTabellaEnabled(boolean isEnabled) {
        this.tabellaGriglia.setEnabled(isEnabled);
    }
    
    public void setConsiglioText(String testo) {
        this.consiglio.setText(testo);
    }
    
    public Dimension getCellaSelezionata() {
        Dimension cella = new Dimension(this.tabellaGriglia.getSelectedRow(), this.tabellaGriglia.getSelectedColumn());
        if (cella.width < 0 || cella.height < 0) {
            return null;
        }
        logger.debug(cella.toString());
        return cella;
    }
    
    public void aggiornaTabella() {
        ModelloTabellaTris modello = (ModelloTabellaTris) this.tabellaGriglia.getModel();
        modello.aggiornaTabella();
    }
    
    public void setBackgroundTabella(Color colore) {
        this.tabellaGriglia.setBackground(colore);
    }
    
}
