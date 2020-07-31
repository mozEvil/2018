package turist;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by Женя on 28.07.2017.
 */
public class Launcher {

    private final DataBase DB;

        private JFrame frame;
        private JPanel header;
        private JPanel center;
        private JPanel footer;
        private JPanel left;
        private JPanel right;
        private User user;

    public Launcher() {
        DB = DataBase.getInstance();
        initGUI();
    }

    private void initGUI() {
        frame = new JFrame("Tourist 0.1");
        center = new JPanel();
        header = new JPanel();
        footer = new JPanel();
        left = new JPanel();
        right = new JPanel();

//        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        footer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//        right.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.getContentPane().add(BorderLayout.CENTER, center);
        frame.getContentPane().add(BorderLayout.NORTH, header);
        frame.getContentPane().add(BorderLayout.SOUTH, footer);
        frame.getContentPane().add(BorderLayout.WEST, left);
        frame.getContentPane().add(BorderLayout.EAST, right);


        /////////////////////////

        center.add(getAuthenticationBox());


//        header.add(new JLabel("header"));
//        center.add(new JLabel("center"));
//        footer.add(new JLabel("footer"));
//        left.add(new JLabel("left"));
//        right.add(new JLabel("right"));

//        header.setBackground(Color.GREEN);
//        center.setBackground(Color.YELLOW);
//        footer.setBackground(Color.BLUE);
//        left.setBackground(Color.CYAN);
//        right.setBackground(Color.CYAN);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

//        DB.save();
    }

    private JComponent getAuthenticationBox() {
        Box authenticationBox = new Box(BoxLayout.Y_AXIS);
        authenticationBox.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JPanel messageString = new JPanel();
        JLabel message = new JLabel("Для начала работы введите логин и пароль");
        messageString.add(message);
        messageString.setBackground(Color.YELLOW);

        JPanel loginString = new JPanel();
        loginString.add(new JLabel("Логин:  "));
        JTextField login = new JTextField(20);
        loginString.add(login);

        JPanel passwordString = new JPanel();
        passwordString.add(new JLabel("Пароль:"));
        JPasswordField pass = new JPasswordField(20);
        passwordString.add(pass);

        JPanel buttonString = new JPanel();
        JButton btn = new JButton("Войти");
        JButton btn2 = new JButton("Зарегистрироваться");
        buttonString.add(btn2);
        buttonString.add(btn);

        btn.addActionListener(e -> {
            if (!verification(login.getText(), pass.getPassword())) {
                message.setText("Неверный логин и/или пароль");
                messageString.setBackground(Color.RED);
                login.setText("");
                pass.setText("");
            }
        });

        btn2.addActionListener(e -> changeBox(center, getRegistrationBox()));

        authenticationBox.add(messageString);
        authenticationBox.add(loginString);
        authenticationBox.add(passwordString);
        authenticationBox.add(buttonString);

        return authenticationBox;
    }

    private JComponent getRegistrationBox() {
        Box reg = new Box(BoxLayout.Y_AXIS);
        reg.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JPanel str0 = new JPanel();
        JPanel str1 = new JPanel();
        JPanel str2 = new JPanel();
        JPanel str3 = new JPanel();

        reg.add(str0);
        reg.add(str1);
        reg.add(str2);
        reg.add(str3);

        JLabel message = new JLabel("Введите желаемые логин и пароль");
        str0.add(message);
        str0.setBackground(Color.YELLOW);

        JTextField login = new JTextField(20);
        str1.add(new JLabel("Логин:  "));
        str1.add(login);

        JPasswordField pass = new JPasswordField(20);
        str2.add(new JLabel("Пароль:"));
        str2.add(pass);

        JButton btn2 = new JButton("Отмена");
        btn2.addActionListener(e -> changeBox(center, getAuthenticationBox()));
        str3.add(btn2);

        JButton btn = new JButton("Зарегистрироваться");
        btn.addActionListener(e -> {
            if (!userRegistration(new User(login.getText(), pass.getPassword()))) {
                message.setText("Логин уже существует");
                str0.setBackground(Color.RED);
                pass.setText("");
            }

        });
        str3.add(btn);

        return reg;
    }

    private boolean userRegistration(User user) {
        if (DB.getUser(user.getLogin()) != null) return false;

        this.user = user;
        DB.addUser(user);
        DB.save();
        login();
        return true;
    }

    private boolean verification(String login, char[] password) {
        user = DB.getUser(login);
        if (user == null) return false;
        if (user.checkPassword(password)) {
            login();
            return true;
        }
        return false;
    }

    private void changeBox(JPanel panel, JComponent box) {
        panel.removeAll();
        panel.add(box);
        panel.revalidate();
        panel.repaint();
    }

    private JPanel getHeader() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        panel.add(new Label(user.getLogin()));

        JButton lc = new JButton("Личный кабинет");
        lc.addActionListener(e -> event_lc());
        panel.add(lc);

        JButton set = new JButton("Настройки");
        set.addActionListener(e -> changeBox(center, getCenter()));
        panel.add(set);

        JButton logout = new JButton("Выход");
        logout.addActionListener(e -> logout());
        panel.add(logout);

        return panel;
    }

    private void event_lc() {
        changeBox(center, getCenter_lc());
        changeBox(right, getRight_lc());
    }

    private void login() {
        header.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        left.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        center.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        right.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        footer.setBorder(BorderFactory.createLoweredSoftBevelBorder());
//        footer.setBackground(Color.GRAY);
        changeBox(center, getCenter());
        changeBox(left, getLeft());
        changeBox(header, getHeader());
    }

    private void logout() {
        DB.save();
        user = null;
        left.removeAll();
        right.removeAll();
        footer.removeAll();
        header.removeAll();
        header.setBorder(BorderFactory.createEmptyBorder());
        footer.setBorder(BorderFactory.createEmptyBorder());
        right.setBorder(BorderFactory.createEmptyBorder());
        left.setBorder(BorderFactory.createEmptyBorder());
        center.setBorder(BorderFactory.createEmptyBorder());
        changeBox(center, getAuthenticationBox());
    }

    private Box getLeft() {
        Box box = new Box(BoxLayout.Y_AXIS);
//        box.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        JButton btn1 = new JButton("Путевки");
        JButton btn2 = new JButton("Туры");
        JButton btn3 = new JButton("Клиенты");

        btn1.addActionListener(e -> {changeBox(center, getCenter1()); changeBox(right, getRight1());});
        btn2.addActionListener(e -> {changeBox(center, getCenter2()); changeBox(right, getRight2());});
        btn3.addActionListener(e -> {changeBox(center, getCenter3()); changeBox(right, getRight3());});

        box.add(btn1);
        box.add(btn2);
        box.add(btn3);

       return box;
    }

    private Box getRight1() {
        Box box = new Box(BoxLayout.Y_AXIS);

        JButton btn1 = new JButton("11");
        JButton btn2 = new JButton("12");
        JButton btn3 = new JButton("13");

        btn1.addActionListener(e -> event_btn11());
        btn2.addActionListener(e -> event_btn12());
        btn3.addActionListener(e -> event_btn13());

        box.add(btn1);
        box.add(btn2);
        box.add(btn3);

        return box;
    }

    private Box getRight2() {
        Box box = new Box(BoxLayout.Y_AXIS);

        JButton btn1 = new JButton("21");
        JButton btn2 = new JButton("22");
        JButton btn3 = new JButton("23");

        btn1.addActionListener(e -> event_btn21());
        btn2.addActionListener(e -> event_btn22());
        btn3.addActionListener(e -> event_btn23());

        box.add(btn1);
        box.add(btn2);
        box.add(btn3);

        return box;
    }

    private Box getRight3() {
        Box box = new Box(BoxLayout.Y_AXIS);

        JButton btn1 = new JButton("31");
        JButton btn2 = new JButton("32");
        JButton btn3 = new JButton("33");

        btn1.addActionListener(e -> event_btn31());
        btn2.addActionListener(e -> event_btn32());
        btn3.addActionListener(e -> event_btn33());

        box.add(btn1);
        box.add(btn2);
        box.add(btn3);

        return box;
    }

    private Box getRight_lc() {
        return new Box(BoxLayout.Y_AXIS);
    }

    private Box getCenter() {
        Box box = new Box(BoxLayout.Y_AXIS);
        JTextArea area = new JTextArea(100, 50);
        JScrollPane list = new JScrollPane(area);
        list.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        list.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        box.add(list);
        area.setEditable(false);
        for (User user : DB.getUsers()) {
            StringBuilder sb = new StringBuilder();
            sb.append(user.getLogin()).append(" : ").append(user.getPassword()).append("\n");
            area.append(sb.toString());
        }

        return box;
    }

    private Box getCenter1() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(new JLabel("Center 1"));
        return box;
    }

    private Box getCenter2() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(new JLabel("Center 2"));
        return box;
    }

    private Box getCenter3() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(new JLabel("Center 3"));
        return box;
    }

    private Box getCenter_lc() {
        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(new JLabel("Личный кабинет"));
        box.add(new JLabel("Логин: " + user.getLogin()));
        box.add(new JLabel("Пароль: " + String.valueOf(user.getPassword())));

        return box;
    }


    /*
    * events 1
    * */
    private void event_btn11() {
        changeBox(center, new JLabel("11"));
    }

    private void event_btn12() {
        changeBox(center, new JLabel("12"));
    }

    private void event_btn13() {
        changeBox(center, new JLabel("13"));
    }

    /*
    * events 2
    * */
    private void event_btn21() {
        changeBox(center, new JLabel("21"));
    }

    private void event_btn22() {
        changeBox(center, new JLabel("22"));
    }

    private void event_btn23() {
        changeBox(center, new JLabel("23"));
    }

    /*
    * events 3
    * */
    private void event_btn31() {
        changeBox(center, new JLabel("31"));
    }

    private void event_btn32() {
        changeBox(center, new JLabel("32"));
    }

    private void event_btn33() {
        changeBox(center, new JLabel("33"));
    }


}
