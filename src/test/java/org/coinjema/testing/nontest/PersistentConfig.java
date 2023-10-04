package org.coinjema.testing.nontest;

import org.coinjema.cjm.AbstractContextOriented;
import org.coinjema.cjm.Cjm;
import org.coinjema.cjm.CjmDependency;
import org.coinjema.cjm.CjmObject;

import java.io.*;

@CjmObject(type = "sessionStore")
public class PersistentConfig extends AbstractContextOriented implements Serializable {
    private static final long serialVersionUID = 1;
    String paramOne = "One";
    String paramTwo = "Two";
    transient MockSingleton mok;


    public PersistentConfig() {
        super();
        Cjm.contextualize(this);
    }

    /**
     * @param args
     */
    public static void create() {
        System.out.println("hey");
        PersistentConfig config = new PersistentConfig();
        File file = new File("src/test/resources/config1/sessionStore.jser");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/test/resources/config1/sessionStore.jser"))) {

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
    @CjmDependency(type = "MockSingleton")
    public void setMok(MockSingleton mok) {
        this.mok = mok;
    }

    private void readObject(ObjectInputStream in) {
        try {
            in.defaultReadObject();
            Cjm.contextualize(this, getCoinjemaContext());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
