package ch.bfh.btx8081.w2013.green.data;

public class Skill {

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
