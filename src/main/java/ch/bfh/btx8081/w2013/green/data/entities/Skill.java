package ch.bfh.btx8081.w2013.green.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Berner Fachhochschule</br>
 * Medizininformatik BSc</br>
 * Modul 8081, HS2013</br>
 *
 *<p>Class Description</p>
 *
 * @author Johannes Gnaegi, gnaegj1@bfh.ch
 * @version 26-12-2013
 */
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int skillId = -1;
    private String name;
    private String description;

    public Skill() {}

    public Skill(int skillId, String name, String description) {

        this.skillId = skillId;
        this.name = name;
        this.description = description;
    }

    public int getSkillId() {
        return skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
