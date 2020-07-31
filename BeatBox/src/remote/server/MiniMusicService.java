package remote.server;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;


/**
 * Created by Женя on 30.06.2017.
 */
public class MiniMusicService implements Service {

    private VisualBox vb;


    @Override
    public JPanel getGuiPanel() {
        JPanel mainPanel = new JPanel();
        vb = new VisualBox();
        JButton playButton = new JButton("Play it");
        playButton.addActionListener(e -> play());
        mainPanel.add(vb);
        mainPanel.add(playButton);
        return mainPanel;
    }


    public void play() {

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