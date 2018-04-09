/*
	Author 	: Aziz Amerul Faozi
	Email 	: rahvanafaozi@gmail.com
*/

package org.labseni;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import java.util.Hashtable;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.image.*;
import javax.swing.JDialog;
import java.awt.Dialog.ModalityType;
//set border
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import static javax.swing.GroupLayout.Alignment.*;
import org.labseni.Termin;
import org.labseni.SimCantik;
import javafx.application.Application;
import javafx.stage.Stage;
//import org.math.plot.*;
import javax.swing.JScrollPane;

public class App extends JFrame
{

    //Teknik Modulasi variable
    JPanel opsi = new JPanel();
    ButtonGroup modulatorGroup = new ButtonGroup();
    JLabel modulatorLabel= new JLabel("Modulator");
    JRadioButton bpsk = new JRadioButton("BPSK");
    JRadioButton gmsk = new JRadioButton("GMSK");
    JRadioButton ofdm = new JRadioButton("OFDM");
    // Teknik Filtering variable
    ButtonGroup filterGroup = new ButtonGroup();
    JLabel filterLabel = new JLabel("Filter");
    JRadioButton FIR = new JRadioButton("FIR");
    JRadioButton IIR = new JRadioButton("IIR");
    JRadioButton LoveFilter = new JRadioButton("LoveFilter");

    // Beam pattern list
    ButtonGroup beamPatternGroup = new ButtonGroup();
    JLabel beamPatternLabel = new JLabel("Beam Pattern");
    JRadioButton LRBP = new JRadioButton("LRBP");
    JRadioButton MGRBP = new JRadioButton("MGRBP");
    // DDS tunner transmit variable
    JSlider freqtransmit = new JSlider(0, 10, 5);
    JLabel freqLabeltransmit = new JLabel("DDS Transmit");

    // DDS tunner recieve variable
    JSlider freqrecv = new JSlider(0, 10, 5);
    JLabel freqLabelrecv = new JLabel("DDS recv");

    public App()
    {

	this.initFrame();
    }

    private void initFrame()
    {

	/*Set Jbutton for transmit*/
	JButton TombolKirim = new JButton("Kirim");
	/*Sett text area for data */
	JTextArea msgArea = new JTextArea(3,45);
	JPanel teks = new JPanel();
	JPanel tunnertransmit = new JPanel();
	tunnertransmit.setPreferredSize(new Dimension(150, 15));
	this.getContentPane().setLayout(new BorderLayout());
	teks.add(new JScrollPane(msgArea), BorderLayout.CENTER);
	teks.add(TombolKirim);
	msgArea.append("jangkring men "+"wowo");

	/* Controller panel */
	JPanel konPanel = new JPanel();
	/* Settingan tabpane */
	JPanel kirimPanel = new JPanel();
	JPanel terimaPanel = new JPanel();
	/* mencoba menggunkan plotting */
	/* Plot2DPanel plot = new Plot2DPanel();*/
	/* Beberapa settingan dasar yang mungkin perlu*/
	Border borderhitam;
	borderhitam = BorderFactory.createLineBorder(Color.black);
	JTabbedPane tabPane = new JTabbedPane();
	Container contentPane = this.getContentPane();


	// Panel modulator
	JPanel modPanel = new JPanel();
	BoxLayout modTegak = new BoxLayout(modPanel, BoxLayout.Y_AXIS);
	modPanel.setLayout(modTegak);
	modPanel.setBorder(borderhitam);

	// Panel filter
	JPanel filPanel = new JPanel();
	BoxLayout filTegak = new BoxLayout(filPanel, BoxLayout.Y_AXIS);
	filPanel.setLayout(filTegak);
	filPanel.setBorder(borderhitam);

	// Panel DDS_Tunner transmit
	JPanel ddsPaneltransmit = new JPanel();
	ddsPaneltransmit.setPreferredSize(new Dimension(200, 70));
	BoxLayout ddsTegaktransmit = new BoxLayout(ddsPaneltransmit, BoxLayout.Y_AXIS);
	ddsPaneltransmit.setLayout(ddsTegaktransmit);
	ddsPaneltransmit.setBorder(borderhitam);


	// Panel DDS_Tunner transmit
	JPanel ddsPanelrecv = new JPanel();
	BoxLayout ddsTegakrecv = new BoxLayout(ddsPanelrecv, BoxLayout.Y_AXIS);
	ddsPanelrecv.setLayout(ddsTegakrecv);
	ddsPanelrecv.setBorder(borderhitam);

	// Panel Beam Pattern
	JPanel bpPanel = new JPanel();
	BoxLayout bpTegak = new BoxLayout(bpPanel, BoxLayout.Y_AXIS);
	bpPanel.setLayout(bpTegak);
	bpPanel.setBorder(borderhitam);

	// Group Layout
	GroupLayout grupLayut = new GroupLayout(contentPane);
	//contentPane.setLayout(new FlowLayout());
	this.setTitle("Short Distance Relationship");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	//Pake icon
	//ImageIcon img = new ImageIcon("/home/afaozi/ngoprek/tugasakhir/SDRCantik/src/main/resources/sdrcantik.png");
	ImageIcon img = new ImageIcon("sdrcantik.png");
	this.setIconImage(img.getImage());

	JMenuBar menuSDR = getSDRMenuBar();
	this.setJMenuBar(menuSDR);

	/*Code ini biar gak nabrak antara JComponentnya*/
	this.setLayout(new GridLayout(2,0));

        //Add three Modulator Group JRadioButton
	modulatorGroup.add(bpsk);
	modulatorGroup.add(gmsk);
	modulatorGroup.add(ofdm);
	/* Jika ingin menambahin teknik modulasi jangan lupa ngedit code ini */
	Box b1=Box.createVerticalBox();

	b1.add(bpsk);
	b1.add(gmsk);
	b1.add(ofdm);
	modPanel.add(modulatorLabel);
	modPanel.add(b1);

	//Add three Filter Group JRadioButton
	filterGroup.add(FIR);
	filterGroup.add(IIR);
	filterGroup.add(LoveFilter);


	/* Jika ingin menambahin teknik filtering jangan lupa ngedit code ini */
	Box b2=Box.createVerticalBox();

	b2.add(FIR);
	b2.add(IIR);
	b2.add(LoveFilter);

	filPanel.add(filterLabel);
	filPanel.add(b2);



	/* Jika ingin menambahkan pola radiasi pada sdr */
	beamPatternGroup.add(LRBP);
	beamPatternGroup.add(MGRBP);

	Box b3=Box.createVerticalBox();
	b3.add(LRBP);
	b3.add(MGRBP);
	bpPanel.add(beamPatternLabel);
	bpPanel.add(b3);

	//Setting scala untuk frequensi DDS tunner transmit
	freqtransmit.setMinorTickSpacing(1);
	freqtransmit.setMajorTickSpacing(2);
	freqtransmit.setPaintTicks(true);
	freqLabeltransmit.setLabelFor(freqtransmit);

	// Ini mapping label ke frekuensi transmit
	Hashtable freqTabeltransmit = new Hashtable();
	freqTabeltransmit.put(new Integer(0), new JLabel("HF"));
	freqTabeltransmit.put(new Integer(5),  new JLabel("VHF"));
	freqTabeltransmit.put(new Integer(10),  new JLabel("UHF"));

	/*ini labeling transmit*/
	freqtransmit.setLabelTable(freqTabeltransmit);
	freqtransmit.setPaintLabels(true);
	ddsPaneltransmit.add(freqLabeltransmit);
	ddsPaneltransmit.add(freqtransmit);
	tunnertransmit.add(ddsPaneltransmit);
	//Setting scala untuk frequensi DDS tunner recv
	freqrecv.setMinorTickSpacing(1);
	freqrecv.setMajorTickSpacing(2);
	freqrecv.setPaintTicks(true);
	freqLabelrecv.setLabelFor(freqrecv);

	// Ini mapping label ke frekuensi recv
	Hashtable freqTabelrecv = new Hashtable();
	freqTabelrecv.put(new Integer(0), new JLabel("HF"));
	freqTabelrecv.put(new Integer(5),  new JLabel("VHF"));
	freqTabelrecv.put(new Integer(10),  new JLabel("UHF"));

	/*ini labeling recv*/
	freqrecv.setLabelTable(freqTabeltransmit);
	freqrecv.setPaintLabels(true);
	ddsPanelrecv.add(freqLabelrecv);
	ddsPanelrecv.add(freqrecv);


	/* Memasukkan konPanel */
	konPanel.add(modPanel);
	konPanel.add(bpPanel);
	/* Memassukan ke kirim panel */
	kirimPanel.setLayout(new GridLayout(3,0));
	kirimPanel.add(konPanel);
	kirimPanel.add(tunnertransmit);
	kirimPanel.add(teks);


	terimaPanel.add(filPanel);
	terimaPanel.add(ddsPanelrecv);

	tabPane.addTab("Kirim", kirimPanel);
	tabPane.addTab("Terima", terimaPanel);
	contentPane.add(tabPane);

    }
    private JMenuBar getSDRMenuBar(){
	JMenuBar menuSDR =new JMenuBar();
	JMenu fileMenu = getFileMenu();
	JMenu AlatMenu = getAlat();


	menuSDR.add(fileMenu);
	menuSDR.add(AlatMenu);
	return menuSDR;

    }
    private JMenu getFileMenu()
    {
    	//Menu ALT
	JMenu fileMenu= new JMenu("File");
	fileMenu.setMnemonic(KeyEvent.VK_F);
	// Isi dari menu file
	JMenuItem keluarMenuItem = new JMenuItem("Keluar", KeyEvent.VK_K);
	JMenuItem terminal = new JMenuItem("Terminal", KeyEvent.VK_T);
	fileMenu.add(terminal);
	fileMenu.add(keluarMenuItem);
	keluarMenuItem.addActionListener(new KeluarBroh());
	terminal.addActionListener(new Terminator());


	return fileMenu;
    }
    private JMenu getAlat()
    {
    	JMenu menuAlat = new JMenu("Alat");
    	menuAlat.setMnemonic(KeyEvent.VK_A);
    	JMenuItem CanSimItem = new JMenuItem("CanSim", KeyEvent.VK_C);
    	menuAlat.add(CanSimItem);
    	//action Listener
    	CanSimItem.addActionListener(new CanSim());
    	return menuAlat;

    }

    private class KeluarBroh implements ActionListener{
	/* Guys ini fungsi untuk keluar */
    	@Override
    	public void actionPerformed(ActionEvent e)
	    {
        	System.exit(0);
	    }
    }

    private class Terminator implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e)
		{
			//Termin testing = new Termin();
			//testing.launch();
			//testing.boker();
			// Modality untuk JDialog
			final ModalityType dialog1Modality = ModalityType.DOCUMENT_MODAL;

			// JDialog
			JDialog kredit = new JDialog(new App(), "Kredit");
			JLabel labelKredit = new JLabel("Kredit Label");
			kredit.setModalityType(dialog1Modality);
			kredit.setBounds(200, 200, 200, 200);
			kredit.add(labelKredit);
			kredit.setVisible(true);
		}
	}
    private class CanSim implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e)
    	{
    		SimCantik simCantik = new SimCantik();
    		simCantik.Jalankan();

    	}
    }
    public static void main(String[] args)
    {
    	/* Fungsi utama */
    	App bf= new App();
    	bf.pack();
    	bf.setVisible(true);

    }

}
