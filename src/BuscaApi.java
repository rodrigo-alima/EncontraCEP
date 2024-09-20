import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaApi {

    //Recebe um cep como parametro, faz a conexao com o site, e retorna um objeto Endereco
    //relativo ao CEP pedido
    private String buscaCEP(String cep){
        try {
            //Faz a conexao com o site para buscar a API
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        }catch (IOException e){
            System.out.println("Erro de IO");
        }catch (InterruptedException e){
            System.out.println("Interrupted Exception");
        }

        return null;
    }

    public Endereco consultaCep(String cep){
        Endereco end;
        String json = buscaCEP(cep);
        Gson gson = new Gson();
        end = gson.fromJson(json,Endereco.class);
        return end;
    }

}
