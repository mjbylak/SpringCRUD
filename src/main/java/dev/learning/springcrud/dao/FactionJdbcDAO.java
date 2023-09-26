package dev.learning.springcrud.dao;

import dev.learning.springcrud.model.Faction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FactionJdbcDAO implements DAO<Faction>{

    private static final Logger log = LoggerFactory.getLogger(FactionJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    public FactionJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Faction> rowMapper =  (rs, rowNum) -> {
        Faction faction = new Faction();
        faction.setFactionId(rs.getInt("faction_id"));
        faction.setTitle(rs.getString("title"));
        faction.setDescription(rs.getString("description"));
        faction.setUnits(rs.getString("units"));
        return faction;
    };

    @Override
    public List<Faction> list() {
        String sql = "SELECT faction_id, title, description, units from Faction";
        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public void create(Faction faction) {
        String sql = "INSERT INTO faction(title,description,units) VALUES (?,?,?)";
        int insert = jdbcTemplate.update(sql,faction.getTitle(),faction.getDescription(),faction.getUnits());
        if(insert == 1) {
            log.info("New faction created: " + faction.getTitle());
        }
    }

    @Override
    public Optional <Faction> get(int id) {
        String sql = "SELECT faction_id,title,description,units FROM faction WHERE faction_id = ?";
        Faction faction = null;
        try {
            faction = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        }
        catch (DataAccessException ex) {
            log.info("Course not found: " + id);
        }
        return Optional.ofNullable(faction);
    }

    @Override
    public void update(Faction faction, int id) {
        String sql = "UPDATE faction SET title = ?, description = ?, units = ? WHERE faction_id = ?";
        int update = jdbcTemplate.update(sql, faction.getTitle(), faction.getDescription(), faction.getUnits(), id);
        if(update == 1) {
            log.info("Updated Faction: " + faction.getTitle());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM faction WHERE faction_id = ?";
        int delete = jdbcTemplate.update(sql, id);
        if (delete == 1){
            log.info("Faction Deleted: " + id);
        }
    }
}
