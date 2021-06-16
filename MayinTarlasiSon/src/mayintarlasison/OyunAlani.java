package mayintarlasison;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OyunAlani {

    JPanel jpanel = new JPanel();
    private static int gelenSatır = 10;
    private static int gelenSutun = 10;
    private final int boslukBoyutu = 15;
    private int bombaSayısı = 7;
    private Random rdd = new Random();
    int[][] oyunAlaniSayilari;
    JLabel labelDizisi[][];
    boolean acilanKare[][];
    boolean[][] bayrakVarMı;

    static int x = 0;
    Timer timer;
    TimerTask timerTask;
    boolean tekSefer = true;
    boolean sayacBiKezCalıstır = true;
    Image ust = new ImageIcon(OyunAlani.class.getResource("/resources/kutu.png")).getImage();
    Image glassessmiley = new ImageIcon(OyunAlani.class.getResource("/resources/sunglasses.png")).getImage();
    Image altBosluk = new ImageIcon(OyunAlani.class.getResource("/resources/bosluk.png")).getImage();
    Image bomba = new ImageIcon(OyunAlani.class.getResource("/resources/bomba.png")).getImage();
    Image yanda1 = new ImageIcon(OyunAlani.class.getResource("/resources/1.png")).getImage();
    Image yanda2 = new ImageIcon(OyunAlani.class.getResource("/resources/2.png")).getImage();
    Image yanda3 = new ImageIcon(OyunAlani.class.getResource("/resources/3.png")).getImage();
    Image yanda4 = new ImageIcon(OyunAlani.class.getResource("/resources/4.png")).getImage();
    Image yanda5 = new ImageIcon(OyunAlani.class.getResource("/resources/5.png")).getImage();
    Image yanda6 = new ImageIcon(OyunAlani.class.getResource("/resources/6.png")).getImage();
    Image yanda7 = new ImageIcon(OyunAlani.class.getResource("/resources/7.png")).getImage();
    Image yanda8 = new ImageIcon(OyunAlani.class.getResource("/resources/8.png")).getImage();
    Image bayrak = new ImageIcon(OyunAlani.class.getResource("/resources/11.png")).getImage();
    Image deadSmile = new ImageIcon(OyunAlani.class.getResource("/resources/deadsmiley.png")).getImage();
    int bayrakSayısı = bombaSayısı;

    public void boyutBelirle() {

        Dimension dimension = new Dimension(gelenSatır * boslukBoyutu, gelenSutun * boslukBoyutu);
        jpanel.setPreferredSize(dimension);

    }

    public void yerlestirJLabel() {
        sayacBiKezCalıstır = true;
        oyunAlaniSayilari = new int[gelenSatır][gelenSutun];
        labelDizisi = new JLabel[gelenSatır][gelenSutun];
        bayrakVarMı = new boolean[gelenSatır][gelenSutun];
        acilanKare = new boolean[gelenSatır][gelenSutun];
        int randomSatır;
        int randomSutun;
        bayrakSayısı = bombaSayısı;
        int[][] sayiDizisi = new int[gelenSatır][gelenSutun];// BombalarÄ±n aynÄ± yerde olmamasÄ± iÃ§in iki boyutlu br sayÄ± dizisi oluÅŸutur  

        MayınTarlası.kalanMayın.setText("00" + bayrakSayısı);
        if (tekSefer) {
            tekSefer();
            tekSefer = false;
        }

        //SayÄ± dizisine sayÄ± ver 
        for (int i = 0; i < gelenSatır; i++) {
            for (int j = 0; j < gelenSutun; j++) {
                sayiDizisi[i][j] = i * gelenSutun + j;
            }
        }

        //BombalarÄ± yerleÅŸtir aynÄ± yere bomba dÃ¼ÅŸmeyecek ÅŸekilde
        for (int i = 0; i < bombaSayısı; i++) {
            while (true) {
                randomSatır = rdd.nextInt(gelenSatır);
                randomSutun = rdd.nextInt(gelenSutun);
                if (sayiDizisi[randomSatır][randomSutun] != -1) {
                    oyunAlaniSayilari[randomSatır][randomSutun] = 10;

                    sayiDizisi[randomSatır][randomSutun] = -1;
                    break;
                }

            }
        }
        // BombalarÄ± gÃ¶steren sayÄ±larÄ± oluÅŸtur ...
//        for (int i = 0; i < bombaSayÄ±sÄ±; i++) {
//            
//        }
//        

        for (int i = 0; i < gelenSutun; i++) {
            for (int j = 0; j < gelenSatır; j++) {//j sutun i satÄ±rdÄ±r..
                if (oyunAlaniSayilari[j][i] == 10) {
                    if (j == 0 && i == 0) {//ilk kÃ¶ÅŸe 
                        if (oyunAlaniSayilari[j + 1][i] == 10) {//saÄŸ

                        } else {
                            oyunAlaniSayilari[j + 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i + 1] == 10) {//Ã§apraz

                        } else {
                            oyunAlaniSayilari[j + 1][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j][i + 1] == 10) {//alt

                        } else {
                            oyunAlaniSayilari[j][i + 1] += 1;
                        }
                    } else if (j == 0 && i == gelenSutun - 1) {//Sol alt kÃ¶ÅŸe 
                        if (oyunAlaniSayilari[j][i - 1] == 10) {//Ã¼st

                        } else {
                            oyunAlaniSayilari[j][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i - 1] == 10) {//Ã§apraz

                        } else {
                            oyunAlaniSayilari[j + 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i] == 10) {//saÄŸ

                        } else {
                            oyunAlaniSayilari[j + 1][i] += 1;
                        }
                    } else if (i == 0 && j == gelenSatır - 1) {//SaÄŸ Ã¼st kÃ¶ÅŸe 
                        if (oyunAlaniSayilari[j - 1][i] == 10) {//sol

                        } else {
                            oyunAlaniSayilari[j - 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i + 1] == 10) {//Ã§apraz

                        } else {
                            oyunAlaniSayilari[j - 1][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j][i + 1] == 10) {//alt

                        } else {
                            oyunAlaniSayilari[j][i + 1] += 1;
                        }
                    } else if (i == gelenSutun - 1 && j == gelenSatır - 1) {//saÄŸ alt kÃ¶ÅŸe 
                        if (oyunAlaniSayilari[j - 1][i] == 10) {//sol

                        } else {
                            oyunAlaniSayilari[j - 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i - 1] == 10) {//Ã§apraz

                        } else {
                            oyunAlaniSayilari[j - 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j][i - 1] == 10) {//Ã¼st

                        } else {
                            oyunAlaniSayilari[j][i - 1] += 1;
                        }
                    } else if (j == 0) {//sol kÃ¶ÅŸe tamamÄ±
                        if (oyunAlaniSayilari[j][i - 1] == 10) {//Ã¼st

                        } else {
                            oyunAlaniSayilari[j][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i - 1] == 10) {//Ã¼st saÄŸ Ã§apraz

                        } else {
                            oyunAlaniSayilari[j + 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i] == 10) {//saÄŸ

                        } else {
                            oyunAlaniSayilari[j + 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i + 1] == 10) {//alt sol Ã§apraz

                        } else {
                            oyunAlaniSayilari[j + 1][i + 1] += 1;
                        }

                        if (oyunAlaniSayilari[j][i + 1] == 10) {//alt

                        } else {
                            oyunAlaniSayilari[j][i + 1] += 1;
                        }
                    } else if (i == 0) {//Ã¼st kÃ¶ÅŸe tamamÄ±
                        if (oyunAlaniSayilari[j - 1][i] == 10) {//solu

                        } else {
                            oyunAlaniSayilari[j - 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i + 1] == 10) {//sol alt kÃ¶ÅŸe

                        } else {
                            oyunAlaniSayilari[j - 1][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j][i + 1] == 10) {//alt

                        } else {
                            oyunAlaniSayilari[j][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i + 1] == 10) {//saÄŸ alt kÃ¶ÅŸe

                        } else {
                            oyunAlaniSayilari[j + 1][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i] == 10) {//saÄŸ

                        } else {
                            oyunAlaniSayilari[j + 1][i] += 1;

                        }
                    } else if (i == gelenSutun - 1) {//alt kÃ¶ÅŸe tamamÄ±
                        if (oyunAlaniSayilari[j - 1][i] == 10) {//sol

                        } else {
                            oyunAlaniSayilari[j - 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i - 1] == 10) {//sol kÃ¶ÅŸe 

                        } else {
                            oyunAlaniSayilari[j - 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j][i - 1] == 10) {//Ã¼st

                        } else {
                            oyunAlaniSayilari[j][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i - 1] == 10) {//SaÄŸ kÃ¶ÅŸe

                        } else {
                            oyunAlaniSayilari[j + 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i] == 10) {

                        } else {
                            oyunAlaniSayilari[j + 1][i] += 1;
                        }

                    } else if (j == gelenSatır - 1) {//saÄŸ kÃ¶ÅŸe tamamÄ±
                        if (oyunAlaniSayilari[j][i - 1] == 10) {//Ã¼st 

                        } else {
                            oyunAlaniSayilari[j][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j][i + 1] == 10) {//alt 

                        } else {
                            oyunAlaniSayilari[j][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i - 1] == 10) {//Ã¼st Ã§apraz

                        } else {
                            oyunAlaniSayilari[j - 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i] == 10) {//sol

                        } else {
                            oyunAlaniSayilari[j - 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i + 1] == 10) {//alt Ã§apraz

                        } else {
                            oyunAlaniSayilari[j - 1][i + 1] += 1;
                        }

                    } else {
                        if (oyunAlaniSayilari[j][i - 1] == 10) {//Ã¼st

                        } else {
                            oyunAlaniSayilari[j][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j][i + 1] == 10) {//Ã¼st

                        } else {
                            oyunAlaniSayilari[j][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i - 1] == 10) {//Ã¼st saÄŸ Ã§apraz

                        } else {
                            oyunAlaniSayilari[j + 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i - 1] == 10) {//Ã¼st sol Ã§apraz

                        } else {
                            oyunAlaniSayilari[j - 1][i - 1] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i] == 10) {//sol

                        } else {
                            oyunAlaniSayilari[j - 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i] == 10) {//saÄŸ

                        } else {
                            oyunAlaniSayilari[j + 1][i] += 1;
                        }
                        if (oyunAlaniSayilari[j - 1][i + 1] == 10) {//sol alt kÃ¶ÅŸe

                        } else {
                            oyunAlaniSayilari[j - 1][i + 1] += 1;
                        }
                        if (oyunAlaniSayilari[j + 1][i + 1] == 10) {//saÄŸ alt kÃ¶ÅŸe

                        } else {
                            oyunAlaniSayilari[j + 1][i + 1] += 1;
                        }
                    }
                }
            }
        }

        //oyun taslaÄŸÄ±nÄ± konsola yaz 
        for (int i = 0; i < gelenSutun; i++) {
            for (int j = 0; j < gelenSatır; j++) {
                System.out.print(oyunAlaniSayilari[j][i] + " ");
            }
            System.out.println("");
        }
        System.out.println("***********************");
        for (int i = 0; i < OyunAlani.gelenSatır; i++) {
            for (int j = 0; j < OyunAlani.gelenSutun; j++) {
                labelDizisi[i][j] = new JLabel();
                labelDizisi[i][j].setBounds(15 * i, 15 * j, 15, 15);
                labelDizisi[i][j].setIcon(new ImageIcon(ust));
                jpanel.add(labelDizisi[i][j]);
                labelDizisi[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (sayacBiKezCalıstır) {
                                timerResume();
                                sayacBiKezCalıstır = false;
                            }

                            onMouseClicked(e);
                        } else if (e.getButton() == MouseEvent.BUTTON3) {
                            onMouseClickedflag(e);
                            if (sayacBiKezCalıstır) {
                                timerResume();
                                sayacBiKezCalıstır = false;
                            }

                        }
                    }

                    private void onMouseClicked(MouseEvent e) {
                        for (int i = 0; i < gelenSatır; i++) {
                            for (int j = 0; j < gelenSutun; j++) {
                                if (e.getSource() == labelDizisi[i][j]) {
                                    // System.out.println("Label " +((j*10)+i) + " was clicked");
                                    labelDizisi[i][j].setIcon(null);
                                    acilanKare[i][j] = true;
                                    if (oyunAlaniSayilari[i][j] == 0) {
                                        bosluklariAc(i, j);
                                        // labelDizisi[i][j].setIcon(new ImageIcon(altBosluk));

                                    } else if (oyunAlaniSayilari[i][j] == 10) {
                                        timerStop();
                                        labelDizisi[i][j].setIcon(new ImageIcon(bomba));
                                        MayınTarlası.yeniOyun.setIcon(null);
                                        MayınTarlası.yeniOyun.setIcon(new ImageIcon(deadSmile));
                                        int result = JOptionPane.showConfirmDialog(jpanel, "Ah! You stepped on a mine. Do you want to play again?", "Stepped on a mine!!!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                        if (result == JOptionPane.YES_OPTION) {
                                            jpanel.removeAll();
                                            MayınTarlası.jframe.revalidate();
                                            boyutAl(gelenSatır, gelenSutun, bombaSayısı);
                                            jpanel.repaint();
                                            MayınTarlası.ekranıOrtala();
                                            MayınTarlası.yeniOyun.setIcon(new ImageIcon(MayınTarlası.smile));
                                            MayınTarlası.gecenSure.setText("000");
                                            timerStop();
                                        }
                                        if (result == JOptionPane.NO_OPTION) {
                                            System.exit(0);
                                        }

                                    } else if (oyunAlaniSayilari[i][j] == 1) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda1));
                                    } else if (oyunAlaniSayilari[i][j] == 2) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda2));
                                    } else if (oyunAlaniSayilari[i][j] == 3) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda3));
                                    } else if (oyunAlaniSayilari[i][j] == 4) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda4));
                                    } else if (oyunAlaniSayilari[i][j] == 5) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda5));
                                    } else if (oyunAlaniSayilari[i][j] == 6) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda6));
                                    } else if (oyunAlaniSayilari[i][j] == 7) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda7));
                                    } else if (oyunAlaniSayilari[i][j] == 8) {
                                        labelDizisi[i][j].setIcon(new ImageIcon(yanda8));
                                    } else {
                                        labelDizisi[i][j].setIcon(new ImageIcon(altBosluk));

                                    }

                                }
                                jpanel.revalidate();
                                jpanel.repaint();
                            }
                        }
                        oyunBittiMi();
                    }

                    private void onMouseClickedflag(MouseEvent e) {
                        for (int i = 0; i < gelenSatır; i++) {
                            for (int j = 0; j < gelenSutun; j++) {
                                if (e.getSource() == labelDizisi[i][j]) {
                                    if (acilanKare[i][j] == false) {
                                        if (bayrakVarMı[i][j] == true) {
                                            labelDizisi[i][j].setIcon(null);
                                            labelDizisi[i][j].setIcon(new ImageIcon(ust));
                                            bayrakVarMı[i][j] = false;
                                            MayınTarlası.kalanMayın.setText("00" + bayrakSayısı);
                                        } else if (bayrakSayısı != 0) {
                                            labelDizisi[i][j].setIcon(null);
                                            bayrakSayısı--;
                                            labelDizisi[i][j].setIcon(new ImageIcon(bayrak));
                                            bayrakVarMı[i][j] = true;
                                            MayınTarlası.kalanMayın.setText("00" + bayrakSayısı);
                                        }
                                        System.out.println(bayrakSayısı);
                                    }
                                }
                            }
                        }
                        oyunBittiMi();
                    }

                });
            }
        }

    }

    public void oyunBittiMi() {
        int kacKapaliKareVar = 0;
        for (int i = 0; i < gelenSatır; i++) {
            for (int j = 0; j < gelenSutun; j++) {
                if (acilanKare[i][j] == false) {
                    kacKapaliKareVar++;
                }

            }
        }
        if (bombaSayısı == kacKapaliKareVar) {
            int result = JOptionPane.showConfirmDialog(jpanel, "Congrats! You finished the game. Want to play again?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
          
           // MayÄ±nTarlasÄ±.yeniOyun.setIcon(new ImageIcon(glassessmiley));
            
            if (result == JOptionPane.YES_OPTION) {
                jpanel.removeAll();
                MayınTarlası.jframe.revalidate();
                boyutAl(gelenSatır, gelenSutun, bombaSayısı);
                jpanel.repaint();
                MayınTarlası.ekranıOrtala();
                MayınTarlası.gecenSure.setText("000");
                timerStop();
                
            }
            if (result == JOptionPane.NO_OPTION) {

                System.exit(0);

            }

        }

    }

    public void bosluklariAc(int i, int j) {

        if (i >= 0 && j >= 0 && i < gelenSatır && j < gelenSutun && oyunAlaniSayilari[i][j] == 0 && oyunAlaniSayilari[i][j] != 100 && bayrakVarMı[i][j] == false) {
            oyunAlaniSayilari[i][j] = 100;
            labelDizisi[i][j].setIcon(null);
            labelDizisi[i][j].setIcon(new ImageIcon(altBosluk));

            acilanKare[i][j] = true;

            bosluklariAc(i - 1, j); //left 
            bosluklariAc(i + 1, j); //right 
            bosluklariAc(i, j + 1); //up
            bosluklariAc(i, j - 1); //down
            bosluklariAc(i - 1, j + 1); //up-left
            bosluklariAc(i + 1, j + 1); //up-right
            bosluklariAc(i - 1, j - 1); //down-left
            bosluklariAc(i + 1, j - 1); //down-right

        } else if (i >= 0 && j >= 0 && i < gelenSatır && j < gelenSutun && oyunAlaniSayilari[i][j] < 9 && oyunAlaniSayilari[i][j] > 0 && bayrakVarMı[i][j] == false) {

            labelDizisi[i][j].setIcon(null);

            acilanKare[i][j] = true;

            if (oyunAlaniSayilari[i][j] == 1) {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda1));
            } else if (oyunAlaniSayilari[i][j] == 2) {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda2));
            } else if (oyunAlaniSayilari[i][j] == 3) {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda3));
            } else if (oyunAlaniSayilari[i][j] == 4) {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda4));
            } else if (oyunAlaniSayilari[i][j] == 5) {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda5));
            } else if (oyunAlaniSayilari[i][j] == 6) {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda6));
            } else if (oyunAlaniSayilari[i][j] == 7) {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda7));
            } else {
                labelDizisi[i][j].setIcon(new ImageIcon(yanda8));
            }

        }

    }

    public void boyutAl(int gelenSatır, int gelenSutun, int bombaSayısı) {
        this.bombaSayısı = bombaSayısı;
        OyunAlani.gelenSatır = gelenSatır;
        OyunAlani.gelenSutun = gelenSutun;
        iÅŸlemKontrol();
    }

    public void iÅŸlemKontrol() {
        jpanel.setLayout(null);
        yerlestirJLabel();
        boyutBelirle();

        MayınTarlası.jframe.add(jpanel, BorderLayout.SOUTH);

    }

    public void timerStop() {
        x = 0;
        timerTask.cancel();
//        timer.purge();
    }

    public void timerResume() {

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                MayınTarlası.gecenSure.setText("00" + x);
                x++;
            }
        };
        timer.schedule(timerTask, 0, 1000);

    }

    public void tekSefer() {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {

            }
        };

    }

}
