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

    @Override
    public String toString() {
        String response = null;
        for (Voyage voyage: this.logs) {
            response+= voyage.toString()+"\n";
        }
        return response;
    }
}
