package org.example;


public class Reader extends Thread{
    int myId;
    Resource resource;

    public Reader(Resource resource, int myId) {
        this.myId = myId;
        this.resource = resource;
    }

    public void run() {
        int i= 0;
        while (i<10){
            System.out.println("Reader " + myId +" wants to read");
            resource.toRead();
            System.out.println("Reader " + myId+ "has finished");
            i++;
        }
    }
}
