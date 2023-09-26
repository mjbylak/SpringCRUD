package dev.learning.springcrud.model;

public class Faction {

    private int factionId;
    private String title;
    private String description;
    private String units;


    public Faction() { }

    public Faction(String title, String description, String units) {
        this.title = title;
        this.description = description;
        this.units = units;
    }

    public Faction(int factionId, String title, String description, String units) {
        this.factionId = factionId;
        this.title = title;
        this.description = description;
        this.units = units;
    }

    public int getFactionId() {
        return factionId;
    }

    public void setFactionId(int faction_id) {
        this.factionId = faction_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String unit) {
        this.units = unit;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "faction_id=" + factionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", units='" + units + '\'' +
                '}';
    }
}
