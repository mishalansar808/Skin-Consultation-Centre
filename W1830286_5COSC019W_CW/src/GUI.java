import javax.swing.*;
import java.awt.*;

public class GUI extends WestminsterSkinConsultationManager{
    public GUI(){
        JFrame frame = new JFrame();
        frame.setTitle("Skin Consultation Centre");
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        ImageIcon frameIcon = new ImageIcon("logo.png");
        frame.setIconImage(frameIcon.getImage());

        frame.getContentPane().setBackground(new Color(0xbebebe));

        ImageIcon bgIcon = new ImageIcon("mlogo.png");

        JLabel label = new JLabel();
        label.setText("Skin Consultation Centre");
        label.setIcon(bgIcon);
        label.setHorizontalTextPosition(JLabel.CENTER);
    }
}
