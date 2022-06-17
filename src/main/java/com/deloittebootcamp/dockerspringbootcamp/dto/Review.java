package com.deloittebootcamp.dockerspringbootcamp.dto;/* © Appsbroker 2022  */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Review {
    private String name;
    private String theoryLevel;
    private String understandingScore;
    private String presentationModel;

    public Review(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheoryLevel() {
        return theoryLevel;
    }

    public void setTheoryLevel(String theoryLevel) {
        this.theoryLevel = theoryLevel;
    }

    public String getUnderstandingScore() {
        return understandingScore;
    }

    public void setUnderstandingScore(String understandingScore) {
        this.understandingScore = understandingScore;
    }

    public String getPresentationModel() {
        return presentationModel;
    }

    public void setPresentationModel(String presentationModel) {
        this.presentationModel = presentationModel;
    }

    public String toString(){
        return "{name:"+this.getName()+
                ";theoryLevel:"+ this.getTheoryLevel()+
                ";understandingScore:"+ this.getUnderstandingScore()+
                ";presentationModel:"+this.getPresentationModel()+";}";
    }

    public void send(){
        try {
            URL url = new URL("https://europe-west1-deloitte-quizzapp.cloudfunctions.net/receive-feedback");
            String postData = this.toString();

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", Integer.toString(postData.length()));

            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                dos.writeBytes(postData);
            }

            try (BufferedReader bf = new BufferedReader(new InputStreamReader(
                    conn.getInputStream())))
            {
                String line;
                while ((line = bf.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Review-ul nu a fost trimis!");
        }
    }
}
