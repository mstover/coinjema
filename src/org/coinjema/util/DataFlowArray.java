/**
 * --start-license-block--
 * 
 * (c) 2006 - present by the University of Rochester 
 * See the file DEDISCOVER-LICENSE.txt for License Details 
 * 
 * --end-license-block--
 * $Id$
 */
package org.coinjema.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michaelstover
 * 
 */
public class DataFlowArray<T> {

	List<DataFlowCell<T>> arr;

	public final int length;

	public DataFlowArray(int size) {
		this.arr = new ArrayList<DataFlowCell<T>>(size);
		for (int i = 0; i < size; i++) {
			this.arr.add(new DataFlowCell<T>());
		}
		length = size;
	}

	public T get(int index) {
		return arr.get(index).get();
	}

	public void set(int index, T value) {
		arr.get(index).set(value);
	}
}
