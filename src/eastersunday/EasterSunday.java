package eastercalendar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Avinash
 */
public class EasterCalendar extends JFrame implements ActionListener {

    JLabel year = new JLabel("Enter Year");
    JTextField inputYear = new JTextField(20);
    JButton submit = new JButton("Submit");
    JLabel Lresult = new JLabel();

    JPanel mainPanel, inputPanel, buttonPanel, resultPanel;

    public EasterCalendar() throws Exception {
        setTitle("Easter Sunday");
        setSize(400, 400);
        setLayout(new GridLayout(5, 2));

        mainPanel = new JPanel();
        inputPanel = new JPanel();
        buttonPanel = new JPanel();
        resultPanel = new JPanel();

        inputPanel.add(year);
        inputPanel.add(inputYear);
        buttonPanel.add(submit);
        resultPanel.add(Lresult);

        add(mainPanel);
        add(inputPanel);
        add(buttonPanel);
        add(resultPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        submit.addActionListener(this);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EasterCalendar().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(EasterCalendar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == submit) {

                int y = Integer.parseInt(inputYear.getText());
                int a = y % 19;
                int b = y / 100;
                int c = y % 100;
                int d = b / 4;
                int e = b % 4;
                int g = (8 * b + 13) / 25;
                int h = (19 * a + b - d - g + 15) % 30;
                int j = c / 4;
                int k = c % 4;
                int m = (a + 11 * h) / 319;
                int r = (2 * e + 2 * j - k - h + m + 32) % 7;
                int n = (h - m + r + 90) / 25;
                int p = (h - m + r + n + 19) % 32;
                String result;
                switch (n) {
                    case 1:
                        result = "January ";
                        break;
                    case 2:
                        result = "February ";
                        break;
                    case 3:
                        result = "March ";
                        break;
                    case 4:
                        result = "April ";
                        break;
                    case 5:
                        result = "May ";
                        break;
                    case 6:
                        result = "June ";
                        break;
                    case 7:
                        result = "July ";
                        break;
                    case 8:
                        result = "August ";
                        break;
                    case 9:
                        result = "September ";
                        break;
                    case 10:
                        result = "October ";
                        break;
                    case 11:
                        result = "November ";
                        break;
                    case 12:
                        result = "December ";
                        break;
                    default:
                        result = "error";
                }

                Lresult.setText("The date of Easter for the year " + y + " is " + result + p);

            }

        } catch (Exception e) {
        }
    }

}
