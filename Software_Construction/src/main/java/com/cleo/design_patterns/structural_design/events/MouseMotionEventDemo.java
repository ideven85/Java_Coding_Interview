package com.cleo.design_patterns.structural_design.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionEventDemo extends JPanel implements MouseMotionListener {
    BlankArea blankArea;
    JTextArea textArea;
    JLabel x;
    JLabel y;
    JTextField x_textField;
    JTextField y_textField;
    static final String NEWLINE = System.lineSeparator();

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {

            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Mouse Motion EventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new MouseMotionEventDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public MouseMotionEventDemo() {
        super(new GridLayout(0,1));
        blankArea = new BlankArea(Color.YELLOW);

        x = new JLabel("X");
        y = new JLabel("Y");
        x_textField = new JTextField(10);
        y_textField = new JTextField(10);
        blankArea.add(x_textField);
        blankArea.add(y_textField);
        add(blankArea);

        add(x_textField);
        add(y_textField);


        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(200, 75));

        add(scrollPane);

        //Register for mouse events on blankArea and panel.
        blankArea.addMouseMotionListener(this);
        addMouseMotionListener(this);


        setPreferredSize(new Dimension(450, 450));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    void eventOutput(String eventDescription, MouseEvent e) {
        textArea.append(eventDescription
                + " (" + e.getX() + "," + e.getY() + ")"
                + " detected on "
                + e.getComponent().getClass().getName()
                + NEWLINE);
        x_textField.setText(e.getX() + "");
        y_textField.setText(e.getY() + "");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public void mouseMoved(MouseEvent e) {
        eventOutput("Mouse moved", e);
    }

    public void mouseDragged(MouseEvent e) {
        eventOutput("Mouse dragged", e);
    }
}