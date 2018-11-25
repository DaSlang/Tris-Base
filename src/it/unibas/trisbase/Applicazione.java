package it.unibas.trisbase;

import it.unibas.trisbase.controllo.ControlloMenu;
import it.unibas.trisbase.controllo.ControlloPrincipale;
import it.unibas.trisbase.modello.Griglia;
import it.unibas.trisbase.modello.Modello;
import it.unibas.trisbase.vista.Frame;
import it.unibas.trisbase.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return Applicazione.singleton;
    }

    private Applicazione() {
    }

    private ResourceManager resourceManager;
    private Modello modello;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private AudioPlayer audioPlayer;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

    public void inizializza() {
        this.resourceManager = new ResourceManager();
        this.modello = new Modello();
        this.modello.putBean(Costanti.MODELLO_GRIGLIA, new Griglia(3));
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.audioPlayer = new AudioPlayer();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public Modello getModello() {
        return modello;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public AudioPlayer getAudioPlayer() {
        return audioPlayer;
    }

}
