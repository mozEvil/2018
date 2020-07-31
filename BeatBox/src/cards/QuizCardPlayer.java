package cards;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Женя on 03.07.2017.
 */
public class QuizCardPlayer {

    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;
    private QuizCardBuilder builder;

    public static void main(String[] args) {
        new QuizCardPlayer().go();
    }

    public void go() {
        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//        Box mainPanel = new Box(BoxLayout.Y_AXIS);
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10, 20);
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEnabled(false);

        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        nextButton = new JButton("Загрузить");
        nextButton.addActionListener(e -> nextButtonEvent());
        nextButton.setEnabled(false);

        mainPanel.add(qScroller);
        mainPanel.add(nextButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Фаил");
        JMenuItem createCardSetItem = new JMenuItem("Создать");
        createCardSetItem.addActionListener(e -> createCardSetItemEvent());
        fileMenu.add(createCardSetItem);
        JMenuItem loadMenuItem = new JMenuItem("Загрузить");
        loadMenuItem.addActionListener(e -> loadMenuItemEvent());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createCardSetItemEvent() {
        if (builder != null) {
            JFrame builderFrame = builder.getFrame();
            if (!builderFrame.isVisible()) builderFrame.setVisible(true);
        } else {
            builder = new QuizCardBuilder();
            builder.go();
        }

    }

    private void loadMenuItemEvent() {
        JFileChooser fileOpen = new JFileChooser();
        fileOpen.showOpenDialog(frame);
        loadFile(fileOpen.getSelectedFile());
    }

    private void loadFile(File file) {
        cardList = new ArrayList<>();
        try {
            BufferedReader reader= new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                makeCard(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        showNextCard();
    }

    private void makeCard(String line) {
        String[] result = line.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
    }

    private void nextButtonEvent() {
        if (isShowAnswer) {
            display.setText(currentCard.getAnswer());
            nextButton.setText("Дальше");
            isShowAnswer = false;
        } else {
            if (currentCardIndex < cardList.size()) {
                showNextCard();
            } else {
                display.setText("Конец");
                nextButton.setEnabled(false);
            }
        }
    }

    private void showNextCard() {
        currentCard = cardList.get(currentCardIndex);
        currentCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Ответ");
        nextButton.setEnabled(true);
        isShowAnswer = true;
    }



}
