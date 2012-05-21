/*
 * Copyright (C) 2010-2011 Richard Lincoln
 *
 * JPOWER is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * JPOWER is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JPOWER. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package edu.cornell.pserc.jpower.jpc;

import cern.colt.matrix.tdouble.DoubleFactory2D;
import cern.colt.matrix.tdouble.DoubleMatrix2D;
import cern.colt.matrix.tint.IntMatrix1D;

import static edu.emory.mathcs.utils.Utils.intm;

/**
 *
 * @author Richard Lincoln
 *
 */
public class Areas {

	private static final int AREA_I			= 0;
	private static final int PRICE_REF_BUS	= 1;

	/** area number */
	public IntMatrix1D area_i;

	/** price reference bus for this area */
	public IntMatrix1D price_ref_bus;

	/**
	 *
	 * @return the number of areas.
	 */
	public int size() {
		return (int) this.area_i.size();
	}

	/**
	 *
	 * @return a full copy of the areas data.
	 */
	public Areas copy() {
		return copy(null);
	}

	/**
	 *
	 * @param indexes
	 * @return a copy of the areas data.
	 */
	public Areas copy(int[] indexes) {
		Areas other = new Areas();

		other.area_i = this.area_i.viewSelection(indexes).copy();
		other.price_ref_bus = this.price_ref_bus.viewSelection(indexes).copy();

		return other;
	}

	/**
	 *
	 * @param other
	 * @param indexes
	 */
	public void update(Areas other, int[] indexes) {

//		this.area_i.viewSelection(indexes).assign(other.area_i.viewSelection(indexes));
//		this.price_ref_bus.viewSelection(indexes).assign(other.price_ref_bus.viewSelection(indexes));

		this.area_i.viewSelection(indexes).assign(other.area_i);
		this.price_ref_bus.viewSelection(indexes).assign(other.price_ref_bus);
	}

	/**
	 *
	 * @param other
	 */
//	public void fromMatrix(DoubleMatrix2D other) {
//
//		this.area_i = intm(other.viewColumn(AREA_I));
//		this.price_ref_bus = intm(other.viewColumn(PRICE_REF_BUS));
//	}

	public static Areas fromMatrix(DoubleMatrix2D other) {
		Areas area = new Areas();

		area.area_i = intm(other.viewColumn(AREA_I));
		area.price_ref_bus = intm(other.viewColumn(PRICE_REF_BUS));

		return area;
	}

	public static Areas fromMatrix(double[][] data) {
		return fromMatrix(DoubleFactory2D.dense.make(data));
	}

	public DoubleMatrix2D toMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	public double[][] toArray() {
		return toMatrix().toArray();
	}

}
