package mayintarlasison;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu {
    private int mGenislik = 900;
    private int mYukseklik = 592;
    public static JFrame jframeMenu = new JFrame("MineSweeper");
    JLabel oyunaBasla = new JLabel();
    JLabel bestTimes = new JLabel();
    JLabel zorLabel = new JLabel();
    JLabel arkaplan = new JLabel();
    JLabel customLabel = new JLabel();
   Image arka = new ImageIcon(OyunAlani.class.getResource("/resources/arkaplan.png")).getImage();

    public Menu() {
        jframeMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframeMenu.setVisible(true);
        jframeMenu.setResizable(false);

        jframeMenu.setLayout(null);
        jframeMenu.getContentPane().setBackground(Color.WHITE);
        setDimension();

        arkaplan.setIcon(new ImageIcon(arka));
        arkaplan.setBounds(0, 0, mGenislik, mYukseklik);

        oyunaBasla.setText("Start Game");
        oyunaBasla.setFont(new Font("Serif", Font.BOLD, 20));
        oyunaBasla.setHorizontalAlignment(JLabel.CENTER);
        oyunaBasla.setVerticalAlignment(JLabel.CENTER);
//        oyunaBasla.setBackground(Color.YELLOW);
//        oyunaBasla.setOpaque(true);



        oyunaBasla.setBounds(375, 125, 125, 50);
        bestTimes.setBounds(337, 250, 200, 50);
        zorLabel.setBounds(385, 375, 100, 50);
        jframeMenu.add(arkaplan);
        arkaplan.add(oyunaBasla);
        arkaplan.add(bestTimes);
        arkaplan.add(zorLabel);
        tıklanma();

    }

    public void setDimension() {
        Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();

        int PosX = 0;
        int PosY = 0;

        if (mGenislik + 100 > Dim.width) {
            mGenislik = Dim.width - 100;
        }
        if (mYukseklik + 100 > Dim.height) {
            mYukseklik = Dim.height - 100;
        }

        PosX = (Dim.width - mGenislik) / 2;
        PosY = (Dim.height - mYukseklik) / 2;

        jframeMenu.setBounds(PosX, PosY, mGenislik, mYukseklik);

    }

    private void tıklanma() {
        oyunaBasla.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                MayınTarlası mayınTarlası = new MayınTarlası();
                jframeMenu.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        bestTimes.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
    }
}
