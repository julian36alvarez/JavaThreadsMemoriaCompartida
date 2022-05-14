package org.example;

public class Player extends Thread{
    int myId;
    Resource resource;

    public Player(Resource resource, int myId){
        this.myId = myId;
        this.resource = resource;
    }
    public void run(){
        int i=0;
        while (1<10){
            System.out.println("Player " + myId +" in game");
            resource.toWrite();
            System.out.println("Player "+ myId + "has finished");
            i++;
        }
    }
}
