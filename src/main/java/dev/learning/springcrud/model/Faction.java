package dev.learning.springcrud.model;

public class Faction {

    private int faction_id;
    private String title;
    private String description;
    private String unit;


    public Faction(){
    }

    public Faction(String title, String description, String unit) {
        this.title = title;
        this.description = description;
        this.unit = unit;
    }

    public int getFaction_id() {
        return faction_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }

    public void setFaction_id(int faction_id) {
        this.faction_id = faction_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "faction_id=" + faction_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
