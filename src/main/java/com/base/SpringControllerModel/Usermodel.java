package com.base.SpringControllerModel;

/**
 * Created by liumin on 16/1/6.
 */
public class Usermodel {
    private int id;
    private String name;
    private String pwd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usermodel usermodel = (Usermodel) o;

        if (id != usermodel.id) return false;
        if (name != null ? !name.equals(usermodel.name) : usermodel.name != null) return false;
        if (pwd != null ? !pwd.equals(usermodel.pwd) : usermodel.pwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
