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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Font;

public class AdobeApps {
	
	//Adding more apps:
	//Array appsfile has the exe files
	//Array appsname has the apps name
	//They must be in the same order

	public static String[] appsfile = {
			"Acrobat.exe",
			"acrodist.exe",
			"Adobe Audition CC.exe",
			"Adobe Media Encoder.exe",
			"Adobe Prelude.exe",
			"Adobe Premiere Pro.exe", 
			"AfterFX.exe",
			"Animate.exe",
			"Bridge.exe",
			"Dreamweaver.exe",
			"Fireworks.exe",
			"Flash.exe",
			"FlashBuilder.exe",
			"Fuse.exe",
			"Illustrator.exe",
			"InCopy.exe",
			"InDesign.exe",
			"lightroom.exe",
			"Lightroom.exe",
			"Muse.exe",
			"Photoshop.exe",
			"SpeedGrade.exe",
			};
	
	public static String[] appsname = {
			"Acrobat Pro DC",
			"Distiller",
			"Audition CC",
			"MediaEncoder",
			"Prelude",
			"Premiere Pro",			
			"AfterEffects",
			"Animate",
			"Bridge",
			"Dreamweaver",
			"Fireworks",
			"Flash",
			"Flash Builder",
			"Fuse",
			"Illustrator",
			"InCopy",
			"InDesign",
			"Lightroom",
			"Lightroom",
			"Muse",
			"Photoshop",
			"SpeedGrade",
			};

	public static String[] pathsfound = {};
	public static String[] appsfound = {};
	public static String[] exesfound = {};

	static int numapps = 0;
	static String app;
	static int countapps = 0;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

	private JFrame frmmain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			System.out.println(e1);
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
		frmmain.setTitle("Iniciador de aplicaciones Adobe (v2 Final)");
		frmmain.setBounds(100, 100, 600, 365);
		frmmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 400, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 11, 33, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		frmmain.getContentPane().setLayout(gridBagLayout);
		frmmain.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));

		JTextPane txtpninstrucciones = new JTextPane();
		txtpninstrucciones.setBackground(SystemColor.control);
		txtpninstrucciones.setEditable(false);
		txtpninstrucciones.setText(
				"Este peque\u00F1o programa inicia todas las aplicaciones Adobe instaladas para que IT SEAT no las desinstale.\r\nAl pulsar en el bot\u00F3n Iniciar, se iniciar\u00E1n y se cerrar\u00E1n una a una de forma autom\u00E1tica TODAS las aplicaciones que se hayan detectado al inicio.\r\nSobretodo: NO TOQUES NADA, todo es autom\u00E1tico.");
		GridBagConstraints gbc_txtpninstrucciones = new GridBagConstraints();
		gbc_txtpninstrucciones.gridwidth = 2;
		gbc_txtpninstrucciones.insets = new Insets(5, 5, 5, 0);
		gbc_txtpninstrucciones.fill = GridBagConstraints.BOTH;
		gbc_txtpninstrucciones.gridx = 0;
		gbc_txtpninstrucciones.gridy = 0;
		frmmain.getContentPane().add(txtpninstrucciones, gbc_txtpninstrucciones);
		
		JTextPane txtpninstrucciones2 = new JTextPane();
		txtpninstrucciones2.setText("Pulsa el bot\u00F3n Iniciar y mira la pantalla :P");
		txtpninstrucciones2.setEditable(false);
		txtpninstrucciones2.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtpninstrucciones2 = new GridBagConstraints();
		gbc_txtpninstrucciones2.insets = new Insets(0, 5, 5, 5);
		gbc_txtpninstrucciones2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpninstrucciones2.gridx = 0;
		gbc_txtpninstrucciones2.gridy = 1;
		frmmain.getContentPane().add(txtpninstrucciones2, gbc_txtpninstrucciones2);
				

		JProgressBar progressBar = new JProgressBar();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.gridwidth = 2;
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.insets = new Insets(0, 5, 5, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 2;
		frmmain.getContentPane().add(progressBar, gbc_progressBar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		frmmain.getContentPane().add(scrollPane, gbc_scrollPane);

		JTextPane textPaneLog = new JTextPane();
		textPaneLog.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setViewportView(textPaneLog);
		textPaneLog.setBackground(Color.WHITE);
		textPaneLog.setEditable(false);
		
		JButton btnIniciar = new JButton("Iniciar");
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
		gbc_btnIniciar.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIniciar.gridx = 1;
		gbc_btnIniciar.gridy = 1;
		frmmain.getContentPane().add(btnIniciar, gbc_btnIniciar);
		btnIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startapps2(textPaneLog, txtpninstrucciones2, btnIniciar, progressBar, txtpninstrucciones);
			}
		});

		
		startup(textPaneLog, txtpninstrucciones2, btnIniciar, progressBar);
		
		JTextPane txtpnSignature = new JTextPane();
		txtpnSignature.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnSignature.setText("Jos\u00E9 J. Sarda (josejuansarda@gmail.com)");
		txtpnSignature.setEditable(false);
		txtpnSignature.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtpnSignature = new GridBagConstraints();
		gbc_txtpnSignature.insets = new Insets(0, 5, 0, 5);
		gbc_txtpnSignature.fill = GridBagConstraints.BOTH;
		gbc_txtpnSignature.gridx = 0;
		gbc_txtpnSignature.gridy = 4;
		frmmain.getContentPane().add(txtpnSignature, gbc_txtpnSignature);
		
		JTextPane txtpnCodename = new JTextPane();
		txtpnCodename.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtpnCodename.setText("codename: Fulgencio");
		txtpnCodename.setEditable(false);
		txtpnCodename.setBackground(SystemColor.menu);
		GridBagConstraints gbc_txtpnCodename = new GridBagConstraints();
		gbc_txtpnCodename.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnCodename.fill = GridBagConstraints.BOTH;
		gbc_txtpnCodename.gridx = 1;
		gbc_txtpnCodename.gridy = 4;
		frmmain.getContentPane().add(txtpnCodename, gbc_txtpnCodename);

	}

	public void startup(JTextPane textPaneLog, JTextPane txtpninstrucciones2, JButton btnIniciar, JProgressBar progressBar) {
		txtpninstrucciones2.setText("Detectando aplicaciones...");
		progressBar.setIndeterminate(true);
		btnIniciar.setVisible(false);
		appendtext(textPaneLog, LocalTime.now().format(dtf) + " ==> Detectando aplicaciones, espera..." + "\n", Color.BLUE);
		System.out.println(LocalTime.now().format(dtf) + " ==> Detectando aplicaciones...");
		Thread x86 = new Thread() {
			@Override
			public void run() {
				findapps("C:\\Program Files (x86)\\Adobe", textPaneLog);
			}
		};
		x86.start();
		Thread x64 = new Thread() {
			@Override
			public void run() {
				findapps("C:\\Program Files\\Adobe", textPaneLog);
				checkrepeatedapps(textPaneLog);
				appendtext(textPaneLog, LocalTime.now().format(dtf) + " ==> Se han detectado " + numapps + " aplicaciones." + "\n", Color.BLUE);
				btnIniciar.setVisible(true);
				btnIniciar.setText("Iniciar");
				btnIniciar.setEnabled(true);
				txtpninstrucciones2.setText("Pulsa el botón Iniciar para empezar.");
				progressBar.setIndeterminate(false);
				System.out.println(LocalTime.now().format(dtf) + " ==> Se han detectado " + numapps + " aplicaciones.");
				System.out.println();
			}
		};
		x64.start();
	}
	
	private void startapps2(JTextPane textPaneLog, JTextPane txtpninstrucciones2, JButton btnIniciar, JProgressBar progressBar, JTextPane txtpninstrucciones) {
		txtpninstrucciones2.setText("Iniciando aplicaciones...");
		progressBar.setVisible(true);
		appendtext(textPaneLog, LocalTime.now().format(dtf) + " ==> Iniciando aplicaciones..." + "\n", Color.BLUE);
		System.out.println(LocalTime.now().format(dtf) + " ==> ## Iniciando aplicaciones ##");
		btnIniciar.setVisible(false);
		progressBar.setMaximum(numapps);
		progressBar.setIndeterminate(true);
		int time = 30;
		for (int k = 0; k < appsfound.length; k++) {
			String apppath = pathsfound[k];
			String appexe = exesfound[k];
			String appname = appsfound[k];
			
			int starttime = time * k;
			int stoptime = starttime + time;

			Thread startapp = new Thread() {
				@Override
				public void run() {
					final ScheduledExecutorService scheduledapp = Executors.newSingleThreadScheduledExecutor();
					ScheduledFuture<?> countdown2 = scheduledapp.schedule(new Runnable() {
						@Override
						public void run() {
							appendtext(textPaneLog, "Iniciando " + appname + " (" + apppath + ")" + "\n", Color.BLACK);
							System.out.println(LocalTime.now().format(dtf) + " - Iniciando " + appname + " (" + apppath + ")");
							ProcessBuilder process = new ProcessBuilder(apppath);
							try {
								process.start();
							} catch (IOException e) {
								JOptionPane.showMessageDialog(frmmain, e);
								e.printStackTrace();
							}
						}
					}, starttime, TimeUnit.SECONDS);
					while (!countdown2.isDone()) {
						try {
							Thread.sleep(time * 100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					scheduledapp.shutdown();

					final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
					ScheduledFuture<?> countdown = executorService.schedule(new Runnable() {
						@Override
						public void run() {
							Runtime stopapp = Runtime.getRuntime();
							try {
								progressBar.setIndeterminate(false);
								stopapp.exec("taskkill /F /IM " + "\"" + appexe + "\"");
								System.out.println(LocalTime.now().format(dtf) + " - Matando " + appname + " (" + appexe + ")");
								appendtext(textPaneLog, appname + " detenida" + " (" + appexe + ")" + "\n", Color.BLUE);
								countapps++;
								progressBar.setValue(countapps);
								if ( countapps == numapps ) {
									appendtext(textPaneLog, "Proceso finalizado, puedes cerrar la ventana", Color.MAGENTA);
									txtpninstrucciones2.setVisible(false);
								}
							} catch (IOException e) {
								System.out.println(e);
								e.printStackTrace();
							}
						}
					}, stoptime, TimeUnit.SECONDS);
					while (!countdown.isDone()) {
						try {
							Thread.sleep(time * 100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					executorService.shutdown();
				};
			};
			startapp.start();
		}
	}

	private static void appendtext(JTextPane pane, String text, Color color) {
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
				for (int l=0; l < appsfile.length; l++) {
					if (file.toString().endsWith(appsfile[l])) {
						String appname = appsname[l];
						appendtext(textPaneLog, appname + " > " + file.toString() + "\n", Color.black);
						System.out.println(LocalTime.now().format(dtf) + " - Encontrada " + appname + " (" + file.toString() + ")" + " [" + file.getName() + "]");

						ArrayList<String> namesfoundList = new ArrayList<String>(Arrays.asList(appsfound));
						namesfoundList.add(appname);
						appsfound = namesfoundList.toArray(appsfound);

						ArrayList<String> pathsfoundList = new ArrayList<String>(Arrays.asList(pathsfound));
						pathsfoundList.add(file.toString());
						pathsfound = pathsfoundList.toArray(pathsfound);
						
						ArrayList<String> exesfoundList = new ArrayList<String>(Arrays.asList(exesfound));
						exesfoundList.add(file.getName());
						exesfound = exesfoundList.toArray(exesfound);

						numapps++;
					}
				}
			}
		}
	}
	
	private void checkrepeatedapps(JTextPane textPaneLog) {
		ArrayList<String> repeatedexesList = new ArrayList<String>();
		ArrayList<String> repeatedappsList = new ArrayList<String>();
		ArrayList<String> repeatedpathsList = new ArrayList<String>();
		
		ArrayList<String> exesfoundList = new ArrayList<String>(Arrays.asList(exesfound));
		ArrayList<String> appsfoundList = new ArrayList<String>(Arrays.asList(appsfound));
		ArrayList<String> pathsfoundList = new ArrayList<String>(Arrays.asList(pathsfound));
		
		appendtext(textPaneLog, LocalTime.now().format(dtf) + " ==> Comprobando si hay aplicaciones en varias versiones...\n", Color.BLUE);
		System.out.println(LocalTime.now().format(dtf) + " ==> Comprobando si hay varios ejecutables iguales...");
		
		for (int j = 0; j < exesfound.length; j++) {
			if ( j > 0 ) {
				String appexe = exesfound[j];
				String prevexe = exesfound[j-1];
				if ( prevexe.equals(appexe)) {
					appendtext(textPaneLog, appsfound[j] + " > disponible en 2 versiones, moviendo una al final.\n", Color.BLACK);
					System.out.println(LocalTime.now().format(dtf) + " - " + appsfound[j] + " está en 2 versiones, llevando al final");
					repeatedexesList.add(appexe);
					exesfoundList.remove(appexe);
					
					repeatedappsList.add(appsfound[j]);
					appsfoundList.remove(appsfound[j]);

					repeatedpathsList.add(pathsfound[j]);
					pathsfoundList.remove(pathsfound[j]);
				}
			}
		}

		repeatedexesList.forEach(item -> exesfoundList.add(item));
		exesfound = exesfoundList.toArray(exesfound);
		
		repeatedappsList.forEach(item -> appsfoundList.add(item));
		appsfound = appsfoundList.toArray(appsfound);
		
		repeatedpathsList.forEach(item -> pathsfoundList.add(item));
		pathsfound = pathsfoundList.toArray(pathsfound);
	}
}