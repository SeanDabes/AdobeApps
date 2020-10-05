import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Font;

public class AdobeApps {

	String[] appsname = { "Acrobat Pro DC", "AfterEffects", "Animate", "Audition CC", "Bridge", "Distiller",
			"Dreamweaver", "Fireworks", "Flash", "Flash Builder", "Fuse", "Illustrator", "InCopy", "InDesign",
			"Lightroom", "MediaEncoder", "Muse", "Photoshop", "Prelude", "Premiere Pro", "SpeedGrade", };

//	String[] appspath = { "C:\\Program Files (x86)\\Adobe\\Adobe Acrobat DC\\Acrobat\\Acrobat.exe",
//			"C:\\Program Files\\Adobe\\Adobe After Effects CC 2017\\Support Files\\AfterFX.exe",
//			"C:\\Program Files\\Adobe\\Adobe Animate CC 2017\\Animate.exe",
//			"C:\\Program Files\\Adobe\\Adobe Audition CC 2017\\Adobe Audition CC.exe",
//			"C:\\Program Files\\Adobe\\Adobe Bridge CC 2017\\Bridge.exe",
//			"C:\\Program Files (x86)\\Adobe\\Adobe Acrobat DC\\Acrobat\\acrodist.exe",
//			"C:\\Program Files\\Adobe\\Adobe Dreamweaver CC 2017\\Dreamweaver.exe",
//			"C:\\Program Files (x86)\\Adobe\\Adobe Fireworks CS6\\Fireworks.exe",
//			"C:\\Program Files\\Adobe\\Adobe Flash CC 2015\\Flash.exe",
//			"C:\\Program Files\\Adobe\\Adobe Flash Builder 4.7 (64 Bit)\\FlashBuilder.exe",
//			"C:\\Program Files (x86)\\Adobe\\Adobe Fuse CC (Preview)\\Code\\Build\\Output\\Fuse\\bin\\Release\\Fuse.exe",
//			"C:\\Program Files\\Adobe\\Adobe Illustrator CC 2017\\Support Files\\Contents\\Windows\\Illustrator.exe",
//			"C:\\Program Files\\Adobe\\Adobe InCopy CC 2017\\InCopy.exe",
//			"C:\\Program Files\\Adobe\\Adobe InDesign CC 2017\\InDesign.exe",
//			"C:\\Program Files\\Adobe\\Adobe Lightroom\\lightroom.exe",
//			"C:\\Program Files\\Adobe\\Adobe Media Encoder CC 2017\\Adobe Media Encoder.exe",
//			"C:\\Program Files\\Adobe\\Adobe Muse CC 2017\\Muse.exe",
//			"C:\\Program Files\\Adobe\\Adobe Photoshop CC 2017\\Photoshop.exe",
//			"C:\\Program Files\\Adobe\\Adobe Prelude CC 2017\\Adobe Prelude.exe",
//			"C:\\Program Files\\Adobe\\Adobe Premiere Pro CC 2017\\Adobe Premiere Pro.exe",
//			"C:\\Program Files\\Adobe\\Adobe SpeedGrade CC 2015\\SpeedGrade.exe", };

	String[] appspath = {};
	String[] appsfound = {};
	
	String[] appsfile = { "Acrobat.exe", "AfterFX.exe", "Animate.exe", "Adobe Audition CC.exe", "Bridge.exe",
			"acrodist.exe", "Dreamweaver.exe", "Fireworks.exe", "Flash.exe", "FlashBuilder.exe", "Fuse.exe",
			"Illustrator.exe", "InCopy.exe", "InDesign.exe", "lightroom.exe", "Adobe Media Encoder.exe", "Muse.exe",
			"Photoshop.exe", "Adobe Prelude.exe", "Adobe Premiere Pro.exe", "SpeedGrade.exe", };
	
	int numapps = 0;

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
			} else {
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
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		frmmain.setBounds(100, 100, 600, 300);
		frmmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 411, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		frmmain.getContentPane().setLayout(gridBagLayout);

		JTextPane txtpninstrucciones = new JTextPane();
		txtpninstrucciones.setBackground(SystemColor.control);
		txtpninstrucciones.setEditable(false);
		txtpninstrucciones.setText(
				"Este peque\u00F1o programa inicia todas las aplicaciones Adobe instaladas para que IT SEAT no las desinstale.\r\nAl pulsar en el bot\u00F3n Iniciar, se iniciar\u00E1n y se cerrar\u00E1n de forma autom\u00E1tica TODAS las aplicaciones a la vez. Es muy probable que el ventilador del PC se ponga al m\u00E1ximo.\r\nSobretodo: NO TOQUES NADA, todo es autom\u00E1tico.\r\n\nPulsa el bot\u00F3n Iniciar para empezar y mira la pantalla :P");
		GridBagConstraints gbc_txtpninstrucciones = new GridBagConstraints();
		gbc_txtpninstrucciones.gridwidth = 2;
		gbc_txtpninstrucciones.insets = new Insets(5, 5, 5, 0);
		gbc_txtpninstrucciones.fill = GridBagConstraints.BOTH;
		gbc_txtpninstrucciones.gridx = 0;
		gbc_txtpninstrucciones.gridy = 0;
		frmmain.getContentPane().add(txtpninstrucciones, gbc_txtpninstrucciones);

		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.insets = new Insets(0, 5, 5, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		frmmain.getContentPane().add(progressBar, gbc_progressBar);
			
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frmmain.getContentPane().add(scrollPane, gbc_scrollPane);
		
		JTextPane textPaneLog = new JTextPane();
		textPaneLog.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(textPaneLog);
		textPaneLog.setBackground(Color.WHITE);
		textPaneLog.setEditable(false);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startapps2(textPaneLog, btnIniciar, progressBar, txtpninstrucciones);
			}
		});
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
		gbc_btnIniciar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciar.fill = GridBagConstraints.BOTH;
		gbc_btnIniciar.gridx = 1;
		gbc_btnIniciar.gridy = 1;
		frmmain.getContentPane().add(btnIniciar, gbc_btnIniciar);
		
		startup(textPaneLog, btnIniciar);
	}
	
	public void startup(JTextPane textPaneLog, JButton btnIniciar) {
		appendtext(textPaneLog, "==> Detectando aplicaciones, espera..." + "\n", Color.BLUE);
		Thread x86 = new Thread() {
			@Override
			public void run() {
				btnIniciar.setEnabled(false);
				btnIniciar.setText("Espera...");
				findapps("C:\\Program Files (x86)\\Adobe", textPaneLog);
			}
		};
		x86.start();
		Thread x64 = new Thread() {
			@Override
			public void run() {
				findapps("C:\\Program Files\\Adobe", textPaneLog);
				btnIniciar.setEnabled(true);
				btnIniciar.setText("Iniciar");
				appendtext(textPaneLog, "Se han detectado " + numapps + " aplicaciones.", Color.BLUE);
			}
		};
		x64.start();
	}
	
	private void startapps2(JTextPane textPaneLog, JButton btnIniciar, JProgressBar progressBar, JTextPane txtpninstrucciones) {
		appendtext(textPaneLog, "==> Iniciando aplicaciones..." + "\n", Color.BLUE);
		progressBar.setMaximum(numapps);
		for (String app : appsfound) {
			appendtext(textPaneLog, "Iniciando " + app + "\n", Color.BLACK);
			Thread th = new Thread() {
				@Override
				public void run() {
					ProcessBuilder process = new ProcessBuilder(appspath[findIndex(appsfound, app)]);
					try {
						process.start();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					progressBar.setValue((numapps - Arrays.asList(appsfound).indexOf(app))/2);
					final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
					ScheduledFuture<?> countdown = executorService.schedule(new Runnable() {
						@Override
						public void run() {
							Runtime stopapp = Runtime.getRuntime();
							try {
								stopapp.exec("taskkill /F /IM " + "\"" + appsfile[findIndex(appsfound, app)] + "\"");
								appendtext(textPaneLog, app + " detenida" + "\n", Color.BLUE);
								progressBar.setValue(numapps - Arrays.asList(appsfound).indexOf(app) + 1);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}, 120, TimeUnit.SECONDS);

					while (!countdown.isDone()) {
						try {
							Thread.sleep(6000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					executorService.shutdown();

				}
			};
			th.start();
		}
	}

	private void appendtext(JTextPane pane, String text, Color color) {
		StyledDocument doc = pane.getStyledDocument();

		Style style = pane.addStyle("Color Style", null);
		StyleConstants.setForeground(style, color);
		try {
			doc.insertString(doc.getLength(), text, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		pane.setCaretPosition(pane.getDocument().getLength());
	}
	
	private void findapps(String path, JTextPane textPaneLog) {
		File dir = new File(path.toString());
		for (File file : dir.listFiles()) {
			if (file.isDirectory()) {
				findapps(file.toString(), textPaneLog);
			} else {
				for (String app : appsfile) {
					if (file.toString().endsWith(app)) {
						String appname = appsname[findIndex(appsfile, app)];
						appendtext(textPaneLog, appname + " > " + file.toString() + "\n", Color.black);
						
						ArrayList<String> namesfoundList = new ArrayList<String>(Arrays.asList(appsfound));
						namesfoundList.add(appname);
						appsfound = namesfoundList.toArray(appsfound);
						
						ArrayList<String> pathsfoundList = new ArrayList<String>(Arrays.asList(appspath));
						pathsfoundList.add(file.toString());
						appspath = pathsfoundList.toArray(appspath);
						
						numapps++;
					}
				}
			}
		}
	}
}
