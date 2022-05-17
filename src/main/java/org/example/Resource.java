package org.example;
import java.util.Random;
import java.util.Scanner;
public class Resource {
    int readerNumber;
    int writerNumber;
    boolean thereIsAWriter;
    boolean thereIsAReader;
    boolean playingTurn;
    int[][] arreglo;
    int n;
    int p;
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    Random r = new Random();
    public Resource(int readerNumber, boolean thereIsAWriter, int[][] arreglo,int n, int p) {
        this.readerNumber = readerNumber;
        this.writerNumber = 0;
        this.thereIsAWriter = thereIsAWriter;
        this.arreglo = arreglo;
        this.p =p;
        this.n = n;
        this.thereIsAReader=thereIsAWriter;
    }

     public synchronized void toRead() {
        synchronized (this){
            while((readerNumber > 0) || (writerNumber > 0))
                try {
                    wait();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            readerNumber++;
        }

        synchronized (this){
            readerNumber--;
            if(readerNumber == 0) notifyAll();
        }
    }

     public synchronized void toWrite(int myId){
        synchronized (this){
            while((writerNumber > 0) || (readerNumber > 0)){
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            if(writerNumber == 0){
                System.out.println("Player = " + myId);
                    for ( int i=0; i < n ;i++){
                        for (int j=0;  j<p;j++){
                            if(arreglo[i][j]>0){
                                System.out.print("["+arreglo[i][j]+"]");
                            }
                            else{
                                System.out.print("-+");
                            }
                        }
                        System.out.println();
                    }
                playingTurn  = true;
                while (playingTurn){
                    int nValue = 0 + r.nextInt(p);
                    System.out.println("matrix position in n "+ nValue);
                    int pValue = 0 + r.nextInt(p);
                    System.out.println("matrix position in p "+pValue);
                    playingTurn = rulesOfGame(nValue, pValue, myId+1);
                }
            }
            thereIsAWriter = true;
            writerNumber++;
        }
        synchronized (this){
            writerNumber--;
            if(writerNumber == 0) notifyAll();
        }
    }

    private boolean rulesOfGame(int nValue, int pValue, int idPlayer) {
        boolean continuePlaying = true;
        boolean validateArray = validateArrayD(nValue, pValue);
        if(validateArray){
            if((arreglo[nValue][pValue]==0)){
                arreglo[nValue][pValue] = idPlayer;
                continuePlaying=false;
            }else{
                System.out.println("Movimiento invalido");
            }
        }else{
            System.out.println("Movimiento invalido");
        }
        return continuePlaying;
    }

    private boolean validateArrayD(int nValue, int pValue) {
        boolean validDimension = false;
        if((nValue < n  && pValue < p) && (nValue >=0  && pValue >=0 )){
            validDimension =true;
        }
        return  validDimension;
    }

}

