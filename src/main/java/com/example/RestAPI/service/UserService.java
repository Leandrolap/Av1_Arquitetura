package com.example.RestAPI.service;
import com.example.RestAPI.model.NoticiaEntity;
import com.example.RestAPI.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository climaRepository;

    public String preverTempo() {
        String dados = "";

        //Metodo para obter Release e noticias
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados:  " + responseEntity.getStatusCode();
        }
        inserirDados(dados);
        return dados;
    }

    public String preverTempo1() {
        String dados = "";

        //Metodo para obter noticias
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados:  " + responseEntity.getStatusCode();
        }
        inserirDados(dados);
        return dados;
    }

    public String preverTempo2() {
        String dados = "";

        //Metodo para obter noticias
        String apiUrl = "https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados:  " + responseEntity.getStatusCode();
        }
        inserirDados(dados);
        return dados;
    }


    public void inserirDados(String dadosMeteorologicos) {


        NoticiaEntity ne = new NoticiaEntity();
        ne.setNoticia(dadosMeteorologicos);

        climaRepository.save(ne);


    }

    @Autowired
    private UserRepository userRepository;

    public List<NoticiaEntity> obterTodos() {
        return userRepository.findAll();
    }

}