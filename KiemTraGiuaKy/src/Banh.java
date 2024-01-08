import javax.swing.ImageIcon;
public class Banh extends HinhAnhMauSac{
    int toaDoX;
    int toaDoY;
    public Banh() {
        KhoiTaoBanh();
    }
    public void KhoiTaoBanh() {
        toaDoX = 1;
        toaDoY = -1;
        loadAnh();
        getCapNhat();
        resetBanh();
    }
    public void loadAnh() {
        var ii = new ImageIcon("src/resources/ball.png");
        anh = ii.getImage();
    }
    public void diChuyen() {
        x += toaDoX;
        y += toaDoY;
        if (x == 0)
            setToaDoX(1);
        if (x == OMau.chieuRong - chieuRongAnh){
            System.out.println(chieuRongAnh);
            setToaDoX(-1);
        }
        if (y == 0) {
            setToaDoY(1);
        }
    }
    public void resetBanh() {
        x = OMau.bongX;
        y = OMau.bongY;
    }

    public int getToaDoX() {
        return toaDoX;
    }

    public void setToaDoX(int toaDoX) {
        this.toaDoX = toaDoX;
    }

    public int getToaDoY() {
        return toaDoY;
    }

    public void setToaDoY(int toaDoY) {
        this.toaDoY = toaDoY;
    }
}
