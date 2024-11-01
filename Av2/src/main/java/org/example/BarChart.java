package org.example;

import javax.swing.*;
import java.awt.*;

class BarChart extends JPanel {
    private final Algorithms algorithms;

    public BarChart(Algorithms algorithms) {
        this.algorithms = algorithms;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int numBars = 4;
        int barWidth = width / (numBars + 1);
        int spacing = (width - numBars * barWidth) / 2;

        // Definir cores
        Color fifoColor = Color.BLUE;
        Color lruColor = Color.GREEN;
        Color clockColor = Color.RED;

        // Obter os resultados de page faults
        int fifoFaults = algorithms.getPageFaultsFifo();
        int lruFaults = algorithms.getPageFaultsLru();
        int clockFaults = algorithms.getPageFaultsClock();
        int optimalFaults = algorithms.getPageFaultsOptimal();

        // Calcular altura máxima
        int maxFaults = Math.max(Math.max(fifoFaults, lruFaults), Math.max(clockFaults, optimalFaults));
        int scalingFactor = (height - 60) / maxFaults;

        // Desenhar barras
        int fifoBarHeight = fifoFaults * scalingFactor;
        g.setColor(fifoColor);
        g.fillRect(spacing, height - fifoBarHeight - 40, barWidth - 10, fifoBarHeight);

        int lruBarHeight = lruFaults * scalingFactor;
        g.setColor(lruColor);
        g.fillRect(spacing + barWidth, height - lruBarHeight - 40, barWidth - 10, lruBarHeight);

        int clockBarHeight = clockFaults * scalingFactor;
        g.setColor(clockColor);
        g.fillRect(spacing + 2 * barWidth, height - clockBarHeight - 40, barWidth - 10, clockBarHeight);

        int optimalBarHeight = optimalFaults * scalingFactor;
        g.setColor(new Color(0x00FFFF));
        g.fillRect(spacing + 3 * barWidth, height - optimalBarHeight - 40, barWidth - 10, optimalBarHeight);

        // Adicionar rótulos
        g.setColor(Color.BLACK);
        g.drawString("FIFO: " + fifoFaults + " faults", spacing, height - 20);
        g.drawString("LRU: " + lruFaults + " faults", spacing + barWidth, height - 20);
        g.drawString("Clock: " + clockFaults + " faults", spacing + 2 * barWidth, height - 20);
        g.drawString("Optimal: " + optimalFaults + " faults", spacing + 3 * barWidth, height - 20);
    }

}
