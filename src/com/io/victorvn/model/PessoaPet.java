package com.io.victorvn.model;

public class PessoaPet {

    private int id;
    private int idPes;
    private int idPet;
    private String obs;
    private Pessoa pes;
    private Pet pet;

    public PessoaPet() {
    }

    public PessoaPet(int id, int idPes, int idPet, String obs) {
        this.id = id;
        this.idPes = idPes;
        this.idPet = idPet;
        this.obs = obs;
    }

    public PessoaPet(int id, int idPes, int idPet, String obs, Pessoa pes, Pet pet) {
        this.id = id;
        this.idPes = idPes;
        this.idPet = idPet;
        this.obs = obs;
        this.pes = pes;
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPes() {
        return idPes;
    }

    public void setIdPes(int idPes) {
        this.idPes = idPes;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Pessoa getPes() {
        return pes;
    }

    public void setPes(Pessoa pes) {
        this.pes = pes;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
