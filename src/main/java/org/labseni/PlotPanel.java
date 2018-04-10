package org.labseni;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PlotPanel extends ApplicationFrame
{
	public PlotPanel(string title)
	{
		super(title);
		setContentPane(createDemoPanel());
	}
	private static PieDataset createDataset()
	{
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Iphone 5s", new Double(20));
		dataset.setValue("Samsung Grand", new Double(20));
		dataset.setValue("MotoG", new Double(40));
		dataset.setValue("Nokia Lumia", new Double(10));
		return dataset;
	}
	private static JFreeChart createChart(pieDataset dataset)
	{
		JFreeChart chart = ChartFactory.createPieChart(
		"Mobile Sales", dataset, true, true, false
		);
		return chart;
	}
	public static JPanel createDemoPanel()
	{
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}
	public static void main(String[] args)
	{
		PlotPanel demo = new PlotPanel("Mobile Sales");
		demo.setSize(560, 367);
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);	
	}
}

