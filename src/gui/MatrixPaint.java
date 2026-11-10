package gui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class MatrixPaint extends JFrame {

    private JPanel matrix;
    private JLabel[][] labels;
    private final int DIMENSION = 15;
    private JButton paintButton;

    public MatrixPaint() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 600);

        paintButton = new JButton("Draw");
        matrix = new JPanel(new GridLayout(DIMENSION, DIMENSION, 5, 5));
        labels = new JLabel[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setOpaque(true);
                matrix.add(labels[i][j]);
            }
        }

        paintButton.addActionListener(e -> redrawZwiebel());

        add(paintButton, BorderLayout.NORTH);
        add(matrix, BorderLayout.CENTER);
    }

    private void redraw() {
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);

            // překreslit pozadí všech labelu na modrou
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    Thread.sleep(16); // 16.7ms = 60fps
                    labels[i][j].setBackground(Color.BLUE);
                    matrix.paintImmediately(0, 0, getWidth(), getHeight());
                }
            }

            paintButton.setText("Finished drawing");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void redrawReversed() {
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);

            // překreslit pozadí všech labelu na modrou
            for (int i = DIMENSION-1; i >= 0; i--) {
                for (int j = DIMENSION-1; j >= 0; j--) {
                    Thread.sleep(16); // 16.7ms = 60fps
                    labels[i][j].setBackground(Color.BLUE);
                    matrix.paintImmediately(0, 0, getWidth(), getHeight());
                }
            }

            paintButton.setText("Finished drawing");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void redrawCols() {
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);

            // překreslit pozadí všech labelu na modrou
            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    Thread.sleep(16); // 16.7ms = 60fps
                    labels[j][i].setBackground(Color.BLUE);
                    matrix.paintImmediately(0, 0, getWidth(), getHeight());
                }
            }

            paintButton.setText("Finished drawing");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void redrawZwiebel() {
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);

            // překreslit pozadí všech labelu na modrou
            int iLimit = DIMENSION-1;
            int jLimit = DIMENSION-1;

            int iPainter = 0;
            int jPainter = DIMENSION-1;
            int run = 0;

            while (iLimit>0||jLimit>0) {
                System.out.println(jLimit);
                if(run!=0) {
                    while (jLimit > jPainter) {
                        Thread.sleep(16); // 16.7ms = 60fps
                        labels[iPainter][jPainter].setBackground(Color.BLUE);
                        matrix.paintImmediately(0, 0, getWidth(), getHeight());
                        jPainter++;
                    }
                    System.out.println(iLimit);

                }
                run++;
                while (iLimit > iPainter) {
                    Thread.sleep(16); // 16.7ms = 60fps
                    labels[iPainter][jPainter].setBackground(Color.BLUE);
                    matrix.paintImmediately(0, 0, getWidth(), getHeight());
                    iPainter++;
                }
                System.out.println(jLimit);
                while ((DIMENSION - jLimit) <= jPainter) {
                    Thread.sleep(16); // 16.7ms = 60fps
                    labels[iPainter][jPainter].setBackground(Color.BLUE);
                    matrix.paintImmediately(0, 0, getWidth(), getHeight());
                    jPainter--;
                }
                jLimit--;
                System.out.println(iLimit);
                while ((DIMENSION - iLimit) <= iPainter) {
                    Thread.sleep(16); // 16.7ms = 60fps
                    labels[iPainter][jPainter].setBackground(Color.BLUE);
                    matrix.paintImmediately(0, 0, getWidth(), getHeight());
                    iPainter--;
                }
                iLimit--;
            }

            Thread.sleep(16); // 16.7ms = 60fps
            labels[(int)Math.round(DIMENSION/2.0)-1][(int)Math.round(DIMENSION/2.0)-1].setBackground(Color.BLUE);
            System.out.println(Math.round(DIMENSION/2.0));
            matrix.paintImmediately(0, 0, getWidth(), getHeight());
//
//
//            for (int i = iLimit; i < DIMENSION-iLimit; i++) {
//                for (int j = jLimit; j < DIMENSION-jLimit; j++) {
//                    Thread.sleep(16); // 16.7ms = 60fps
//                    labels[i][j].setBackground(Color.BLUE);
//                    matrix.paintImmediately(0, 0, getWidth(), getHeight());
//                }
//                jLimit++;
////                iLimit++;
//            }

            paintButton.setText("Finished drawing");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatDarkLaf.setup();

        UIManager.setLookAndFeel(new FlatDarkLaf());

        new MatrixPaint().setVisible(true);
    }
}
