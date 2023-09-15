/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
*/

/*
 * This class appeared originally in the Apache JMeter project, and is used in Coinjema 
 * with modifications and improvements.  Although the Coinjema project is Public Domain 
 * software, please be aware of the source files with an Apache origin.
 */

package org.coinjema.collections;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
/**
 * 
 * @author Michael Stover (mstover1@apache.org)
 *
 */
class ConfigurationTreeParser {

    private static final String BLOCK = "[[!";
    private static final String END_BLOCK = "!]]";
    public static final String VALUE = "!!VALUE_][!!";
    
    static void getSpaces(int level, Writer buf) throws IOException {
        for (int i = 0; i < level; i++)
            buf.write("    ");
    }
    
    public static void fromXML(Reader buf,ConfigurationTree tree) throws IOException {
        String[] line = readLine(buf,null);
        int nameIndex = line[0].indexOf("{");
        if (nameIndex > 0) {
            tree.setValue(line[0].substring(0, nameIndex).trim());
        } 
        fromXML(buf, tree,line);
    }

    /**
     * @param buf
     * @param tree
     * @throws IOException
     */
    static boolean fromXML(Reader buf, ConfigurationTree tree,String[] line)
            throws IOException {
        boolean done = false;
        try {
            while (!done && !(line = readLine(buf,line)).equals("}")) {
                int equals = line[0].indexOf("=");
                if (line[0].endsWith("{")) {
                    line[0] = line[0].substring(0, line[0].length() - 1).trim();
                    equals = line[0].indexOf("=");
                    if (equals > -1) {
                        ConfigurationTree newTree = tree.add(line[0].substring(0,
                                equals));
                        newTree.setValue(line[0].substring(equals + 1));
                        done = fromXML(buf, newTree,line);
                    } else {
                        done = fromXML(buf, tree.add(line[0]),line);
                    }
                } else if (equals > -1) {
                    String key = line[0].substring(0, equals);
                    if ((equals + 1) < line[0].length())
                        tree.addRaw(key, line[0].substring(equals + 1));
                    else
                        tree.addRaw(key);
                } else if (line[0].equals("}")) {
                    return false;
                } else if(line[0].length() > 0)
                {
                    tree.addRaw(line[0]);
                }
            }
        } catch (IOException e) {
            if (e.getMessage().equals("End of File")) {
                return true;
            } else
                throw e;
        }
        return false;
    }

    /**
     * @param buf
     * @throws IOException
     */
    static String[] readLine(Reader buf,String[] extra) throws IOException {
        if(extra == null)
        {
            extra = new String[2];
        }
        if(extra[1] != null && extra[1].length() > 0)
        {
            extra[0] = extra[1];
            extra[1] = null;
            return extra;
        }
        StringBuffer line = new StringBuffer();
        int c = buf.read();
        while ((c != -1) && ((char) c != '\n') && ((char) c != '\r') && 
                ((char)c != '}') && ((char)c != '{')) {
            line.append((char) c);
            c = buf.read();
        }
        if (c == -1)
            throw new IOException("End of File");
        if(((char)c == '}'))
            extra[1] = String.valueOf((char)c);
        else if(((char)c) == '{')
        {
            line.append('{');
        }
        extra[0] = line.toString().trim();
        if(extra[0].endsWith(BLOCK))
        {
            extra[0] = extra[0].substring(0,extra[0].length()- BLOCK.length()) + 
                    readBlock(buf);
        }
        return extra;
    }
    
    static String readBlock(Reader buf) throws IOException
    {
        StringBuffer line = new StringBuffer();
        int c = buf.read();
        line.append((char)c);
        while (!line.toString().endsWith(END_BLOCK)) {
            c = buf.read();
            line.append((char) c);
        }
        return line.toString().substring(0,line.length() - END_BLOCK.length()).trim();
    }

    public static void toXML(Writer buf,ConfigurationTree tree) throws IOException {
        if (tree.getValue() != null) {
            buf.write(tree.getValue());
            buf.write(" {\n");
        } else
            buf.write("{\n");
        int level = 1;
        toXML(tree, level, buf);
        buf.write("}");
    }

    static void toXML(ConfigurationTree tree, int level, Writer buf)
            throws IOException {
        String[] entries = tree.getPropertyNames();
        for (int i = 0; i < entries.length; i++) {
            if(!VALUE.equals(entries[i]))
            {
                if (tree.listPropertyNames(entries[i]) == null
                        || tree.listPropertyNames(entries[i]).size() == 0) {
                    getSpaces(level, buf);
                    writeLeafValue(buf,entries[i],level);
                    buf.write("\n");
                } else if (tree.isLeaf(entries[i])) {
                    getSpaces(level, buf);
                    buf.write(entries[i]);
                    buf.write("=");
                    writeLeafValue(buf,tree.getPropertyNames(entries[i])[0],level);
                    buf.write("\n");
                } else {
                    getSpaces(level, buf);
                    buf.write(entries[i]);
                    if (tree.getTree(entries[i]).getValue() != null) {
                        buf.write("=");
                        buf.write(tree.getTree(entries[i]).getValue());
                    }
                    buf.write(" {\n");
                    toXML(tree.getTree(entries[i]), (level + 1), buf);
                    getSpaces(level, buf);
                    buf.write("}\n");
                }
            }
        }
    }
    
    static void writeLeafValue(Writer buf,String entry,int level) throws IOException
    {
        if(entry.indexOf('\n') > -1 || entry.indexOf('\r') > -1)
        {
            buf.write(BLOCK);
            buf.write("\n");
            buf.write(entry.trim());
            buf.write("\n");
            getSpaces(level,buf);
            buf.write(END_BLOCK);
        }
        else
        {
            buf.write(entry);
        }
    }

}
