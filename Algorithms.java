import java.util.LinkedList;

public class Algorithms {
    int[] pages;
    int frames;

    public Algorithms(int[] pages, int frames) {
        this.pages = pages;
        this.frames = frames;
    }

    public int fifo() {
        LinkedList<Integer> memory = new LinkedList<>();
        int pageFaults  = 0;

        for(int page : pages) {
            if (!memory.contains(page)) {
                if(memory.size() == frames) {
                    memory.poll();
                }
                memory.add(page);
                pageFaults ++;
            }
        }

        return pageFaults ;
    }

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
        return sb.toString();
    }
}
