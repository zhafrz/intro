
package org.upao.intro;

import javax.swing.*;
import java.awt.*;

public class SnakePanel extends JPanel{
    
    Snake snake;
    int escala;
    
    SnakePanel (Snake snake){
        this.snake= snake ;
        this.escala=escala;
        this.setPreferredSize( 
                new Dimension (snake.ancho * escala ,snake.alto*escala));
        this.setBackground(Color.black);
        this.setOpaque(true);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        for (int i=snake.inicioSnake;i<snake.inicioSnake+snake.longSnake;i++){
            int pos = i % (snake.alto*snake.ancho);
            g.fillOval(
                    snake.snakeX[pos]*escala,
                    snake.snakeY[pos]*escala,
                    escala,escala);
        }
        g.setColor(Color.red);
        g.drawOval(snake.manzanaX*escala,snake.manzanaY*escala,escala,escala);
    }
    
}
