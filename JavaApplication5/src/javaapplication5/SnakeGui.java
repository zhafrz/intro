package org.upao.intro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

    
public class SnakeGui extends JFrame {
    
    Snake snake;
    SnakePanel panel;
    public static void main(String[] args) {
        new SnakeGui().ejecutar();
    }
    void ejecutar () {
        snake = new Snake  (10,10);
        panel = new SnakePanel(snake,60);
        final boolean pausa = true;
        this.setTitle("Snake INSO");
        this.getContentPane().add(panel);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(new KeyAdapter() { 
                    
                    public void keyTyped(KeyEvent e) {
                        switch(e.getKeyChar()){
                            case 'w':snake.irArriba();
                                break;
                            case 'a':snake.irIzquierda();
                                break;
                            case 's':snake.irAbajo();
                                break;
                            case 'd':snake.irDerecha();
                                break;
                            case 'q':;
                                break;
                            case 'p':
                                pausa =!pausa;
                                break;
                        }
                        panel.repaint();
                        
                    }
                });
                iniciarJuego();
	}

       void iniciarJuego(boolean pausa, boolean gameOver) {
        snake.inicializar();
        while(!gameOver){
            try {
                while(pausa){
                    Thread.sleep(10);
                }
                Thread.sleep(150);
            } catch (InterruptedException ex) {
            }
            snake.mover();
            panel.repaint();
        }
    }

        
        
}

