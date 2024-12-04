import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ProgramaArvoreSimples {
    private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProgramaArvoreSimples().criarInterface());
    }

    public void criarInterface() {
        JFrame frame = new JFrame("Árvore Binária de Busca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new FlowLayout());

        JTextField campoValor = new JTextField(10);
        JButton botaoInserir = new JButton("Inserir");

        painelEntrada.add(new JLabel("Valor:"));
        painelEntrada.add(campoValor);
        painelEntrada.add(botaoInserir);

        JPanel painelAcoes = new JPanel();
        painelAcoes.setLayout(new GridLayout(3, 1, 5, 5));

        JButton botaoInverter = new JButton("Inverter Árvore");
        JButton botaoListar = new JButton("Listar Elementos");
        JButton botaoSair = new JButton("Sair");

        painelAcoes.add(botaoInverter);
        painelAcoes.add(botaoListar);
        painelAcoes.add(botaoSair);

        JTextArea areaResultados = new JTextArea(5, 20);
        areaResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultados);

        frame.add(painelEntrada, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(painelAcoes, BorderLayout.SOUTH);

        botaoInserir.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(campoValor.getText());
                arvore.insere(valor);
                areaResultados.append("Valor " + valor + " inserido na árvore.\n");
                campoValor.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira um número inteiro válido.");
            }
        });

        botaoInverter.addActionListener(e -> {
            if (arvore.raiz != null) {
                arvore.raiz.inverte();
                areaResultados.append("A árvore foi invertida.\n");
            } else {
                JOptionPane.showMessageDialog(frame, "A árvore está vazia!");
            }
        });

        botaoListar.addActionListener(e -> {
            if (arvore.raiz != null) {
                LinkedList<Integer> listaOrdenada = arvore.paraListaOrdenada();
                areaResultados.append("Elementos em ordem: " + listaOrdenada + "\n");
            } else {
                JOptionPane.showMessageDialog(frame, "A árvore está vazia!");
            }
        });

        botaoSair.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
