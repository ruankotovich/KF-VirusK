/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.bean;

/**
 *
 * @author Koulikov
 */
public abstract class Entity {
    byte Memory;
    int Id;

    public byte getMemory() {
        return Memory;
    }

    public void setMemory(byte Memory) {
        this.Memory = Memory;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
}
