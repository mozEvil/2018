package beat;

import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;


/**
 * Created by Женя on 02.07.2017.
 */
public class BeatBox {

    public static void main(String[] args) {
        new BeatBox().startUp("Maxim");
    }


    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;
    JFrame frame;
    JList incomingList;
    JTextField userMessage;
    int nextNum;
    Vector<String> listVector = new Vector<>();
    String userName;
    ObjectInputStream in;
    ObjectOutputStream out;
    HashMap<String, boolean[]> otherSeqsMap = new HashMap<>();

    Sequencer sequencer;
    Sequence sequence;
    Track track;

    String[] instrumentNames = {"Bass Drum", "Close Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-Mid Tom", "High Agogo",
            "Open Hi Conga"};

    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public void startUp(String name) {
        userName = name;
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            new Thread(this::thread_RemoteReader).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setUpMidi();
        buildGUI();
    }

    private void thread_RemoteReader() {
        boolean[] checkBoxState;
        Object o;
        try {
            while ((o = in.readObject()) != null) {
                System.out.println("got an object from server");
                System.out.println(o.getClass());
                String nameToShow = (String) o;
                checkBoxState = (boolean[]) in.readObject();
                otherSeqsMap.put(nameToShow, checkBoxState);
                listVector.add(nameToShow);
                incomingList.setListData(listVector);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buildGUI() {
        frame = new JFrame("Cyber Beat Box");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel background = new JPanel(new BorderLayout());
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkboxList = new ArrayList<>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(e -> btnStartEvent());
        buttonBox.add(btnStart);

        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(e -> btnStopEvent());
        buttonBox.add(btnStop);

        JButton btnUpTempo = new JButton("Tempo Up");
        btnUpTempo.addActionListener(e -> btnUpTempoEvent());
        buttonBox.add(btnUpTempo);

        JButton btnDownTempo = new JButton("Tempo Down");
        btnDownTempo.addActionListener(e -> btnDownTempoEvent());
        buttonBox.add(btnDownTempo);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(e -> btnSaveEvent());
        buttonBox.add(btnSave);

        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(e -> btnLoadEvent());
        buttonBox.add(btnLoad);

        JButton btnSendIt = new JButton("Send");
        btnSendIt.addActionListener(e -> btnSendItEvent());
        buttonBox.add(btnSendIt);

        userMessage = new JTextField();
        buttonBox.add(userMessage);

        incomingList = new JList();
        incomingList.addListSelectionListener(this::incomingListEvent);
        incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane incomingList_and_scroll = new JScrollPane(incomingList);
        buttonBox.add(incomingList_and_scroll);
        incomingList.setListData(listVector);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentNames[i]));
        }

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);
        background.add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(background);
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private void incomingListEvent(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selected = (String) incomingList.getSelectedValue();
            if (selected != null) {
                boolean[] selectedState = otherSeqsMap.get(selected);
                changeSequence(selectedState);
                sequencer.stop();
                buildTrackAndStart();
            }
        }
    }

    private void changeSequence(boolean[] selectedState) {
        for (int i = 0; i < 256; i++) {
            checkboxList.get(i).setSelected(selectedState[i]);
        }
    }

    private void btnSendItEvent() {
        boolean checkBoxState[] = new boolean[256];
        for (int i = 0; i < 256; i++) {
            checkBoxState[i] = checkboxList.get(i).isSelected();
        }
        String messageToSend = userName + nextNum++ + ": " + userMessage.getText();
        try {
            out.writeObject(messageToSend);
            out.writeObject(checkBoxState);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not send it to the server.");
        }
        userMessage.setText("");
    }

    private void btnLoadEvent() {
        boolean checkBoxState[] = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("Checkbox.ser")))) {
            checkBoxState = (boolean[]) ois.readObject();
            ois.close();
            for (int i = 0; i < 256; i++) {
                checkboxList.get(i).setSelected(checkBoxState[i]);
            }
            sequencer.stop();
            buildTrackAndStart();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void btnSaveEvent() {
        boolean checkBoxState[] = new boolean[256];
        for (int i = 0; i < 256; i++) {
            checkBoxState[i] = checkboxList.get(i).isSelected();
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Checkbox.ser")))) {
            oos.writeObject(checkBoxState);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        int[] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = instruments[i];

            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxList.get(j + (16 * i));
                trackList[j] = jc.isSelected() ? key : 0;
            }

            makeTracks(trackList);
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int cmd, int chn, int one, int two, int tick) {
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

    private void btnStartEvent() {
        buildTrackAndStart();
    }

    private void btnStopEvent() {
        sequencer.stop();
    }

    private void btnUpTempoEvent() {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor((float) (tempoFactor * 1.03));
    }

    private void btnDownTempoEvent() {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor((float) (tempoFactor * 0.97));
    }

}
