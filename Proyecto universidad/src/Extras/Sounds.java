package Extras;
import java.io.*;
import javax.sound.sampled.*;

public class Sounds{


        /*
        !!!!!Esta Clase esta implementada por humor lamentamos si sale de lo serio
        (si le parece una ofensa la podes remover sin problema)!!!!!
        */



                public String rutaDeArchivo = "Cosas/Inicio_de_sesion.wav";

                public void reproducirSonido() {
                try {
                        System.out.println(
                                "⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠛⠛⠋⠉⠈⠉⠉⠉⠉⠛⠻⢿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⡏⣀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⢏⣴⣿⣷⠀⠀⠀⠀⠀⢾⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣟⣾⣿⡟⠁⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣷⢢⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣟⠀⡴⠄⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⠟⠻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠶⢴⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿\n" +
                                "⣿⣁⡀⠀⠀⢰⢠⣦⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⡄⠀⣴⣶⣿⡄⣿⣿⣿⣿\n" +
                                "⣿⡋⠀⠀⠀⠎⢸⣿⡆⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⠗⢘⣿⣟⠛⠿⣼⣿⣿⣿\n" +
                                "⣿⣿⠋⢀⡌⢰⣿⡿⢿⡀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⡇⠀⢸⣿⣿⣧⢀⣼⣿⣿⣿\n" +
                                "⣿⣿⣷⢻⠄⠘⠛⠋⠛⠃⠀⠀⠀⠀⠀⢿⣧⠈⠉⠙⠛⠋⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣧⠀⠈⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠟⠀⠀⠀⠀⢀⢃⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⡿⠀⠴⢗⣠⣤⣴⡶⠶⠖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡸⠀⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⡀⢠⣾⣿⠏⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠉⠀⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣧⠈⢹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⡄⠈⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣿⣦⣄⣀⣀⣀⣀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠙⣿⣿⡟⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠁⠀⠀⠹⣿⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢐⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                                "⣿⣿⣿⣿⠿⠛⠉⠉⠁⠀⢻⣿⡇⠀⠀⠀⠀⠀⠀⢀⠈⣿⣿⡿⠉⠛⠛⠛⠉⠉⣿⣿⣿\n" +
                                "⣿⡿⠋⠁⠀⠀⢀⣀⣠⡴⣸⣿⣇⡄⠀⠀⠀⠀⢀⡿⠄⠙⠛⠀⣀⣠⣤⣤⣿⣿⣿  ");


                        File archivoDeSonido = new File(rutaDeArchivo);

                        AudioInputStream streamDeAudio = AudioSystem.getAudioInputStream(archivoDeSonido);
                        AudioFormat formatoDeAudio = streamDeAudio.getFormat();
                        DataLine.Info infoDeClip = new DataLine.Info(Clip.class, formatoDeAudio);
                        Clip clipDeSonido = (Clip) AudioSystem.getLine(infoDeClip);
                        clipDeSonido.open(streamDeAudio);

                        clipDeSonido.start();

                        FloatControl controlDeVolumen = (FloatControl) clipDeSonido.getControl(FloatControl.Type.MASTER_GAIN);
                        double volumenInicial = controlDeVolumen.getValue() - 50;
                        double volumenActual = volumenInicial;
                        double volumenObjetivo = volumenInicial - 10.0;
                        double velocidadDeCambio = 0.10;

                        while (volumenActual > volumenObjetivo) {
                                volumenActual -= velocidadDeCambio;
                                controlDeVolumen.setValue((float) volumenActual);
                                Thread.sleep(100);
                        }

                        clipDeSonido.stop();
                        clipDeSonido.close();

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                        System.out.println("Error al reproducir el sonido: " + e.getMessage());
                }
        }



        public String rutaDeArchivo2 = "Cosas/DN.wav";

        public void reproducirSonido2() {
                try {
                        System.out.println("HASTA" +
                                "⠀⠀⢀⣤⣤⣤⣤⣤⣤⣀⡀⠀⠀⢀⣀⠄⠀⠀⣀⣠⣤⡤⠤⠀⠀⠀⠀⠀\n" +
                                "⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⣠⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⡼⠋⠁⠀⠈⠉⠙⠛⠛⠉⣡⣿⡟⠀⠀⣼⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⠁⠀⠀⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⠀⠀⠘⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⠀⠀⠀⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡀⠀⠀⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⢀⣤⣶⣶⣶⣿⣿⣿⣿⡇⠀⠀⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠈⠉⠉⠙⢿⣿⣿⣿⣿⡇⠀⠀⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⡇⠀⠀⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠶⢶⣶⣾⣿⣿⣿⠁⠀⢠⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⡏⠀⢀⣾⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡿⠀⢀⣾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⠀⢀⣾⡟⢁⣴⣟⣡⣤⣤⣶⣶⣶⣶⣶⣦⣤⣀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠀⠀⢠⣾⣟⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣴⠞ \n" +
                                "⠀⠀⠀⠀⢀⣴⡿⠿⠛⠛⠋⠉⠉⠉⠉⠉⠉⠛⠛⠿⣿⣿⣿⣿⣿⠟⠁⠀UEGO \n" +
                                "⠀⠀⠀⠘⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⠟⠁⠀⠀⠀ ");




                        File archivoDeSonido = new File(rutaDeArchivo2);

                        AudioInputStream streamDeAudio = AudioSystem.getAudioInputStream(archivoDeSonido);
                        AudioFormat formatoDeAudio = streamDeAudio.getFormat();
                        DataLine.Info infoDeClip = new DataLine.Info(Clip.class, formatoDeAudio);
                        Clip clipDeSonido = (Clip) AudioSystem.getLine(infoDeClip);
                        clipDeSonido.open(streamDeAudio);

                        clipDeSonido.start();

                        FloatControl controlDeVolumen = (FloatControl) clipDeSonido.getControl(FloatControl.Type.MASTER_GAIN);
                        double volumenInicial = controlDeVolumen.getValue() - 50;
                        double volumenActual = volumenInicial;
                        double volumenObjetivo = volumenInicial - 10.0;
                        double velocidadDeCambio = 0.10;

                        while (volumenActual > volumenObjetivo) {
                                volumenActual -= velocidadDeCambio;
                                controlDeVolumen.setValue((float) volumenActual);
                                Thread.sleep(100);
                        }

                        clipDeSonido.stop();
                        clipDeSonido.close();

                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        System.out.println("Error al reproducir el sonido: " + e.getMessage());
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
        }

}


