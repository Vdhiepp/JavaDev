import javax.swing.ImageIcon;
public class XuLyCham extends HinhAnhMauSac {
    boolean phaHuy;
    public XuLyCham(int x, int y) {
        KhoiTaoXuLyCham(x, y);
    }
    public void KhoiTaoXuLyCham(int x, int y) {
        this.x = x;
        this.y = y;
        phaHuy = false;
        loadAnh();
        getCapNhat();
    }
    public void loadAnh() {
        var ii = new ImageIcon("src/resources/brick.png");
        anh = ii.getImage();
    }
    boolean kiemTraPhaHuy() {
        return phaHuy;
    }

    public void setPhaHuy(boolean phaHuy) {
        this.phaHuy = phaHuy;
    }
}
