import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnderecoFrame extends JFrame {
    private Endereco endereco;
    private List<Endereco> listaEnderecos;

    private JTextField txtCep;
    private JButton btnProcurar;

    private JTextField txtLogradouro;
    private JTextField txtNumero;
    private JTextField txtComplemento;
    private JTextField txtUnidade;
    private JTextField txtBairro;
    private JTextField txtLocalidade; //Cidade
    private JTextField txtUf; //sigla do estado
    private JTextField txtEstado; //Estado por extenso
    private JTextField txtRegiao;
    private JTextField txtDdd;

    private JButton btnAdicionar;
    private JButton btnSalvar;
    private JButton btnSair;

    public EnderecoFrame() {
        listaEnderecos = new ArrayList<Endereco>();

        setSize(500,370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Buscador de Endereços");

        //painel superior
        //laber CEP, caixa de texto, botão procurar
        JPanel painelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets = new Insets(5,5,5,5);

        gc.gridy = 0;
        gc.gridx = 0;
        painelSuperior.add(new JLabel("CEP: "), gc);

        gc.gridx = 1;
        gc.weightx = 1.0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        txtCep = new JTextField();
        painelSuperior.add(txtCep, gc);

        gc.gridx = 2;
        gc.weightx = 0;
        btnProcurar = new JButton("Procurar");
        painelSuperior.add(btnProcurar,gc);

        //painel central
        JPanel painelCentral = new JPanel(new GridBagLayout());

        gc.gridx = 0;

        gc.gridy = 0;
        painelCentral.add(new JLabel("Logradouro: "),gc);
        gc.gridy = 1;
        painelCentral.add(new JLabel("Número: "), gc);
        gc.gridy = 2;
        painelCentral.add(new JLabel("Complemento: "),gc);
        gc.gridy = 3;
        painelCentral.add(new JLabel("Unidade: "),gc);
        gc.gridy = 4;
        painelCentral.add(new JLabel("Bairro: "),gc);
        gc.gridy = 5;
        painelCentral.add(new JLabel("Lcalidade: "),gc);
        gc.gridy = 6;
        painelCentral.add(new JLabel("UF (Sigla): "),gc);
        gc.gridy = 7;
        painelCentral.add(new JLabel("Estado: "),gc);
        gc.gridy = 8;
        painelCentral.add(new JLabel("Região: "),gc);
        gc.gridy = 9;
        painelCentral.add(new JLabel("DDD: "),gc);

        gc.gridx = 1;
        gc.weightx = 2;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.gridy = 0;
        txtLogradouro = new JTextField();
        painelCentral.add(txtLogradouro, gc);
        gc.gridy = 1;
        txtNumero = new JTextField();
        painelCentral.add(txtNumero, gc);
        gc.gridy = 2;
        txtComplemento = new JTextField();
        painelCentral.add(txtComplemento, gc);
        gc.gridy = 3;
        txtUnidade = new JTextField();
        painelCentral.add(txtUnidade, gc);
        gc.gridy = 4;
        txtBairro = new JTextField();
        painelCentral.add(txtBairro, gc);
        gc.gridy = 5;
        txtLocalidade = new JTextField();
        painelCentral.add(txtLocalidade, gc);
        gc.gridy = 6;
        txtUf = new JTextField();
        painelCentral.add(txtUf, gc);
        gc.gridy = 7;
        txtEstado = new JTextField();
        painelCentral.add(txtEstado, gc);
        gc.gridy = 8;
        txtRegiao = new JTextField();
        painelCentral.add(txtRegiao, gc);
        gc.gridy = 9;
        txtDdd = new JTextField();
        painelCentral.add(txtDdd, gc);

        //Painel Inferior
        JPanel painelInferior = new JPanel(new GridBagLayout());

        gc.gridy = 0;
        gc.weightx = 1.0;

        gc.gridx = 0;
        btnAdicionar = new JButton("Adicionar");
        painelInferior.add(btnAdicionar, gc);

        gc.gridx = 1;
        btnSalvar = new JButton("Salvar");
        btnSalvar.setEnabled(false);
        painelInferior.add(btnSalvar, gc);

        gc.gridx = 2;
        btnSair = new JButton("Sair");
        painelInferior.add(btnSair,gc);

        add(painelSuperior, BorderLayout.PAGE_START);
        add(painelCentral, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.PAGE_END);

        btnProcurar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cep = txtCep.getText();
                if(validaCEP(cep)) {
                    BuscaApi busca = new BuscaApi();
                    endereco = busca.consultaCep(cep);

                    txtLogradouro.setText(endereco.getLogradouro());
                    txtComplemento.setText(endereco.getComplemento());
                    txtBairro.setText(endereco.getBairro());
                    txtLocalidade.setText(endereco.getLocalidade());
                    txtUf.setText(endereco.getUf());
                    txtEstado.setText(endereco.getEstado());
                    txtRegiao.setText(endereco.getRegiao());
                    txtDdd.setText(endereco.getDdd());
                }else{
                    return;
                }
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        //Adiciona o endereço na lista
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSalvar.setEnabled(true);
                endereco.setNumero(txtNumero.getText());
                listaEnderecos.add(endereco);
                System.out.println(listaEnderecos.toString());
            }
        });

        //Salva a lista em um arquivo no formato csv
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser dialogoArquivo= new JFileChooser();
                int resultado = dialogoArquivo.showSaveDialog(EnderecoFrame.this);
                if(resultado == JFileChooser.APPROVE_OPTION) {

                    try {
                        FileWriter file = new FileWriter(String.valueOf(dialogoArquivo.getSelectedFile()));
                        int i = 0;
                        StringBuilder csv = new StringBuilder();
                        while(i < listaEnderecos.size()){
                            csv.append(enderecoToCsv(listaEnderecos.get(i)));
                            i++;
                        }
                        var writer = new PrintWriter(file);
                        writer.print(csv);
                        file.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    //Transforma um objeto Endereco em uma string csv
    private String enderecoToCsv(Endereco end){
        String csv = "";
        csv = end.getLogradouro() + "," +
                end.getNumero() + "," +
                end.getComplemento() + "," +
                end.getBairro() + "," +
                end.getLocalidade() + "," +
                end.getUf() + "," +
                end.getCep() + "\n";
        return csv;
    }

    //Faz a validação do cep digitado
    public boolean validaCEP(String cep){
        String regex = "^[0-9]{8}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(cep);

        return matcher.matches();

    }
}
