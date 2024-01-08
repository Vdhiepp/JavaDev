import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GamePlay extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    private boolean play = true;
    private int score = 0; //tính điểm
    private ImageIcon paddleImage;
    private int totalBricks = 50; //số lượng gạch

    private Timer timer;
    private int delay = 8;

    private int playerX = 310; //vị trí của paddle

    private int ballposX = 350; //vị trí của quả bóng
    private int ballposY = 520;
    private int ballXdir = -2; //hướng di chuyển của bóng
    private int ballYdir = -3;

    private MapGenerator map;
    private boolean mousePressed = false; // xem chuột có được nhấn hay không


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        // Kiểm tra chuột có được nhấn trên paddle không
        if (mouseX >= playerX && mouseX <= playerX + 100 && mouseY >= 550 && mouseY <= 562) {
            mousePressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mousePressed) {
            playerX = e.getX() - 50; // đặt vị trí paddle theo vị trí của chuột
            if (playerX < 0) {
                playerX = 0;
            } else if (playerX > 600) {
                playerX = 600;
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public GamePlay() {
        map = new MapGenerator(5, 10);
        paddleImage = new ImageIcon("src/resources/paddle.png");
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {

        //background color
        g.setColor(new Color(230, 230, 250));
        g.fillRect(1, 1, 692, 592);

        map.draw((Graphics2D)g);

        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        Image paddleImg = paddleImage.getImage();
        g.drawImage(paddleImg, playerX, 550, 100, 12, null);

        g.setColor(Color.BLUE);  // ball color
        g.fillOval(ballposX, ballposY, 20, 20);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 520, 30);


        if (totalBricks <= 0) { // nếu tất cả các viên gạch bị phá hủy thì bạn thắng
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 30));
            g.drawString("You Won, Score: " + score, 190, 300);

            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press Enter to Restart.", 230, 350);
        }

        if(ballposY > 570) { // nếu bóng rơi xuống dưới paddle thì bạn thua
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 30));
            g.drawString("Game Over, Score: " + score, 190, 300);

            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press Enter to Restart", 230, 350);

        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        timer.start();
        if(play) {
            // kiểm tra xem quả bóng có va chạm với paddle nếu có, bóng sẽ đi lên
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYdir = - ballYdir;
            }
            for( int i = 0; i<map.map.length; i++) {
                for(int j = 0; j<map.map[0].length; j++) {  // map.map[0].length là số cột
                    //kiểm tra va chạm bóng với gạch tại vị trí (i, j) lớn hơn 0 là có gạch ở đó
                    if(map.map[i][j] > 0) {
                        int brickX = j*map.brickWidth + 80;
                        int brickY = i*map.brickHeight + 50;
                        //lấy kích thước của gạch từ MapGenerator
                        int brickWidth= map.brickWidth;
                        int brickHeight = map.brickHeight;

                        //tạo đối tượng Rectangle đại diện cho gạch
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        //tạo đối tượng Rectangle đại diện cho bóng
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20,20);
                        Rectangle brickRect = rect;

                        //kiểm tra xem Rectangle của bóng có chạm với Rectangle của gạch ko
                        if(ballRect.intersects(brickRect) ) {
                            map.setBrickValue(0, i, j);//nếu có chạm, đặt giá trị của ô gạch là 0
                            totalBricks--;//giảm số lượng gạch
                            score+=5;//tăng điểm
                            //kiểm tra xem bóng chạm vào cạnh trái, phải của gạch ko
                            if(ballposX + 19 <= brickRect.x || ballposX +1 >= brickRect.x + brickRect.width)
                                ballXdir = -ballXdir;
                            else {
                                ballYdir = -ballYdir;
                            }
                        }

                    }

                }
            }

            ballposX += ballXdir;
            ballposY += ballYdir;
            if(ballposX < 0) { // nếu quả bóng chạm vào bức tường bên trái thì nó sẽ bật ngược trở lại
                ballXdir = -ballXdir;
            }
            if(ballposY < 0) {  // nếu quả bóng chạm vào bức tường trên thì nó sẽ bật ngược trở lại
                ballYdir = -ballYdir;
            }
            if(ballposX > 670) { // nếu quả bóng chạm vào bức tường bên phải thì nó sẽ bật ngược trở lại
                ballXdir = -ballXdir;
            }
        }
        repaint(); //thông báo cho Java Swing rằng JPanel cần được vẽ lại
    }


    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) { // nếu nhấn phím mũi tên phải thì paddle sẽ di chuyển sang phải
            if(playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();

            }
        }
        if(arg0.getKeyCode() == KeyEvent.VK_LEFT) { // nếu nhấn phím mũi tên trái thì paddle sẽ di chuyển sang trái
            if(playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();

            }
        }

        if(arg0.getKeyCode() == KeyEvent.VK_ENTER) { // nếu nhấn phím enter thì trò chơi sẽ khởi động lại
            if(!play) {
                play = true;
                ballposX = 350;
                ballposY = 520;
                ballXdir = -2;
                ballYdir = -3;
                score = 0;
                totalBricks = 50;
                map = new MapGenerator(5,10);

                repaint();
            }
        }

    }
    public void moveRight() { // paddle di chuyển sang phải 50 pixel
        play = true;
        playerX += 50;
    }
    public void moveLeft() { // paddle di chuyển sang trái 50 pixel
        play = true;
        playerX -= 50;
    }



    @Override
    public void keyReleased(KeyEvent arg0) {

    }


}