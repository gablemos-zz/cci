/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.sql.Date;



/**
 *
 * @author gabri
 */
public class Data {
    private int id;
    private Date agenda;

    public Data() {
    }

    public Data(Date agenda) {
        this.agenda = agenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda) {
        this.agenda = agenda;
    }
    
    
    
    
    
}
