package it.unibas.trisbase.vista;

import it.unibas.trisbase.Applicazione;
import it.unibas.trisbase.Costanti;
import it.unibas.trisbase.modello.Griglia;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaTris extends AbstractTableModel {
    
    private Griglia griglia;
    private ImageIcon immagineX;
    private ImageIcon immagineO;

    public ModelloTabellaTris(Griglia griglia, ImageIcon immagineX, ImageIcon immagineO) {
        this.griglia = griglia;
        this.immagineX = immagineX;
        this.immagineO = immagineO;
    }
    
    @Override
    public int getRowCount() {
        return this.griglia.getDimensione();
    }

    @Override
    public int getColumnCount() {
        return this.griglia.getDimensione();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return ImageIcon.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (this.griglia.getStatoCella(rowIndex, columnIndex) == Costanti.STATO_X) {
            return this.immagineX;
        }
        if (this.griglia.getStatoCella(rowIndex, columnIndex) == Costanti.STATO_O) {
            return this.immagineO;
        }
        return null;
    }
    
    public void aggiornaTabella() {
        super.fireTableDataChanged();
    }
    
}
