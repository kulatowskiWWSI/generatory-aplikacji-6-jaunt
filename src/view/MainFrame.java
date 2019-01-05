package view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Kamil Ulatowski
 * @version 1.00, 23 Dec 2018
 */

public class MainFrame extends JFrame {

    View view;

    /**
     * Konstruktor do tworzenia frame'a
     */

    public MainFrame() {
        super("Generatory aplikacji - 6");
        setLayout(null);
        setSize(650, 500);

        getContentPane().setBackground( new Color(60,63,65));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addComponents();
    }


    /**
     * Dodawanie komponentów
     */

    void addComponents()
    {
        view = new View();

        add(view);
    }



}
