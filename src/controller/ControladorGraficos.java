package controller;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ControladorGraficos {
    
    private JPanel panelGraficos;
    
    public ControladorGraficos(JPanel panel){
        this.panelGraficos = panel;
    }
    
    private void actualizarGraficoBarras(
            int votosProductoA, String nombreProductoA, 
            int votosProductoB, String nombreProductoB,
            int votosProductoC, String nombreProductoC){
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(votosProductoA, "Producto A", nombreProductoA);
        dataset.addValue(votosProductoB, "Producto B", nombreProductoB);
        dataset.addValue(votosProductoC, "Producto C", nombreProductoC);
        
        JFreeChart grafico = ChartFactory.createBarChart("", "Productos", "Votos", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        agregarPanel(grafico);        
    }
    
    private void actualizarGraficoPastel(
            int votosProductoA, String nombreProductoA, 
            int votosProductoB, String nombreProductoB,
            int votosProductoC, String nombreProductoC){
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(nombreProductoA, votosProductoA);
        dataset.setValue(nombreProductoB, votosProductoB);
        dataset.setValue(nombreProductoC, votosProductoC);
        
        JFreeChart grafico = ChartFactory.createPieChart(" ", dataset, true, true, false);
        
        agregarPanel(grafico);
    }
    
    private void agregarPanel(JFreeChart grafico){
        ChartPanel contenedorGrafico;
        contenedorGrafico = new ChartPanel(grafico);
        contenedorGrafico.setSize(400, 300);
        contenedorGrafico.setVisible(true);
        //contenedorGraficoPastel.updateUI();
        panelGraficos.add(contenedorGrafico);
        contenedorGrafico.updateUI();
    }
    
    public void actualizarGraficos(
            int votosProductoA, String nombreProductoA, 
            int votosProductoB, String nombreProductoB,
            int votosProductoC, String nombreProductoC){
        
        panelGraficos.removeAll();
        actualizarGraficoBarras(votosProductoA, nombreProductoA, votosProductoB, nombreProductoB, votosProductoC, nombreProductoC);
        actualizarGraficoPastel(votosProductoA, nombreProductoA, votosProductoB, nombreProductoB, votosProductoC, nombreProductoC);
        panelGraficos.setVisible(true);
        panelGraficos.updateUI();
    }   
    
    public JPanel getPanelGraficos(){
        return this.panelGraficos;
    }   
    
}
