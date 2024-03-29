package mayintarlasison;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MayınTarlası {

    public static JFrame jframe = new JFrame("Minesweeper");
    private final JMenuBar menuBar = new JMenuBar();
//    private JPanel altMenu = new JPanel();
    private final JMenuBar menubar2 = new JMenuBar();
    static JLabel yeniOyun = new JLabel();
    public static JLabel kalanMayın = new JLabel();
    static JLabel gecenSure = new JLabel();
    private final JMenuItem ozelOyun = new JMenuItem();
    private final JMenu menuAyarlar = new JMenu();
    private final JMenu menuYardım = new JMenu();
    private final JMenu menuYeniOyun = new JMenu();
    private final JMenuItem menuItemEasy = new JMenuItem();
    private final JMenuItem menuItemMedium = new JMenuItem();
    private final JMenuItem menuItemHard = new JMenuItem();
    private final OyunAlani oyunAlani = new OyunAlani();
    static Image smile = new ImageIcon(OyunAlani.class.getResource("/resources/smiley.png")).getImage();
    private int mayınSayısı = 7;
    private int sutunSayisi = 10;
    private int satirSayisi = 10;
    JLabel[][] labelDizisi = new JLabel[sutunSayisi][satirSayisi];
    int[][] bombaDizisi = new int[sutunSayisi][satirSayisi];

    public MayınTarlası() {

        ekranTasarla();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setVisible(true);

        jframe.setLocationRelativeTo(null);
        jframe.revalidate();
        jframe.repaint();
    }

    public void ekranTasarla() {

        //menubar actions
        jframe.add(menuBar, BorderLayout.NORTH);
        jframe.add(menubar2, BorderLayout.CENTER);
        //menu iÅŸlemleri
        menuAyarlar.setText("Settings");
        ozelOyun.setText("Special Game");
        menuYardım.setText("Help");
        menuBar.add(menuAyarlar, BorderLayout.WEST);
        menuBar.add(menuYardım);
        //menu new game actions
        menuAyarlar.add(menuYeniOyun);
        menuYeniOyun.setText("New Game");

        //menuItemEasy actions
        menuYeniOyun.add(menuItemEasy);
        menuItemEasy.setText("Easy");

        //menuItemMedium actions
        menuYeniOyun.add(menuItemMedium);
        menuItemMedium.setText("Medium");

        //menuItemHard actions
        menuYeniOyun.add(menuItemHard);
        menuItemHard.setText("Hard");

        menuAyarlar.add(ozelOyun);
        yeniOyun.setIcon(new ImageIcon(smile));

        menubar2.add(kalanMayın);
        menubar2.add(new JPanel());
        menubar2.add(yeniOyun);
        menubar2.add(new JPanel());
        menubar2.add(gecenSure);
        kalanMayın.setText("007");
        gecenSure.setText("000");
        tıklanma();

        oyunAlani.iÅŸlemKontrol();
        jframe.pack();

    }

    private void tıklanma() {
    	
    	//Easy part number of columns, rows and mines
        menuItemEasy.addActionListener((java.awt.event.ActionEvent evt) -> {
            oyunAlani.jpanel.removeAll();
            mayınSayısı = 7;
            satirSayisi = 10;
            sutunSayisi = 10;
            oyunAlani.boyutAl(sutunSayisi, satirSayisi, mayınSayısı);
            jframe.revalidate();
            jframe.repaint();
            jframe.pack();
            ekranıOrtala();
            oyunAlani.timerStop();
            gecenSure.setText("000");

        });
        
        //Medium part number of columns, rows and mines
        menuItemMedium.addActionListener((java.awt.event.ActionEvent evt) -> {
            oyunAlani.jpanel.removeAll();
            mayınSayısı = 40;
            satirSayisi = 16;
            sutunSayisi = 16;
            oyunAlani.boyutAl(sutunSayisi, satirSayisi, mayınSayısı);
            jframe.revalidate();
            jframe.repaint();
            jframe.pack();
            ekranıOrtala();
            oyunAlani.timerStop();
            gecenSure.setText("000");
        });
        
        //Hard part number of columns, rows and mines
        menuItemHard.addActionListener((java.awt.event.ActionEvent evt) -> {
            oyunAlani.jpanel.removeAll();
            mayınSayısı = 99;
            satirSayisi = 16;
            sutunSayisi = 30;
            oyunAlani.boyutAl(sutunSayisi, satirSayisi, mayınSayısı);
            jframe.revalidate();
            jframe.repaint();
            jframe.pack();
            ekranıOrtala();
            oyunAlani.timerStop();
            gecenSure.setText("000");
        });
        
        //Special game actions
        ozelOyun.addActionListener((ActionEvent e) -> {

            JTextField girilenSatir = new JTextField(5);
            JTextField girilenSutun = new JTextField(5);
            JTextField girilenMayin = new JTextField(5);
            JPanel myPanel = new JPanel();
            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
            
            //number of columns being asked from user
            myPanel.add(new JLabel("Enter the number of columns :"));
            myPanel.add(girilenSatir);

            //number of rows being asked from user
            myPanel.add(new JLabel("Enter the number of rows :"));
            myPanel.add(girilenSutun);
            
            //number of mines being asked from user
            myPanel.add(new JLabel("Enter the number of mines :"));
            myPanel.add(girilenMayin);
            int result = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                char[] girilenSatirChar = girilenSatir.getText().toCharArray();
                char[] girilenSutunChar = girilenSutun.getText().toCharArray();
                char[] girilenMayinChar = girilenMayin.getText().toCharArray();
                boolean sadeceSayiMi = true;
                boolean bosMu = false;

                if (girilenSatir.getText().equals("")) {
                    bosMu = true;
                }
                if (girilenMayin.getText().equals("")) {
                    bosMu = true;
                }
                if (girilenSutun.getText().equals("")) {
                    bosMu = true;
                }

                for (char i : girilenMayinChar) {
                    if (i != '0' && i != '1' && i != '2' && i != '3' && i != '4' && i != '5' && i != '6' && i != '7' && i != '8' && i != '9') {
                        sadeceSayiMi = false;
                        break;
                    }
                }
                for (char i : girilenSatirChar) {
                    if (i != '0' && i != '1' && i != '2' && i != '3' && i != '4' && i != '5' && i != '6' && i != '7' && i != '8' && i != '9') {
                        sadeceSayiMi = false;
                        break;
                    }
                }
                for (char i : girilenSutunChar) {
                    if (i != '0' && i != '1' && i != '2' && i != '3' && i != '4' && i != '5' && i != '6' && i != '7' && i != '8' && i != '9') {
                        sadeceSayiMi = false;
                        break;
                    }
                }
                if (bosMu != true) {
                    if (sadeceSayiMi) {
                        mayınSayısı = Integer.valueOf(girilenMayin.getText());
                        satirSayisi = Integer.valueOf(girilenSutun.getText());
                        sutunSayisi = Integer.valueOf(girilenSatir.getText());
                        if (sutunSayisi < 10) {
                            JOptionPane.showMessageDialog(null, "Enter number of columns greater than 10");
                        } else if (sutunSayisi * satirSayisi >= mayınSayısı) {
                            oyunAlani.jpanel.removeAll();

                            oyunAlani.boyutAl(sutunSayisi, satirSayisi, mayınSayısı);
                            jframe.revalidate();
                            jframe.repaint();
                            jframe.pack();
                            ekranıOrtala();
                            oyunAlani.timerStop();
                            gecenSure.setText("000");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nice job! ");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Don't press any button. ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "One or more of the rows, columns and bomb numbers are empty");

                }
            }
        });
        yeniOyun.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                oyunAlani.jpanel.removeAll();
                jframe.revalidate();
                oyunAlani.boyutAl(sutunSayisi, satirSayisi, mayınSayısı);
                jframe.repaint();
                jframe.pack();
                ekranıOrtala();
                oyunAlani.timerStop();
                gecenSure.setText("000");
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

    public static void ekranıOrtala() {
        jframe.setLocationRelativeTo(null);
    }

}
