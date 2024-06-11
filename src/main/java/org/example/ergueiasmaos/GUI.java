package org.example.ergueiasmaos;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class GUI {

    private JButton button1; // Botão para tocar a primeira parte da música
    private JButton button2; // Botão para tocar a segunda parte da música
    private JButton button3; // Botão para tocar a música completa
    private JButton button4; // Botão para parar a música
    private JTextArea textArea1; // Área de texto para exibir a legenda da música
    private AudioPlayer audioPlayer; // Objeto para controlar a reprodução de áudio
    private SwingWorker<Void, String> worker; // Objeto para realizar tarefas em segundo plano

    public GUI() {
        // Inicializa os componentes da interface gráfica
        button1 = new JButton("Tocar Primeira Parte");
        button2 = new JButton("Tocar Segunda Parte");
        button3 = new JButton("Tocar Música Completa");
        button4 = new JButton("Parar Música");
        textArea1 = new JTextArea();
        textArea1.setFont(new Font("Arial", Font.PLAIN, 30));
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        textArea1.setEditable(false);
        textArea1.setBorder(new EmptyBorder(10, 10, 10, 10));
        audioPlayer = new AudioPlayer();

        // Cria o JFrame (janela principal da aplicação)
        JFrame frame = new JFrame("Erguei As Mãos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Centraliza o JFrame na tela

        // Cria um painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2)); // 2 linhas, 2 colunas
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        // Cria um painel para a área de texto
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 1)); // 1 linha, 1 coluna
        textPanel.add(new JScrollPane(textArea1));

        // Adiciona os componentes ao frame
        frame.setLayout(new BorderLayout());
        frame.add(buttonPanel, BorderLayout.SOUTH); // // Painel de botões na parte inferior
        frame.add(textPanel, BorderLayout.CENTER); // Área de texto no centro

        // Adiciona lógica aos botões
        button1.addActionListener(e -> {
            tocarParte(1);
            Legenda.exibirLegenda(1);
        });
        button2.addActionListener(e -> {
            tocarParte(2);
            Legenda.exibirLegenda(2);
        });
        button3.addActionListener(e -> {
            tocarParte(3);
            Legenda.exibirLegenda(3);
        });
        button4.addActionListener(e -> pararMusica());

        // Exibe o frame
        frame.setVisible(true);
    }

    private void tocarParte(int parte) {
        // Para a reprodução atual, se houver
        pararMusica();
        // Inicia uma nova tarefa em segundo plano para exibir a legenda
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                String[] linhas = Legenda.gerarLegenda(parte).split("\n");
                for (String linha : linhas) {
                    publish(linha);
                    Thread.sleep(3000); // Espera 3 segundos entre cada linha da legenda
                }
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                textArea1.setText(chunks.get(chunks.size() - 1)); // Atualiza a última linha da legenda na interface
            }
        };
        worker.execute();

        // Toca a parte selecionada da música
        if (parte == 3) {
            audioPlayer.play("src/main/resources/COMPLETO.wav");  // Toca a música completa
        }
            else{
        audioPlayer.play("src/main/resources/PARTE-" + parte + ".wav"); // Toca a parte específica da música
    }}


    private void pararMusica() {
        // Para a reprodução atual e limpa a área de texto
        if (worker != null && !worker.isDone()) {
            worker.cancel(true);
        }
        audioPlayer.stop();
        textArea1.setText("");
    }

    public static void main(String[] args) {
        // Executa a Interface
        SwingUtilities.invokeLater(GUI::new);

    }
}
