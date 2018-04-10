package org.labseni;

import javax.swing.JFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;

public class SimCantik {
	public SimCantik()
	{
		
	
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
	
			JFreeChart chart = ChartFactory.createPieChart("CSC408 Mark Distribution", pieDataset, true, true, false);
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

	}

}
