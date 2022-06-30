package janela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.TextField;
import javax.swing.SwingConstants;

public class TelaInicial {

	private JFrame frame;
	private JTextField inputMoeda;
	private JTextField inputTemperatura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex); 
        	
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}
	
	// Declarando variaveis
	double fahrenheit, celsius, reais,
	dolar, euro, libras, pesoA, pesoC;
	String mensagem = "";
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(SystemColor.textHighlight);
		panelTop.setBounds(0, 0, 487, 50);
		frame.getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		JLabel panelTopTitle = new JLabel("Conversor de Moedas e Temperaturas");
		panelTopTitle.setForeground(new Color(255, 255, 255));
		panelTopTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelTopTitle.setBounds(79, 11, 320, 28);
		panelTop.add(panelTopTitle);
		
		JLabel boxMoedaLabel = new JLabel("Converta Moedas");
		boxMoedaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		boxMoedaLabel.setBounds(33, 67, 152, 14);
		frame.getContentPane().add(boxMoedaLabel);
		
		JComboBox<Object> boxMoeda = new JComboBox<Object>();
		boxMoeda.setModel(new DefaultComboBoxModel<Object>(new String[] {
		"Reais a Dólar", "Reais a Euro", 
		"Reais a Libras Esterlinas", "Reais a Peso Argentino", 
		"Reais a Peso Chileno", "Dólar a Reais", 
		"Euro a Reais", "Libras Esterlinas a Reais", 
		"Peso Argentino a Reais", "Peso Chileno a Reais"}));
		boxMoeda.setBounds(29, 86, 173, 35);
		frame.getContentPane().add(boxMoeda);
		
		JComboBox<Object> boxTemperatura = new JComboBox<Object>();
		boxTemperatura.setModel(new DefaultComboBoxModel<Object>(new String[] {"Celsius para Fahrenheit", "Fahrenheit para Celsius"}));
		boxTemperatura.setBounds(29, 193, 173, 35);
		frame.getContentPane().add(boxTemperatura);
		
		JLabel boxTemperaturaLabel = new JLabel("Converta Temperaturas");
		boxTemperaturaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		boxTemperaturaLabel.setBounds(33, 174, 155, 14);
		frame.getContentPane().add(boxTemperaturaLabel);
		
		inputMoeda = new JTextField();
		inputMoeda.setBounds(212, 86, 147, 35);
		frame.getContentPane().add(inputMoeda);
		inputMoeda.setColumns(10);
		
		inputTemperatura = new JTextField();
		inputTemperatura.setColumns(10);
		inputTemperatura.setBounds(212, 193, 147, 35);
		frame.getContentPane().add(inputTemperatura);
		
		JLabel inputMoedaLabel = new JLabel("Digite o Valor:");
		inputMoedaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		inputMoedaLabel.setBounds(214, 64, 152, 21);
		frame.getContentPane().add(inputMoedaLabel);
		
		JLabel inputTemperaturaLabel = new JLabel("Digite a Temperatura:");
		inputTemperaturaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		inputTemperaturaLabel.setBounds(214, 174, 161, 15);
		frame.getContentPane().add(inputTemperaturaLabel);
		
		JButton btnLimparMoeda = new JButton("Limpar");
		btnLimparMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputMoeda.setText("");
			}
		});
		btnLimparMoeda.setBackground(new Color(119, 136, 153));
		btnLimparMoeda.setBounds(250, 121, 72, 29);
		frame.getContentPane().add(btnLimparMoeda);
		
		JButton btnConverterMoeda = new JButton("Converter");
		btnConverterMoeda.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(inputMoeda.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " - Digite somente números\n" + " - O Campo não pode estar em branco", 
					"Dados Inválidos!", JOptionPane.WARNING_MESSAGE );
					inputMoeda.requestFocus();
					return;
				}
				
				String boxM = (String)boxMoeda.getSelectedItem();
				
				if( boxM.equals("Reais a Dólar")) {
					reais = Double.parseDouble(inputMoeda.getText());
					dolar = (reais * 0.190);
					mensagem = "R$ " + Math.round(reais) + " Reais é \n" + "$ " + 
					new DecimalFormat("##.##").format(dolar) +  " Dólares.";	
				}
				
				if( boxM.equals("Reais a Euro")) {
					reais = Double.parseDouble(inputMoeda.getText());
					euro = (reais * 0.180);
					mensagem = "R$ " + Math.round(reais) + " Reais é \n" + "€ " +
					new DecimalFormat("##.##").format(euro) + " Euros.";	
				}
				
				if( boxM.equals("Reais a Libras Esterlinas")) {
					reais = Double.parseDouble(inputMoeda.getText());
					libras = (reais * 0.155);
					mensagem = "R$ " + Math.round(reais) + " Reais é \n" + "£ " +
					new DecimalFormat("##.##").format(libras) + " Libras Esterlinas.";
				}
				
				if( boxM.equals("Reais a Peso Argentino")) {
					reais = Double.parseDouble(inputMoeda.getText());
					pesoA = (reais * 23.703);
					mensagem = "R$ " + Math.round(reais) + " Reais é \n" + "$ " +
					new DecimalFormat("##.##").format(pesoA) + " Pesos Argentino.";
				}
				
				if( boxM.equals("Reais a Peso Chileno")) {
					reais = Double.parseDouble(inputMoeda.getText());
					pesoC = (reais * 172.95);
					mensagem = "R$ " + Math.round(reais) + " Reais é \n" + "$ " +
					new DecimalFormat("##.##").format(pesoC) + " Pesos Chileno.";
				}
				
				if( boxM.equals("Dólar a Reais")) {
					dolar = Double.parseDouble(inputMoeda.getText());
					reais = (dolar * 5.267);
					mensagem = "$ " + Math.round(dolar) + " Dólares é \n" + "R$ " +
					new DecimalFormat("##.##").format(reais) + " Reais.";
				}
				
				if( boxM.equals("Euro a Reais")) {
					euro = Double.parseDouble(inputMoeda.getText());
					reais = (euro * 5.547);
					mensagem = "€ " + Math.round(euro) + " Euros é \n" + "R$ " +
					new DecimalFormat("##.##").format(reais) + " Reais.";
				}
				
				if( boxM.equals("Libras Esterlinas a Reais")) {
					libras = Double.parseDouble(inputMoeda.getText());
					reais = (libras * 6.429);
					mensagem = "£ " + Math.round(libras) + " Libras Esterlinas é \n" + "R$ " +
					new DecimalFormat("##.##").format(reais) + " Reais.";
				}
				
				if( boxM.equals("Peso Argentino a Reais")) {
					pesoA = Double.parseDouble(inputMoeda.getText());
					reais = (pesoA * 0.0421);
					mensagem = "$ " + Math.round(pesoA) + " Pesos Argentino é \n" + "R$ " +
					new DecimalFormat("##.##").format(reais) + " Reais.";
				}
				
				if( boxM.equals("Peso Chileno a Reais")) {
					pesoC = Double.parseDouble(inputMoeda.getText());
					reais = (pesoC * 0.00578201);
					mensagem = "$ " + Math.round(pesoC) + " Pesos Chileno é \n" + "R$ " +
					new DecimalFormat("##.##").format(reais) + " Reais.";
				}
				
				
				JOptionPane.showMessageDialog(null, mensagem, 
				"Conversão Realizada com Sucesso!", JOptionPane.INFORMATION_MESSAGE );
			
			}
			
		});
		btnConverterMoeda.setBackground(new Color(100, 149, 237));
		btnConverterMoeda.setBounds(369, 85, 81, 36);
		frame.getContentPane().add(btnConverterMoeda);
		
		JButton btnLimparTemperatura = new JButton("Limpar");
		btnLimparTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTemperatura.setText("");
			}
		});
		btnLimparTemperatura.setBackground(new Color(119, 136, 153));
		btnLimparTemperatura.setBounds(250, 228, 72, 29);
		frame.getContentPane().add(btnLimparTemperatura);
		
		JButton btnConverterTemperatura = new JButton("Converter");
		btnConverterTemperatura.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(inputTemperatura.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, " - Digite somente números\n" + " - O Campo não pode estar em branco", 
					"Dados Inválidos!", JOptionPane.WARNING_MESSAGE );
					inputTemperatura.requestFocus();
					return;
				}
					
				String boxT = (String)boxTemperatura.getSelectedItem();
				if( boxT.equals("Celsius para Fahrenheit")) {
					
					celsius = Double.parseDouble(inputTemperatura.getText());
					fahrenheit = celsius * 1.8 + 32;
					mensagem = Math.round(celsius) + " Graus Celsius é \n" + 
					new DecimalFormat("##.##").format(fahrenheit) + " Graus Fahrenheit.";
					
				}
				
				if( boxT.equals("Fahrenheit para Celsius")) {
					
					fahrenheit = Double.parseDouble(inputTemperatura.getText());
					celsius = (fahrenheit-32) * 5/9;
					mensagem = Math.round(fahrenheit) + " Graus Fahrenheit é \n" + 
					new DecimalFormat("##.##").format(celsius) + " Graus Celsius.";
				}
				
					JOptionPane.showMessageDialog(null, mensagem, 
					"Conversão Realizada com Sucesso!", JOptionPane.INFORMATION_MESSAGE );
					
				}
			
		});
		
		btnConverterTemperatura.setBackground(new Color(100, 149, 237));
		btnConverterTemperatura.setBounds(369, 192, 81, 36);
		frame.getContentPane().add(btnConverterTemperatura);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int escolha = 0;
				escolha = JOptionPane.showConfirmDialog(null, "Deseja Sair?");
				if (escolha == 0) {
					JOptionPane.showMessageDialog(null, " Obrigado por usar está aplicação.", "Até Breve!",
							JOptionPane.DEFAULT_OPTION);
					System.exit(0);
				}

			}
		});
		btnSair.setBackground(new Color(204, 51, 51));
		btnSair.setBounds(29, 245, 91, 35);
		frame.getContentPane().add(btnSair);
	}
	
}
