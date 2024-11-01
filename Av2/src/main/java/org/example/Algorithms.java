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

    // Lógica do algoritmo relógio
    public int clock() {
        LinkedList<Integer> memory = new LinkedList<>();
        LinkedList<Integer> bits = new LinkedList<>();
        int pageFaults = 0;
        int bitOne = 1;
        int bitZero = 0;
        int pointer = 0;

        for (int page : pages) {
            if (!memory.contains(page)) {
                if (memory.size() == frames) {
                    while (true) {
                        if (pointer == frames) {
                            pointer = 0;
                        }
                        if (bits.get(pointer) == bitOne) {
                            bits.set(pointer, bitZero);
                            pointer++;
                        } else {
                            memory.set(pointer, page);
                            bits.set(pointer, bitOne);
                            pageFaults++;
                            pointer++;
                            break;
                        }
                    }
                } else {
                    memory.add(page);
                    bits.add(bitOne);
                    pageFaults++;
                }
            } else {
                int index = memory.indexOf(page);
                bits.set(index, bitOne);
            }
        }
        return pageFaults;
    }

    public int optimal() {
        int[] fr = new int[frames];
        int hit = 0;
        int index = 0;
        for (int i = 0; i < pages.length; i++) {
            if (search(pages[i], fr)) {
                hit++;
                continue;
            }
            if (index < frames)
                fr[index++] = pages[i];
            else {
                int j = predict(pages, fr, pages.length, i + 1);
                fr[j] = pages[i];
            }
        }
        return pages.length - hit;
    }

    static boolean search(int key, int[] fr) {
        for (int i = 0; i < fr.length; i++)
            if (fr[i] == key)
                return true;
        return false;
    }

    static int predict(int pg[], int[] fr, int pn, int index) {
        int res = -1, farthest = index;
        for (int i = 0; i < fr.length; i++) {
            int j;
            for (j = index; j < pn; j++) {
                if (fr[i] == pg[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }
            if (j == pn)
                return i;
        }
        return (res == -1) ? 0 : res;
    }


    public int getPageFaultsFifo() {
        return fifo();
    }

    public int getPageFaultsLru() {
        return lru();
    }

    public int getPageFaultsClock() {
        return clock();
    }

    public int getPageFaultsOptimal() {
        return optimal();
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
        sb.append("CLOCK PageFaults: ").append(clock()).append("\n");
        sb.append("Optimal PageFaults: ").append(optimal()).append("\n");
        return sb.toString();
    }
}


