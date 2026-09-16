package myshit;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class RotatingWindow extends JFrame {

    public List<JPanel> panels = new ArrayList<>();
    public static List<Color> colors = new ArrayList<>(List.of(Color.red,Color.blue,Color.green,Color.yellow,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE));
    public static final List<String> layouts = List.of(BorderLayout.NORTH,BorderLayout.WEST,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.EAST,BorderLayout.SOUTH,BorderLayout.WEST,BorderLayout.NORTH);

    public RotatingWindow() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        setSize(500,500);
        setLocationRelativeTo(null);

        for (int i = 0; i < 4; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(colors.get(i));
            panel.setPreferredSize(new Dimension(100,100));
            add(panel,layouts.get(i));
            panels.add(panel);
        }

        JPanel inner = new JPanel();
        inner.setLayout(new BorderLayout());

        for (int i = 4; i < 8; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(colors.get(i));
            panel.setPreferredSize(new Dimension(100,100));
            inner.add(panel,layouts.get(i));
            panels.add(panel);
        }

        JButton button = new JButton("Rotate");
        button.addActionListener(e->{
//            colors.addFirst(colors.get(colors.size()-1));
//            colors.removeLast();
            rotate();

        });


        inner.add(button);

        add(inner);
        setVisible(true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                rotate();
            }
        }, 20L, 80L);
    }

    public void rotate(){
        colors.add(colors.getFirst());
        colors.removeFirst();
        for (int i = 0; i < panels.size(); i++) {
            JPanel panel = panels.get(i);
            panel.setBackground(colors.get(i));
        }
    }

    public static void main(String[] args) {
        new RotatingWindow();
    }
}
