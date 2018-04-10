package org.labseni;
import java.awt.Color;
import java.awt.BasicStroke;
import javax.swing.JFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ui.UIUtils; //perubahan dari refinerry utilities
import java.io.File;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class SimCantik {
	public SimCantik()
	{
		
	
	}
	private class ngeplotFrame extends ApplicationFrame
	{
		public ngeplotFrame(String JudulFrame, String JudulPlot)
		{
			super(JudulFrame);
			JFreeChart ChartGarisXY = ChartFactory.createXYLineChart(JudulPlot, "Category", "Score", createDataset(), PlotOrientation.VERTICAL, true, true, false);
			ChartPanel plotPanel = new ChartPanel(ChartGarisXY);
			plotPanel.setPreferredSize(new java.awt.Dimension(560, 367));
			final XYPlot plot = ChartGarisXY.getXYPlot();
			XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
			renderer.setSeriesPaint(0, Color.RED);
			renderer.setSeriesPaint(1, Color.GREEN);
			renderer.setSeriesPaint(2, Color.YELLOW);
			renderer.setSeriesStroke(0, new BasicStroke(4.0f));
			renderer.setSeriesStroke(1, new BasicStroke(3.0f));
			renderer.setSeriesStroke(2, new BasicStroke(2.0f));
			plot.setRenderer(renderer);
			setContentPane(plotPanel);
			
		}
		private XYDataset createDataset()
		{
			final XYSeries firefox = new XYSeries("Firefox");
			firefox.add(1.0, 1.0);
			firefox.add(2.0, 4.0);
			firefox.add(3.0, 3.0);
			final XYSeries chrome = new XYSeries("Chrome");
			chrome.add(1.0, 4.0);
			chrome.add(2.0, 5.0);
			chrome.add(3.0, 6.0);
			final XYSeries iexplorer = new XYSeries("Internet Explorer");
			iexplorer.add(1.0, 1.0);
			iexplorer.add(2.0, 4.0);
			iexplorer.add(3.0, 3.0);
			final XYSeriesCollection dataset = new XYSeriesCollection();
			dataset.addSeries(firefox);
			dataset.addSeries(chrome);
			dataset.addSeries(iexplorer);
			return dataset;

		}

	}

	private class bikinGambar 
	{
		
		public void bikinGambar()
		{
			DefaultPieDataset pieDataset = new DefaultPieDataset();
			pieDataset.setValue("A", new Integer(75));
			pieDataset.setValue("B", new Integer(10));
			pieDataset.setValue("C", new Integer(10));
			pieDataset.setValue("D", new Integer(5));
	
			JFreeChart chart = ChartFactory.createPieChart("Nyoba sih", pieDataset, true, true, false);
			try {
				ChartUtils.saveChartAsJPEG(new File("chasrt.jpg"), chart, 500, 300);
			} 
			catch (Exception e) 
			{
				System.out.println("Problem occurred creating chart."); 
			}
		}
	}

	public void Jalankan()
	{
		bikinGambar makan= new bikinGambar();
		makan.bikinGambar();
		ngeplotFrame chart = new ngeplotFrame("Boker", "Dicelana");
		chart.pack();
		UIUtils.centerFrameOnScreen(chart);
		chart.setVisible(true);
		

	}

}
