import javax.swing.*;
import java.awt.*;

class MapGenerator {
    public int map [][];
    public int brickWidth;
    public int brickHeight;
    private ImageIcon brickImage;

    public MapGenerator(int row, int col) {
        map = new int [row][col];
        brickImage = new ImageIcon("src/resources/brick.png");
        for (int i = 0; i < map.length; i++) {
            for (int j=0; j< map[0].length;j++) {
                map[i][j] = 1;
            }
        }
        // độ rộng cao của mỗi viên gạch tính theo pixel
        brickWidth = 540/col;
        brickHeight = 150/row;
    }

    // vẽ những viên gạch
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j=0; j< map[0].length;j++) {
                if(map[i][j] > 0) {
                    Image img = brickImage.getImage();
                    g.drawImage(img, j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight, null);
                }
            }

        }
    }

    // đặt giá trị của viên gạch thành 0 nếu nó bị bóng đụng vào
    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }
}