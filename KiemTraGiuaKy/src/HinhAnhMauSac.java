import java.awt.Image;
import java.awt.Rectangle;
public class HinhAnhMauSac {
    int x;
    int y;
    int chieuRongAnh;
    int chieuCaoAnh;
    Image anh;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getChieuRongAnh() {
        return chieuRongAnh;
    }

    public void setChieuRongAnh(int chieuRongAnh) {
        this.chieuRongAnh = chieuRongAnh;
    }

    public int getChieuCaoAnh() {
        return chieuCaoAnh;
    }

    public void setChieuCaoAnh(int chieuCaoAnh) {
        this.chieuCaoAnh = chieuCaoAnh;
    }

    public Image getAnh() {
        return anh;
    }

    public void setAnh(Image anh) {
        this.anh = anh;
    }

    Rectangle getRect() {
        return new  Rectangle(x, y, anh.getWidth(null), anh.getHeight(null));
    }
    public void getCapNhat() {
        chieuRongAnh = anh.getWidth(null);
        chieuCaoAnh = anh.getHeight(null);
    }
}
