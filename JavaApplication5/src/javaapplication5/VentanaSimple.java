package org.upao.intro;

import javax.swing.*;
import java.awt.event.*;

public class VentanaSimple {
	
        MiPanel panel;
        boolean gameOver=false;
        int incX =5, incY =5;
        
	public static void main (String [ ] args) {
		new VentanaSimple ().ejecutar();
	}
	
	public void ejecutar() {
		JFrame ventana = new JFrame("Mi ventana");
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.setVisible(true);
                panel = new MiPanel();
                ventana.getContentPane().add(panel);
                ventana.pack();
                ventana.setResizable(false);
                ventana.addKeyListener(new KeyAdapter() { 
                    
                    public void keyTyped(KeyEvent e) {
                        switch(e.getKeyChar()){
                            case 'w':
                                panel.y -=10;
                                break;
                            case 'a':
                                panel.x -=10;
                                break;
                            case 's':
                                panel.y +=10;
                                break;
                            case 'd':
                                panel.x +=10;
                                break;
                            case 'q':
                                panel.diametro +=10;
                                break;
                            case 'e':
                                panel.diametro -=10;
                                break;
                        }
                        panel.repaint();
                        
                    }
                });
                moverContinuamente();
	}
        
        public void moverContinuamente() {
            while (!gameOver) {
                try {
                    Thread.sleep(100);
                }catch (InterruptedException ex) {}
                if(panel.x + panel.diametro > panel.getWidth() || panel.x < 0) {
                    incX*=-1;
                }
                if(panel.y + panel.diametro > panel.getHeight() || panel.y<0) {
                    incY*=-1;
                }
                panel.x +=incX;
                panel.y +=incY;
                panel.repaint();
                
            }
        }
}