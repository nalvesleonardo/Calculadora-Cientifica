package View;

import Model.calcModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class calcView extends JFrame {

    private JTextField visor;
    private final JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private final JButton btnSoma, btnSub, btnDiv, btnMult, btnIgual, btnPonto;

    public calcView() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        btn1 = new JButton("1");
        btn1.addActionListener(new StandardButtonListener());
        btn2 = new JButton("2");
        btn2.addActionListener(new StandardButtonListener());
        btn3 = new JButton("3");
        btn3.addActionListener(new StandardButtonListener());
        btn4 = new JButton("4");
        btn4.addActionListener(new StandardButtonListener());
        btn5 = new JButton("5");
        btn5.addActionListener(new StandardButtonListener());
        btn6 = new JButton("6");
        btn6.addActionListener(new StandardButtonListener());
        btn7 = new JButton("7");
        btn7.addActionListener(new StandardButtonListener());
        btn8 = new JButton("8");
        btn8.addActionListener(new StandardButtonListener());
        btn9 = new JButton("9");
        btn9.addActionListener(new StandardButtonListener());
        btn0 = new JButton("0");
        btn0.addActionListener(new StandardButtonListener());
        btnSoma = new JButton("+");
        btnSoma.addActionListener(new StandardButtonListener());
        btnSub = new JButton("-");
        btnSub.addActionListener(new StandardButtonListener());
        btnDiv = new JButton("/");
        btnDiv.addActionListener(new StandardButtonListener());
        btnMult = new JButton("*");
        btnMult.addActionListener(new StandardButtonListener());
        btnIgual = new JButton("=");

        btnIgual.addActionListener(e -> {
            String[] partes = visor.getText().split(" ");
            if (partes.length == 3) {
                double valor1 = Double.parseDouble(partes[0]);
                String operador = partes[1];
                double valor2 = Double.parseDouble(partes[2]);
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = calcModel.soma(valor1, valor2);
                        break;
                    case "-":
                        resultado = calcModel.subtracao(valor1, valor2);
                        break;
                    case "*":
                        resultado = calcModel.multiplicacao(valor1, valor2);
                        break;
                    case "/":
                        resultado = calcModel.divisao(valor1, valor2);
                        break;
                }
                visor.setText(String.valueOf(resultado));
            }
        });

        btnPonto = new JButton(".");
        btnPonto.addActionListener(new StandardButtonListener());

        criarMenu();
        criarVisor();
        criarBotoes();

        setVisible(true);
    }

    private void criarMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuEdit = new JMenu("Edit");
        JMenu menuView = new JMenu("View");
        JMenu menuHelp = new JMenu("Help");
        menuBar.add(menuEdit);
        menuBar.add(menuView);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);
    }

    private void criarVisor() {
        visor = new JTextField();
        visor.setEditable(false);
        visor.setFont(new Font("Arial", Font.PLAIN, 20));
        add(visor, BorderLayout.NORTH);
    }

    private void criarBotoes() {
        JPanel pnlMain = new JPanel(new GridLayout(1, 2));

        JPanel pnlCien = new JPanel(new GridLayout(4, 3, 5, 5));
        pnlCien.setBorder(BorderFactory.createTitledBorder("Scientific"));
        String[] btnCien = {
                "sqrt", "1/x", "sin",
                "%", "Exp", "cos",
                "x^3", "ln", "tan",
                "x^2", "n!", "sec"
        };
        for (String texto : btnCien) {
            JButton btn = new JButton(texto);
            btn.addActionListener(new ScientificButtonListener());
            pnlCien.add(btn);
        }

        JPanel pnlStandard = new JPanel(new GridLayout(4, 4, 5, 5));
        pnlStandard.setBorder(BorderFactory.createTitledBorder("Standard"));
        for (JButton jButton : Arrays.asList(btn7, btn8, btn9, btnDiv, btn4, btn5, btn6, btnMult, btn1, btn2, btn3,
                btnSub, btn0, btnPonto, btnIgual, btnSoma)) {
            pnlStandard.add(jButton);
        }

        pnlMain.add(pnlCien);
        pnlMain.add(pnlStandard);
        add(pnlMain, BorderLayout.CENTER);
    }

    private class ScientificButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            try {
                double valor = Double.parseDouble(visor.getText());
                double resultado = switch (command) {
                    case "sqrt" -> calcModel.raiz(valor);
                    case "1/x" -> calcModel.inverso(valor);
                    case "sin" -> calcModel.seno(valor);
                    case "cos" -> calcModel.cossseno(valor);
                    case "tan" -> calcModel.tangente(valor);
                    case "x^2" -> calcModel.quadrado(valor);
                    case "x^3" -> calcModel.cubo(valor);
                    case "ln" -> calcModel.log(valor);
                    case "n!" -> calcModel.fatorial((int) valor);
                    case "%" -> calcModel.porcentagem(valor, 100); // Exemplo
                    case "Exp" -> calcModel.exp(valor, 1);
                    case "sec" -> calcModel.secante(valor);
                    default -> 0; // Exemplo
                };

                visor.setText(String.valueOf(resultado));
            } catch (Exception ex) {
                visor.setText("Erro");
            }
        }
    }

    private class StandardButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String visorText = visor.getText();

            if (command.equals("=")) {
                return;
            }

            if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
                visor.setText(visorText + " " + command + " ");
            } else {
                visor.setText(visorText + command);
            }
        }
    }
}