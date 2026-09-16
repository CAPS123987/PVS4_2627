package myshit;

import javax.swing.*;
import java.awt.*;

public class UkolOkynka1 extends JFrame {
    public UkolOkynka1() throws HeadlessException {
        setTitle("task");
        setSize(1000,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1000,50));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel queryLbl = new JLabel("Query:");
        queryLbl.setVerticalAlignment(SwingConstants.CENTER);
        queryLbl.setHorizontalAlignment(SwingConstants.LEFT);

        JTextField queryInput = new JTextField();
        queryInput.setPreferredSize(new Dimension(400,20));

        JButton querySubmit = new JButton("Go");
        querySubmit.addActionListener((e -> {
            JOptionPane.showMessageDialog(null,"Hello mother fucker");
        }));

        topPanel.add(queryLbl);
        topPanel.add(queryInput);
        topPanel.add(querySubmit);


        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(5,1));
        leftPanel.setPreferredSize(new Dimension(200,730));

        ButtonGroup rationButtonGroup = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            JRadioButton iRadioButton = new JRadioButton("Option "+((char)(i+65)));
            rationButtonGroup.add(iRadioButton);
            leftPanel.add(iRadioButton);
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setPreferredSize(new Dimension(1000,20));

        JLabel bottomResults = new JLabel("100 results");
        bottomResults.setFont(new Font("Consolas",Font.ITALIC,10));
        bottomPanel.add(bottomResults);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(10,11,5,5));

        for (int i = 0; i < 10 * 11; i++) {
            Tile iTile = new Tile("Tile "+(char)(i+48));
            centerPanel.add(iTile);
        }


        add(topPanel,BorderLayout.NORTH);
        add(leftPanel,BorderLayout.WEST);
        add(bottomPanel,BorderLayout.SOUTH);
        add(centerPanel);

    }

    public static void main(String[] args) {
        new UkolOkynka1().setVisible(true);
    }
}

class Tile extends JLabel {
    public Tile(String name) {
        super(name);

        setBackground(Color.WHITE);
        setOpaque(true);
        setVerticalAlignment(CENTER);
        setHorizontalAlignment(CENTER);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(100,50));
    }
}
