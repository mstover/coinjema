package org.coinjema.nontest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject(type="sessionStore")
public class PersistentConfig implements Serializable {
    private static final long serialVersionUID = 1;
    String paramOne = "One";
    String paramTwo = "Two";
    transient MockSingleton mok;
    
    

    public PersistentConfig() {
        super();
    }

    /**
     * @param args
     */
    public static void create() {
        System.out.println("hey");
        PersistentConfig config = new PersistentConfig();
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test/config1/sessionStore.jser"));
            output.writeObject(config);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Returns the paramOne.
     */
    public String getParamOne() {
        return paramOne;
    }

    /**
     * @param paramOne The paramOne to set.
     */
    public void setParamOne(String paramOne) {
        this.paramOne = paramOne;
    }

    /**
     * @return Returns the paramTwo.
     */
    public String getParamTwo() {
        return paramTwo;
    }

    /**
     * @param paramTwo The paramTwo to set.
     */
    public void setParamTwo(String paramTwo) {
        this.paramTwo = paramTwo;
    }

    /**
     * @return Returns the mok.
     */
    public MockSingleton getMok() {
        return mok;
    }

    /**
     * @param mok The mok to set.
     */
    @CoinjemaDependency(type="MockSingleton")
    public void setMok(MockSingleton mok) {
        this.mok = mok;
    }
    
    private void readObject(ObjectInputStream in)
    {
        try {
            in.defaultReadObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
