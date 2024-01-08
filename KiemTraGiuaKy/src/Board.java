import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel {
    Timer timer;
    String thongBao = "Game Over";
    Banh banh;
    ThanhChan thanhChan;
    XuLyCham[] xuLyCham;
    boolean inGame = true;

    public Board() {
        KhoiTaoBoard();
    }

    public void KhoiTaoBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(OMau.chieuRong, OMau.chieuCao));

        gameInit();
    }

    private void gameInit() {

        xuLyCham = new XuLyCham[OMau.soOMau];

        banh = new Banh();
        thanhChan = new ThanhChan();

        int k = 0;

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 6; j++) {

                xuLyCham[k] = new XuLyCham(j * 40 + 30, i * 10 + 50);
                k++;
            }
        }

        timer = new Timer(OMau.capNhat, new GameCycle());
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        if (inGame) {

            drawObjects(g2d);
        } else {

            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {

        g2d.drawImage(banh.getAnh(), banh.getX(), banh.getY(),
                banh.getChieuRongAnh(), banh.getChieuCaoAnh(), this);
        g2d.drawImage(thanhChan.getAnh(), thanhChan.getX(), thanhChan.getY(),
                thanhChan.getChieuRongAnh(), thanhChan.getChieuCaoAnh(), this);

        for (int i = 0; i < OMau.soOMau; i++) {

            if (!xuLyCham[i].kiemTraPhaHuy()) {

                g2d.drawImage(xuLyCham[i].getAnh(), xuLyCham[i].getX(),
                        xuLyCham[i].getY(), xuLyCham[i].getChieuRongAnh(),
                        xuLyCham[i].getChieuCaoAnh(), this);
            }
        }
    }

    private void gameFinished(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(thongBao,
                (OMau.chieuRong - fontMetrics.stringWidth(thongBao)) / 2,
                OMau.chieuRong / 2);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            thanhChan.phimTha(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            thanhChan.phimNhan(e);
        }
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private void doGameCycle() {

        banh.diChuyen();
        thanhChan.diChuyen();
        checkCollision();
        repaint();
    }

    private void stopGame() {

        inGame = false;
        timer.stop();
    }

    private void checkCollision() {

        if (banh.getRect().getMaxY() > OMau.riaDuoi) {

            stopGame();
        }

        for (int i = 0, j = 0; i < OMau.soOMau; i++) {

            if (xuLyCham[i].kiemTraPhaHuy()) {

                j++;
            }

            if (j == OMau.soOMau) {

                thongBao = "Victory";
                stopGame();
            }
        }

        if ((banh.getRect()).intersects(thanhChan.getRect())) {

            int paddleLPos = (int) thanhChan.getRect().getMinX();
            int ballLPos = (int) banh.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {

                banh.setToaDoX(-1);
                banh.setToaDoY(-1);
            }

            if (ballLPos >= first && ballLPos < second) {

                banh.setToaDoX(-1);
                banh.setToaDoY(-1 * banh.getToaDoY());
            }

            if (ballLPos >= second && ballLPos < third) {

                banh.setToaDoX(0);
                banh.setToaDoY(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {

                banh.setToaDoX(1);
                banh.setToaDoY(-1 * banh.getToaDoY());
            }

            if (ballLPos > fourth) {

                banh.setToaDoX(1);
                banh.setToaDoY(-1);
            }
        }

        for (int i = 0; i < OMau.soOMau; i++) {

            if ((banh.getRect()).intersects(xuLyCham[i].getRect())) {

                int ballLeft = (int) banh.getRect().getMinX();
                int ballHeight = (int) banh.getRect().getHeight();
                int ballWidth = (int) banh.getRect().getWidth();
                int ballTop = (int) banh.getRect().getMinY();

                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
                var pointLeft = new Point(ballLeft - 1, ballTop);
                var pointTop = new Point(ballLeft, ballTop - 1);
                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

                if (!xuLyCham[i].kiemTraPhaHuy()) {

                    if (xuLyCham[i].getRect().contains(pointRight)) {

                        banh.setToaDoX(-1);
                    } else if (xuLyCham[i].getRect().contains(pointLeft)) {

                        banh.setToaDoX(1);
                    }

                    if (xuLyCham[i].getRect().contains(pointTop)) {

                        banh.setToaDoY(1);
                    } else if (xuLyCham[i].getRect().contains(pointBottom)) {

                        banh.setToaDoY(-1);
                    }

                    xuLyCham[i].setPhaHuy(true);
                }
            }
        }
    }
}
