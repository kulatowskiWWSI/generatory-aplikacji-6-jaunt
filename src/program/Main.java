package program;

import com.jaunt.*;
import service.JauntService;
import view.MainFrame;

public class Main {

    public static void main(String[] args) throws JauntException {
        JauntService jauntService = new JauntService();

        //jauntService.findAllElementsByUrl("http://www.wwsi.edu.pl/");
        MainFrame mainFrame = new MainFrame();

        mainFrame.repaint();
        mainFrame.revalidate();
        mainFrame.invalidate();
    }
}
