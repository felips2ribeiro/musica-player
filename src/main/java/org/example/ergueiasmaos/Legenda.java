package org.example.ergueiasmaos;

public class Legenda {

    // Método para gerar a legenda da música com base na parte fornecida
    public static String gerarLegenda(Integer parte){
        // Criação das partes da letra da música
        String erguei_as_maos = "Erguei as mãos e dai glória a " +
                "Deus\n" +
                "Erguei as mãos e dai glória a Deus\n" +
                "Erguei as mãos\n" +
                "E cantai como os filhos do Senhor\n\n";
        String animais_elefante_passarinho = repetirAnimais("O elefante", "os passarinhos");
        String animais_minhoquinha_pinguins = repetirAnimais("A minhoquinha", "os pinguins" );
        String animais_canguru_sapinho = repetirAnimais("O canguru", "o sapinho" );
        String deus_disse_noe = "Deus disse a Noé: Constrói uma arca\n" +
                "Deus disse a Noé: Constrói uma arca\n" +
                "Que seja feita\n" +
                "De madeira para os filhos do Senhor\n\n";
        String o_senhor_tem_filhos = "O senhor tem muitos filhos\n" +
                "Muitos filhos ele tem\n" +
                "Eu sou um deles, você também\n" +
                "Louvemos ao senhor";
        // Montagem das partes da música
        String parte1 =
                erguei_as_maos + animais_elefante_passarinho + animais_minhoquinha_pinguins + animais_canguru_sapinho + deus_disse_noe + erguei_as_maos + erguei_as_maos + erguei_as_maos;
        String parte2 =
                o_senhor_tem_filhos + repetirAcoes(1) + "\n\n" + o_senhor_tem_filhos + repetirAcoes(2)+ "\n" + o_senhor_tem_filhos + repetirAcoes(3) + "\n\n" + o_senhor_tem_filhos + repetirAcoes(4) + "\n" + o_senhor_tem_filhos + repetirAcoes(4)+ "\n" + o_senhor_tem_filhos + repetirAcoes(4)+ "\n" + o_senhor_tem_filhos + repetirAcoes(5) + "\n\n" + o_senhor_tem_filhos + repetirAcoes(6);
        // Verifica qual parte da música foi solicitada e retorna a legenda correspondente
        if(parte == 1){
            return parte1;
        } else if (parte == 2) {

            return parte2;
        } else{
            return parte1 + "E atenção agora, porque\n\n" + parte2;
        }
    }

    // Método para exibir a legenda no console
    public static void exibirLegenda(int parte) {
        String legenda = gerarLegenda(parte);
        if (legenda != null) {
            System.out.println(legenda);
        }
    }

    // Método para repetir a estrutura de animais
    public static String repetirAnimais(String animal1, String animal2) {
        return "Os animaizinhos subiram de dois em dois\n" +
                "Os animaizinhos subiram de dois em dois\n" +
                animal1 +"\n" +
                "E " + animal2 + ", como os filhos do Senhor\n\n";
    }

    // Método para repetir as ações
    public static String repetirAcoes(int numPartes) {
        String[] partes = {"Braço direito", ", braço esquerdo",
                "Perna direita", ", perna esquerda",
                "Balança a cabeça, dá uma voltinha\nDá um pulinho", " e abraça o irmão"};
        String resultado = "\n\n";
        for (int i = 0; i < numPartes && i < partes.length; i++) { // Percorre o partes e adiciona no resultado
            resultado += partes[i];
            if (i % 2 != 0) { // Adiciona quebra de linha a cada duas entradas
                resultado += "\n";
            }
        }
        return resultado;
    }
}