import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class PizzaGuiFrame extends JFrame {
    JPanel mainPnl, titlePnl, selectPnl, displayPnl, cmdPnl;
    JLabel titleLbl, sizeLbl, toppingsLbl;
    ButtonGroup sizeBtnGroup;
    JRadioButton smlRBtn, medRBtn, lrgRBtn, xlRBtn;
    JCheckBox pepperoniCB, baconCB, onionCB, pepperCB, anchovyCB, pineappleCB;
    ImageIcon icon;
    JScrollPane scroller;
    JTextArea pizzaTA;
    JButton quitBtn, orderBtn, clearBtn;

    public PizzaGuiFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createSelectPanel();
        createDisplayPanel();
        createControlPanel();

        setTitle("Order a Pizza!");
        setSize(650,750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTitlePanel(){
        titlePnl = new JPanel();
        icon = new ImageIcon("src/pizzaIcon.png");
        titleLbl = new JLabel("Delicious Pizza", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.TOP);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }

    private void createDisplayPanel() {
        displayPnl = new JPanel();
        pizzaTA = new JTextArea(15,50);
        scroller = new JScrollPane(pizzaTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    private void createSelectPanel(){
        selectPnl = new JPanel();
        ButtonGroup sizeBtnGroup = new ButtonGroup();
        JLabel sizeLbl = new JLabel("Pizza Size: ");

        JRadioButton smlRBtn = new JRadioButton("Small");
        JRadioButton medRBtn = new JRadioButton("Medium");
        JRadioButton lrgRBtn = new JRadioButton("Large");
        JRadioButton xlRBtn = new JRadioButton("Extra Large");

        smlRBtn.setBounds(120, 30, 120, 50);
        medRBtn.setBounds(120, 30, 120, 50);
        lrgRBtn.setBounds(120, 30, 120, 50);
        xlRBtn.setBounds(120, 30, 120, 50);

        sizeLbl.setBounds(120,30,120,50);

        sizeBtnGroup.add(smlRBtn);
        sizeBtnGroup.add(medRBtn);
        sizeBtnGroup.add(lrgRBtn);
        sizeBtnGroup.add(xlRBtn);

        selectPnl.add(sizeLbl);

        selectPnl.add(smlRBtn);
        selectPnl.add(medRBtn);
        selectPnl.add(lrgRBtn);
        selectPnl.add(xlRBtn);

        JLabel toppingsLbl = new JLabel();
        sizeLbl.setText("Toppings: ");

        mainPnl.add(selectPnl);
    }

    private void createControlPanel() {
        Random rnd = new Random();
        cmdPnl = new JPanel();
        cmdPnl.setLayout(new GridLayout(1,3));
        orderBtn = new JButton("Order!");
        clearBtn = new JButton("Clear form!");
        quitBtn = new JButton("Quit!");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        orderBtn.addActionListener((ActionEvent ae) -> {

            pizzaTA.append("fish" +"\n");
        });

        clearBtn.addActionListener((ActionEvent ae) -> {

            pizzaTA.selectAll();
            pizzaTA.replaceSelection("");
        });

        cmdPnl.add(orderBtn);
        cmdPnl.add(clearBtn);
        cmdPnl.add(quitBtn);

        mainPnl.add(cmdPnl, BorderLayout.SOUTH);

    }
}