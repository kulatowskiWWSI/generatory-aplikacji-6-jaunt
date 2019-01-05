package view;


import com.jaunt.Element;
import service.JCommon;
import service.JauntService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JPanel implements ActionListener {

    JTable positionTable = new JTable(5, 2);
    DefaultTableModel model;
    JauntService jauntService = new JauntService();
    JButton findButton;
    JTextArea urlArea;
    JScrollPane scrollPane = new JScrollPane(positionTable);

    public View()
    {
        setLocation(0, 0);
        setSize(600, 700);
        setBackground( new Color(60,63,65));
        setLayout(null);

        addComponents();
    }



    public void addComponents()
    {
        findButton = JCommon.addButton("szukaj", 430, 10, 100, 30);
        add(findButton);

        findButton.addActionListener(e -> {
            refreshTable(urlArea.getText());
        });

        urlArea = JCommon.addTextArea(10, 10, 400, 30);
        add(urlArea);


       // refreshTable("https://kodejava.org/how-do-i-create-a-scrollable-jtable-component/");
    }

    void refreshTable(String url)
    {
        remove(positionTable);
        remove(scrollPane);

        model = new DefaultTableModel(
                new String [] {
                        "element", "text", "atrybuty"
                }, 0
        );
        positionTable.setLocation(0,0);
        positionTable.setSize(580, 500);

        positionTable.setModel(model);

        model.addRow(new Object[] {
                "element", "text", "atrybuty"
        });

        for(Element element : jauntService.findAllElementsByUrl(url))
        {
            model.addRow(new Object[] {
                    element.getName(), element.getTextContent(), element.getAttributeNames().toString()
            });

        }

        scrollPane = new JScrollPane(positionTable);
        scrollPane.setSize(580, 400);
        scrollPane.setLocation(10, 50);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, null);

        repaint();
        revalidate();
        invalidate();
        validate();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
