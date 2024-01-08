import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GamePlay extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    private boolean play = true;
    private int score = 0;
    private ImageIcon paddleImage;
    private int totalBricks = 50;

    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballposX = 350;
    private int ballposY = 520;
    private int ballXdir = -2;
    private int ballYdir = -3;

    private MapGenerator map;
    private boolean mousePressed = false;


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        // Kiểm tra xem chuột có được nhấn trên thanh trượt không
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
            playerX = e.getX() - 50; // Đặt vị trí thanh trượt theo vị trí của chuột
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
            // Ball - Pedal  interaction
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYdir = - ballYdir;
            }
            for( int i = 0; i<map.map.length; i++) { // Ball - Brick interaction
                for(int j = 0; j<map.map[0].length; j++) {  // map.map[0].length is the number of columns
                    if(map.map[i][j] > 0) {
                        int brickX = j*map.brickWidth + 80;
                        int brickY = i*map.brickHeight + 50;
                        int brickWidth= map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20,20);
                        Rectangle brickRect = rect;

                        if(ballRect.intersects(brickRect) ) {
                            map.setBrickValue(0, i, j);
                            totalBricks--;
                            score+=5;

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


        repaint();

    }


    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) { // if right arrow key is pressed then paddle moves right
            if(playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();

            }
        }
        if(arg0.getKeyCode() == KeyEvent.VK_LEFT) { // if left arrow key is pressed then paddle moves left
            if(playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();

            }
        }

        if(arg0.getKeyCode() == KeyEvent.VK_ENTER) { // if enter key is pressed then game restarts
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
    public void moveRight() { // paddle moves right by 50 pixels
        play = true;
        playerX += 50;
    }
    public void moveLeft() { // paddle moves left by 50 pixels
        play = true;
        playerX -= 50;
    }



    @Override
    public void keyReleased(KeyEvent arg0) {

    }


}