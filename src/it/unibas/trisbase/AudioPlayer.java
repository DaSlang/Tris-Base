package it.unibas.trisbase;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AudioPlayer {

    private static Logger logger = LoggerFactory.getLogger(AudioPlayer.class);
    
    private Clip clip;

    public void playClip(String nomeFile) {
        ResourceManager resManager = Applicazione.getInstance().getResourceManager();
        try {
            this.clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(resManager.caricaAudio(nomeFile)));
            clip.start();
        } catch (Exception e) {
            logger.error(resManager.getStringaFromBundle(Costanti.STR_ECCEZIONE_AUDIO) + "\n" + e.getMessage());
        }
    }

}
