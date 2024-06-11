package org.example.ergueiasmaos;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    public Clip clip; // Objeto Clip para controlar a reprodução de áudio

    // Método para reproduzir um arquivo de áudio
    public void play(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); // Obtém o arquivo de áudio e cria um stream de áudio
            clip = AudioSystem.getClip();  // Obtém um objeto Clip para reprodução de áudio
            clip.open(audioInputStream); // Abre o stream de áudio no Clip
            clip.start(); // Inicia a reprodução do áudio
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // Trata exceções caso ocorram ao abrir e reproduzir o áudio
            e.printStackTrace();
        }
    }

    // Método para parar a reprodução de áudio
    public void stop() {
        // Verifica se o Clip está em execução e o interrompe
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

}

