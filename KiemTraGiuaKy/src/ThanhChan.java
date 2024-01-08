import javax.swing.*;
import java.awt.event.KeyEvent;

public class ThanhChan extends HinhAnhMauSac{
    int diChuyenNgang;
    public ThanhChan() {
        KhoiTaoThanhChan();
    }
    public void KhoiTaoThanhChan() {
        loadAnh();
        getCapNhat();
        resetThanhChan();
    }
    public void loadAnh() {
        var ii = new ImageIcon("src/resources/paddle.png");
        anh = ii.getImage();
    }
    public void diChuyen() {
        x += diChuyenNgang;
        if (x <= 0)
            x = 0;
        if (x >= OMau.chieuRong - chieuRongAnh)
            x = OMau.chieuRong - chieuRongAnh;
    }
    public void phimNhan(KeyEvent event){
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            diChuyenNgang = -1;
        if (key == KeyEvent.VK_RIGHT)
            diChuyenNgang = 1;
    }
    public void phimTha(KeyEvent event){
        int key = event.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            diChuyenNgang = 0;
        if (key == KeyEvent.VK_RIGHT)
            diChuyenNgang = 0;
    }
    public void resetThanhChan(){
        x = OMau.thanhChanX;
        y = OMau.thanhChanY;
    }
}
