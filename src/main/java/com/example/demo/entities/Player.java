package com.example.demo.entities;

import java.util.List;
import java.util.Stack;
import com.example.demo.dataStructure.Node;

public class Player {
    Node head, tail;
    
    public Playlist playlist;

    public Stack<Node> songStack;


    public Playlist getPlaylist() {
        return playlist;
    }

    public void generateCircularDoublyLinkedList(List<Song> items) {
        head = new Node(items.get(0), null);
        head.next = head;
        head.previous = head;
        tail = head;
        for(int i = 1; i < items.size(); i++) {
            tail.next = new Node(items.get(i), tail);
            tail.next.next = head;
            tail = tail.next;
            head.previous = tail;
        }
    }


    public Player(Playlist playlist) {
        this.playlist = playlist;
        this.songStack = new Stack<>();
        generateCircularDoublyLinkedList(this.playlist.getSongs());
    }

    public Node getHeadOfSongsCDLL() {
        return head;
    }

    public Node getTailOfSongsCDLL() {
        return tail;
    }
}
