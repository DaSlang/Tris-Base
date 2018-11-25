package it.unibas.trisbase;

import java.awt.Color;

public class Costanti {
    //DIMENSIONE
    public static final int DIMENSIONE_FRAME = 500;
    
    //PATH
    public static final String PATH_IMMAGINE_X = "/res/imgX.png";
    public static final String PATH_IMMAGINE_O = "/res/imgO.png";
    public static final String PATH_AUDIO_TRIS = "/res/audioTris.wav";
    public static final String PATH_AUDIO_NUOVO_GIOCO = "/res/audioNuovoGioco.wav";
    public static final String PATH_AUDIO_CELLA = "/res/audioCella.wav";
    public static final String PATH_AUDIO_TERMINATO = "/res/audioTerminato.wav";
    
    //COLORI
    public static final Color COLORE_BIANCO_SPORCO = new Color(240, 240, 240);
    
    //MODELLO
    public static final char STATO_VUOTO = '-';
    public static final char STATO_X = 'X';
    public static final char STATO_O = 'O';
    public static final String MODELLO_GRIGLIA = "Griglia";
    
    //ECCEZIONI
    public static final String STR_ECCEZIONE_POSIZIONE = "EccezionePosizione";
    public static final String STR_ECCEZIONE_LAF = "EccezioneLAF";
    public static final String STR_ECCEZIONE_AUDIO = "EccezioneAudio";
    
    //AZIONI
    public static final String STR_NUOVA_PARTITA = "NuovaPartita";
    public static final String STR_NUOVA_PARTITA_SHORT = "NuovaPartitaShort";
    public static final String STR_INTERROMPI_MATCH = "InterrompiMatch";
    public static final String STR_INTERROMPI_MATCH_SHORT = "InterrompiMatchShort";
    public static final String STR_ESCI = "Esci";
    public static final String STR_ESCI_SHORT = "EsciShort";
    
    //TESTI
    public static final String STR_TITOLO = "Titolo";
    public static final String STR_PARTITA = "Partita";
    public static final String STR_MESSAGGIO = "Messaggio";
    public static final String STR_MESSAGGIO_INTERROTTO = "MessaggioInterrotto";
    public static final String STR_CONSIGLIO_UNO = "ConsiglioUno";
    public static final String STR_CONSIGLIO_DUE = "ConsiglioDue";
    public static final String STR_CONSIGLIO_TRE = "ConsiglioTre";
    public static final String STR_PARTITA_TERMINATA_NO_TRIS = "PartitaTerminataNoTris";
    public static final String STR_PARTITA_TERMINATA_TRIS = "PartitaTerminataTris";
    
}
