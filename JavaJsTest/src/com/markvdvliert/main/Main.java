package com.markvdvliert.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        System.out.println(HTTP_GET("?test=Hello, World!","html"));
    }


    public static String HTTP_GET(String args, String location) {
        HttpClient client = HttpClient.newHttpClient();
        String link = "http://localhost/" + location + args;


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost/"))
                .build();
        try{
            return client.send(request,HttpResponse.BodyHandlers.ofString()).toString();
        }catch(IOException IOE){
            return "err IOException";
        }catch(InterruptedException IE){
            return "err InterruptedException";
        }


    }

    public String listener(){
        while(true){
            try{
                

                Thread.sleep(20);
            }catch(InterruptedException e){

            }


        }
    }
}