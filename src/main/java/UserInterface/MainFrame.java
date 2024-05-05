package main.java.UserInterface;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private final int SCREENHEIGTH = 900;
    private final int SCREENWIDTH = 1400;


    public MainFrame () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SCREENWIDTH, SCREENHEIGTH);

        DrawPanel drawPanel = new DrawPanel();
        drawPanel.setFrameSize(new Dimension(SCREENHEIGTH, SCREENWIDTH));
        drawPanel.setBackground(Color.WHITE);

        KeyBoardListener keyBoardListener = new KeyBoardListener(drawPanel);

        drawPanel.generateListElements();
        drawPanel.setFrameSize(this.getSize());

        this.addKeyListener(keyBoardListener);
        this.add(drawPanel);

        this.setVisible(true);
        this.setTitle("Sorting-Algorithm-Visualizer");
    }
}
