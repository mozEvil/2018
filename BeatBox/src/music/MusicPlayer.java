package music;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;


/**
 * Created by Женя on 30.06.2017.
 */
public class MusicPlayer {

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.play();
    }

    private JFrame frame = new JFrame("Мой первый музыкальный клип");
    private VisualBox vb = new VisualBox();

    // создаем интерфейс
    private void setUpGui() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(vb);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);
    }

    public void play() {

        setUpGui();

        try {

            // создаем проигрыватель
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            //добавляем обработчик событий
            sequencer.addControllerEventListener(vb, new int[] {127});

            // создаем трек
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // создаем композицию трека здесь
            for (int i = 5; i < 61; i+= 4) {
                int r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i+2));
            }

            // загружаем трек в проигрыватель
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // упрощает создание звуков
    private MidiEvent makeEvent(int cmd, int chn, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage mes = new ShortMessage();
            mes.setMessage(cmd, chn, one, two);
            event = new MidiEvent(mes, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return event;
    }


    class VisualBox extends JPanel implements ControllerEventListener {

        private boolean msg = false;

        @Override
        protected void paintComponent(Graphics g) {
            if (msg) {
                int red = (int) (Math.random() * 250);
                int green = (int) (Math.random() * 250);
                int blue = (int) (Math.random() * 250);

                g.setColor(new Color(red, green, blue));

                int height = (int) ((Math.random() * 120) + 10);
                int width = (int) ((Math.random() * 120) + 10);

                int x = (int) ((Math.random() * 40) + 10);
                int y = (int) ((Math.random() * 40) + 10);

                g.fillRect(x, y, width, height);
                msg = false;
            }
        }

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }
    }
}
