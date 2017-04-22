package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Paint extends JFrame implements MouseListener,MouseMotionListener,ActionListener{
    private static JPanel panel;
    private static JMenuBar menuBar;
    private static JMenu menu;
    private static JMenuItem menuItem;
    private Color color;
    
    int p1 ,p2;
    
    public static void main(String[] args) {
        menuItem = new JMenuItem("Choose Color...");
        menu = new JMenu("Options");
        menuBar = new JMenuBar();
        panel = new JPanel();
        
        menu.add(menuItem);
        menuBar.add(menu);        
        
        Paint paint = new Paint();
        paint.setLayout(new BorderLayout());
        paint.add(menuBar,BorderLayout.NORTH);
        paint.add(panel);
        
        menuItem.addActionListener(paint);
        panel.addMouseMotionListener(paint);
        panel.addMouseListener(paint);
        
        paint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paint.setSize(500,500);
        paint.setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.drawLine(p1,p2,me.getX(), me.getY());
        p1 = me.getX();
        p2=me.getY();       
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color chosenColor = JColorChooser.showDialog(this, "Choose Color", Color.white);  
        color = chosenColor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
     
    }

    @Override
    public void mousePressed(MouseEvent e) {
        p1 = e.getX();
        p2 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }    
}
