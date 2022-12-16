package br.com.americanas.polotech.projetoPoloTech;
public class Usuario {
    String nomeUsuario;
    String senhaUsuario;

    static int indiceAtual = 0;
    static Usuario[] usuariosArray = new Usuario[3];

    public static void cadastroUsuario(Usuario us) {
        if (indiceAtual == usuariosArray.length) {
            usuariosArray = usuarioNovoArray();
        }
        usuariosArray[indiceAtual++] = us; // incrementa depois de atribuir
    }

    private static Usuario[] usuarioNovoArray() {
        Usuario[] NovoArrayTweets = new Usuario[indiceAtual + 5];
        System.arraycopy(usuariosArray, 0, NovoArrayTweets, 0, usuariosArray.length);
        return NovoArrayTweets;
    }

    public static boolean autenticaUsuario(String nomeDig, String senhaDig ) {
        for (int i = 0; i < indiceAtual; i++) {
            String nome  = usuariosArray[i].nomeUsuario;
            String senha  = usuariosArray[i].senhaUsuario;
            if (nomeDig.equals(nome) && senhaDig.equals(senha) ){
                System.out.println("===========================");
                System.out.println("Login Bem Sucedido");
                return true;
            }
        }
        return false;
    }
}
