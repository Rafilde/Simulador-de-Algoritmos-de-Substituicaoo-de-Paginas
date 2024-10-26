package org.example;

import javax.swing.*;
import java.awt.*;

public class BarChart extends JPanel {
    private final Algorithms algorithms;

    public BarChart(Algorithms algorithms) {
        this.algorithms = algorithms;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / 4;

        // Definir cores
        Color fifoColor = Color.BLUE;
        Color lruColor = Color.GREEN;

        // Obter os resultados de page faults
        int fifoFaults = algorithms.getPageFaultsFifo();
        int lruFaults = algorithms.getPageFaultsLru();

        // Calcular altura máxima
        int maxFaults = Math.max(fifoFaults, lruFaults);
        int scalingFactor = (height - 60) / maxFaults;

        // Desenhar barra FIFO
        int fifoBarHeight = fifoFaults * scalingFactor;
        g.setColor(fifoColor);
        g.fillRect(50, height - fifoBarHeight - 40, barWidth - 10, fifoBarHeight);

        // Desenhar barra LRU
        int lruBarHeight = lruFaults * scalingFactor;
        g.setColor(lruColor);
        g.fillRect(50 + barWidth, height - lruBarHeight - 40, barWidth - 10, lruBarHeight);

        // Adicionar rótulos
        g.setColor(Color.BLACK);
        g.drawString("FIFO: " + fifoFaults + " faults", 50, height - 20);
        g.drawString("LRU: " + lruFaults + " faults", 50 + barWidth, height - 20);
    }
}
