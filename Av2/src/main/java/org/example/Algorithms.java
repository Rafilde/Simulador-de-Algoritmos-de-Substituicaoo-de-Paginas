package org.example;

import java.util.LinkedList;

public class Algorithms {
    int[] pages;
    int frames;

    public Algorithms(int[] pages, int frames) {
        this.pages = pages;
        this.frames = frames;
    }

    //Lógica do algoritmo fifo
    public int fifo() {
        LinkedList<Integer> memory = new LinkedList<>();
        int pageFaults = 0;

        for(int page : pages) {
            if (!memory.contains(page)) {
                if(memory.size() == frames) {
                    memory.poll();
                }
                memory.add(page);
                pageFaults++;
            }
        }

        return pageFaults ;
    }

    // Lógica do algoritmo lru
    public int lru() {
        LinkedList<Integer> memory = new LinkedList<>();
        int pageFaults = 0;

        for (int page : pages) {
            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    memory.poll();
                }
                memory.add(page);
                pageFaults++;
            } else {
                memory.remove((Integer) page);
                memory.add(page);
            }
        }
        return pageFaults;
    }

    public int getPageFaultsFifo() {
        return fifo();
    }

    public int getPageFaultsLru() {
        return lru();
    }

    //visualizar pelo terminal
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        sb.append("Algorithms Details:\n");
        sb.append("Pages: ");
        for (int page : pages) {
            sb.append(page);
            count++;
            if (count != pages.length) {
                sb.append("-");
            }
        }
        sb.append("\nFrames: ").append(frames).append("\n");
        sb.append("FIFO PageFaults: ").append(fifo()).append("\n");
        sb.append("LRU PageFaults: ").append(lru()).append("\n");
        return sb.toString();
    }
}

