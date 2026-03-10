package br.com.senai.sistema_escolar.exception;

public class Response {

private int code;
    private String mensagem;

    public Response(int code, String mensagem) {
        this.code = code;
        this.mensagem = mensagem;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }



    
}
