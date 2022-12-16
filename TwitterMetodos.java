package br.com.americanas.polotech.projetoPoloTech;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TwitterMetodos {
    String dataPublicacao;
    String usuarioPublicacao;
    String tweetsPublicacao;

    static int indiceAtual = 0;
    static TwitterMetodos[] tweetsArray = new TwitterMetodos[3];

    public static void inserirTweet(TwitterMetodos us) {
        if (indiceAtual == tweetsArray.length) {
            tweetsArray = tweetsNovoArray();
        }
        tweetsArray[indiceAtual++] = us; // incrementa depois de atribuir
    }

    private static TwitterMetodos[] tweetsNovoArray() {
        TwitterMetodos[] NovoArrayTweets = new TwitterMetodos[indiceAtual + 5];
        System.arraycopy(tweetsArray, 0, NovoArrayTweets, 0, tweetsArray.length);
        return NovoArrayTweets;
    }

    public static void exibirTimeline() {
        System.out.println("============================");
        System.out.println("        Timeline");
        System.out.println("============================");
        for (int i = 0; i < indiceAtual; i++) {
            System.out.println(tweetsArray[i]);
        }
    }

    public static void exibirTweetsFeitos(String usuario) {
        String usuarioT = "@" + usuario;
        System.out.println("============================");
        System.out.println("       Tweets Feitos");
        System.out.println("============================");
        for (int i =0; i < indiceAtual; i++) {
            String nomeUsu = tweetsArray[i].usuarioPublicacao;
            if (usuarioT.equals(nomeUsu)) {
                System.out.println(tweetsArray[i]);
            }
        }
    }

    public static String getDataAtual() {
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        String dataFormat = "["+data+"] " + "["+hora+"]";
        return dataFormat;
    }

    @Override
    public String toString() {
        return "Data: " + dataPublicacao + " Nome: [" + usuarioPublicacao + "] Tweets: " + tweetsPublicacao ;
    }
}
