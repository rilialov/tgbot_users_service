package users_service.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamDTO {

    @XmlElement
    private long id;

    @XmlElement
    private String teamName;

    @XmlElement
    private String color;

    public TeamDTO() {
    }

    public TeamDTO(String teamName, String color) {
        this.teamName = teamName;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getColor() {
        return color;
    }
}
