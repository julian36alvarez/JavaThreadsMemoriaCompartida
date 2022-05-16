package org.example;

public class Player extends Thread {
    int myId;
    Resource resource;

    public Player(Resource resource, int myId) {
        this.myId = myId;
        this.resource = resource;
    }

    public void run() {

        //System.out.println("Player " + myId + " in game");
        resource.toWrite(myId);
        System.out.println("Player " + myId + " has finished");

    }
}

