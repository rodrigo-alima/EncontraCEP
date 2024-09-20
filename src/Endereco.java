public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade; //Cidade
    private String uf; //sigla do estado
    private String estado; //Estado por extenso
    private String regiao;
    private String ddd;

    public Endereco(String cep, String logradouro, String complemento, String unidade, String bairro, String localidade, String uf, String estado, String regiao, String ddd) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.unidade = unidade;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
        this.regiao = regiao;
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "(" +
                "cep=" + cep +
                ", logradouro = " + logradouro +
                ", numero = " + numero +
                ", complemento = " + complemento +
                ", unidade = " + unidade +
                ", bairro = " + bairro +
                ", localidade = " + localidade +
                ", uf = " + uf +
                ", estado = " + estado +
                ", regiao = " + regiao +
                ", ddd = " + ddd +
                ")";
    }
}
