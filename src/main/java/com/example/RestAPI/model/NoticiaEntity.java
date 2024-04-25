package com.example.RestAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "noticia")
public class NoticiaEntity {

    @Id
    private String id;
    private String page;
    private String totalpage;
    private String nextPage;
    private String previousPage;





    public NoticiaEntity(){}

    public NoticiaEntity(String id, String page) {
        this.id = id;
        this.page = page;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticia() {
        return totalpage;
    }

    public void setNoticia(String totalpage) {
        this.totalpage = totalpage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public String getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }
}