package org.example;

public class Resource {
    int readerNumber;
    boolean thereIsAWriter;

    public Resource(int readerNumber, boolean thereIsAWriter) {
        this.readerNumber = readerNumber;
        this.thereIsAWriter = thereIsAWriter;
    }

    public void toRead() {
        synchronized (this){
            while(thereIsAWriter)
                try {
                    wait();
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            readerNumber++;
        }
        //reading is not synchronized to allow concurrency
        synchronized (this){
            readerNumber--;
            if(readerNumber == 0) notifyAll();
        }
    }

    synchronized public void toWrite(){
        synchronized (this){
            while(thereIsAWriter || (readerNumber > 0))
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            thereIsAWriter = true;
        }
        synchronized (this){
            thereIsAWriter =false;
            notifyAll();
        }
    }



    //
}
