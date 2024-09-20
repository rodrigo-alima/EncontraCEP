# Programa Encontra CEP

O **Encontra CEP** permite localizar endereços a partir de um CEP (Código de Endereçamento Postal) e gerenciar uma lista de endereços.

## Funcionalidades

- **Busca de endereços**: Insira o CEP (somente números) no campo apropriado e clique em "Procurar" para visualizar o endereço correspondente.
- **Adicionar à lista**: Após visualizar o endereço, você pode adicionar o número da residência e clicar em "Adicionar" para gravar o endereço em uma lista.
- **Gerenciamento de endereços**: Busque e adicione diversos endereços à lista conforme necessário.
- **Salvar arquivo**: Quando concluir, clique em "Salvar" para exportar a lista de endereços no formato CSV. O arquivo pode ser aberto em aplicativos como Excel ou Word, facilitando a impressão em envelopes.

## Requisitos

Para que o programa funcione corretamente, é necessário importar a biblioteca **Gson** para manipulação de arquivos JSON. Você pode obtê-la diretamente no [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).

## Execução

Para executar o arquivo já compilado, abra o terminal e use o comando:

```bash
java -jar EncontraCEP.jar
```

Este arquivo foi compilado com o **Java 17** em um sistema **Gentoo Linux** utilizando o **IntelliJ IDEA**.

## Observações

Este programa foi desenvolvido com base no **ConsultaCEP**, apresentado nas aulas de Java da **Alura**.

### Agradecimentos

Agradecemos à equipe da [Alura](https://www.alura.com.br) pelo suporte e ensinamentos.
