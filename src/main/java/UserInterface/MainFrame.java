package main.java.UserInterface;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    private final int SCREENHEIGTH = 900;
    private final int SCREENWIDTH = 1500;


    public MainFrame () {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREENWIDTH, SCREENHEIGTH);

        DrawPanel drawPanel = new DrawPanel();
        drawPanel.setFrameSize(new Dimension(SCREENHEIGTH, SCREENWIDTH));
        drawPanel.setBackground(Color.WHITE);

        KeyBoardListener keyBoardListener = new KeyBoardListener(drawPanel);

        drawPanel.generateListElements();
        drawPanel.setFrameSize(this.getSize());

        addKeyListener(keyBoardListener);
        add(drawPanel);

        setVisible(true);
        setTitle("Sorting-Algorithm-Visualizer");
    }
}
