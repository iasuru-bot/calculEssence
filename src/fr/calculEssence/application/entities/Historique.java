package fr.calculEssence.application.entities;

import java.util.ArrayList;
import java.util.List;

public class Historique {
    private List<Voyage> logs = new ArrayList<>();

    public Historique() {
    }


    public List<Voyage> getLogs() {
        return logs;
    }

    public void setLogs(List<Voyage> logs) {
        this.logs = logs;
    }

    //TODO A changer
    @Override
    public String toString() {
        return "Historique{" +
                "voyage=" + logs +
                '}';
    }
}
