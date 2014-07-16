/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
class SampleFrame extends Frame
  {
  SampleFrame(String title){
      super(title);
      MyWindowAdapter adapter=new MyWindowAdapter(this);
      addWindowListener(adapter);
  }
  }
class MyWindowAdapter extends WindowAdapter{
    SampleFrame s;
    public MyWindowAdapter(SampleFrame e){
        this.s=e;
    }
    
  //  @Override
   // public void windowClosing(WindowEvent we){
  //      s.setVisible(false);
  //  }

    @Override
    public void windowStateChanged(WindowEvent e) {
        super.windowStateChanged(e);
        s.repaint();
    }
    
}

public class DrawtestSwing extends JApplet implements ActionListener{
     Frame f;
    Graphics gg;
    Line l1;
    Point1 p1;
    Rect r1;
    Erase pen1;
    int width,height;
    JButton b[]=new JButton[12];
    Cursor c;
    JLabel a=new JLabel();
    JLabel l=new JLabel();
    
    @Override
    public void init(){      
        f=new SampleFrame("Paint Canvas");      
        f.setType(Window.Type.UTILITY);
        f.setLocation(500,100);
        f.setSize(500,500);       
        width=f.getWidth();
        height=f.getHeight();
        f.setVisible(true);
        gg= f.getGraphics();
        gg.setColor( Color.white );
        gg.fillRect( 0, 0, width, height );
        gg.setColor( Color.black );
        l1=new Line(gg);
        p1=new Point1(gg);
        r1=new Rect(gg);
        pen1=new Erase(gg);
        
        setSize(300,500);
        Container pane=getContentPane();
        pane.setLayout(new GridLayout(7,2));
        pane.setSize(100,300);
        pane.setVisible(true);
        pane.setBackground(Color.LIGHT_GRAY);
        for(int i=0;i<12;i++){
            b[i]=new JButton();
           b[i].addActionListener(this);
            b[i].setActionCommand(i+"");
            b[i].setDoubleBuffered(true);
            pane.add(b[i]);
        }
        b[0].setText("Get Applet Info.");
        b[1].setText("Get Frame Info.");
        b[2].setText("Clear Screen");
        b[3].setText("Colour: Red");
        b[4].setText("Colour: Green");
        b[5].setText("Colour: Black");
        b[6].setText("Increase Window Size");
        b[7].setText("Decrease Window Size");
        b[8].setText("LINE");
        b[9].setText("POINT");
        b[10].setText("RECTANGLE");
        b[11].setText("ERASE");
        for(int i=0;i<12;i++){            
        
        }  
        b[10].setActionCommand("r");
        b[11].setActionCommand("p");
        b[11].setDoubleBuffered(true);
        l.setVisible(true);
        l.setText("Information:");
        pane.add(l);
        pane.add(a);
        Toolkit t=Toolkit.getDefaultToolkit();
        Image im=t.getImage("E://cur.gif");
               c=t.createCustomCursor(im,new Point(getX(),getY()), "img");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String ac=e.getActionCommand();
         f.setCursor(Cursor.CROSSHAIR_CURSOR);
       switch(ac.charAt(0)){
           case '0':
               a.setText(getName());          
               break;
           case '1':
               a.setText(f.getTitle()+"  "+f.getName());
               break;
           case '2':
               gg.clearRect(0,0, width, height);
               break;
           case '3':
               gg.setColor(Color.red);
               break;
           case '4':
               gg.setColor(Color.green);
               break;
           case '5':
               gg.setColor(Color.black);
               break;
           case '6':
               f.setSize(f.getWidth()+10,f.getHeight()+10);
               break;
           case '7':
               f.setSize(f.getWidth()-10,f.getHeight()-10);
               break;
           case '8':
               f.removeMouseMotionListener(pen1);
               f.removeMouseListener(r1);
               f.removeMouseListener(p1);
               f.addMouseListener(l1);
               break;
           case '9':
               f.removeMouseMotionListener(pen1);
               f.removeMouseListener(r1);
               f.removeMouseListener(l1);
               f.addMouseListener(p1);
               break;
           case 'r':  
               f.removeMouseMotionListener(pen1);
               f.removeMouseListener(l1);
               f.addMouseListener(r1);
               break;
           case 'p':
               f.setCursor(c);
               f.removeMouseListener(l1);
               f.removeMouseListener(p1);
               f.removeMouseListener(r1);
               f.addMouseMotionListener(pen1);
       }
        // throw new UnsupportedOperationException("Not supported yet.");
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
class Line extends Applet implements MouseListener{
    Point start=new Point();
    Graphics gg;
    Line(Graphics gg){
        this.gg=gg;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        start.x=e.getX();
        start.y=e.getY();
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gg.drawLine(start.x,start.y,e.getX(),e.getY());
        repaint();
        e.consume();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
class Point1 extends Applet implements MouseListener{
    Point start=new Point();
    Graphics gg;
    Point1(Graphics gg){
        this.gg=gg;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        gg.fillOval(e.getX(),e.getY(),2,2);
        repaint();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
class Rect extends Applet implements MouseListener{
    Point start=new Point();
    Graphics gg;
    Rect(Graphics gg){
        this.gg=gg;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        start.x=e.getX();
        start.y=e.getY();
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gg.drawLine(start.x,start.y,start.x,e.getY());
        gg.drawLine(start.x,start.y,e.getX(),start.y);
        gg.drawLine(e.getX(),e.getY(),e.getX(),start.y);
        gg.drawLine(e.getX(),e.getY(),start.x,e.getY());
        repaint();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

class Erase extends Applet implements MouseMotionListener{
    Point xy=new Point();
    Graphics gg; 
    Erase(Graphics gg){
        this.gg=gg;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        Color x=gg.getColor();
        gg.setColor(Color.white);
        gg.fillOval(e.getX()-3,e.getY()-3,30,30);
        gg.setColor(x);       
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xy.x=e.getX();
        xy.y=e.getY();
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
