package org.gestern.gringotts.data;

import com.avaje.ebean.validation.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="gringotts_accountchest")
@UniqueConstraint(columnNames={"world","x","y","z"})
class EBeanAccountChest {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Id int id;

    @NotNull String world;

    @NotNull int x;
    @NotNull int y;
    @NotNull int z;

    @NotNull int account;
    
    @Override
    public String toString() {
        return "EBeanAccountChest("+account+","+world+": "+x+","+y+","+z+")"; 
    }

}