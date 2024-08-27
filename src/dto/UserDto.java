package dto;

public class UserDto {
    private String id;
    private String name;
    private String address;
    private String contact_number;
    private String joinedDate;

    

    
    public UserDto() {
    }


    public UserDto(String id, String name, String address, String contact_number, String joinedDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact_number = contact_number;
        this.joinedDate = joinedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }



    @Override
    public String toString() {
        return "UserDto [id=" + id + ", name=" + name + ", address=" + address + ", contact_number=" + contact_number
                + ", joinedDate=" + joinedDate + "]";
    }
        
    
}
