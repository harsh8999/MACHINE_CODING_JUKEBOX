package com.example.demo.dataStructure;

import com.example.demo.entities.Song;

public class Node {
    public Song song;
    public Node previous;
    public Node next;

    public Node(Song song, Node previous) {
        this.song = song;
        this.previous = previous;
        this.next = null;
    }

    public Node(Song song, Node previous, Node next) {
        this.song = song;
        this.previous = previous;
        this.next = next;
    }
}
