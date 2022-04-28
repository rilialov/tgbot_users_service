package users_service.dto;

import users_service.entity.Role;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO {

    @XmlElement
    private String chatId;

    @XmlElement
    private String nickname;

    @XmlElement
    private String firstName;

    @XmlElement
    private String lastName;

    @XmlElement
    private TeamDTO team;

    @XmlElement
    private Role role;

    public UserDTO() {
    }

    public UserDTO(String chatId, String nickname, String firstName, String lastName) {
        this.chatId = chatId;
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getChatId() {
        return chatId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TeamDTO getTeam() {
        return team;
    }

    public void setTeam(TeamDTO team) {
        this.team = team;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
