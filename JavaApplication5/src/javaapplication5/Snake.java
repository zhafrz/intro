package org.upao.intro;

public class Snake {
    
    final int ARRIBA=0;
    final int ABAJO=1;
    final int DERECHA=2;
    final int IZQUIERDA=3;
    
    int inicioSnake;
    int longSnake;
    int ancho, alto;
    int[ ] snakeX;
    int[ ] snakeY;
    int direccion;
    int manzanaX,manzanaY;
    boolean pierde = false;
    
    Snake(int ancho,int alto) {
        this.ancho=ancho;
        this.alto=alto;
        snakeX = new int [ancho*alto];
        snakeY = new int [ancho*alto];
    
    }
    
    void inicializar (){
        inicioSnake = 0;
        longSnake =4;
        //Cola de la serpiente
        snakeX[inicioSnake] =1;
        snakeY[inicioSnake] =1;
        snakeX[inicioSnake+1] =2;
        snakeY[inicioSnake+1] =1;
        snakeX[inicioSnake+2] =3;
        snakeY[inicioSnake+2] =1;
        //cabeza de la serpiente
        snakeX[inicioSnake+3] =4;
        snakeY[inicioSnake+3] =1;
        //Direccion inicial
        direccion = DERECHA;
        pierde=false;
    }
    
    void mover (){
        int cabezaAnterior = inicioSnake+longSnake-1;
        int cabeza =inicioSnake+longSnake;
        switch(direccion){
            case DERECHA:
                snakeX[cabeza]=snakeX [cabezaAnterior]+1;
                snakeY[cabeza]=snakeY [cabezaAnterior];
                break;
            case IZQUIERDA:
                snakeX[cabeza]=snakeX [cabezaAnterior]-1;
                snakeY[cabeza]=snakeY [cabezaAnterior];
                break;
            case ARRIBA:
                snakeX[cabeza]=snakeX [cabezaAnterior];
                snakeY[cabeza]=snakeY [cabezaAnterior]-1;
                break;
            case ABAJO:
                snakeX[cabeza]=snakeX [cabezaAnterior];
                snakeY[cabeza]=snakeY [cabezaAnterior]+1;
                break;
        }
        if ( snakeX[cabeza]==manzanaX&&snakeY[cabeza]==manzanaY) {
            longSnake ++;
        }else {
            inicioSnake++;
            inicioSnake= inicioSnake%(alto*ancho);
        }
    }
    void irDerecha() {
        if(direccion!=IZQUIERDA) {
            direccion =DERECHA;
        }
    }
    void irIzquierda() {
        if(direccion!=DERECHA) {
                    direccion =DERECHA;
        }
    }
    void irArriba() {
        if(direccion!=ABAJO) {
            direccion=ARRIBA;
        }
    }
    void irAbajo() {
        if(direccion!=ARRIBA) {
            direccion=ABAJO;
        }
    }
    void verificacionObstaculos() {
        int cabeza=inicioSnake+longSnake-1;
        cabeza = cabeza % (alto*ancho);
        for (int i = inicioSnake; i <inicioSnake+longSnake-1;i++) {
            int pos = i%(alto*ancho);
            if (snakeX[cabeza]== snakeX[pos]&&snakeY[cabeza]==snakeY[pos]) {
               pierde = true;
               break;
            }
            
        }
    }
    void generarManzana() {
        boolean valido = true;
        do {
            manzanaX = (int) (Math.random()*ancho);
            manzanaY = (int) (Math.random()*alto);
            for (int i = inicioSnake ; i < inicioSnake + longSnake ; i++) {
                if (manzanaX==snakeX[i] && manzanaY==snakeY[i]) {
                    valido = false ;
                    break ;
                }
            }
        }while(!valido);
    }
    
}
