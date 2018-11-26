package it.unibas.trisbase.vista;

import it.unibas.trisbase.Applicazione;
import it.unibas.trisbase.Costanti;
import it.unibas.trisbase.ResourceManager;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame extends javax.swing.JFrame {

    private static final Logger logger = LoggerFactory.getLogger(Frame.class);
    
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            logger.error(Applicazione.getInstance().getResourceManager().getStringaFromBundle(Costanti.STR_ECCEZIONE_LAF));
        }
    }
    
    public void inizializza() {
        initComponents();
        this.inizializzaTesti();
        this.inizializzaAzioni();
        this.setSize(Costanti.DIMENSIONE_FRAME, Costanti.DIMENSIONE_FRAME);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setContentPane(Applicazione.getInstance().getVistaPrincipale());
        this.setVisible(true);
    }
    
    private void inizializzaTesti() {
        ResourceManager resManager = Applicazione.getInstance().getResourceManager();
        this.setTitle(resManager.getStringaFromBundle(Costanti.STR_TITOLO));
        this.menuPartita.setText(resManager.getStringaFromBundle(Costanti.STR_PARTITA));
        this.itemNuovaPartita.setText(resManager.getStringaFromBundle(Costanti.STR_NUOVA_PARTITA));
    }
    
    private void inizializzaAzioni() {
        this.itemNuovaPartita.setAction(Applicazione.getInstance().getControlloMenu().getAzioneNuovoMatch());
        this.itemInterrompiPartita.setAction(Applicazione.getInstance().getControlloMenu().getAzioneInterrompiMatch());
        this.itemEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
    }
    
    public void mostraMessaggioErrore(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        menuPartita = new javax.swing.JMenu();
        itemNuovaPartita = new javax.swing.JMenuItem();
        itemInterrompiPartita = new javax.swing.JMenuItem();
        itemEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuPartita.setText("File");

        itemNuovaPartita.setText("jMenuItem1");
        menuPartita.add(itemNuovaPartita);

        itemInterrompiPartita.setText("jMenuItem1");
        menuPartita.add(itemInterrompiPartita);

        itemEsci.setText("jMenuItem1");
        menuPartita.add(itemEsci);

        jMenuBar1.add(menuPartita);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemEsci;
    private javax.swing.JMenuItem itemInterrompiPartita;
    private javax.swing.JMenuItem itemNuovaPartita;
    private javax.swing.JMenu menuPartita;
    // End of variables declaration//GEN-END:variables
}
