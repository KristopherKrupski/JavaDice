import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DieGUI extends JFrame implements ActionListener {
    Font mainFont = new Font("Impact", Font.PLAIN, 26);
    JLabel title = new JLabel("Two Dice Game");
    JLabel playerLabel = new JLabel("The player's roll is: ");
    JLabel compLabel = new JLabel("The computer's roll is: ");
    JLabel result = new JLabel("");
    JTextField pRoll = new JTextField(4);
    JTextField cRoll = new JTextField(4);
    JButton button = new JButton("Click to play");


    public DieGUI() {
        super("Two Dice Game");
        setBounds(450, 450, 300, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        pRoll.setEditable(false);
        cRoll.setEditable(false);
        

        title.setFont(mainFont);
        result.setFont(mainFont);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);

        add(title);
        add(playerLabel);
        add(pRoll);
        add(compLabel);
        add(cRoll);
        add(button);
        add(result);

        button.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Die playerDie = new Die();
            Die computerDie = new Die();
            String outcome;

            if(playerDie.getDieValue() > computerDie.getDieValue()){
                outcome = "The player wins!";
                result.setForeground(Color.GREEN);
            } else if (playerDie.getDieValue() < computerDie.getDieValue()){
                outcome= "The computer wins!";
                result.setForeground(Color.RED);
            } else {
                outcome = "It is a draw!";
                result.setForeground(Color.BLACK);
            }
            pRoll.setText(""+playerDie.getDieValue());
            cRoll.setText(""+computerDie.getDieValue());
            result.setText(outcome);
            button.setFocusPainted(false);
            button.setText("Play Again?");


        }
    

    public static void main(String[] args) {
        DieGUI frame = new DieGUI();
        frame.setSize(230,200);
        frame.setResizable(false);
    }
}
