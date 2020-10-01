import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Dimension;

public class AdobeApps {
	
	String[] appsname = {
			"Acrobat Pro DC",
			"AfterEffects",
			"Animate",
			"Audition CC",
			"Bridge",
			"Distiller",
			"Dreamweaver",
			"Fireworks",
			"Flash",
			"Flash Builder",
			"Fuse",
			"Illustrator",
			"InCopy",
			"InDesign",
			"Lightroom",
			"MediaEncoder",
			"Muse",
			"Photoshop",
			"Prelude",
			"Premiere Pro",
			"SpeedGrade",
	};
	
	String[] appspath = {
			"C:\\Program Files (x86)\\Adobe\\Adobe Acrobat DC\\Acrobat\\Acrobat.exe",
			"C:\\Program Files\\Adobe\\Adobe After Effects CC 2017\\Support Files\\AfterFX.exe",
			"C:\\Program Files\\Adobe\\Adobe Animate CC 2017\\Animate.exe",
			"C:\\Program Files\\Adobe\\Adobe Audition CC 2017\\Adobe Audition CC.exe",
			"C:\\Program Files\\Adobe\\Adobe Bridge CC 2017\\Bridge.exe",
			"C:\\Program Files (x86)\\Adobe\\Adobe Acrobat DC\\Acrobat\\acrodist.exe",
			"C:\\Program Files\\Adobe\\Adobe Dreamweaver CC 2017\\Dreamweaver.exe",
			"C:\\Program Files (x86)\\Adobe\\Adobe Fireworks CS6\\Fireworks.exe",
			"C:\\Program Files\\Adobe\\Adobe Flash CC 2015\\Flash.exe",
			"C:\\Program Files\\Adobe\\Adobe Flash Builder 4.7 (64 Bit)\\FlashBuilder.exe",
			"C:\\Program Files (x86)\\Adobe\\Adobe Fuse CC (Preview)\\Code\\Build\\Output\\Fuse\\bin\\Release\\Fuse.exe",
			"C:\\Program Files\\Adobe\\Adobe Illustrator CC 2017\\Support Files\\Contents\\Windows\\Illustrator.exe",
			"C:\\Program Files\\Adobe\\Adobe InCopy CC 2017\\InCopy.exe",
			"C:\\Program Files\\Adobe\\Adobe InDesign CC 2017\\InDesign.exe",
			"C:\\Program Files\\Adobe\\Adobe Lightroom\\lightroom.exe",
			"C:\\Program Files\\Adobe\\Adobe Media Encoder CC 2017\\Adobe Media Encoder.exe",
			"C:\\Program Files\\Adobe\\Adobe Muse CC 2017\\Muse.exe",
			"C:\\Program Files\\Adobe\\Adobe Photoshop CC 2017\\Photoshop.exe",
			"C:\\Program Files\\Adobe\\Adobe Prelude CC 2017\\Adobe Prelude.exe",
			"C:\\Program Files\\Adobe\\Adobe Premiere Pro CC 2017\\Adobe Premiere Pro.exe",
			"C:\\Program Files\\Adobe\\Adobe SpeedGrade CC 2015\\SpeedGrade.exe",
	};
	
	String[] appsfile = {
			"Acrobat.exe",
			"AfterFX.exe",
			"Animate.exe",
			"Adobe Audition CC.exe",
			"Bridge.exe",
			"acrodist.exe",
			"Dreamweaver.exe",
			"Fireworks.exe",
			"Flash.exe",
			"FlashBuilder.exe",
			"Fuse.exe",
			"Illustrator.exe",
			"InCopy.exe",
			"InDesign.exe",
			"lightroom.exe",
			"Adobe Media Encoder.exe",
			"Muse.exe",
			"Photoshop.exe",
			"Adobe Prelude.exe",
			"Adobe Premiere Pro.exe",
			"SpeedGrade.exe",
	};

	
    // Linear-search function to find the index of an element 
    public static int findIndex(String[] appsname2, String i2) {  
        // if array is Null 
        if (appsname2 == null) { 
            return -1; 
        } 
  
        // find length of array 
        int len = appsname2.length; 
        int i = 0; 
  
        // traverse in the array 
        while (i < len) { 
  
            // if the i-th element is t 
            // then return the index 
            if (appsname2[i] == i2) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return -1; 
    } 

	private JFrame frmmain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdobeApps window = new AdobeApps();
					window.frmmain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdobeApps() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmmain = new JFrame();
		frmmain.setAlwaysOnTop(true);
		frmmain.setMinimumSize(new Dimension(510, 200));
		frmmain.setMaximumSize(new Dimension(510, 200));
		frmmain.setResizable(false);
		frmmain.setTitle("Iniciador de aplicaciones Adobe");
		frmmain.setBounds(100, 100, 510, 180);
		frmmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		frmmain.getContentPane().setLayout(gridBagLayout);
		
		JTextPane txtpninstrucciones = new JTextPane();
		txtpninstrucciones.setBackground(SystemColor.control);
		txtpninstrucciones.setEditable(false);
		txtpninstrucciones.setText("Este peque\u00F1o programa inicia todas las aplicaciones Adobe instaladas para que IT SEAT no las desinstale.\r\nAl pulsar en el bot\u00F3n Iniciar, se ir\u00E1n iniciando y cerrando de forma autom\u00E1tica las aplicaciones. Sobretodo: NO TOQUES NADA, todo es autom\u00E1tico.\r\n\nPulsa el bot\u00F3n Iniciar para empezar y ves a tomarte un caf\u00E9, que tarda un rato.");
		GridBagConstraints gbc_txtpninstrucciones = new GridBagConstraints();
		gbc_txtpninstrucciones.gridwidth = 2;
		gbc_txtpninstrucciones.insets = new Insets(5, 5, 5, 0);
		gbc_txtpninstrucciones.fill = GridBagConstraints.BOTH;
		gbc_txtpninstrucciones.gridx = 0;
		gbc_txtpninstrucciones.gridy = 0;
		frmmain.getContentPane().add(txtpninstrucciones, gbc_txtpninstrucciones);
		
		JTextPane textPaneLog = new JTextPane();
		textPaneLog.setBackground(SystemColor.control);
		textPaneLog.setEditable(false);
		GridBagConstraints gbc_textPaneLog = new GridBagConstraints();
		gbc_textPaneLog.gridwidth = 2;
		gbc_textPaneLog.insets = new Insets(0, 5, 5, 0);
		gbc_textPaneLog.fill = GridBagConstraints.BOTH;
		gbc_textPaneLog.gridx = 0;
		gbc_textPaneLog.gridy = 1;
		frmmain.getContentPane().add(textPaneLog, gbc_textPaneLog);
		
		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.insets = new Insets(0, 5, 5, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 2;
		frmmain.getContentPane().add(progressBar, gbc_progressBar);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startapps(textPaneLog, btnIniciar, progressBar, txtpninstrucciones);
			}
		});
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
		gbc_btnIniciar.fill = GridBagConstraints.BOTH;
		gbc_btnIniciar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciar.gridx = 1;
		gbc_btnIniciar.gridy = 2;
		frmmain.getContentPane().add(btnIniciar, gbc_btnIniciar);
	}
	
	private void startapps(JTextPane textPaneLog, JButton btnIniciar, JProgressBar progressBar, JTextPane txtpninstrucciones) {
		btnIniciar.setEnabled(false);
		progressBar.setMaximum(appspath.length);
		String LogOK = "";
		String LogKO = "";
		for (String i : appsname) {
			File f = new File(appspath[findIndex(appsname, i)]);
			if(f.exists()) {
				Thread preinfo = new Thread() {
					public void run() {
						textPaneLog.setText("");
						appendtext(textPaneLog, "Iniciando " + i.toString() + "... ", Color.DARK_GRAY);
						textPaneLog.update(textPaneLog.getGraphics());
						txtpninstrucciones.update(txtpninstrucciones.getGraphics());
						}
					};
					preinfo.start();
					
					ProcessBuilder process = new ProcessBuilder(appspath[findIndex(appsname, i)]);
					try {
						process.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
				    ScheduledFuture<?> countdown = executorService.schedule(new Runnable() {
				    	@Override
				    	public void run() {
				    	Runtime stopapp = Runtime.getRuntime();
				    	try {
				    		stopapp.exec("taskkill /F /IM " + "\"" + appsfile[findIndex(appsname, i)] + "\"");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	}}, 40, TimeUnit.SECONDS);
				    
				    while (!countdown.isDone()) {
			            try {
			                Thread.sleep(6000);
			            } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
			        }
				    executorService.shutdown();
				    LogOK = LogOK + "\n - " + i.toString();
			}
			else {
				Thread preinfo = new Thread() {
					public void run() {
						textPaneLog.setText("");
						appendtext(textPaneLog, i + " no encontrado, saltando...\n", Color.RED);
						}
					};
					preinfo.start();
					LogKO = LogKO + "\n - " + i.toString();
				try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

			}
			Thread progress = new Thread() {
				public void run() {
					progressBar.setValue(findIndex(appsname, i) + 1);
					progressBar.update(progressBar.getGraphics());
					}
				};
				progress.start();
		}
		
		if (LogKO == "") {
			JOptionPane.showMessageDialog(frmmain,
					"¡Finalizado!\n\n"
					+ "Estos son los programas que se han abierto correctamente:"
					+ LogOK	+ "\n\n"
					+ "Si tienes algún programa instalado que no aparece en esta lista,\n"
					+ "coméntalo con Jose para añadirlo.");
		}
		
		if (LogOK == "") {
			JOptionPane.showMessageDialog(frmmain,
					"¡Finalizado!\n\n"
					+ "Estos programas NO se han podido ejecutar porque no se han encontrado:"
					+ LogKO + "\n\n"
					+ "Si tienes algún programa instalado que no aparece en esta lista,\n"
					+ "coméntalo con Jose para añadirlo.");

		}
		
		if (LogOK != "" && LogKO != "") {
			JOptionPane.showMessageDialog(frmmain,
					"¡Finalizado!\n\n"
					+ "Estos son los programas que se han abierto correctamente:"
					+ LogOK	+ "\n\n"
					+ "Estos programas NO se han podido ejecutar porque no se han encontrado:"
					+ LogKO + "\n\n"
					+ "Si tienes algún programa instalado que no aparece en esta lista,\n"
					+ "coméntalo con Jose para añadirlo.");
		}
	}
	
	private void appendtext(JTextPane pane, String text, Color color) {
		StyledDocument doc = pane.getStyledDocument();

        Style style = pane.addStyle("Color Style", null);
        StyleConstants.setForeground(style, color);
        try {
            doc.insertString(doc.getLength(), text, style);
        } 
        catch (BadLocationException e) {
            e.printStackTrace();
        }           
    }

}
