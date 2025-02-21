import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class PizzaGuiFrame extends JFrame {
    JPanel mainPnl, titlePnl, displayPnl, cmdPnl;
    JLabel titleLbl, sizeLbl, toppingsLbl;
    ButtonGroup sizeBtnGroup;
    JRadioButton smlRBtn, medRBtn, lrgRBtn, xlRBtn;
    JCheckBox pepperoniCB, baconCB, onionCB, pepperCB, anchovyCB, pineappleCB;
    ImageIcon icon;
    JScrollPane scroller;
    JTextArea pizzaTA;
    JButton quitBtn, orderBtn, clearBtn;

    double sizeCost;
    double toppingsCost;
    double tax = .07;

    public PizzaGuiFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
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

        ButtonGroup sizeBtnGroup = new ButtonGroup();
        JLabel sizeLbl = new JLabel("Pizza Size: ");

        JPanel boxes = new JPanel();

        JRadioButton smlRBtn = new JRadioButton("Small");
        JRadioButton medRBtn = new JRadioButton("Medium");
        JRadioButton lrgRBtn = new JRadioButton("Large");
        JRadioButton xlRBtn = new JRadioButton("Extra Large");

        sizeBtnGroup.add(smlRBtn);
        sizeBtnGroup.add(medRBtn);
        sizeBtnGroup.add(lrgRBtn);
        sizeBtnGroup.add(xlRBtn);

        boxes.add(sizeLbl);

        boxes.add(smlRBtn);
        boxes.add(medRBtn);
        boxes.add(lrgRBtn);
        boxes.add(xlRBtn);

        displayPnl.add(boxes);

        JPanel checks = new JPanel();

        JLabel toppingsLbl = new JLabel("Toppings: ");

        JCheckBox pepperoniCB = new JCheckBox("Pepperoni");
        JCheckBox baconCB = new JCheckBox("Bacon");
        JCheckBox onionCB = new JCheckBox("Onion");
        JCheckBox pepperCB = new JCheckBox("Green Bell Pepper");
        JCheckBox anchovyCB = new JCheckBox("Anchovies");
        JCheckBox pineappleCB = new JCheckBox("Pineapple");

        checks.add(toppingsLbl);

        checks.add(pepperoniCB);
        checks.add(baconCB);
        checks.add(onionCB);
        checks.add(pepperCB);
        checks.add(anchovyCB);
        checks.add(pineappleCB);

        displayPnl.add(checks);

        pizzaTA = new JTextArea(10,50);
        scroller = new JScrollPane(pizzaTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl);
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

            pizzaTA.append("======================================================================" + "\n");
            pizzaTA.append("Size price:       " + getSizeCost() + "\n");
            pizzaTA.append("Toppings price:   " + getToppingsCost() + "\n");
            pizzaTA.append("");
            pizzaTA.append("Subtotal:         " + (getSizeCost() + getToppingsCost()) + "\n");
            pizzaTA.append("Tax:              " + tax + "\n");
            pizzaTA.append("");
            pizzaTA.append("----------------------------------------------------------------------" + "\n");
            pizzaTA.append("");
            pizzaTA.append("Total:             " + ((getSizeCost() + getToppingsCost()) + (getSizeCost() + getToppingsCost())*tax) + "\n");
            pizzaTA.append("");
            pizzaTA.append("======================================================================" + "\n");

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

    public double getSizeCost() {

        if (smlRBtn.isSelected()) {
            sizeCost = 5;
        }

        if (medRBtn.isSelected()) {
            sizeCost = 8;
        }

        if (lrgRBtn.isSelected()) {
            sizeCost = 10;
        }

        if (xlRBtn.isSelected()) {
            sizeCost = 14;
        }
        return sizeCost;
    }

    public double getToppingsCost(){

        toppingsCost = 0;

        if(pepperoniCB.isSelected()){
            toppingsCost += 1;
        }

        if(baconCB.isSelected()){
            toppingsCost += 2;
        }

        if(onionCB.isSelected()){
            toppingsCost += .5;
        }

        if(pepperCB.isSelected()){
            toppingsCost += .5;
        }

        if(anchovyCB.isSelected()){
            toppingsCost += 3;
        }

        if(pineappleCB.isSelected()){
            toppingsCost += 3;
        }
        return toppingsCost;
    }

}