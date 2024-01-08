import javax.swing.JFrame;
import java.awt.EventQueue;

public class MainBreak extends JFrame {
    public MainBreak() {

        initUI();
    }

    private void initUI() {

        add(new Board());
        setTitle("Breakout");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new MainBreak();
            game.setVisible(true);
        });
    }
}
