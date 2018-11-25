package it.unibas.trisbase.vista;

import it.unibas.trisbase.Applicazione;
import it.unibas.trisbase.Costanti;
import it.unibas.trisbase.modello.Griglia;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaTris extends AbstractTableModel {

    @Override
    public int getRowCount() {
        Griglia griglia = (Griglia) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_GRIGLIA);
        return griglia.getDimensione();
    }

    @Override
    public int getColumnCount() {
        Griglia griglia = (Griglia) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_GRIGLIA);
        return griglia.getDimensione();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return ImageIcon.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Griglia griglia = (Griglia) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_GRIGLIA);
        if (griglia.getStatoCella(rowIndex, columnIndex) == Costanti.STATO_X) {
            return Applicazione.getInstance().getResourceManager().caricaImmagine(Costanti.PATH_IMMAGINE_X);
        }
        if (griglia.getStatoCella(rowIndex, columnIndex) == Costanti.STATO_O) {
            return Applicazione.getInstance().getResourceManager().caricaImmagine(Costanti.PATH_IMMAGINE_O);
        }
        return null;
    }
    
    public void aggiornaTabella() {
        super.fireTableDataChanged();
    }
    
}
